# Cliente-con-turnos
# Turn Management System (Java-Console)

A structured **Java console application** designed to manage, allocate, and track customer 
service appointments or turns. This system implements a clean, multi-layered architecture 
that decouples user interaction from the business logic and persistent data management via JDBC.

## 🚀 Key Features

* **Customer Management:** Register new customers using their identification details 
(ID/Cedula and Name) and search for existing clients directly within the database.

* **Service Administration:** Catalog different service types offered by the entity using unique alphanumeric codes.

* **Turn Allocation & Scheduling:** Schedule appointments dynamically by defining specific 
time blocks (month, day, hour) and linking customers with their required services.

* **Status Tracking & Closure:** List all active turns associated with a particular 
customer and seamlessly close resolved appointments, modifying their execution status persistently.

---

## 🏗️ Project Architecture

The application strictly follows a **layered software design pattern** to ensure separation of concerns and high maintainability:

* **`pkg2006_turnos_a` (Presentation Layer):** Houses the `Main.java` entry point. It manages the 
runtime loop, processes the command-line interactive menu using `java.util.Scanner`, and handles user inputs.

* **`Logica` (Business Logic Layer):** Contains controller classes (`LogCliente`, `LogServicio`, `LogTurno`) 
that orchestrate domain data validations and intermediate data between presentation and persistence modules.

* **`BDatos` (Data Access Layer / DAO):** Modules (`BDCliente`, `BDServicio`, `BDTurno`) that interface directly with the database. 
They build and execute SQL queries safely using parameterized `PreparedStatement` statements via an auxiliary connection manager.

* **`Clases` (Domain Models / POJOs):** Plain Old Java Objects (`Cliente`, `Servicio`, `Turno`) that map database 
rows and relationships directly into standard object-oriented programming entities.

---

## 🛠️ Tech Stack & Requirements

* **Language:** Java SE (JDK 8 or higher recommended)
* **Database Relational Engine:** MySQL (v5.7 / v8.0+)
* **Driver:** JDBC (Java Database Connectivity)
* **Recommended IDE:** NetBeans / IntelliJ IDEA 

---

## ⚙️ Setup and Installation

### 1. Database Schema Deployment
Execute the following SQL script (forward engineered from MySQL Workbench) to initialize your database instance and structural relationships:

```sql
CREATE SCHEMA IF NOT EXISTS turnos_a DEFAULT CHARACTER SET utf8 ;
USE turnos_a ;

-- -----------------------------------------------------
-- Table turnos_a.Clientes
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS turnos_a.Clientes (
  idClie INT NOT NULL AUTO_INCREMENT,
  cedula INT(10) NOT NULL,
  cliente VARCHAR(45) NOT NULL,
  PRIMARY KEY (idClie))
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table turnos_a.Servicios
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS turnos_a.Servicios (
  idSer INT NOT NULL AUTO_INCREMENT,
  codigo VARCHAR(10) NOT NULL,
  servicio VARCHAR(45) NOT NULL,
  PRIMARY KEY (idSer))
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table turnos_a.Turnos
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS turnos_a.Turnos (
  idTurn INT NOT NULL AUTO_INCREMENT,
  mes INT NOT NULL,
  dia INT NOT NULL,
  hora INT NOT NULL,
  estado INT NOT NULL DEFAULT 0, -- 0: Open / 1: Closed
  idClie INT NOT NULL,
  idSer INT NOT NULL,
  PRIMARY KEY (idTurn),
  INDEX fk_Turnos_Clientes_idx (idClie ASC) VISIBLE,
  INDEX fk_Turnos_Servicios1_idx (idSer ASC) VISIBLE,
  CONSTRAINT fk_Turnos_Clientes
    FOREIGN KEY (idClie)
    REFERENCES turnos_a.Clientes (idClie)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_Turnos_Servicios1
    FOREIGN KEY (idSer)
    REFERENCES turnos_a.Servicios (idSer)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

✒️ Author
Hans Alexander - Initial Work & Architecture