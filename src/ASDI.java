import java.util.List;
import java.util.Stack;

public class ASDI implements Parser {
    private int i = 0, j = 0, k = 0;
    private boolean err = false;
    private Token preAn;
    private final List<Token> tokens;
    private final Tabla ta = new Tabla();
    private String prod = "", item = "";
    private final Stack<String> battery = new Stack<>();

    public ASDI(List<Token> tokens) {
        this.tokens = tokens;
        preAn = this.tokens.get(i);
    }

    private void error() {
        System.out.println("Error on: " + (i + 1) + ". Expecting:" + tokens.get(i));
    }

    @Override
    public boolean parse() {
        System.out.println("---\nSyntax Analysis\n---");
        this.battery.push("$");
        this.battery.push("Q");
        this.item = battery.pop();
    }

    public void addBatteryInv() {
        battery.pop();
        char c; // ? Distingue palabras de producciónes
        String aux = "";
        int x = this.prod.length() - 1;

        while (x >= 0) {
            c = this.prod.charAt(x);// ? Asigna último char del lexema
            if ((c == ' ') || (x == 0)) {
                if (x == 0) {
                    aux += c;
                }
                System.out.println("Before reverse: " + aux);
                this.battery.push(this.reverse(aux));
                aux = "";
                System.out.println("Battery start: " + battery.peek());
            } else {
                aux += c;
            }
            x--;
        }
    }

    public String reverse(String cad) {
        // ? Revertir la cadena usando bucle y concatenación
        String inverted = "";
        for (int i = cad.length() - 1; i >= 0; i--) {
            inverted += cad.charAt(i);
        }
        return inverted;
    }
}