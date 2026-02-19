🚀 Zarvela — Java Backend & Fundamentals

Repositorio que documenta mi evolución técnica en el ecosistema Java, desde fundamentos de Programación Orientada a Objetos hasta el desarrollo de una API REST con Spring Boot y persistencia real.

📌 Objetivo del Proyecto

Este repositorio demuestra la progresión técnica a través de:

Fundamentos sólidos de Java y POO

Manejo de excepciones, colecciones, enums y diseño orientado a objetos

Construcción de una API REST bajo arquitectura MVC

Integración con base de datos relacional usando JPA

🎯 Descripción del Proyecto

El objetivo principal de este repositorio es demostrar la progresión técnica desde los pilares de la Programación Orientada a Objetos hasta la construcción de una API REST funcional con persistencia de datos real.
📂 Estructura del Repositorio
```bash
.
├── Fundamentos_de_Java_POO/
│   ├── week1/
│   ├── week2/
│   └── ejercicios de lógica, POO y estructuras
│
├── zarvela/
│   ├── src/main/java
│   ├── src/test/java
│   └── Aplicación Spring Boot
│
└── README.md
```
🧱 Módulo 1 — Fundamentos de Java (POO)

Ubicación: Fundamentos_de_Java_POO/

Contiene ejercicios organizados por semanas:

🔹 Semana 1

Sintaxis básica

Tipos primitivos

Arreglos

Estructuras de control

Introducción a POO

🔹 Semana 2

Excepciones personalizadas (checked / unchecked)

try-with-resources

Clases internas (inner / static nested)

Iteradores personalizados

Enums avanzados con lógica

EnumMap y EnumSet

Diseño orientado a objetos aplicado

🌐 Módulo 2 — Zarvela API (Spring Boot)

Ubicación: zarvela/

API REST desarrollada bajo arquitectura MVC.

Características:

CRUD completo

Persistencia con JPA

Conexión a MySQL

Manejo de capas: Controller → Service → Repository

Buenas prácticas de diseño

🛠 Stack Tecnológico
Tecnología	Uso
Java 17	Lenguaje principal
Spring Boot 3	Framework backend
Spring Data JPA	Persistencia
MySQL	Base de datos
Maven	Gestión de dependencias
Lombok	Reducción de boilerplate
⚙️ Configuración y Ejecución (API)
Requisitos

Java 17+

Maven

MySQL (o Docker)

Base de Datos
URL: jdbc:mysql://localhost:3307/Zarvela
Usuario: root
Password: root
Hibernate está en modo update.

Ejecutar API
cd zarvela
mvn spring-boot:run
Disponible en: http://localhost:8080

La API estará disponible en: [http://localhost:8080](http://localhost:8080/api/pacientes)
