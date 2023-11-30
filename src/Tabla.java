import java.util.HashMap;
import java.util.Map;

public class Tabla {

    public Tabla(){

    }

    public Map < String, Map<String, String> > generarTablaAnalisis() {
        Map<String, Map<String, String>> tabla = new HashMap<>();
        //  "Ɛ"   Simbolos de entrada            id|  ,  |sel|dist|from|  *  | .  | $
        tabla.put("Q", crearFila("!", "!", "1", "!", "!", "!", "!", "!"));
        tabla.put("D", crearFila("2", "!", "!", "2", "!", "2", "!", "!"));
        tabla.put("P", crearFila("3", "!", "!", "!", "!", "3", "!", "!"));
        tabla.put("A", crearFila("4", "!", "!", "!", "!", "!", "!", "!"));
        tabla.put("A1", crearFila("!", "5", "!", "!", "5", "!", "!", "!"));
        tabla.put("A2", crearFila("6", "!", "!", "!", "!", "!", "!", "!"));
        tabla.put("A3", crearFila("!", "7", "!", "!", "7", "!", "7", "!"));
        tabla.put("T", crearFila("8", "!", "!", "!", "!", "!", "!", "!"));
        tabla.put("T1", crearFila("!", "9", "!", "!", "!", "!", "!", "9"));
        tabla.put("T2", crearFila("10", "!", "!", "!", "!", "!", "!", "!"));
        tabla.put("T3", crearFila("11", "11", "!", "!", "!", "!", "!", "11"));

        return tabla;
    }

    private Map<String, String> crearFila(String... valores) {
        Map<String, String> fila = new HashMap<>();
        fila.put("id", valores[0]);
        fila.put(",", valores[1]);
        fila.put("select", valores[2]);
        fila.put("dinstict", valores[3]);
        fila.put("from", valores[4]);
        fila.put("*", valores[5]);
        fila.put(".", valores[6]);
        fila.put("$", valores[7]);
        return fila;
    }

}