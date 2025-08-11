package org.ejercicio;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Conversor {

    Scanner leer = new Scanner(System.in);
    int op = 0;

    public void menu() throws IOException, InterruptedException {
        System.out.println("Bienvenido/a al Conversor de Monedas\n");
        while (true) {
            System.out.println("""                    
                    Elija una opción para la conversión de monedas:
                    
                    1) Dólar (USD) a Peso Argentino (ARS)
                    2) Peso Argentino (ARS) a Dólar (USD)
                    3) Dólar (USD) a Real Brasileño (BRL)
                    4) Real Brasileño (BRL) a Dólar (USD)
                    5) Dólar (USD) a Peso Colombiano (COP)
                    6) Peso Colombiano (COP) a Dólar (USD)
                    7) Salir
                    """);
            System.out.print("Opción: ");
            op = leer.nextInt();

            if (op == 7) {
                System.out.println("Gracias por utilizar el conversor de monedas.");
                break;
            }

            if (op < 1 || op > 7) {
                System.out.println("Opción no válida, por favor elija una opción del 1 al 7.");
                continue;
            }

            System.out.println("Ingrese el valor que desea convertir:");
            BigDecimal valor = leer.nextBigDecimal();

            switch (op) {
                case 1:
                    convertirMoneda("USD", "ARS", valor);
                    break;
                case 2:
                    convertirMoneda("ARS", "USD", valor);
                    break;
                case 3:
                    convertirMoneda("USD", "BRL", valor);
                    break;
                case 4:
                    convertirMoneda("BRL", "USD", valor);
                    break;
                case 5:
                    convertirMoneda("USD", "COP", valor);
                    break;
                case 6:
                    convertirMoneda("COP", "USD", valor);
                    break;
            }
        }
    }

    public void convertirMoneda(String moneda1, String moneda2, BigDecimal valor) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://v6.exchangerate-api.com/v6/a00a36683f5add62b3bd0591/pair/" + moneda1 + "/" + moneda2 + "/" + valor))
                .build();

        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create();

        MonedaRecord monedaRecord1 = gson.fromJson(response.body(), MonedaRecord.class);

        Moneda moneda = new Moneda(monedaRecord1, valor);
        System.out.println(moneda);
    }
}
