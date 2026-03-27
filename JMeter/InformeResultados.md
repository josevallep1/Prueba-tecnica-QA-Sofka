# Análisis: Prueba de Carga en k6

## 1. Métricas Clave (Puntos de Control)

![alt text](<Captura de pantalla 2026-03-26 182220.png>)
![alt text](<Captura de pantalla 2026-03-26 182211.png>)

---

## 2. Análisis de Comportamiento (Gráfico de VUs vs TPS)

### Carga inicial de la prueba
* El sistema escaló rápidamente de 0 a **100 TPS**.
* Se observa una respuesta lineal durante el incremento inicial de carga.

### Inestabilidad (01:50:00 - 02:00:00)
* **Incidente detectado:** Se observa una caída en las **TPS**, bajando menos de **15**.
* **Observación:** La cantidad de usuarios (VUs) se mantuvo constante en 140. Esto indica que el problema **no fue falta de carga**, sino un cuello de botella en el servidor (posible saturación de CPU, base de datos bloqueada o aumento masivo en los tiempos de respuesta).

### Recuperación y Meseta
* El sistema logró recuperarse por sí solo, estabilizándose nuevamente en un rango de **75-85 TPS**.
* El rendimiento se mantuvo constante hasta el final de la prueba (Ramp-down).

## 3. Conclusiones y Recomendaciones

### Conclusiones
* La prueba es **Exitosa Parcialmente**. Aunque el sistema procesó casi 270 mil solicitudes, la caída de rendimiento indica que el sistema no sabe recuperarse o estabilizarse ante cargas prolongadas.

---
