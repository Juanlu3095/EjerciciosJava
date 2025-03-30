
package Cajero;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Usuario
 */
public class Cajero {
    
    public boolean validarPin(String pin) {
	File carpeta = new File("src/Cajero/" + pin + ".txt");
	boolean existe = carpeta.exists();
        return existe;
    }
    
   
    public String obtenerSaldo(String pin) {
        File archivo = new File("src/Cajero/" + pin + ".txt");
        
        try(FileReader reader = new FileReader(archivo)){
            BufferedReader buffer = new BufferedReader(reader);

            String linea = buffer.readLine(); // Leemos el archivo
            buffer.close();
            
            return linea;
        } catch (IOException e) {
            return "Error al obtener el saldo en su cuenta: " + e.getMessage();
        }
        
    }
        
    public String sacarDinero(String pin, int importe) {
        int saldo = Integer.parseInt(obtenerSaldo(pin)); // Convertimos el saldo obtenido del archivo a int para operar
        int saldoRestante = saldo - importe; // Realizamos la operación
        String saldoString = Integer.toString(saldoRestante); // Convertimos el saldo restante a string para guardarlo en el archivo
        
        // Escritura en archivo
        try (FileWriter writer = new FileWriter("src/Cajero/" + pin + ".txt")){
            
            writer.write(saldoString);
            writer.close();
            return saldoString;
        } catch (IOException e) {
            return "Error al proporcionarle su dinero: " + e.getMessage();
        }
        
    }
    
    public String ingresarDinero(String pin, int importe) {
        int saldo = Integer.parseInt(obtenerSaldo(pin)); // Convertimos el saldo obtenido del archivo a int para operar
        int saldoRestante = saldo + importe; // Realizamos la operación
        String saldoString = Integer.toString(saldoRestante); // Convertimos el saldo restante a string para guardarlo en el archivo
        
        // Escritura en archivo
        try (FileWriter writer = new FileWriter("src/Cajero/" + pin + ".txt")){
            
            writer.write(saldoString);
            writer.close();
            return saldoString;
        } catch (IOException e) {
            return "Error al proporcionarle su dinero: " + e.getMessage();
        }
    }
}
