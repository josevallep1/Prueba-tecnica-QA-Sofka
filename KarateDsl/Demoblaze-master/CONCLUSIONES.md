# Conclusiones del Proyecto de Automatización - Demoblaze

## 1. Selección de Herramientas
Se eligió **Karate DSL** como framework de automatización debido a sus capacidades integrales para pruebas de API. Su sintaxis basada en **Gherkin** facilita la lectura y comprensión de los escenarios de prueba tanto para perfiles técnicos como no técnicos, alineándose con las prácticas de BDD (Behavior Driven Development).

## 2. Gestión de Dependencias con Gradle
La implementación de **Gradle** proporciona un sistema de construcción robusto y flexible:
*   Permite gestionar fácilmente las dependencias (como `karate-junit5`).
*   Facilita la ejecución de pruebas desde la línea de comandos, lo cual es ideal para la integración en tuberías de CI/CD.

## 3. Arquitectura y Configuración
*   **Centralización:** El archivo `karate-config.js` actúa como el núcleo de configuración. Se utilizó para definir variables globales como `base_url`, evitando la duplicidad de código ("hardcoding") en los archivos `.feature`.
*   **Manejo de Entornos:** La estructura permite cambiar dinámicamente entre entornos (ej. `dev`, `qa`) mediante propiedades del sistema, lo que hace que los scripts sean reutilizables.
*   **Resolución de Problemas:** Se identificó la importancia de la correcta inicialización de variables en el contexto global para prevenir fallos de ejecución (como el `ReferenceError` solucionado).

## 4. Ejecución y Escalabilidad
*   **Runners JUnit 5:** La creación de clases `Runner` permite ejecutar pruebas de manera modular o en paralelo, mejorando la eficiencia del ciclo de pruebas.
*   **Control de Versiones:** Se estableció un `.gitignore` optimizado para ignorar artefactos de compilación (`/build`, `/target`) y archivos específicos del IDE, manteniendo el repositorio limpio y profesional.

## 5. Reporte de Resultados
Karate genera nativamente reportes en HTML detallados (`karate-reports`), lo que proporciona visibilidad inmediata sobre el estado de las pruebas y facilita el diagnóstico de errores sin necesidad de librerías externas adicionales.