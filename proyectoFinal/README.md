# Explicación del Stack Tecnológico — TechShop

Este documento explica cómo cada tecnología del proyecto contribuye a cumplir las reglas de negocio y cómo la IA apoyó en el proceso de desarrollo.

---

## Java + Spring → Esqueleto del Proyecto

Spring actúa como el **framework integrador** que conecta todas las capas de la aplicación:

```
HTTP Request → Controller → Service (lógica de negocio) → Repository → Base de Datos
```

Las **reglas de negocio** viven en la capa **Service**: validar stock, calcular totales de órdenes, verificar que un usuario exista antes de crear un carrito, etc. Sin Spring, todo ese cableado entre capas tendría que hacerse manualmente.

Spring permite trabajar con las diferentes piezas de la arquitectura de forma organizada:

| Capa | Responsabilidad |
|---|---|
| **Model / Entity** | Representa la estructura de los datos (tablas/documentos) |
| **Repository / JPA** | Acceso a la base de datos (consultas, inserciones) |
| **Service** | Lógica de negocio y reglas del dominio |
| **Controller** | Recibe peticiones HTTP y devuelve respuestas |
| **DTO** | Objetos de transferencia para no exponer entidades internas |
| **Test** | Validación del comportamiento esperado |

---

## ¿Por qué MySQL Y MongoDB? (Arquitectura Dual de Bases de Datos)

La arquitectura usa dos tipos de base de datos, cada una donde mejor se adapta:

| | **MySQL** | **MongoDB** |
|---|---|---|
| **Qué guarda** | Usuarios, carritos, órdenes | Catálogo de productos |
| **Tipo de BD** | Relacional y transaccional | Documental y flexible |
| **¿Por qué este tipo?** | Los pedidos SIEMPRE tienen usuario, items y total — necesitan consistencia fuerte | Un celular tiene specs distintas a un cable — el esquema flexible evita columnas vacías |
| **Necesita consistencia fuerte** | ✅ Sí (no se puede perder una orden) | ❌ No tanto (un producto puede tener campos extras) |

> **Ejemplo**: Un producto tipo "monitor" puede tener el campo `"resolución_pantalla"`, mientras que un "cable USB" no lo tiene. MongoDB permite esa variación sin romper el esquema. En MySQL esto se volvería un caos con decenas de columnas vacías.

---

## Spring Batch — Proceso ETL (Extracción, Transformación y Carga)

El proceso Batch **no mueve datos de MySQL a MongoDB**. El flujo real es:

```
productos.csv  →  [Spring Batch]  →  MongoDB
   (archivo)      Extrae, valida,      (catálogo)
                  transforma
```

### ¿Para qué sirve?

En un negocio real, el equipo de compras entrega periódicamente un archivo Excel/CSV con los nuevos productos del mes. El batch lo procesa automáticamente en bloques de 10 registros a la vez, validando cada uno, en lugar de hacer cientos de inserciones manuales una por una.

### Las 3 fases del ETL:

1. **Extracción** → `FlatFileItemReader` lee el archivo `productos.csv`
2. **Transformación** → `ProductoItemProcessor` valida y transforma cada registro
3. **Carga** → `MongoItemWriter` persiste los productos en la colección de MongoDB

---

## Testing — JUnit, Mockito, MockMvc y H2

Son herramientas distintas que trabajan juntas:

| Herramienta | Tipo de prueba | ¿Qué valida? |
|---|---|---|
| **JUnit 5** | Framework base | Define los tests, assertions y estructura |
| **Mockito** | Pruebas unitarias | Simula dependencias (ej. Repository falso) para probar el Service aislado |
| **MockMvc** | Pruebas de integración | Simula peticiones HTTP reales (`GET`, `POST`, `PUT`, `DELETE`) sin levantar servidor |
| **H2** | Base de datos en memoria | Reemplaza MySQL/MongoDB durante los tests para no tocar datos reales |

```
Mockito + JUnit  →  "¿La lógica del Service es correcta?"
MockMvc + JUnit  →  "¿El endpoint responde 200 con el JSON correcto?"
H2              →  Base de datos falsa en RAM para aislar los tests del entorno real
```

**JaCoCo** mide la cobertura de código y el build falla automáticamente si baja del **80%**, garantizando que siempre exista un nivel mínimo de pruebas.

---

## Docker — Portabilidad y Consistencia de Entornos

Docker resuelve el clásico problema de *"en mi máquina sí funciona"*. Con un solo comando:

```bash
docker-compose up -d
```

Se levantan **3 contenedores** ya configurados entre sí:

```
┌─────────────────┐    ┌─────────────────┐    ┌─────────────────┐
│   MySQL 8.0     │    │  MongoDB 7.0    │    │  Spring Boot    │
│   Puerto 3307   │◄───│  Puerto 27017   │◄───│  Puerto 8080    │
└─────────────────┘    └─────────────────┘    └─────────────────┘
```

Cualquier máquina con Docker instalado ejecuta el proyecto de forma idéntica, sin necesidad de instalar Java, MySQL ni MongoDB localmente. El `Dockerfile` usa **multi-stage build**: una etapa para compilar con Maven y otra etapa ligera solo para ejecutar el JAR.

---

## Swagger + OpenAPI — Documentación Interactiva de la API

Son dos cosas relacionadas pero distintas:

- **OpenAPI** es el **estándar/especificación** (el contrato). Define en formato JSON/YAML qué endpoints existen, qué parámetros aceptan y qué respuestas devuelven. Es el *"plano arquitectónico"* de la API.
- **Swagger UI** es la **interfaz visual** que lee ese contrato y genera una página web interactiva.

```
Anotaciones en el código Java
           ↓
     OpenAPI Spec (JSON)
           ↓
     Swagger UI → http://localhost:8080/swagger-ui.html
```

### ¿Para qué sirve en la práctica?

Un desarrollador frontend o un cliente externo puede:
- Ver **exactamente** qué endpoints existen y cómo consumirlos
- Conocer qué parámetros requiere cada petición y qué respuesta esperar
- **Probar los endpoints en vivo** directamente desde el navegador, sin necesidad de Postman

---

## ¿Cómo ayudó la IA en el proyecto?

La IA (GitHub Copilot) actuó en varios roles durante el desarrollo:

### 1. Generación de código repetitivo (boilerplate)
Spring requiere mucho código estructural repetitivo (entidades, configuraciones, constructores). La IA genera esas estructuras en segundos, permitiendo enfocarse en la lógica de negocio.

### 2. Generación de tests
Escribir pruebas es tedioso y propenso a omisiones. La IA genera los casos de prueba (happy path, casos de error, edge cases) basándose en el código del Service o Controller existente.

### 3. Depuración y explicación
Cuando aparece un error de configuración (Spring Batch, conexión dual de BD, JaCoCo), la IA identifica el problema y explica el *porqué*, no solo el *qué cambiar*.

### 4. Decisiones de arquitectura
Preguntas como *"¿Debería usar MySQL o MongoDB para el catálogo de productos?"* se resuelven con la IA explicando los trade-offs de cada opción según el contexto del negocio.

### 5. Documentación automática
Generación de comentarios Javadoc, READMEs, y las guías de Git, Scrum y Docker disponibles en la carpeta `/guias/`.

> **Conclusión**: La IA no reemplazó al desarrollador, sino que eliminó el trabajo mecánico y repetitivo, permitiendo enfocarse en las decisiones importantes de diseño y en comprender el *porqué* de cada tecnología aplicada al proyecto.
