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
*   **Archivo:** `./script/Data/LoginData.csv`
*   **Variables:** `username`, `password`
*   **Configuración:** Delimitador `,`, ignora la primera línea (cabecera) y recicla los datos al terminar el archivo.

---

## 🚀 3. Estrategias de Carga (Thread Groups)

### Comparativa de Escenarios de Prueba

Este documento detalla la configuración técnica de los tres escenarios definidos en el Plan de Pruebas de JMeter: **Línea Base**, **Carga** y **Estrés**.

#### 1. Tabla Comparativa de Métricas y Configuración


| Métrica / Configuración | Línea Base | Carga | Estrés |
| :--- | :--- | :--- | :--- |
| **Tipo de Thread Group** | Thread Group estándar | Ultimate Thread Group | Ultimate Thread Group |
| **Usuarios (Threads)** | 1 | 30 | 60 |
| **Ramp-up (Arranque)** | 1 segundo | 0 segundos | 0 segundos |
| **Hold-on (Mantenimiento)** | N/A (300 iteraciones) | 300 segundos | 300 segundos |
| **Shutdown (Parada)** | Inmediato | 60 segundos | 60 segundos |
| **Control de Bucles** | 300 iteraciones | Infinito (Tiempo definido) | Infinito (Tiempo definido) |
| **Acción ante Error** | `startnextloop` | `continue` | `continue` |

---

#### 2. Detalles de Implementación Comunes

##### Parámetros de Petición HTTP
*   **Protocolo:** `${protocolo}` (https)
*   **Dominio:** `${url}` (fakestoreapi.com)
*   **Ruta:** `/auth/login`
*   **Método:** `POST`
*   **Cuerpo (JSON):**
    ```json
    {
      "username": "${username}",
      "password": "${password}"
    }
    ```

##### Validaciones (Aserciones)
Para asegurar la integridad de las pruebas, todos los escenarios incluyen:
1.  **Response Code Assertion:** Verifica que el código de respuesta sea **201**.
2.  **Response Body Assertion:** Valida que el cuerpo de la respuesta contenga el campo **"token"**.

##### Gestión de Datos
*   **Origen:** Archivo CSV ubicado en `./Data/LoginData.csv`.
*   **Variables:** `username`, `password`.
*   **Delimitador:** `;`.

---

#### 3. Relevancia de los Escenarios
*   **Línea Base:** Establece el rendimiento ideal con un solo usuario para comparar desviaciones.
*   **Carga:** Evalúa el comportamiento del sistema bajo el volumen de usuarios esperado.
*   **Estrés:** Busca identificar el punto de degradación o ruptura doblando la carga inicial.

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
