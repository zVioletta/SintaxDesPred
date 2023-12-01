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
        return false;
    }

    public void indexSearch(String j, Token k) {
        // ? No terminales
        switch (j) {
            case "Q":
                this.j = 0;
                break;
            case "D":
                this.j = 1;
                break;
            case "P":
                this.j = 2;
                break;
            case "A":
                this.j = 3;
                break;
            case "A1":
                this.j = 4;
                break;
            case "A2":
                this.j = 5;
                break;
            case "A3":
                this.j = 6;
                break;
            case "T":
                this.j = 7;
                break;
            case "T1":
                this.j = 8;
                break;
            case "T2":
                this.j = 9;
                break;
            case "T3":
                this.j = 10;
                break;
            default:
                error();
                err = true;
                break;
        }

        // ? Terminales
        switch (k.tipo) {
            case SELECT:
                this.k = 0;
                break;
            case FROM:
                this.k = 1;
                break;
            case DISTINCT:
                this.k = 2;
                break;
            case ASTERISCO:
                this.k = 3;
                break;
            case COMA:
                this.k = 4;
                break;
            case PUNTO:
                this.k = 5;
                break;
            case IDENTIFICADOR:
                this.k = 6;
                break;
            case EOF:
                this.k = 7;
                break;
            default:
                error();
                err = true;
                break;
        }
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