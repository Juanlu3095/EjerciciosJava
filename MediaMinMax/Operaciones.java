
package MediaMinMax;

import java.util.ArrayList;

public class Operaciones {
    
    /**
     * Calcula la media de los números de un ArrayList.
     * @param datos ArrayList
     * @return media float
     */
    public static float media(ArrayList<Float> datos) {
        float suma = 0;
        for(int i=0; i < datos.size(); i++) {
            suma = suma + datos.get(i);
        }
        float media = suma/datos.size();
        return media;
    }
    
    /**
     * Calcula el máximo de los números de un ArrayList.
     * @param datos ArrayList
     * @return maximo float
     */
    public static float maximo(ArrayList<Float> datos) {
        float maximo = 0;
        for(int i=0; i < datos.size(); i++) {
            if(datos.get(i) > maximo) {
                maximo = datos.get(i);
            }
        }
        return maximo;
    }
    
    /**
     * Calcula el mínimo de los números de un ArrayList.
     * @param datos ArrayList
     * @return minimo float
     */
    public static float minimo(ArrayList<Float> datos) {
        float minimo = datos.get(0);
        for(int i=0; i < datos.size(); i++) {
            if(minimo >= 0 && minimo > datos.get(i)) {
                minimo = datos.get(i);
            }
        }
        return minimo;
    }
}
