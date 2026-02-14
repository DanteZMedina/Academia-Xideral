🚀 Zarvela — Backend API & Java Fundamentals

Bienvenido al repositorio Zarvela, un espacio dedicado a documentar mi curva de aprendizaje en el ecosistema Java, abarcando desde la lógica pura de programación hasta la arquitectura de microservicios.
📋 Tabla de Contenidos

    Descripción del Proyecto

    Estructura del Repositorio

    Módulo 1: Fundamentos de Java (POO)

    Módulo 2: Zarvela API (Spring Boot)

    Stack Tecnológico

    Configuración y Ejecución

🎯 Descripción del Proyecto

El objetivo principal de este repositorio es demostrar la progresión técnica desde los pilares de la Programación Orientada a Objetos hasta la construcción de una API REST funcional con persistencia de datos real.
📂 Estructura del Repositorio
Bash

.
├── Fundamentos_de_Java_POO  # Ejercicios de lógica y bases del lenguaje
└── zarvela                  # Aplicación Backend principal (Spring Boot)

🧱 Módulo 1: Fundamentos de Java (POO)

Esta sección contiene la base técnica desarrollada durante la Semana 1, enfocada en la resolución de problemas mediante el paradigma de objetos:

    Sintaxis Base: Tipos primitivos, arreglos y estructuras de control (loops/condicionales).

    POO Avanzada: Implementación de Herencia, Polimorfismo y Encapsulamiento.

    Lógica de Negocio: Modelado de clases que sirven de base para la arquitectura de Spring Boot.

🌐 Módulo 2: Zarvela API (Spring Boot)

Una API REST robusta diseñada bajo el patrón de diseño MVC (Modelo-Vista-Controlador) para gestionar la persistencia de datos.
🛠 Stack Tecnológico
Tecnología	Función
Java 17	Lenguaje de programación principal
Spring Boot 3	Framework de desarrollo Backend
Spring Data JPA	Abstracción de persistencia de datos
MySQL	Base de datos relacional
Maven	Gestor de dependencias y construcción
Lombok	Optimización de código (Boilerplate reduction)
⚙️ Configuración y Ejecución
Requisitos Previos

    Java 17 o superior.

    Maven instalado.

    MySQL corriendo (preferiblemente vía Docker).

1. Base de Datos

La aplicación está configurada para conectarse a:

    URL: jdbc:mysql://localhost:3307/Zarvela

    Credenciales: root / root

    [!TIP]
    Hibernate está configurado en modo update, por lo que las tablas se crearán automáticamente al iniciar la aplicación.

2. Ejecución

Navega a la carpeta del proyecto y ejecuta:
Bash

cd zarvela
mvn spring-boot:run

La API estará disponible en: http://localhost:8080
