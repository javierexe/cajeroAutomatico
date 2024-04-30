import java.util.Scanner;

public class Cajero {
    public static void main(String[] args) {

        String clienteRut = "11111111-1";
        String clienteNombre = "Javier";
        int saldo = 1000;
        int giro = 0;
        int deposito = 0;
        int opcion = 0;

        String encabezado = """
                              \n
                              ***************************************************
                              *** Sistema Cajero Automático Banco Alura-Latam ***
                              ***************************************************
                              """;
        String mensajeBienvenida = "\n      Hola " + clienteNombre + ", un gusto tenerte de vuelta";
        String nuevaOperacion = "\n¿Desea realizar otra operación?. Si(1) No(2)\"";
        String mensajeDespedidaCliente = "\nGracias " + clienteNombre + " por utilizar nuestro servicio\n" +
                                         " de cajero automático. Te esperamos pronto.\n" +
                                         "************ Banco Alura Latam ************";
        String mensajeDespedidaNoCliente = "\nGracias por utilizar nuestro servicio de cajero automático.\n" +
                                           "*************** Banco Alura Latam *****************";
        String suSaldo = "El saldo actual de su cuenta es: $";
        String saldoInsuficiente = "Saldo insuficiente. Intente con una cantidad menor.\n";
        String cantidadGiro = "¿Cuánto deseas girar?";
        String giroRealizado = "Giro realizado exitosamente. \n" +
                               "Su saldo actualizado es: $";
        String cantidadDeposito = "¿Cuánto deseas depositar?";
        String depositoExistoso = "Depósito realizado exitosamente. \n" +
                                  "Su saldo actualizado es: $";
        String quiereSalir = "¿Estás seguro que deseas salir?. Si(1) No(2)";
        String opcionNoValida = "El número ingresado no es válido para ninguna opción.";
        String nvoIntento = "Por favor, inténtalo nuevamente.";
        String menuOpciones = """
               **************************************************
                      Ingresa el número de la opción elegida    \s
               --------------------------------------------------
                1 --> Consultar Saldo
                2 --> Girar
                3 --> Depositar
                9 --> Salir
               --------------------------------------------------
               \s""";

        Scanner teclado = new Scanner(System.in);

        System.out.println(encabezado);
        //Autenticación del usuario
        System.out.println("Por favor, ingresa tu RUT (xxxxxxxx-x)");
        String rut = teclado.next();
        while (!rut.equals(clienteRut)) {
            System.out.println("Ingresa un RUT de cliente válido o simplemente presiona 9 para salir");
            rut = teclado.next();
            if (rut.equals("9")) {
                System.out.println(mensajeDespedidaNoCliente);
                return; //Salir del programa
            }
        }

        System.out.println(mensajeBienvenida);

        int salida = 0;
        do {
            salida = 0;
            System.out.println(menuOpciones);
            opcion = teclado.nextInt();
            switch (opcion) {
                case 1:
                    System.out.println(suSaldo + saldo + " pesos");
                    break;
                case 2:
                    System.out.println(cantidadGiro);
                    giro = teclado.nextInt();
                    while (giro > saldo) {
                        System.out.println(saldoInsuficiente);
                        giro = teclado.nextInt();
                    }
                    saldo -= giro;
                    System.out.println(giroRealizado + saldo + " pesos");
                    break;
                case 3:
                    System.out.println(cantidadDeposito);
                    deposito = teclado.nextInt();
                    saldo += deposito;
                    System.out.println(depositoExistoso + saldo + " pesos");
                    break;
                case 9:
                    System.out.println(quiereSalir);
                    salida = teclado.nextInt();
                    while (salida !=1 && salida!=2) {
                        System.out.println("Deber ingresar 1(Salir) o 2 (NO Salir)");
                        salida = teclado.nextInt();
                    } if (salida == 1) {
                        System.out.println(mensajeDespedidaCliente);
                        return; //Salir del programa
                    } else
                        break;
                default:
                    System.out.println(opcionNoValida);

            } if (opcion != 1 && opcion != 2 && opcion != 3 && salida != 2) {
                System.out.println(nvoIntento+"\n");
            } else {
                System.out.println(nuevaOperacion);
                salida = teclado.nextInt();
            }
        } while (salida != 2 || salida == 0);
        System.out.println(mensajeDespedidaCliente);
    }
}





