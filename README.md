# Prueba-tecnica-QA-Sofka
# Ejercicios de Automatización de Pruebas

Este repositorio contiene las soluciones para la prueba técnica de automatización, dividida en pruebas de interfaz de usuario (E2E), pruebas de servicios API y pruebas de Performance.

```
Prueba-tecnica-QA-Sofka
├── README.md
├── JMeter
├── KarateDsl/Demoblaze-master
└── SerenityBdd/Demoblaze-master
```
---

## 🚀 EJERCICIO 1: Automatización Web (E2E)

### Instrucciones
*   **Framework deseable:** Serenity BDD.
*   **Entrega:** Repositorio público de GitHub con scripts, reportes e insumos necesarios.
*   **Archivos obligatorios:**
    *   `readme.txt`: Instrucciones paso a paso de ejecución.
    *   `conclusiones.txt`: Hallazgos y conclusiones del ejercicio.

### Descripción del flujo
Realizar una prueba funcional automatizada (E2E) en la página [Demoblaze](https://www.demoblaze.com) que incluya:
1. Agregar dos productos al carrito.
2. Visualizar el carrito.
3. Completar el formulario de compra.
4. Finalizar la compra.

---

## 🛠️ EJERCICIO 2: Automatización de API (Servicios REST)

### Instrucciones
*   **Herramienta deseable:** Karate DSL.
*   **Entrega:** Repositorio público de GitHub con scripts y reportes.
*   **Archivos obligatorios:**
    *   `readme.txt`: Instrucciones paso a paso de ejecución.
    *   `conclusiones.txt`: Hallazgos y conclusiones del ejercicio.

### Casos de Prueba
Utilizando los servicios de [Demoblaze](https://www.demoblaze.com), realizar pruebas de los siguientes endpoints identificando entradas y capturando salidas:

*   **Signup:** `https://api.demoblaze.com`
    *   Crear un nuevo usuario.
    *   Intentar crear un usuario ya existente.
*   **Login:** `https://api.demoblaze.com`
    *   Usuario y password correctos.
    *   Usuario y password incorrectos.

---

## 🚀 EJERCICIO 3

#### Instrucciones

1. Para la resolución del ejercicio, se debe utilizar una de las siguientes herramientas:
K6 o JMeter.
2. Al finalizar el ejercicio se debe subir en un repositorio github público.

El ejercicio debe contener archivos, scripts, reportes y cualquier otro insumo que sustente su implementación para que pueda ser reproducido por la persona a revisar.

Adicional debe contener:
1. Un archivo readme.txt con las instrucciones paso a paso de ejecución (debe especificar las versiones de las tecnologías a usar).
2. Un archivo conclusiones.txt con los hallazgos y conclusiones del ejercicio

EJERCICIO:
Realizar una prueba de carga del servicio de login, para efectos del ejercicio, se
brindará el siguiente CURL:

```bash
curl --location --max-time 60
'https://fakestoreapi.com/auth/login&#39' ^
--header 'Content-Type: application/json'^
--data '{
  "username": "user",
  "password": "passwd"
}"
```


Los datos de entrada que se deben parametrizar desde un archivo .csv son:
```bash
user,passwd
donero,ewedon
kevinryan,kev02937@
johnd,m38rmF$
derek,jklg*_56
mor_2314,83r5^_
```

#### Criterios de aceptacion
El escenario de la prueba al menos debe alcanzar los 20 TPS y debe tener las
siguientes validaciones:
* El tiempo de respuesta permitido es de máximo 1,5 segundos.
* Tasa de error aceptable, menor al 3% del total de peticiones.

---
