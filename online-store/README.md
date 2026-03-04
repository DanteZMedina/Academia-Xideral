# API de Ecommerce (Spring Boot)

API REST para un sistema de comercio electrónico construida con Spring Boot.

Este proyecto implementa funcionalidades básicas de un ecommerce como gestión de productos, clientes y pedidos, además de incluir validaciones, manejo global de errores, pruebas unitarias y consultas avanzadas.

## 🚀 Tecnologías utilizadas

- Java 17
- Spring Boot
- Spring Data JPA
- H2 Database
- Lombok
- JUnit 5
- Mockito

## 📦 Funcionalidades

- Product management
- Customer management
- Order creation
- Stock validation
- Top selling products
- Pagination and sorting
- Global exception handling
- Unit tests

## ▶️ Ejecutar el proyecto

```bash
./mvnw spring-boot:run
Open H2 console:
Open H2 console:
🗄️ Consola de base de datos H2

http://localhost:8080/h2-console

Configuración:
JDBC URL:
jdbc:h2:mem:testdb

📚 Endpoints principales
Get products
GET /api/v1/products?page=0&size=10
Crear un pedido
POST /api/v1/orders
{
  "customerId": 1,
  "items": [
    {
      "productId": 1,
      "quantity": 2
    }
  ]
}

Obtener productos más vendidos
GET /api/v1/products/top-selling
[
  {
    "productId": 1,
    "name": "Laptop Pro",
    "totalSold": 4
  }
]
🧪 Ejecutar pruebas
Run tests con:

./mvnw test


---

📊 Arquitectura del proyecto
El proyecto sigue una arquitectura por capas:
controller
service
repository
model
dto
exception
config

```
👨‍💻 Autor Dante Medina. 

Desarrollado como parte de práctica de backend con Spring Boot.

