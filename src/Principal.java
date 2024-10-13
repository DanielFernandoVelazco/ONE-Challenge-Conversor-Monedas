import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.IOException;

public class Principal {

    public static void main(String[] args) throws IOException, InterruptedException {

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String direccion = System.getenv("API_URL");

        // Instanciamos los servicios
        ApiService apiService = new ApiService();
        CurrencyConverter currencyConverter = new CurrencyConverter();
        MenuService menuService = new MenuService();

        // Obtener respuesta de la API
        String json = apiService.getApiResponse(direccion);

        // Deserializar el JSON
        ApiResponse apiResponse = gson.fromJson(json, ApiResponse.class);

        // Obtener tasas de cambio
        Double dolarUSD = apiResponse.conversion_rates.get("USD");
        Double pesoArgentinoARS = apiResponse.conversion_rates.get("ARS");
        Double realBrasileroBRL = apiResponse.conversion_rates.get("BRL");
        Double pesoColombianoCOP = apiResponse.conversion_rates.get("COP");

        while (true) {
            int opcion = menuService.getOption();

            if (opcion == 7) {
                System.out.println("Gracias por usar nuestros servicios");
                break;
            }

            if (opcion < 1 || opcion > 7) {
                System.out.println("La opcion debe ser del 1 al 7");
                break;
            }

            double valorOriginal = menuService.getAmount();
            double valorCambio = 0.0;
            String simboloOriginal = "";
            String simboloCambio = "";

            switch (opcion) {
                case 1 -> {
                    simboloOriginal = " [USD] ";
                    simboloCambio = " [ARS] ";
                    valorCambio = currencyConverter.convertCurrency(valorOriginal, dolarUSD, pesoArgentinoARS);
                }
                case 2 -> {
                    simboloOriginal = " [ARS] ";
                    simboloCambio = " [USD] ";
                    valorCambio = currencyConverter.convertCurrency(valorOriginal, pesoArgentinoARS, dolarUSD);
                }
                case 3 -> {
                    simboloOriginal = " [USD] ";
                    simboloCambio = " [BRL] ";
                    valorCambio = currencyConverter.convertCurrency(valorOriginal, dolarUSD, realBrasileroBRL);
                }
                case 4 -> {
                    simboloOriginal = " [BRL] ";
                    simboloCambio = " [USD] ";
                    valorCambio = currencyConverter.convertCurrency(valorOriginal, realBrasileroBRL, dolarUSD);
                }
                case 5 -> {
                    simboloOriginal = " [USD] ";
                    simboloCambio = " [COP] ";
                    valorCambio = currencyConverter.convertCurrency(valorOriginal, dolarUSD, pesoColombianoCOP);
                }
                case 6 -> {
                    simboloOriginal = " [COP] ";
                    simboloCambio = " [USD] ";
                    valorCambio = currencyConverter.convertCurrency(valorOriginal, pesoColombianoCOP, dolarUSD);
                }
            }

            System.out.println("El valor de " +
                    valorOriginal +
                    simboloOriginal +
                    "corresponde al valor final de =>> " +
                    valorCambio +
                    simboloCambio);
        }
    }
}
