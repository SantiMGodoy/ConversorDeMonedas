# Conversor de Monedas

Este proyecto es una aplicación de consola en Java que permite convertir diferentes tipos de monedas utilizando tasas de cambio en tiempo real.

## Funcionalidad

El conversor permite las siguientes conversiones de monedas:

1. Dólar (USD) a Peso Argentino (ARS)
2. Peso Argentino (ARS) a Dólar (USD)
3. Dólar (USD) a Real Brasileño (BRL)
4. Real Brasileño (BRL) a Dólar (USD)
5. Dólar (USD) a Peso Colombiano (COP)
6. Peso Colombiano (COP) a Dólar (USD)

El usuario ingresa un valor en una moneda y el programa lo convierte a la moneda seleccionada utilizando tasas de cambio obtenidas a través de una API.

## Uso

Al ejecutar el programa, el usuario verá un menú con opciones de conversión. Después de seleccionar una opción, se solicita un valor y se realiza la conversión de acuerdo a la moneda elegida.

## Tecnologías utilizadas

- **Java 17+**
- **Gson** (para el manejo de datos JSON de la API de tasas de cambio)
- **HttpClient** (para hacer solicitudes HTTP a la API de tasas de cambio)
