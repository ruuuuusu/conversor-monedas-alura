import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {

        try (Scanner lectura = new Scanner(System.in)) {

            ConsultaMoneda consulta = new ConsultaMoneda();
            int opcion = 0;

            while (opcion != 7) {

                System.out.println("*************************************");
                System.out.println("Sea bienvenido al Conversor de Moneda");
                System.out.println();
                System.out.println("1) Dólar -> Peso argentino");
                System.out.println("2) Peso argentino -> Dólar");
                System.out.println("3) Dólar -> Real brasileño");
                System.out.println("4) Real brasileño -> Dólar");
                System.out.println("5) Dólar -> Euro");
                System.out.println("6) Euro -> Dólar");
                System.out.println("7) Salir");
                System.out.println("Elija una opción válida:");
                System.out.println("*************************************");

                opcion = lectura.nextInt();

                if (opcion == 7) {
                    break;
                }

                System.out.println("Ingrese la cantidad a convertir:");
                double cantidad = lectura.nextDouble();

                try {

                    Moneda moneda = consulta.buscarMoneda("USD");

                    double resultado = 0;

                    switch (opcion) {

                        case 1:
                            resultado = cantidad * moneda.conversion_rates.get("ARS");
                            System.out.println("Resultado: " + resultado + " ARS");
                            break;

                        case 2:
                            resultado = cantidad / moneda.conversion_rates.get("ARS");
                            System.out.println("Resultado: " + resultado + " USD");
                            break;

                        case 3:
                            resultado = cantidad * moneda.conversion_rates.get("BRL");
                            System.out.println("Resultado: " + resultado + " BRL");
                            break;

                        case 4:
                            resultado = cantidad / moneda.conversion_rates.get("BRL");
                            System.out.println("Resultado: " + resultado + " USD");
                            break;

                        case 5:
                            resultado = cantidad * moneda.conversion_rates.get("EUR");
                            System.out.println("Resultado: " + resultado + " EUR");
                            break;

                        case 6:
                            resultado = cantidad / moneda.conversion_rates.get("EUR");
                            System.out.println("Resultado: " + resultado + " USD");
                            break;

                        default:
                            System.out.println("Opción inválida");
                    }

                } catch (Exception e) {
                    System.out.println("Error al consultar la API");
                }
            }

            System.out.println("Programa finalizado.");
        }
    }
}