import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ASDI {
    private int i = 0;
    private final List<Token> tokens;
    private Token preAn;
    private Map<String, TipoToken> prod = new HashMap<>();
    Tabla t = new Tabla();
    Map<String, Map<String, String>> tablas = t.tableAnalysis();

    private void error() {
        System.out.println("Error on: " + (i + 1) + ". Expecting:" + tokens.get(i));
    }

    public ASDI (List<Token> tokens) {
        this.tokens = tokens;
        preAn = this.tokens.get(i);

        prod.put("Q", new String[] {"select D from T"});
        prod.put("D", new String[] {"distingt P", "P"});
        prod.put("P", new String[] {"*", "A"});
        prod.put("A", new String[] {"A2 A1"});
        prod.put("A1", new String[] {", A", ""});
        prod.put("A2", new String[] {"id A3"});
        prod.put("A3", new String[] {". id", ""});
        prod.put("T", new String[] {"T2 T1"});
        prod.put("T1", new String[] {", T", ""});
        prod.put("T2", new String[] {"id T3"});
        prod.put("T3", new String[] {"id", ""});
    }

    public boolean entryAnalysis(){
        return true;
    }
}