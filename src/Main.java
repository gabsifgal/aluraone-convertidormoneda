import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Main {
    public static void main(String[] args) {
        // Menú de opciones
        String menu = """
        Sea bienvenido/a al Conversor de Moneda
        1) Dólar => Sol peruano
        2) Sol peruano => Dólar
        3) Dólar => Peso argentino
        4) Peso argentino => Dólar
        5) Dólar => Peso colombiano
        6) Peso colombiano => Dólar
        7) Salir
        Elija una opción válida:
        """;

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print(menu);
            String opt = scanner.nextLine();

            // Definir las divisas según la opción elegida
            String currFrom = switch (opt) {
                case "1" -> "USD"; case "2" -> "PEN";
                case "3" -> "USD"; case "4" -> "ARS";
                case "5" -> "USD"; case "6" -> "COP";
                case "7" -> { System.exit(0); yield ""; }
                default -> throw new IllegalStateException("Valor no válido: " + opt);
            };
            String currTo = opt.equals("1") || opt.equals("3") || opt.equals("5") ? currTo = "PEN" : "USD";

            // Pedir el monto
            System.out.print("Ingrese el monto a convertir: ");
            float amount = Float.parseFloat(scanner.nextLine());

            // Enviar solicitud HTTP y obtener la tasa de conversión
            try {
                String url = "https://v6.exchangerate-api.com/v6/2026efaa474eae8674b249af/latest/" + currFrom;
                HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).GET().build();
                HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());

                // Procesar el JSON y calcular el resultado
                JsonObject rates = JsonParser.parseString(response.body())
                        .getAsJsonObject()
                        .getAsJsonObject("conversion_rates");
                float rate = rates.get(currTo).getAsFloat();
                System.out.printf("%.2f %s equivale a %.2f %s%n", amount, currFrom, amount * rate, currTo);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}