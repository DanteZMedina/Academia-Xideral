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

🧱 Módulo 1: Fundamentos de Java
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
Este módulo representa el fundamento conceptual sobre el cual se construye la API.

🌐 Módulo 2: Zarvela API (Spring Boot)
Aplicación Backend desarrollada con Spring Boot 3, implementando el patrón de arquitectura MVC (Modelo-Vista-Controlador) para gestionar persistencia de datos en MySQL.
La API incluye:
```bash
- Controladores REST
- Servicios con lógica de negocio
- Repositorios con Spring Data JPA
- Persistencia automática mediante Hibernate
- Integración con base de datos relacional
```

🛠 Stack Tecnológico
```bash
Tecnología	Función
Java 17	Lenguaje principal
Spring Boot 3	Framework Backend
Spring Data JPA	Abstracción de persistencia
MySQL	Base de datos relacional
Maven	Gestión de dependencias
Lombok	Reducción de código boilerplate
```

⚙️ Configuración y Ejecución
🔹 Requisitos Previos
Java 17 o superior
Maven instalado
MySQL corriendo (preferiblemente vía Docker)

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
