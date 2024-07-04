package ConversorMoneda;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import com.google.gson.Gson;
import com.google.gson.JsonObject;


public class ConsultaApi {
    public double busquedaApi(int eleccion) throws IOException, InterruptedException{

        String apiKey = "684e5ca42b20ce4c2bf71616";

        // SE DECLARA VARIABLE TIPO <URI PARA ALMACENAR LA DIRECCION DE LA API
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/" + apiKey + "/latest/USD");
        // SE CREA NUEVO <HttpClient
        HttpClient cliente = HttpClient.newHttpClient();
        //SE CREA UN REQUEST CON LA DIRECCION DE LA API
        HttpRequest request = HttpRequest.newBuilder().uri(direccion).build();
        // SE DECLARA VARIABLE TIPO <HttpResponse Y SE USA PARA MANDAR EL REQUEST Y SE ESPECIFICA QUE EL CUERPO DE LA RESPUESTA SE MANEJARA COMO <String
        HttpResponse<String> respuesta = cliente.send(request, HttpResponse.BodyHandlers.ofString());


        //SE CREA INSTANCIA TIPO <Gson
        Gson gson = new Gson();
        //SE CREA VARIABLE TIPO <JsonObject Y SE ALMACENA LA INSTANCIA <gson PARA APLICAR EL METODO <fromJson() DONDE SE TOMA EL JSON DE LA RESPUESTA HTTP Y SE ESPECIFICA QUE SE CONVIERTE EN UN OBJETO <JsonObject
        JsonObject jsonManipulable = gson.fromJson(respuesta.body(), JsonObject.class);
        // AQUI ESPECIFICAMENTE SE OBTIENEN TODOS LOS VALORES ("KEY" : VALUE), <conversion_rates ES UNA KEY ESPECIFICA DE LA API DONDE SE ALMACENAN TODAS LAS MONEDAS ("KEY" : VALUE)
        // SE CREA VARIABLE TIPO <JsonObject , SE USA PARA CREAR UN JSON SECUNDARIO CON LOS VALORES ("KEY" : VALUE) QUE CONTIENE <conversion_rates A PARTIR DEL JSON PRINCIPAL <jsonManipulable
        JsonObject valoresAPI = jsonManipulable.getAsJsonObject("conversion_rates");

        double valor = 0;

        switch (eleccion) {
            case 1:
                valor = valoresAPI.get("ARS").getAsDouble();
                break;
            case 2:
                valor = valoresAPI.get("BRL").getAsDouble();
                break;
            case 3:
                valor = valoresAPI.get("COP").getAsDouble();
                break;
            default:
                throw new RuntimeException("Gracias por usar nuestro servicio.");
        }
        return valor;
    }

}
