# Sistema de Gestión Hospitalaria (Proyecto 1)

Este proyecto es una aplicación de escritorio desarrollada en **Java** utilizando **Swing** para la interfaz gráfica. Permite la administración integral de un hospital pequeño, gestionando pacientes, médicos, inventario y consultas.

## 🚀 Características Principales

La aplicación está dividida en 4 módulos principales:

### 1. Pacientes 🏥
- Registro de nuevos pacientes.
- Búsqueda por ID (automática o manual).
- Actualización y eliminación de registros.
- **Filtros avanzados:** Búsqueda por rango de edad, dirección o ambos.

### 2. Médicos 👨‍⚕️
- Gestión de médicos y sus especialidades.
- Capacidad de agregar nuevas especialidades dinámicamente.
- Búsqueda y listado de personal médico.

### 3. Inventario 📦
- Control de equipos médicos y suministros.
- Operaciones de **Inventariar** (aumentar stock) y **Desinventariar** (disminuir stock).
- Validación de stock negativo.

### 4. Consultas 📅
- Agendamiento de citas médicas.
- Selección de fechas futuras (validación de fechas pasadas).
- Asignación de paciente y médico.
- Selección de prioridad (Normal, Urgencia).

## 🛠️ Tecnologías Utilizadas

- **Lenguaje:** Java (JDK 21 recomendado).
- **Interfaz Gráfica:** Java Swing.
- **IDE:** NetBeans (con soporte para GUI Builder).
- **Gestor de Construcción:** Maven.
- **Persistencia:** Listas en memoria (Simulación).

## 📋 Requisitos para Ejecutar

- Tener instalado **Java JDK**.
- Tener **Maven** instalado (opcional si usas NetBeans).
- IDE recomendado: **NetBeans** (para editar la interfaz gráfica cómodamente).

## ▶️ Cómo Ejecutar

### Desde NetBeans:
1. Abrir el proyecto en NetBeans.
2. Hacer clic derecho en el proyecto -> **Run / Ejecutar**.

### Desde Terminal (Maven):
Compilar y ejecutar la clase principal:
```bash
mvn compile exec:java -Dexec.mainClass="proyecto_1.gui.VentanaPrincipal"
```

## 👤 Autor
**Alejandro Montijo**
Para la materia de Programación III.
