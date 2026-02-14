Zarvela — Backend API & Java Fundamentals

Este repositorio contiene dos partes principales de aprendizaje y desarrollo en Java:

Ejercicios de fundamentos de Java (POO)

API REST construida con Spring Boot conectada a MySQL

El objetivo del repositorio es documentar el progreso desde los fundamentos del lenguaje hasta la construcción de una API funcional con persistencia de datos.

Estructura del repositorio
.
├── Fundamentos_de_Java_POO
└── zarvela
Fundamentos_de_Java_POO

Carpeta con ejercicios prácticos de la Semana 1, enfocados en reforzar los conceptos base de Java:

Tipos primitivos

Clases y objetos

Encapsulación

Arreglos y loops

Condicionales

Herencia y polimorfismo

Estos ejercicios funcionan como base para entender la arquitectura usada posteriormente en Spring Boot.

Zarvela API

Proyecto Spring Boot que expone una API REST conectada a una base de datos MySQL.

Tecnologías

Java 17

Spring Boot

Spring Web

Spring Data JPA

MySQL

Maven

Lombok

Configuración de base de datos

La aplicación se conecta a MySQL usando:

jdbc:mysql://localhost:3307/Zarvela

Configuración en application.properties:

spring.datasource.url=jdbc:mysql://localhost:3307/Zarvela
spring.datasource.username=root
spring.datasource.password=root
spring.jpa.hibernate.ddl-auto=update

Hibernate crea o actualiza automáticamente las tablas a partir de las entidades JPA.

Ejecutar el proyecto

Desde la carpeta zarvela:

mvn spring-boot:run

La API se ejecuta en:

http://localhost:8081
Notas

Este repositorio forma parte de un proceso de aprendizaje práctico de:

Java

Spring Boot

APIs REST

Persistencia con JPA

Integración con MySQL en Docker
