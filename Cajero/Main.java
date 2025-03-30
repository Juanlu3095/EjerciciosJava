
package Cajero;

import java.util.Scanner;

/**
 *
 * @author Usuario
 */
public class Main {
    Scanner escaner;
    Cajero cajero;
    
    public Main() {
        this.escaner = new Scanner(System.in);
        this.cajero = new Cajero();
    }
    
    public static void main(String[] args) {
        Main main = new Main();
        
        System.out.println("Bienvenido a su cajero.");
        System.out.println("Por favor, introduzca su pin a continuación (9999 para salir):");
        String pin = main.escaner.nextLine();
        
        if (pin.equals("9999")) { // no compara el contenido de las cadenas
            System.out.println("Gracias por confiar en nuestro cajero.");
            main.escaner.close();
            System.exit(0); // Termina el programa, 0 es ok, número positivo es error controlado, negativo no controlado o del sistema
        }
        
        if(main.cajero.validarPin(pin)) {
            String saldo = main.cajero.obtenerSaldo(pin);
            System.out.println("Hola, usuario.");
            System.out.println("Su saldo actual es de: " + saldo + " euros.");
            System.out.println("¿Qué acción quiere realizar? Introduzca el número de la acción.");
            System.out.println("1 - Ingresar dinero");
            System.out.println("2 - Retirar dinero");
            int opcion = main.escaner.nextInt();
            
            switch (opcion) {
                case 1:
                    main.ingresarDinero(pin);
                    break;
                case 2:
                    main.retirarDinero(pin, saldo);
                    break;
                default:
                    System.out.println("Gracias por confiar en nuestro cajero");
            }
            
            main.escaner.close();
            
        } else {
            System.out.println("Pin incorrecto.");
        }
    }
    
    public void ingresarDinero(String pin) {
        System.out.println("Indique a continuacion el importe que desea abonar:");
            
        int importe = escaner.nextInt();
        String saldoRestante = cajero.ingresarDinero(pin, importe);
        System.out.println("----Dinero imgresado con éxito----");
        System.out.println("Saldo en cuenta: " + saldoRestante);
    }
    
    public void retirarDinero(String pin, String saldo) {
        System.out.println("Indique a continuacion el importe que desea retirar:");
            
        int importe = escaner.nextInt();
        if (Integer.parseInt(saldo) >= importe) {
            String saldoRestante = cajero.sacarDinero(pin, importe);
            System.out.println("----Recoja su dinero----");
            System.out.println("Saldo en cuenta: " + saldoRestante);
        } else {
            System.out.println("----Saldo insuficiente----");
        }
    }
}
