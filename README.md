# Programación Orientada a Objetos

# Sistema de Gestión de Clínica SAN TI
 
Aplicación de escritorio en **Java** con interfaz gráfica en **Swing**, desarrollada para la asignatura **Programación Orientada a Objetos I**. Permite administrar médicos, pacientes e ingresos hospitalarios aplicando los principios fundamentales de POO.
 
![Java](https://img.shields.io/badge/Java-JDK%208+-orange)
![Swing](https://img.shields.io/badge/GUI-Swing-blue)
 
## Capturas
 
*(Agregar 1-2 screenshots de la app corriendo — es lo primero que un revisor mira)*
 
## Funcionalidades
 
**Médicos** · **Pacientes** · **Ingresos hospitalarios**
 
Cada módulo implementa el ciclo CRUD completo (Crear, Leer, Actualizar, Eliminar), con código autogenerado por registro y validación básica de campos vacíos.
 
- **Ingresos** asocia paciente, médico, habitación, cama, fecha de ingreso y contacto de emergencia.
- **Pacientes** incluye datos personales, dirección y fecha de nacimiento.
- **Médicos** incluye datos personales y especialidad.
## Modelo de clases
 
| Clase | Responsabilidad |
|---|---|
| `Paciente` | Datos personales, dirección, fecha de nacimiento |
| `Medico` | Datos personales y especialidad |
| `DatosContactos` | Clase base con nombre, dirección y teléfono de contacto |
| `ingreso` | Extiende `DatosContactos`; registra el ingreso hospitalario y vincula paciente/médico |
 
La herencia `ingreso extends DatosContactos` evita duplicar los campos de contacto de emergencia, que estructuralmente son los mismos datos que ya modela la clase base.
 
## Tecnologías
 
Java · Swing (`JFrame`, `JOptionPane`) · `ArrayList` · `GregorianCalendar` / `SimpleDateFormat`
 
## Ejecución
 
1. Abrir el proyecto en NetBeans (o cualquier IDE compatible con Java).
2. Ejecutar `MainGUI.java`.
**Requisitos:** JDK 8 o superior.
 
## Conceptos de POO aplicados
 
Encapsulamiento · Herencia · Constructores · Composición · Colecciones (`ArrayList`)
 
## Notas técnicas y mejoras identificadas
 
Este proyecto priorizó practicar POO y manejo de eventos en Swing. Al revisarlo con perspectiva de buenas prácticas, identifiqué puntos concretos de mejora que pienso abordar:
 
- Separar la lógica de negocio de la capa de UI (actualmente vive dentro de `actionPerformed`).
- Agregar manejo de excepciones en la conversión de campos numéricos (`parseInt`).
- Reemplazar el parsing de código desde texto de `JComboBox` por referencias directas a objetos.
- Migrar de `setLayout(null)` a un layout manager responsivo.
- Persistencia de datos (archivo o base de datos) en vez de almacenamiento en memoria.
- Adoptar convenciones estándar de Java en nombres de clases y métodos.
## Contexto académico
 
Proyecto desarrollado para simular la gestión informática de una clínica, conforme al enunciado de la asignatura Programación Orientada a Objetos I.
 
---
Proyecto con fines académicos y educativos.
