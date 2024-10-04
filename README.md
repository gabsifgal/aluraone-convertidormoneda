# Conversor de Moneda

Este es un proyecto de conversor de moneda implementado en Java para el Challenge de Back End de Alura Latam y Oracle Next Education. El programa permite convertir entre varias monedas (dólares, soles peruanos, pesos argentinos y pesos colombianos) usando la API pública de **ExchangeRate-API**.

## Funcionalidades

- Conversión de **Dólar (USD)** a **Sol peruano (PEN)** y viceversa.
- Conversión de **Dólar (USD)** a **Peso argentino (ARS)** y viceversa.
- Conversión de **Dólar (USD)** a **Peso colombiano (COP)** y viceversa.
- El programa obtiene la tasa de conversión actualizada desde la API de **ExchangeRate-API**.
- Se solicita al usuario que ingrese el monto a convertir.
- El resultado se muestra directamente en la consola.

## Uso

1. Al iniciar el programa, se muestra un menú con las opciones de conversión.
2. El usuario debe ingresar el número correspondiente a la conversión deseada:
   - `1`: Convertir de Dólar a Sol peruano.
   - `2`: Convertir de Sol peruano a Dólar.
   - `3`: Convertir de Dólar a Peso argentino.
   - `4`: Convertir de Peso argentino a Dólar.
   - `5`: Convertir de Dólar a Peso colombiano.
   - `6`: Convertir de Peso colombiano a Dólar.
   - `7`: Salir del programa.
3. Luego, el usuario ingresa el monto que desea convertir.
4. El programa consulta la tasa de conversión y muestra el resultado.

## Requisitos

- **Java 11** o superior para aprovechar la clase `HttpClient` utilizada en el proyecto.
- Acceso a Internet para realizar las solicitudes a la API de conversión de monedas.

## Instalación

1. Clona este repositorio en tu máquina local:
```bash
git clone https://github.com/gabsifgal/aluraone-convertidormoneda.git
```
Asegúrate de tener Java 11 o superior instalado.
Navega al directorio del proyecto y compila el código:
  
```bash
cd conversor-moneda
javac Main.java
```

Ejecuta el programa:
```bash
java Main
```
## Dependencias

Este proyecto utiliza las siguientes librerías:

- HttpClient (incluida en Java 11) para realizar las solicitudes HTTP a la API.
- Gson para procesar las respuestas en formato JSON.

## API Utilizada

Este proyecto utiliza la ExchangeRate-API para obtener las tasas de conversión actuales. Puedes visitar [ExchangeRate-API](https://www.exchangerate-api.com/docs/overview) para más información sobre esta API.
## Notas

La API gratuita de ExchangeRate-API tiene un límite de solicitudes diarias. Asegúrate de no excederlo durante las pruebas.
Para modificar las divisas o agregar nuevas conversiones, simplemente ajusta las opciones del menú y las abreviaturas de las monedas en el código fuente.

## Licencia

Este proyecto es de uso libre bajo la licencia MIT. Siéntete libre de modificarlo y adaptarlo según tus necesidades.
