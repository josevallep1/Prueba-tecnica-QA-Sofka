# Demoblaze - Prueba automatizada con Serenity BDD

## 1) Objetivo

Este proyecto automatiza el flujo de compra en [Demoblaze](https://www.demoblaze.com) usando:

- **Serenity BDD**
- **Cucumber** (JUnit Platform)
- **Gradle**
- **Java 21**

**Escenario principal:**

| Elemento | Ruta |
|---|---|
| Feature | `src/test/resources/features/purchase.feature` |
| Scenario | `Make a successful purchase` |

---

## 2) Requisitos

- Java 21 instalado y configurado en `JAVA_HOME`
- *(Opcional)* Gradle instalado globalmente
- IntelliJ IDEA con los siguientes plugins:
  - **Gherkin**
  - **Cucumber for Java**

> **Nota:** no es obligatorio tener Gradle global; el proyecto incluye wrapper (`gradlew.bat`).

---

## 3) Importar en IntelliJ

1. Abrir **IntelliJ IDEA**.
2. Seleccionar **Open** y elegir la carpeta del proyecto.
3. Importar desde `build.gradle` si IntelliJ lo solicita.
4. Esperar la sincronización de dependencias.

---

## 4) Ejecutar pruebas

### Opción A: desde IntelliJ *(recomendado)*

- Abrir el runner: `src/test/java/runners/DemoblazeBuyRunners.java`
- Click derecho sobre la clase → **Run DemoblazeBuyRunners**

### Opción B: desde terminal (Windows PowerShell)

Ejecutar todas las pruebas:

```powershell
.\gradlew.bat clean test
```

Ejecutar solo este runner:

```powershell
.\gradlew.bat test --tests runners.DemoblazeBuyRunners
```

---

## 5) Configuración de Cucumber

| Elemento | Ruta / Valor |
|---|---|
| Steps package | `src/test/java/stepsdefinitions` |
| Runner | `src/test/java/runners/DemoblazeBuyRunners.java` |
| Properties | `src/test/resources/junit-platform.properties` |
| Features | `src/test/resources/features` |

---

## 6) Reporte Serenity

Al finalizar las pruebas, el reporte se genera en:

```
target/site/serenity/index.html
```

Para regenerar el reporte manualmente:

```powershell
.\gradlew.bat aggregate
```

---

## 7) Estructura mínima relevante

```
src/
├── main/
│   └── java/
│       ├── interaction/
│       ├── questions/
│       ├── tasks/
│       ├── userinterfaces/
│       └── utils/
└── test/
    ├── java/
    │   ├── runners/
    │   │   └── DemoblazeBuyRunners.java
    │   └── stepsdefinitions/
    │       └── DemoblazeBuyStepDefinitions.java
    └── resources/
        ├── features/
        │   └── purchase.feature
        ├── data/
        │   └── dataPurchase.json
        └── junit-platform.properties
```

📊 **Reporte:** `target/site/serenity/index.html`

---

## 8) Conclusiones y Hallazgos

Ver el archivo 📄 [CONCLUSIONES.md](./CONCLUSIONES.md) para los hallazgos encontrados y las conclusiones del ejercicio.

