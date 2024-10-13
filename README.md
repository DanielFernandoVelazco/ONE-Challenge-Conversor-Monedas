
# Conversor de Moneda - Java

Esta es una aplicación en Java que permite convertir entre diferentes monedas (Dólar Estadounidense, Peso Argentino, Real Brasileño y Peso Colombiano) utilizando datos de tasas de conversión obtenidos de una API externa.

## Tabla de contenidos

- [Características](#características)
- [Requisitos](#requisitos)
- [Configuración](#configuración)
- [Uso](#uso)
- [Estructura del Proyecto](#estructura-del-proyecto)
- [Ejemplo de Ejecución](#ejemplo-de-ejecución)
- [Licencia](#licencia)

## Características

- Convierte entre las siguientes monedas:
  - Dólar Estadounidense (USD)
  - Peso Argentino (ARS)
  - Real Brasileño (BRL)
  - Peso Colombiano (COP)
- Utiliza una API externa para obtener las tasas de cambio en tiempo real.
- Menú interactivo para seleccionar la conversión deseada.
- Fácil de extender para agregar más monedas o funcionalidades.

## Requisitos

- **Java 17** o superior.
- Conexión a internet para acceder a la API de tasas de cambio.
- **Gson**: Biblioteca para trabajar con JSON en Java (incluido en el proyecto).
- API que proporciona los datos de tasas de cambio. Necesitarás una URL de API válida asignada a la variable de entorno `API_URL`.

## Configuración

1. Clona este repositorio en tu máquina local:
   ```bash
   git clone https://github.com/usuario/conversor-monedas-java.git
   ```

2. Asegúrate de tener instalada una versión compatible de Java (17 o superior). Puedes verificar la versión con el siguiente comando:
   ```bash
   java -version
   ```

3. Configura la variable de entorno `API_URL` con la URL de la API que proporciona las tasas de cambio de moneda. Por ejemplo:
   ```bash
   export API_URL="https://api.exchangerate-api.com/v4/latest/USD"
   ```

4. Compila el proyecto con `javac`:
   ```bash
   javac -d bin src/*.java
   ```

5. Ejecuta la aplicación desde el directorio `bin`:
   ```bash
   java Principal
   ```

## Uso

Al ejecutar la aplicación, se mostrará un menú interactivo en el cual podrás seleccionar la conversión de monedas deseada. El flujo básico es el siguiente:

1. Selecciona una opción de conversión (por ejemplo, de Dólar a Peso Argentino).
2. Ingresa la cantidad de dinero que deseas convertir.
3. La aplicación mostrará el resultado de la conversión basada en las tasas actuales de la API.
4. Puedes repetir el proceso o salir de la aplicación.

### Opciones de conversión disponibles:

1. Dólar => Peso Argentino
2. Peso Argentino => Dólar
3. Dólar => Real Brasileño
4. Real Brasileño => Dólar
5. Dólar => Peso Colombiano
6. Peso Colombiano => Dólar
7. Salir

## Estructura del Proyecto

El proyecto está dividido en varios archivos para cumplir con el principio de responsabilidad única.

- `ApiService.java`: Gestiona la solicitud HTTP para obtener los datos de la API.
- `ApiResponse.java`: Clase que representa la estructura del JSON obtenido de la API.
- `CurrencyConverter.java`: Contiene la lógica de conversión de monedas.
- `MenuService.java`: Se encarga de mostrar el menú y capturar la entrada del usuario.
- `Principal.java`: Archivo principal que integra todos los servicios y ejecuta la aplicación.

```bash
src/
│
├── ApiService.java
├── ApiResponse.java
├── CurrencyConverter.java
├── MenuService.java
└── Principal.java
```

## Ejemplo de Ejecución

```bash
Bienvenido al ¡Conversor de Moneda!

*************************************************
1) Dolar =>> Peso Argentino
2) Peso Argentino =>> Dolar
3) Dolar =>> Real Brasilero
4) Real Brasirelo =>> Dolar
5) Dolar =>> Peso Colombiano
6) Peso Colombiano =>> Dolar
7) Salir
***************************************************

Elija una opción válida: 1
Ingresa el valor que deseas convertir: 100
El valor de 100 [USD] corresponde al valor final de =>> 9800.0 [ARS]
```


