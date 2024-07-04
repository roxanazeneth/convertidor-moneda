package ConversorMoneda;
import java.util.Map;

public class Api {
    //VARIABLE QUE ALMACENA EL VALOR BASE DE LA API "USD" EN ESTE CASO
    private String monedaBaseUSD;
    //VARIABLE TIPO <Map QUE ALMASENA LOS VALORES DE LA API ("KEY" : VALUE)
    private Map<String, Double> valoresAPI;

    // CONSTRUCTOR, CONSTRUYE INSTANCIA TIPO <Api Y ALMACENA SUS VALORES CORRESPONDIENTES
    public Api(String baseCurrency, Map<String, Double> valoresAPI) {
        this.monedaBaseUSD = baseCurrency;
        this.valoresAPI = valoresAPI;
    }

    //GETTER PARA OBTENER VALOR DE MONEDA BASE (USD)
    public String getMonedaBaseUSD() {
        return monedaBaseUSD;
    }

    // GETTER PARA OBTENER VALORES DE LA API ("KEY" : VALUE)
    public Map<String, Double> getValoresAPI() {
        return valoresAPI;
    }

}
