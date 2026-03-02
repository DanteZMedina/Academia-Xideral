🚀 ACADEMIA DE JAVA XIDERAL — Backend API & Java Fundamentals

Bienvenido al repositorio ACADEMIA DE JAVA XIDERAL, un espacio dedicado a documentar mi curva de aprendizaje en el ecosistema Java, abarcando desde la lógica pura de programación hasta la construcción de una API REST con arquitectura profesional usando Spring Boot.

 📋 Tabla de Contenidos
```bash
🎯 Descripción del Proyecto

📂 Estructura del Repositorio

🧱 Módulo 1: Fundamentos de Java

🌐 Módulo 2: Zarvela API (Spring Boot)

🛠 Stack Tecnológico

⚙️ Configuración y Ejecución
```
🎯 Descripción del Proyecto

El objetivo principal de este repositorio es demostrar la progresión técnica desde los pilares de la Programación Orientada a Objetos hasta la construcción de una API REST funcional con persistencia de datos real.
Este proyecto refleja:
Evolución desde lógica básica hasta arquitectura backend
Aplicación práctica de principios SOLID y POO
Implementación del patrón MVC con Spring Boot
Integración con base de datos relacional

```bash
.
├── fundamentos   # Ejercicios de lógica y bases del lenguaje Java
└── zarvela       # Aplicación Backend principal (Spring Boot)
```
⚠️ Las carpetas Fundamentos_de_Java_POO y StudentProfile no forman parte de la estructura oficial del proyecto actual.

🧱 Fundamentos : 
Semana 1: Fundamentos de Java
Esta sección contiene la base técnica enfocada en la resolución de problemas utilizando el paradigma orientado a objetos.
Incluye:
```bash
🔹 Sintaxis base: Tipos primitivos, arreglos y estructuras de control
🔹 Manejo de colecciones
🔹 Programación Orientada a Objetos:
        Encapsulamiento
        Herencia
        Polimorfismo
🔹 Modelado de clases
🔹 Manejo de excepciones
```
Semana 2: Lección: Excepciones, Patrones y Diseño
Cubre excepciones, clases anidadas, enumeraciones, interfaces funcionales y patrones de diseño.
Incluye:
```bash
🔹 Ejercicio 1: Excepciones Personalizadas — Sistema Bancario
🔹 Ejercicio 2: Iterador con Inner Class — SimpleStack
🔹 Ejercicio 3: Sistema de Tickets con Enums Avanzados
🔹 Ejercicio 4: Pipeline Funcional de Productos
🔹 Ejercicio 5: Pizzas — Builder + Decorator
🔹 Ejercicio 6: Framework de Eventos — Observer + Strategy + DI
```

Semana 3: Java Avanzado - Colecciones, Lambdas y Streams
Seis ejercicios progresivos que cubren Collections, Generics, Lambdas, Streams y CompletableFuture.
Incluye:
```bash
🔹 Ejercicio 1: Gestor de Contactos con Collections
🔹 Ejercicio 2: Caché Genérico con Expiración
🔹 Ejercicio 3: Validador Composable con Lambdas
🔹 Ejercicio 4: Análisis de Ventas con Streams
🔹 Ejercicio 5: Pipeline de Procesamiento de Texto
🔹 Ejercicio 6: Web Scraper Concurrente con CompletableFuture
```

Semana 4: Lección: Spring Boot, REST y Herramientas
6 ejercicios progresivos construirás una API REST completa para una tienda en línea usando Spring Boot, JPA, testing y Git. Cada ejercicio agrega funcionalidad sobre el anterior.
Incluye:
```bash
🔹 Ejercicio 1: Proyecto Base y Modelo de Datos
🔹 Ejercicio 2: Repository y Service Layer
🔹 Ejercicio 3: REST Controller con CRUD Completo
🔹 Ejercicio 4: Unit Tests con JUnit 5 y Mockito
🔹 Ejercicio 5: Relaciones JPA y Consultas Avanzadas
🔹 Ejercicio 6: (Bonus): Data Loader, Paginación y Documentación
```

🌐 Zarvela API (Spring Boot)
Aplicación Backend desarrollada con Spring Boot 3, implementando el patrón de arquitectura MVC (Modelo-Vista-Controlador) para gestionar persistencia de datos en MySQL.
La API incluye:
```bash
- Controladores REST
- Servicios con lógica de negocio
- Repositorios con Spring Data JPA
- Persistencia automática mediante Hibernate
- Integración con base de datos relacional
```


👩‍⚕️ Zarvela Spring Batch — Procesamiento por Lotes de Pacientes
Zarvela Spring Batch es un módulo especializado en procesamiento masivo de datos clínicos, enfocado en la carga, transformación y persistencia automatizada de información de pacientes.
Este módulo simula un escenario real del sector salud donde es necesario:
```bash
- Procesar miles de registros clínicos sin intervención manual
- Transformar datos antes de almacenarlos
- Garantizar trazabilidad e historial de ejecución
- Manejar grandes volúmenes con eficiencia y control transaccional
```

⚙️ Configuración y Ejecución
- Requisitos Previos
- Java 17 o superior 
- Maven instalado
- MySQL corriendo (preferiblemente vía Docker)

🔹 Base de Datos
La aplicación está configurada para conectarse a:
```bash
    URL: jdbc:mysql://localhost:3307/Zarvela
    User: root
    Password: root
```
💡 Hibernate está configurado en modo update, por lo que las tablas se crearán automáticamente al iniciar la aplicación.

🔹 Ejecución
Desde la raíz del proyecto:
```bash
cd zarvela
mvn spring-boot:run
```
La API estará disponible en:
```bash
http://localhost:8080
http://localhost:8080/api/pacientes
```

👩‍⚕️ Zarvela Spring BatchV2Mongo — Procesamiento por Lotes de Pacientes y escribiendo los datos procesados en mongo. 
Para mas información entrar en la carpeta correspondiente: 
```bash

Academia-Xideral >>> zarvela-batch-v2-mongo
```
