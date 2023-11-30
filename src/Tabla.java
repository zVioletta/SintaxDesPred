import java.util.HashMap;
import java.util.Map;

public class Tabla {

    public Tabla(){

    }

    public Map < String, Map<String, String> > tableAnalysis() {
        Map<String, Map<String, String>> t = new HashMap<>();
        //  "Ɛ"   Simbolos de entrada            id|  ,  |sel|dist|from|  *  | .  | $
        t.put("Q", crearFila("!", "!", "1", "!", "!", "!", "!", "!"));
        t.put("D", crearFila("2", "!", "!", "2", "!", "2", "!", "!"));
        t.put("P", crearFila("3", "!", "!", "!", "!", "3", "!", "!"));
        t.put("A", crearFila("4", "!", "!", "!", "!", "!", "!", "!"));
        t.put("A1", crearFila("!", "5", "!", "!", "5", "!", "!", "!"));
        t.put("A2", crearFila("6", "!", "!", "!", "!", "!", "!", "!"));
        t.put("A3", crearFila("!", "7", "!", "!", "7", "!", "7", "!"));
        t.put("T", crearFila("8", "!", "!", "!", "!", "!", "!", "!"));
        t.put("T1", crearFila("!", "9", "!", "!", "!", "!", "!", "9"));
        t.put("T2", crearFila("10", "!", "!", "!", "!", "!", "!", "!"));
        t.put("T3", crearFila("11", "11", "!", "!", "!", "!", "!", "11"));

        return t;
    }

    private Map<String, String> crearFila(String... valores) {
        Map<String, String> row = new HashMap<>();
        row.put("id", valores[0]);
        row.put(",", valores[1]);
        row.put("select", valores[2]);
        row.put("dinstict", valores[3]);
        row.put("from", valores[4]);
        row.put("*", valores[5]);
        row.put(".", valores[6]);
        row.put("$", valores[7]);
        return row;
    }

}