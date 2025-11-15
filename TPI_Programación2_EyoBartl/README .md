**Link al Drive que contiene el video**
https://drive.google.com/drive/folders/1rFosNQO6qsVEnGVXB_6MSNKQWjEmD7mr?usp=sharing


**Sistema de Gestión de Pedidos y Envíos**

**Descripción**

Sistema CRUD completo desarrollado en Java para la gestión de pedidos y
envíos, implementando una relación 1→1 unidireccional con arquitectura
en capas y operaciones transaccionales.

El sistema gestiona el proceso completo de pedidos y envíos. Cada pedido
realizado por un cliente puede tener asociado un único envío, pero no
todos los pedidos necesariamente requieren envío.

**Características Principales**

-   Gestión Completa de Pedidos: CRUD con validaciones y búsquedas
    avanzadas

-   Sistema de Envíos Integrado: Gestión independiente o asociada a
    pedidos

-   Arquitectura en 5 Capas: Separación clara de responsabilidades

-   Transacciones Atómicas: Operaciones todo-o-nada con rollback
    automático

-   Seguridad Robusta: 100% PreparedStatements para prevenir SQL
    injection

-   Soft Delete: Eliminación lógica que preserva la integridad de datos

-   Relación 1→1: Implementación correcta con FK UNIQUE en base de datos

**Entidades Principales**

**Pedido**

Representa una transacción de compra con:

-   Número único identificador del pedido

-   Información del cliente que realiza la compra

-   Total, de la transacción

-   Estado del flujo del pedido (NUEVO → FACTURADO → ENVIADO)

-   Fecha de creación automática

**Envío**

Gestiona la distribución con:

-   Número de tracking único para seguimiento

-   Empresa de transporte (ANDREANI, OCA, CORREO_ARG)

-   Tipo de envío (ESTÁNDAR o EXPRÉS)

-   Costos asociados al transporte

-   Fechas estimadas y reales de despacho

-   Estado del envío (PREPARACIÓN → TRÁNSITO → ENTREGADO)

**Relación 1→1 Unidireccional**

Pedido (1) \-\-\-\-- (0..1) Envío

-   Unidireccional: El Pedido conoce su Envío, pero el Envío no conoce
    el Pedido

-   Opcional: Un Pedido puede existir sin Envío

-   Exclusiva: Un Envío solo puede estar asociado a un Pedido

**Tecnologías**

-   Java 21 - Lenguaje principal

-   MySQL 8.x - Base de datos

-   JDBC - Conector de base de datos

-   Patrones de Diseño: DAO, Service Layer, Factory, Transaction Manager

**Instalación**

**Prerrequisitos**

-   Java JDK 21 o superior

-   MySQL 8.0 o superior

-   MySQL Connector/J 8.0.33

**1. Configuración de la Base de Datos**

sql

\-- Crear base de datos

DROP DATABASE IF EXISTS prog2;

CREATE DATABASE prog2;

USE prog2;

\-- Tabla de envíos

CREATE TABLE envios (

id BIGINT AUTO_INCREMENT PRIMARY KEY,

tracking VARCHAR(40) UNIQUE NOT NULL,

empresa ENUM(\'ANDREANI\', \'OCA\', \'CORREO_ARG\') NOT NULL,

tipo ENUM(\'ESTANDAR\', \'EXPRES\') NOT NULL,

costo DECIMAL(10,2),

fecha_despacho DATE,

fecha_estimada DATE,

estado_envio ENUM(\'EN_PREPARACION\', \'EN_TRANSITO\', \'ENTREGADO\')
NOT NULL,

eliminado BOOLEAN DEFAULT FALSE

);

\-- Tabla de pedidos con relación 1→1

CREATE TABLE pedidos (

id BIGINT AUTO_INCREMENT PRIMARY KEY,

numero VARCHAR(20) UNIQUE NOT NULL,

fecha DATE NOT NULL,

cliente_nombre VARCHAR(120) NOT NULL,

total DECIMAL(12,2) NOT NULL,

estado ENUM(\'NUEVO\', \'FACTURADO\', \'ENVIADO\') NOT NULL,

envio_id BIGINT UNIQUE, \-- FK UNIQUE para relación 1→1

eliminado BOOLEAN DEFAULT FALSE,

FOREIGN KEY (envio_id) REFERENCES envios(id) ON DELETE SET NULL

);

**2. Datos de Prueba**

sql

USE prog2;

\-- INSERCIÓN DE ENVÍOS (TABLA HIJA/DEPENDIENTE)

\-- Nota: Insertamos primero los envíos para poder

\-- referenciarlos en la tabla de pedidos mediante la FK.

INSERT INTO envios (id, tracking, empresa, tipo, costo, fecha_despacho,
fecha_estimada, estado_envio, eliminado) VALUES

(1, \'TRK-1001\', \'ANDREANI\', \'ESTANDAR\', 5500.50, \'2025-11-01\',
\'2025-11-05\', \'ENTREGADO\', FALSE),

(2, \'TRK-1002\', \'OCA\', \'EXPRES\', 8200.00, \'2025-11-10\',
\'2025-11-12\', \'EN_TRANSITO\', FALSE),

(3, \'TRK-1003\', \'CORREO_ARG\', \'ESTANDAR\', 4100.00, NULL, NULL,
\'EN_PREPARACION\', FALSE),

(4, \'TRK-1004\', \'ANDREANI\', \'EXPRES\', 9000.00, NULL, NULL,
\'EN_PREPARACION\', FALSE);

\-- 2. INSERCIÓN DE PEDIDOS (TABLA PADRE)

\-- Pedidos 1, 2 y 3 Ya tienen envío asignado (Relación 1-\>1)

\-- Pedidos 4 y 5: No tienen envío (envio_id NULL)

INSERT INTO pedidos (numero, fecha, cliente_nombre, total, estado,
envio_id, eliminado) VALUES

(\'PED-001\', \'2025-10-25\', \'Juan Perez\', 150000.00, \'ENVIADO\', 1,
FALSE),

(\'PED-002\', \'2025-11-08\', \'Maria Garcia\', 45600.50, \'ENVIADO\',
2, FALSE),

(\'PED-003\', \'2025-11-11\', \'Tecno Sur SA\', 980000.00, \'ENVIADO\',
3, FALSE),

(\'PED-004\', \'2025-11-12\', \'Carlos Lopez\', 12500.00, \'FACTURADO\',
NULL, FALSE),

(\'PED-005\', \'2025-11-13\', \'Ana Martinez\', 32000.00, \'NUEVO\',
NULL, FALSE);

**3. Configuración del Proyecto**

**Configuración por defecto:**

properties

Host: localhost:3306

Base de datos: prog2

Usuario: root

Contraseña: (vacía)

**Configuración personalizada:**

bash

java -Ddb.url=jdbc:mysql://localhost:3306/prog2 \\

-Ddb.user=tu_usuario \\

-Ddb.password=tu_contraseña \\

-cp \"build:mysql-connector-java-8.0.33.jar\" trabajointegrador2.AppMenu

**Uso**

**Ejecución**

bash

\# Compilar (desde IDE o línea de comandos)

javac -cp \"mysql-connector-java-8.0.33.jar\" -d build src/\*\*/\*.java

\# Ejecutar

java -cp \"build:mysql-connector-java-8.0.33.jar\"
trabajointegrador2.AppMenu

**Menú Principal**

\*\*\*\*\* GESTIÓN DE PEDIDOS Y ENVÍOS \*\*\*\*\*

1\. Crear pedido

2\. Listar pedidos

3\. Actualizar pedido

4\. Eliminar pedido

5\. Crear envío

6\. Listar envíos

7\. Actualizar envío

8\. Eliminar envío

9\. Asignar envío a pedido

10\. Eliminar envío de pedido

0\. Salir

**Ejemplos de Uso**

**Crear Pedido con Envío**

Número de pedido: PED-001

Nombre del cliente: Juan Pérez

Total: 12500.50

¿Desea crear un envío para este pedido? (s/n): s

Número de tracking: TRK001

Empresa (1-ANDREANI, 2-OCA, 3-CORREO_ARG): 1

Tipo (1-ESTANDAR, 2-EXPRES): 1

Costo: 1500.00

Estado (1-EN_PREPARACION, 2-EN_TRANSITO, 3-ENTREGADO): 1

**Buscar Pedidos por Cliente**

¿Desea (1) listar todos o (2) buscar por cliente? 2

Ingrese nombre del cliente a buscar: Juan

ID: 1, Número: PED-001, Cliente: Juan Pérez, Total: \$12500.50, Estado:
FACTURADO

Envío: TRK001 - EN_PREPARACION

**Arquitectura**

**Estructura del Proyecto**

trabajointegrador2/

├──Model \# Entidades de dominio

│ ├── Base.java \# Clase abstracta con id y eliminado

│ ├── Pedido.java \# Entidad Pedido

│ ├── Envio.java \# Entidad Envio

│ └── Enums \# Dominios acotados

│ ├── Estados.java

│ ├── Empresas.java

│ ├── Tipos.java

│ └── EstadosEnvios.java

├──Dao \# Capa de acceso a datos

│ ├── GenericDao.java \# Interfaz genérica CRUD

│ ├── PedidoDao.java \# DAO específico para pedidos

│ └── EnvioDao.java \# DAO específico para envíos

├──Service/ \# Lógica de negocio

│ ├── GenericService.java \# Interfaz genérica servicios

│ ├── PedidoService.java \# Servicio con validaciones

│ └── EnvioService.java \# Servicio con validaciones

├──Config/ \# Configuración e infraestructura

│ ├── DatabaseConnection.java \# Factory de conexiones

│ └── TransactionManager.java \# Gestor transaccional

└──trabajointegrador2/ \# Capa de presentación

├── AppMenu.java \# Orquestador principal

├── MenuHandler.java \# Controlador de operaciones

├── MenuDisplay.java \# Vista del menú

├── Main.java \# Punto de entrada

└── TestConexion.java \# Utilidad de verificación

**Diagrama de Capas**

┌─────────────────────────────────┐

│ PRESENTACIÓN │

│ AppMenu · MenuHandler │

└───────────────┬─────────────────┘

│

┌───────────────▼─────────────────┐

│ SERVICIO │

│ Validaciones · Reglas Negocio │

└───────────────┬─────────────────┘

│

┌───────────────▼─────────────────┐

│ DAO │

│ Persistencia · Queries SQL │

└───────────────┬─────────────────┘

│

┌───────────────▼─────────────────┐

│ MODELO │

│ Entidades · Enums · Base │

└───────────────┬─────────────────┘

│

┌───────────────▼─────────────────┐

│ CONFIG │

│ Conexiones · Transacciones │

└─────────────────────────────────┘

**Modelo de Datos**

sql

\-- Relación 1→1: Pedido → Envio

pedidos.envio_id BIGINT UNIQUE FOREIGN KEY REFERENCES envios(id)

**Configuración**

**DatabaseConnection**

java

// Configuración estática con validación

public static Connection getConnection() throws SQLException {

return DriverManager.getConnection(URL, USER, PASSWORD);

}

**TransactionManager**

java

// Gestión automática de transacciones

try (TransactionManager tx = new TransactionManager(conn)) {

tx.startTransaction();// Operaciones transaccionales

tx.commit();

} // Rollback automático en caso de error

**Seguridad y Validaciones**

**Prevención de SQL Injection**

java

// 100% PreparedStatements

private static final String INSERT_SQL =

\"INSERT INTO pedidos (numero, cliente_nombre, total) VALUES (?, ?,
?)\";

**Validaciones Multi-nivel**

-   Service Layer: Validaciones de negocio

-   Base de Datos: Constraints UNIQUE y FOREIGN KEY

-   Aplicación: Validación de inputs con .trim()

**Operaciones Transaccionales**

**Crear Pedido con Envío**

java

public void insertar(Pedido pedido) throws Exception {

try (TransactionManager tx = new
TransactionManager(DatabaseConnection.getConnection())) {

tx.startTransaction();

if (pedido.getEnvio() != null && pedido.getEnvio().getId() == 0) {

envioDao.insertTx(pedido.getEnvio(), tx.getConnection());

}

pedidoDao.insertTx(pedido, tx.getConnection());

tx.commit(); // Todo OK → Commit

} // Error → Rollback automático

}

**Solución de Problemas**

**Error: ClassNotFoundException**

Solución: Asegurar que el JAR de MySQL está en el classpath

bash

java -cp \"build:mysql-connector-java-8.0.33.jar\"
trabajointegrador2.AppMenu

**Error: Communications Link Failure**

Solución: Verificar que MySQL esté ejecutándose

bash

\# Linux/macOS

sudo systemctl start mysql

\# Windows

net start MySQL80

**Error: Access Denied**

Solución: Verificar credenciales en DatabaseConnection.java o usar
parámetros:

bash

java -Ddb.user=usuario -Ddb.password=clave \...

**Conceptos Académicos Implementados**

Programación Orientada a Objetos

-    Herencia: Clase abstracta Base

-    Polimorfismo: Interfaces GenericDAO\<T\>, GenericService\<T\>

-    Encapsulamiento: Atributos privados + getters/setters

-   Abstracción: Separación interfaz/implementación

**Patrones de Diseño**

-   DAO Pattern: Abstracción del acceso a datos

-   Service Layer: Separación lógica de negocio

-   Factory Pattern: DatabaseConnection

-   Transaction Manager: Gestión transaccional

**Gestión de Recursos**

-   Try-with-resources: Cierre automático de conexiones

-   AutoCloseable: TransactionManager con rollback automático

**Testing**

**Verificar Conexión**

bash

java -cp \"build:mysql-connector-java-8.0.33.jar\"
trabajointegrador2.TestConexion

Salida esperada:

Conexión exitosa a la base de datos

Usuario conectado: root@localhost

Base de datos: prog2

**Reglas de Negocio**

1.  Unicidad: Número de pedido y tracking de envío deben ser únicos

2.  Integridad Referencial: Relación 1→1 mantenida con FK UNIQUE

3.  Transacciones: Operaciones compuestas son atómicas

4.  Soft Delete: Eliminación lógica sin pérdida de datos

5.  Validaciones: Multi-nivel (aplicación + base de datos)

**Mejoras Futuras**

-   Implementar índices para consultas en la base de datos

-   Desarrollar interfaz gráfica (java swing)

-   Implementar una generación automática y secuencial del número de
    pedido y traking con una estructura preestablecida

-   Implementar tests unitarios

Versión: 1.0\
Java: 21+\
MySQL: 8.x\
Arquitectura: 5-capas con relación 1→1
