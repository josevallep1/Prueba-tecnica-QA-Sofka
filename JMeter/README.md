# Plan de Pruebas de Rendimiento: API Fakestore Login

Este repositorio contiene un plan de pruebas de rendimiento desarrollado en **Apache JMeter (v5.6.3)** para validar el comportamiento, estabilidad y escalabilidad del proceso de autenticación de la plataforma **Fakestore API**.

## 📌 1. Descripción del Proyecto
El objetivo principal es medir los tiempos de respuesta y la tasa de transferencia (throughput) del endpoint de **Login**. El script simula el comportamiento de múltiples usuarios concurrentes realizando peticiones `POST` con credenciales dinámicas.

---

## ⚙️ 2. Configuración Técnica del Entorno

### 🌍 Variables Globales
Para facilitar la portabilidad entre entornos (Dev, QA, Prod), se utilizan variables definidas por el usuario:
*   **Protocolo:** `https`
*   **URL:** `fakestoreapi.com`
*   **BaseDir:** Ruta dinámica del servidor de archivos.

### 📂 Parametrización (Data-Driven)
Se utiliza un elemento **CSV Data Set Config** para inyectar datos de prueba:
*   **Archivo:** `C:/JMeter/script/Data/LoginData.csv`
*   **Variables:** `username`, `password`
*   **Configuración:** Delimitador `;`, ignora la primera línea (cabecera) y recicla los datos al terminar el archivo.

---

## 🚀 3. Estrategias de Carga (Thread Groups)

El plan de pruebas está estructurado en 4 escenarios distintos para cubrir diferentes tipos de pruebas de rendimiento:


| Escenario | Tipo de Prueba | Configuración | Estado inicial |
| :--- | :--- | :--- | :--- |
| **Línea Base** | Control | 1 Hilo / 300 Iteraciones | **Habilitado** |
| **Grupo de Hilos** | Carga Unitaria | 1 Hilo / 300 Iteraciones | Deshabilitado |
| **Carga** | Carga Progresiva | 30 Hilos / Ramp-up 300s / Duración 600s | Deshabilitado |
| **Estrés** | Estrés / Pico | 60 Hilos / Ramp-up 300s / Duración 600s | Deshabilitado |

---

## 🛠️ 4. Detalles del Sampler HTTP

### **Endpoint: Fakestoreapi Login**
*   **Método:** `POST`
*   **Ruta:** `/auth/login`
*   **Cabeceras:** `Content-Type: application/json`
*   **Cuerpo de la petición (JSON Raw):**
    ```json
    {
      "username": "${username}",
      "password": "${password}"
    }
    ```

---

## ✅ 5. Validaciones y Aseveraciones (Assertions)

Para garantizar que el servidor responde correctamente más allá del código HTTP, se han configurado:
1.  **Response Assertion Code:** Valida que el código de respuesta sea estrictamente **201**.
2.  **Response Assertion Body:** Valida que el cuerpo de la respuesta contenga el texto `"token"`.

---

## 📊 6. Reportes y Análisis

El script incluye los siguientes receptores (Listeners) para el análisis de métricas:
*   **Árbol de Resultados (View Results Tree):** Para depuración y visualización de payloads individuales.
*   **Informe Agregado (Summary Report):** Para el cálculo de medias, percentiles (90, 95, 99) y porcentaje de error.

---

## 📝 7. Instrucciones de Uso

1.  **Requisito:** Tener instalado **JMeter 5.6.3** o superior.
2.  **Preparación de Datos:** Asegúrese de que el archivo `LoginData.csv` esté ubicado en `C:/JMeter/script/Data/` o actualice la ruta en el elemento *Datos CSV*.
3.  **Ejecución GUI:** 
    *   Habilite solo el *Thread Group* que desea probar.
    *   Presione el botón "Play" (Verde).
4.  **Ejecución Non-GUI (Recomendado para Carga/Estrés):**
    ```bash
    jmeter -n -t plan_de_pruebas.jmx -l resultados.jtl -e -o ./reporte_html
    ```

---
