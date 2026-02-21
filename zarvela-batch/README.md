# 🏥 Zarvela Batch — Procesamiento Clínico con Spring Batch

Proyecto de procesamiento por lotes (Batch Processing) construido con **Spring Boot 3.2 + Spring Batch 5 + MySQL (Docker)**.

Este proyecto simula el procesamiento de pacientes clínicos desde un archivo CSV hacia una base de datos, aplicando reglas de negocio y manteniendo metadata de ejecución.

---

## 🚀 Tecnologías Utilizadas

- Java 17+
- Spring Boot 3.2.2
- Spring Batch 5
- MySQL 8 (Docker)
- Maven Wrapper (mvnw)
- DBeaver (opcional para visualización)

---

## 📂 Arquitectura del Proyecto
```bash
zarvela-batch/
│
├── src/main/java/com/zarvela/zarvela_batch/
│ ├── ZarvelaBatchApplication.java
│ ├── config/BatchConfig.java
│ ├── model/Paciente.java
│ └── processor/PacienteProcessor.java
│
├── src/main/resources/
│ ├── application.properties
│ └── pacientes.csv
│
└── pom.xml
```

---

## ⚙️ ¿Qué hace el Batch?

1. 📥 Lee un archivo CSV (`pacientes.csv`)
2. 🔄 Aplica reglas de negocio:
   - Nombre en mayúsculas
   - Nivel de riesgo según edad
3. 💾 Inserta los resultados en MySQL (`pacientes_procesados`)
4. 📊 Guarda metadata en tablas `BATCH_*`

---

## 🏗️ Flujo Interno
```bash
CSV
↓
FlatFileItemReader
↓
PacienteProcessor (reglas de negocio)
↓
JdbcBatchItemWriter
↓
MySQL
```

Procesamiento en **chunks de 3 registros**.

---

## 🐳 Base de Datos (Docker)

Crear contenedor:

```bash
docker run --name mysql-academia \
  -e MYSQL_ROOT_PASSWORD=root \
  -e MYSQL_DATABASE=Zarvela \
  -v mysql_academia_data:/var/lib/mysql \
  -p 3307:3306 \
  -d mysql:8
```
🗄️ Tabla de Negocio
```bash
CREATE TABLE pacientes_procesados (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL,
    edad INT NOT NULL,
    diagnostico VARCHAR(100) NOT NULL,
    nivel_riesgo VARCHAR(50) NOT NULL
);
```
▶️ Ejecutar el Proyecto

Desde la carpeta raíz:
```bash
./mvnw clean install
./mvnw spring-boot:run
```
Si todo funciona correctamente verás: 
```bash
Job ... completed with status: COMPLETED
```
🔎 Ver Resultados
```bash
USE Zarvela;
SELECT * FROM pacientes_procesados;
```
También puedes visualizar las tablas BATCH_* para ver el historial de ejecuciones.
📌 Estado Actual

✔ Conexión a MySQL
✔ Lectura desde CSV
✔ Transformación con reglas clínicas
✔ Escritura en base de datos
✔ Metadata automática de ejecución