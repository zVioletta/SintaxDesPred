import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ASDI implements Parser {
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


    }
}