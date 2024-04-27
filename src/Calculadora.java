import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Calculadora {

    public void opciones(String monedaOrigen,String monedaFinal) throws IOException, InterruptedException {
        String direccion = "https://v6.exchangerate-api.com/v6/e4d44800ed2315597f54b2cb/latest/"+monedaOrigen;
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(direccion))
                .build();
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        Gson gson = new Gson();
        String json = response.body();
        Monedas moneda = gson.fromJson(json, Monedas.class); // Lo convierte a una clase
        JsonObject jsonResponse = JsonParser.parseString(json).getAsJsonObject();
        JsonObject rates = jsonResponse.getAsJsonObject("conversion_rates");
        System.out.println(moneda);
        double factor = rates.get(monedaFinal).getAsDouble();
        System.out.println("***************************************");
        System.out.println("Una unidad de ["+monedaOrigen
                +"]"+" = "+factor+" ["+monedaFinal+"]");

        Scanner lectura= new Scanner(System.in);
        System.out.println("Cuántas unidades de "+"[" + monedaOrigen+ "]" + " requieres? ");
        int unidades = lectura.nextInt();
        System.out.println("***************************************"+ '\n');
       // Calculadora myclass = new Calculadora();
        double montoFinal = convierte(unidades, factor);
        //Agrega un salto de linea
        System.out.println("***************************************");
        System.out.println("Requieres: "+montoFinal+" "+monedaFinal);
        System.out.println("***************************************"+ '\n');

    }


    public double convierte (int cantidad, double factor) {
        return cantidad*factor;
    }


}
