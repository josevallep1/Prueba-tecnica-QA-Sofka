# Conclusiones y Hallazgos del Ejercicio

## 🔍 Hallazgos

### ❌ Error en la aserción de fecha en la pantalla de confirmación

- Al realizar la aserción en la pantalla **"Gracias por tu compra"**, la fecha es incorrecta.
- El sistema toma el **mes anterior** al mes real de la compra.
- Este es un bug conocido del sitio [Demoblaze](https://www.demoblaze.com) y no del framework de automatización.

---

## ✅ Conclusiones

### Stack tecnológico

El ejercicio fue planteado y desarrollado usando el siguiente stack:

| Tecnología | Rol en el proyecto |
|---|---|
| **Serenity BDD** | Framework principal de automatización y reporte |
| **Cucumber** | Motor de escenarios BDD con lenguaje Gherkin |
| **Screenplay Pattern** | Patrón de diseño para interacciones de usuario |
| **Gradle** | Herramienta de construcción y gestión de dependencias |
| **Java 21** | Lenguaje de programación base |

---

### Dificultades encontradas

#### 1. Modal emergente al agregar producto

- Al agregar un producto al carrito, el sitio muestra un **modal emergente (alert/dialog)**.
- Fue necesario implementar una interacción específica para aceptar ese modal antes de continuar el flujo.
- Este tipo de elemento aumentó la complejidad del escenario.

#### 2. Fecha incorrecta en la confirmación de compra

- El sistema de Demoblaze presenta un bug en la fecha de confirmación.
- Fue identificado durante la fase de aserción del flujo E2E.

---

### Alcance del flujo automatizado

Se implementó el flujo **E2E** lo más completo posible, validado contra los **criterios de aceptación** del enunciado de la prueba técnica:

- [x] Acceso al sitio Demoblaze
- [x] Selección de producto
- [x] Agregar al carrito (incluyendo manejo del modal)
- [x] Proceso de compra
- [x] Validación de la pantalla de confirmación

--- 

## ⚠️ Problemas comunes

### ❌ "No se linkean los steps" o aparecen `Undefined steps`

- Verifica que estés ejecutando el runner `DemoblazeBuyRunners`.
- Verifica que en `src/test/resources/junit-platform.properties` exista:
  ```properties
  cucumber.glue=stepsdefinitions
  ```
- Verifica que la clase de steps tenga el paquete correcto:
  ```java
  package stepsdefinitions;
  ```

### ❌ Error al generar HTML del reporte en Windows (archivo bloqueado)

- Cierra cualquier `index.html` o archivo abierto dentro de `target/site/serenity/`.
- Vuelve a ejecutar:
  ```powershell
  .\gradlew.bat test --tests runners.DemoblazeBuyRunners
  ```


