import java.io.IOException;
import java.util.Scanner;

public class Principal {


    static Scanner lectura= new Scanner(System.in);

    public static void main(String[] args) throws IOException, InterruptedException {
        Calculadora myclass = new Calculadora();

        var opcion = 0;

        do{
            System.out.println("Bienvenido al Conversor de Divisas");
            System.out.println("1. MXN A USD");
            System.out.println("2. MXN A BRL");
            System.out.println("3. MXN A ARS");
            System.out.println("4. Salir");
            System.out.println("Por favor digite una opción");

            opcion = lectura.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("*****************");
                    System.out.println("1. De USD A MXN");
                    myclass.opciones("USD","MXN");
                    break;

                case 2:
                    System.out.println("*****************");
                    System.out.println("2. BRL A MXN");
                    myclass.opciones("BRL","MXN");
                    break;

                case 3:
                    System.out.println("*****************");
                    System.out.println("3. ARS A MXN");
                    myclass.opciones("ARS","MXN");


                    break;


                    default:
                    System.out.println("Opción no valida, vuelva a intentarlo"+ '\n');

            }
        }while (opcion!=4);

        System.out.println("Vuelva Pronto!"+ '\n');







    }








}
