import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;

public class Principal {

    static class ApiResponse {
        Map<String, Double> conversion_rates;
    }

    public static void main(String[] args) throws IOException, InterruptedException {

        Gson gson = new GsonBuilder().setPrettyPrinting().create();



        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(direccion))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        String json = response.body();

        ApiResponse apiResponse = gson.fromJson(json, ApiResponse.class);
        System.out.println(apiResponse);

        Double tasaUSD = apiResponse.conversion_rates.get("USD");
        Double tasaAUD = apiResponse.conversion_rates.get("AUD");

        // Imprimir las tasas de conversión
        System.out.println("Tasa de USD: " + tasaUSD);
        System.out.println("Tasa de AUD: " + tasaAUD);
    }
}
