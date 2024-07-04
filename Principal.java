package ConversorMoneda;

import java.io.IOException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) throws IOException, InterruptedException {

        Scanner seleccionarOperacion = new Scanner(System.in);
        Scanner cantidadDeseada = new Scanner(System.in);
        ConsultaApi consulta = new ConsultaApi();

        int eleccion = 0;

        while (eleccion != 4) {

            System.out.println("***********************************\n"+
                    "Sea bienvenido al conversor de moneda\n\n"+
                    "Le mostramos las opciones:\n"+
                    "1. Dólar -> Peso Argentino\n"+
                    "2. Dólar -> Real Brasileño\n"+
                    "3. Dólar -> Peso Colombiano\n"+
                    "4. Salir\n\n"+
                    "Favor de elegir una opción válida:");

            try {
                eleccion = Integer.parseInt(seleccionarOperacion.nextLine());
                double valor = consulta.busquedaApi(eleccion);

                System.out.print("Introduzca cantidad de dolares convertir: ");
                int eleccion2 = Integer.parseInt(cantidadDeseada.nextLine());

                if (eleccion == 1) {
                    double resultado = eleccion2 * valor;
                    System.out.println("Cantidad convertida: " + resultado);
                } else if (eleccion == 2) {
                    double resultado = eleccion2 * valor;
                    System.out.println("Cantidad convertida: " + resultado);
                } else if (eleccion == 3) {
                    double resultado = eleccion2 * valor;
                    System.out.println("Cantidad convertida: " + resultado);
                }

            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
                System.out.println("");
            }

        }

    }

}
