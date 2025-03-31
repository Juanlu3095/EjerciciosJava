
/*
|----------------------------------------------------------------------------------------
| Media, mínimo y máximo
|----------------------------------------------------------------------------------------
|
| Programa hecho en Java que nos pide varios números hasta insertar un número negativo.
| Luego calcula la media, el valor mín y máx.
| A continuación comprueba que exista un archivo llamado resultado.txt. Si este archivo
| no existe lo crea.
| Para terminar escribe la media, mín y máx en el archivo .txt.
| 
*/

package MediaMinMax;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    /**
     * Función principal. La terminal pide valores float hasta que se escriba
     * un valor negativo.
     * @param args 
     */
    public static void main(String[] args) {
        Scanner escaner = new Scanner(System.in);
        
        System.out.println("Por favor introduzca los números para añadir a la lista.");
        ArrayList<Float> lista = new ArrayList<>();
        float numero;
        while (true) {
            numero = escaner.nextFloat();
            if(numero < 0) {
                break;
            } else {
                lista.add(numero);
            }
           
        }
        
        float media = Operaciones.media(lista);
        float minimo = Operaciones.minimo(lista);
        float maximo = Operaciones.maximo(lista);
        System.out.println("Los números introducidos son: " + lista);
        System.out.println("La media es: " + media);
        System.out.println("El máximo es: " + maximo);
        System.out.println("El mínimo es: " + minimo);
        guardarDatos(media, minimo, maximo);
    }
    
    /**
     * Permite escribir en un archivo los valores de media, min y máx, previa comprobación
     * de que exista el archivo datos.txt.
     * @param media
     * @param minimo
     * @param maximo 
     */
    public static void guardarDatos(float media, float minimo, float maximo) {
        String nombreArchivo = "src/MediaMinMax/datos.txt";
        File archivo = new File(nombreArchivo);
        
        if(!archivo.exists()) {
            try {
                archivo.createNewFile();
            } catch (IOException e) {
                System.out.println("No se ha podido crear el archivo, el error es: " + e.getMessage());
            }
        }
        
        try (FileWriter writer = new FileWriter(nombreArchivo)){
            
            writer.write("La media es: " + media + '\n');
            writer.write("El mínimo es: " + minimo + '\n');
            writer.write("El máximo es: " + maximo + '\n');
            writer.close();
        } catch (IOException e) {
            System.out.println("No se ha podido guardar los datos en el archivo, el error es: " + e.getMessage());
        }
    }
}
