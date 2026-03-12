# Inventory API - Spring Boot Project

## Descripción

Este proyecto es una **API REST desarrollada con Spring Boot** que permite gestionar un inventario de productos y categorías.

Forma parte de los **Milestones 1 y 2 del proyecto**, donde se implementa:

* Modelo de datos con JPA
* Repositorios
* Servicios con lógica de negocio
* Controladores REST
* Manejo global de excepciones
* Validaciones
* Base de datos en memoria (H2)
* Tests unitarios

---

# Tecnologías utilizadas

* Java 17
* Spring Boot 3.3
* Spring Data JPA
* Spring Web
* Spring Validation
* H2 Database
* Maven
* JUnit / Spring Boot Test

---

# Estructura del proyecto

```
inventory
│
├── controller
│   ├── ProductController.java
│   └── CategoryController.java
│
├── service
│   ├── ProductService.java
│   └── CategoryService.java
│
├── repository
│   ├── ProductRepository.java
│   ├── CategoryRepository.java
│   └── OrderRepository.java
│
├── entity
│   ├── Product.java
│   ├── Category.java
│   └── Order.java
│
├── exception
│   └── GlobalExceptionHandler.java
│
└── InventoryApplication.java
```

---

# Cómo descargar el proyecto

Clonar el repositorio desde GitHub:

```
git clone https://github.com/TU-USUARIO/inventory.git
```

Entrar al directorio del proyecto:

```
cd inventory
```

---

# Cómo ejecutar el proyecto

### 1️⃣ Compilar el proyecto

```
mvn clean install
```

---

### 2️⃣ Ejecutar la aplicación

```
mvn spring-boot:run
```

La aplicación iniciará en:

```
http://localhost:8080
```

---

# Base de datos H2

La base de datos se ejecuta **en memoria**.

Acceder a la consola:

```
http://localhost:8080/h2-console
```

Configuración:

```
JDBC URL: jdbc:h2:mem:testdb
User: sa
Password: (vacío)
```

---

# Endpoints principales

## Productos

| Método | Endpoint           | Descripción                 |
| ------ | ------------------ | --------------------------- |
| GET    | /api/products      | Obtener todos los productos |
| GET    | /api/products/{id} | Obtener producto por ID     |
| POST   | /api/products      | Crear producto              |
| PUT    | /api/products/{id} | Actualizar producto         |
| DELETE | /api/products/{id} | Eliminar producto           |

---

## Categorías

| Método | Endpoint        | Descripción                  |
| ------ | --------------- | ---------------------------- |
| GET    | /api/categories | Obtener todas las categorías |
| POST   | /api/categories | Crear categoría              |

---

# Ejemplos de uso

### Obtener productos

```
GET http://localhost:8080/api/products
```

Respuesta esperada:

```
[
  {
    "id": 1,
    "name": "Laptop",
    "price": 1200
  }
]
```

---

### Obtener producto inexistente

```
GET /api/products/999
```

Respuesta esperada:

```
404 NOT FOUND
Product not found
```

---

# Ejecutar tests

Para correr los tests unitarios:

```
mvn test
```

Resultado esperado:

```
Tests run: X
Failures: 0
Errors: 0
```

---

# Resultados esperados del proyecto

Al ejecutar correctamente el proyecto se debe:

* Iniciar el servidor en **localhost:8080**
* Poder acceder a los endpoints REST
* La base de datos H2 debe contener datos iniciales
* Todos los tests deben ejecutarse correctamente
* Manejar errores como **404 Not Found**

---

# Autor
DanteZMedina

Proyecto desarrollado como parte de los ejercicios prácticos de **Spring Boot Backend Development**.
