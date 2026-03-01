README – Zarvela Batch v2 (MySQL ➜ MongoDB)
# 🚀 Zarvela Batch v2 — MySQL ➜ MongoDB

Proyecto desarrollado como parte de **Academia Xideral**.

Este módulo implementa un flujo **Spring Batch** que:

1. 📥 Lee pacientes procesados desde MySQL
2. 🧠 Aplica lógica de negocio (clasificación clínica)
3. 📤 Persiste los resultados transformados en MongoDB

---

## 🏗 Arquitectura

```bash
MySQL (pacientes_procesados)
│
▼
JdbcCursorItemReader
│
▼
ReportePacienteProcessor
│
▼
MongoItemWriter
│
▼
MongoDB (reportes_pacientes)
```

---

## 🛠 Tecnologías

- Java 17
- Spring Boot 3.2.2
- Spring Batch
- MySQL 8 (Docker)
- MongoDB 7 (Docker)
- Maven
- Docker

---

## 📦 Estructura del Proyecto

```bash
zarvela-batch-v2-mongo
│
├── config
│ └── BatchConfig.java
│
├── model
│ ├── Paciente.java
│ └── ReportePaciente.java
│
├── processor
│ └── ReportePacienteProcessor.java
│
└── ZarvelaBatchV2MongoApplication.java

```
---

## ⚙️ Configuración

### 🔹 MySQL (Step 1)

```properties
spring.datasource.url=jdbc:mysql://localhost:3307/Zarvela
spring.datasource.username=root
spring.datasource.password=root
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
🔹 MongoDB (Step 2)
spring.data.mongodb.uri=mongodb://root:root123@localhost:27017/Zarvela?authSource=admin
```
🐳 Docker
```bash
MySQL
docker run -d \
  --name mysql-academia \
  -e MYSQL_ROOT_PASSWORD=root \
  -e MYSQL_DATABASE=Zarvela \
  -p 3307:3306 \
  mysql:8
MongoDB
docker run -d \
  --name mongo-academia \
  -e MONGO_INITDB_ROOT_USERNAME=root \
  -e MONGO_INITDB_ROOT_PASSWORD=root123 \
  -p 27017:27017 \
  mongo:7
▶️ Ejecutar el proyecto
./mvnw clean install
./mvnw spring-boot:run
```
Si todo es correcto, deberás ver:

Job: [SimpleJob: [name=procesarPacientesJob]] completed with status: [COMPLETED]
🔍 Verificar datos en Mongo

Entrar al contenedor:

winpty docker exec -it mongo-academia mongosh -u root -p root123

Luego:
```bash
use Zarvela
show collections --> Muestra las tablas en la BD.
db.reportes_pacientes.find().pretty() --> Muestra los registros
db.reportes_pacientes.find({ nivelRiesgo: "BAJO" }) --> Muestra los px con un nivel de riesgo bajo
db.reportes_pacientes.countDocuments() --> Muestra el numero total de registros. 
```
🧠 Lógica de Negocio

El ReportePacienteProcessor transforma los datos:
```bash
Nivel Riesgo	Categoría Clínica
ALTO	REQUIERE ATENCION INMEDIATA
MEDIO	SEGUIMIENTO PRIORITARIO
BAJO	CONTROL REGULAR
```
🧪 Testing — JUnit 5 + Mockito
Además del procesamiento Batch, este proyecto incluye tests unitarios completos, siguiendo buenas prácticas:

✅ Tests sin mocks para funciones puras

✅ Tests con Mockito para servicios con dependencias

❌ No se levanta Spring en unit tests

❌ No se requiere MySQL ni Mongo para ejecutar los tests
📂 Estructura de Tests
```bash
src/test/java/com/zarvela/zarvela_batch_v2_mongo
│
├── model
│   └── PacienteTest.java
│
├── processor
│   └── ReportePacienteProcessorTest.java
│
└── service
    └── PacienteServiceTest.java
```

Tests SIN Mock (JUnit 5 puro)

Se aplican cuando la clase:

No depende de base de datos

No depende de Spring

Es una función pura (entrada → salida)

Ejemplo: ReportePacienteProcessorTest

```bash
@Test
@DisplayName("process: convierte nombre a mayúsculas")
void process_nombreSeConvierteAMayusculas() throws Exception {

    Paciente paciente = new Paciente("Juan Perez", 65, "Vertigo", "ALTO");

    ReportePaciente resultado = processor.process(paciente);

    assertEquals("JUAN PEREZ", resultado.getNombre());
}
```

🔑 Configuración de Mockito
```bash
@ExtendWith(MockitoExtension.class)
class PacienteServiceTest {

    @Mock
    private ReportePacienteProcessor processor;

    @Mock
    private ReportePacienteRepository repository;

    @InjectMocks
    private PacienteService service;
}
```
¿Qué hace cada anotación?
Anotación	Función
@ExtendWith(MockitoExtension.class)	Activa Mockito en JUnit 5
@Mock	Crea un mock automático
@InjectMocks

🧠 Técnicas de Mockito utilizadas

Este proyecto implementa las técnicas principales:
```bash
| Técnica           | Uso                                  |
| ----------------- | ------------------------------------ |
| `when/thenReturn` | Programar retorno de mocks           |
| `verify`          | Verificar que un método fue llamado  |
| `times(n)`        | Verificar número de invocaciones     |
| `never()`         | Verificar que NO se llamó un método  |
| `InOrder`         | Verificar orden de ejecución         |
| `ArgumentCaptor`  | Capturar argumentos enviados al mock |
| `any()`           | Coincidir con cualquier argumento    |

```

▶️ Ejecutar Tests
```bash
./mvnw test
```
nota: No es necesario que MySQL ni Mongo estén corriendo.

Salida esperada:
```bash
[INFO] Tests run: X, Failures: 0, Errors: 0, Skipped: 0
[INFO] BUILD SUCCESS
```

📊 Cobertura conceptual del módulo

Este proyecto cubre:

Spring Batch

MySQL ➜ Mongo

Arquitectura por capas

Testing con JUnit 5

Testing profesional con Mockito

Verificación de interacción entre componentes

Buenas prácticas de testing backend



📌 Observaciones Técnicas

No se usa @EnableBatchProcessing (Spring Boot 3 ya lo auto-configura).

El Job se ejecuta automáticamente al iniciar la aplicación.

Cada ejecución genera un nuevo run.id.

Mongo genera _id automático (ObjectId).

🚀 Posibles Mejoras

Evitar duplicados en Mongo con índice único.

Implementar upsert en lugar de insert.

Exponer Mongo como API REST.

Agregar métricas con Micrometer.

Agregar Step adicional de agregación.

👨‍💻 Autor
```bash 
Dante Medina
Proyecto académico — Academia Xideral
Spring Batch | Backend Engineering | Data Processing
```