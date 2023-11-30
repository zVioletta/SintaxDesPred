import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ASDI {

    private int i = 0;
    private Token aux;
    private final List<Token> tokens;
    private final Map<String, String[]> production = new HashMap<>();
    Tabla t = new Tabla();
    Map<String, Map<String, String>> table = t.tableAnalysis();

    private void error() {
        System.out.println("Error on: " + (i + 1) + ". Expecting:" + tokens.get(i));
    }

    public ASDI(List<Token> tokens) {
        this.tokens = tokens;

        production.put("Q", new String[] {"select D from T"});
        production.put("D", new String[] {"distinct P", "P"});
        production.put("P", new String[] {"*", "A"});
        production.put("A", new String[] {"A2 A1"});
        production.put("A1", new String[] {", A", ""});
        production.put("A2", new String[] {"id A3"});
        production.put("A3", new String[] {". id", ""});
        production.put("T", new String[] {"T2 T1"});
        production.put("T1", new String[] {", T", ""});
        production.put("T2", new String[] {"id T3"});
        production.put("T3", new String[] {"id", ""});
    }

    public boolean analizarEntrada() {
        Stack<String> battery = new Stack<>();
        battery.push("$");
        battery.push("Q");
        String x = battery.pop();

        int flag;
        String[] success;

        while (!(x.equals("$"))) {
            aux = tokens.get(i);
            System.out.println("Popped Out:" + x + " Aux:" + aux.getLexema());

            if (x.equals(aux.getLexema())) {
                i++;
            }
            else if (x.isEmpty()) {
                // TODO: Look if needed
            }
            else if (this.isTerminal(x)) {
                error();
                return false;
            }
            else if ((table.get(x).get(aux.getLexema())).equals("!")) {
                error();
                return false;
            }
            else if (!table.get(x).get(aux.getLexema()).equals("!")) {
                success = production.get(x)[0].split(" ");
                if (production.get(x).length > 1) {
                    if (success[0].equals(aux.getLexema())) {
                        flag = 0;
                    } else {
                        flag = 1;
                    }
                } else {
                    flag = 0;
                }
                String[] newElement = production.get(x)[flag].split(" ");
                System.out.println("Output: " + x + "->" + production.get(x)[flag]);
                for (int j = 0; j < newElement.length; j++) {
                    battery.push(newElement[newElement.length - j - 1]);
                }
            }
            x = battery.pop();
        }
        return true;
    }
}