# Módulo 7 – GitHub Copilot: IA aplicada al desarrollo de software

> **Repositorio de ejercicios prácticos** desarrollados con la asistencia de GitHub Copilot durante el módulo de Inteligencia Artificial aplicada al desarrollo.

---

## 📌 ¿Qué es la Inteligencia Artificial?

La **Inteligencia Artificial (IA)** es la rama de la informática que busca crear sistemas capaces de realizar tareas que normalmente requieren inteligencia humana, como reconocimiento de patrones, comprensión del lenguaje natural, toma de decisiones y aprendizaje a partir de datos.

### Áreas de aplicación

| Área | Ejemplo |
|---|---|
| Salud | Diagnóstico médico por imágenes |
| Finanzas | Detección de fraudes en tiempo real |
| Educación | Tutores personalizados con IA |
| Desarrollo de software | Asistentes de código como GitHub Copilot |
| Manufactura | Mantenimiento predictivo en maquinaria |

### Ética en la IA

La IA plantea importantes desafíos éticos que todo desarrollador debe considerar:

- **Sesgo algorítmico**: los modelos pueden reproducir sesgos presentes en los datos de entrenamiento.
- **Privacidad**: el uso masivo de datos personales levanta preocupaciones importantes.
- **Transparencia**: los sistemas deben ser explicables y auditables.
- **Responsabilidad**: es necesario definir quién responde cuando una IA toma una decisión errónea.
- **Desplazamiento laboral**: la automatización puede afectar empleos; es clave gestionar la transición.

---

## 🤖 ¿Qué es GitHub Copilot?

**GitHub Copilot** es un asistente de programación basado en IA, desarrollado por GitHub en colaboración con OpenAI. Utiliza el modelo **Codex** para sugerir líneas de código, funciones completas, tests y documentación directamente en el editor.

### Características principales

- Sugerencias de código en tiempo real mientras escribes
- Generación de funciones completas a partir de comentarios en lenguaje natural
- Soporte para múltiples lenguajes: Java, Python, JavaScript, TypeScript, Go, etc.
- Integración con VS Code, IntelliJ IDEA, Neovim y otros IDEs

### Requisitos de instalación

1. Cuenta de GitHub con acceso a Copilot (plan Individual, Business o Education)
2. Visual Studio Code u otro IDE compatible
3. Extensión **GitHub Copilot** instalada desde el Marketplace de VS Code
4. Extensión opcional: **GitHub Copilot Chat** para interacción conversacional

### Pasos de instalación en VS Code

```
1. Abre VS Code
2. Ve a Extensions (Ctrl+Shift+X)
3. Busca "GitHub Copilot"
4. Haz clic en "Install"
5. Inicia sesión con tu cuenta de GitHub cuando se solicite
6. Acepta los permisos de autorización
7. ¡Listo! Copilot estará activo automáticamente
```

---

## ⚙️ Configuración del entorno con GitHub

### Autenticación

1. En VS Code, abre la paleta de comandos: `Ctrl+Shift+P`
2. Busca: `GitHub: Sign In`
3. Se abrirá una ventana del navegador para autorizar la aplicación
4. Regresa a VS Code; ya estarás autenticado y Copilot activo

### Verificar que Copilot está activo

- Busca el ícono de Copilot en la barra de estado inferior de VS Code
- Debe aparecer en color blanco/activo (sin tachado)
- Haz clic en él para ver opciones: activar/desactivar, gestionar suscripción

### Atajos útiles en VS Code

| Acción | Atajo |
|---|---|
| Aceptar sugerencia | `Tab` |
| Rechazar sugerencia | `Esc` |
| Ver siguiente sugerencia | `Alt + ]` |
| Ver sugerencia anterior | `Alt + [` |
| Abrir panel de sugerencias | `Ctrl + Enter` |
| Abrir Copilot Chat | `Ctrl + Shift + I` |

---

## 💡 Casos de uso demostrados

Los siguientes ejemplos de código fueron generados y/o asistidos por GitHub Copilot:

### 1. 📝 Sugerencia de código durante la escritura

Copilot sugiere código en tiempo real mientras escribes. Por ejemplo, al comenzar a escribir el nombre de un método, Copilot sugiere la implementación completa basándose en el contexto del archivo.

**Ejemplo**: Al escribir el comentario `// find product by id and throw exception if not found`, Copilot generó automáticamente:

```java
public Product findById(Long id) {
    return productRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));
}
```

### 2. 🧱 Generación de clases POJO / DTO
📁 `copilot-examples/pojo/`
- [`ProductDTO.java`](copilot-examples/pojo/ProductDTO.java) – DTO para transferencia de datos de productos
- [`UserDTO.java`](copilot-examples/pojo/UserDTO.java) – DTO para datos de usuario con validaciones

### 3. 🔧 Inyección de dependencias y anotaciones en Spring Boot
📁 `copilot-examples/springboot/`
- [`Product.java`](copilot-examples/springboot/Product.java) – Entidad JPA con anotaciones
- [`ProductRepository.java`](copilot-examples/springboot/ProductRepository.java) – Repositorio con Spring Data JPA
- [`ProductService.java`](copilot-examples/springboot/ProductService.java) – Servicio con `@Service` e inyección de dependencias
- [`ProductController.java`](copilot-examples/springboot/ProductController.java) – REST Controller con `@RestController` y `@RequestMapping`

### 4. 🧪 Generación de instancias mock para test cases
📁 `copilot-examples/tests/`
- [`ProductServiceTest.java`](copilot-examples/tests/ProductServiceTest.java) – Tests unitarios con Mockito (`@Mock`, `@InjectMocks`, `@ExtendWith`)

---

## 📸 Capturas de pantalla

> ⚠️ **Nota**: Las capturas de pantalla mostrando las sugerencias en tiempo real de Copilot deben ser tomadas directamente en VS Code durante el desarrollo y agregadas a esta carpeta.

Sugerencias recomendadas para capturar:
- Autocompletado de un método al escribir su firma
- Generación de un constructor con todos los campos a partir de un comentario
- Sugerencia de un test case completo con Mockito

---

## 🧠 Experiencia con GitHub Copilot

### Lo que más me sorprendió

- **Velocidad**: Copilot genera estructuras completas (POJO con campos, getters, setters y constructores) en segundos a partir de un comentario.
- **Contexto**: Entiende el contexto del archivo. Si ya tienes una entidad `Product`, al escribir el servicio Copilot sabe qué métodos ofrecer.
- **Tests con Mockito**: La generación de mocks es especialmente útil. Solo describiendo qué método testear, genera el `@Mock`, `@InjectMocks` y el `when(...).thenReturn(...)` completo.
- **Documentación**: Al escribir `/**` antes de un método, Copilot genera el Javadoc completo con parámetros y descripción.

### Limitaciones observadas

- A veces sugiere código con APIs deprecadas
- No siempre entiende reglas de negocio muy específicas del proyecto
- Las sugerencias deben revisarse: Copilot no reemplaza el criterio del desarrollador

### Conclusión

GitHub Copilot es una herramienta poderosa que **acelera el desarrollo** y reduce el tiempo invertido en tareas repetitivas. El desarrollador sigue siendo responsable de revisar, entender y validar todo el código generado.

---

## 📂 Estructura del proyecto

```
Modulo7/
├── README.md
└── copilot-examples/
    ├── pojo/
    │   ├── ProductDTO.java
    │   └── UserDTO.java
    ├── springboot/
    │   ├── Product.java
    │   ├── ProductRepository.java
    │   ├── ProductService.java
    │   └── ProductController.java
    └── tests/
        └── ProductServiceTest.java
```

---

*Desarrollado con asistencia de GitHub Copilot — Academia Xideral, Módulo 7*
