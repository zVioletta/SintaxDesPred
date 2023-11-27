import java.util.List;
import java.util.Stack;

public class ASDI implements Parser {
    private int i = 0, noTerm = 0, term = 0;
    private boolean err = false;
    private Token preAn;
    private final List<Token> tokens;
    private final Tabla ta = new Tabla();
    private String prod = "", item = "";
    private Stack<String> pila = new Stack<>();

    public ASDI(List<Token> tokens) {
        this.tokens = tokens;
        preAn = this.tokens.get(i);
    }

    @Override
    public boolean parse() {
        this.pila.push("$");
        this.pila.push("Q");
        this.item = pila.pop();

        while (item != null) {
            if (this.err)
                return false;

            //? Comprobar si item es terminal o no terminal.
            if ((item.equals("Q")) || (item.equals("D")) || (item.equals("P")) || (item.equals("A")) || (item.equals("A1")) || (item.equals("A2")) || (item.equals("A3")) || (item.equals("T")) || (item.equals("T1")) || (item.equals("T2")) || (item.equals("T3"))) {
                System.out.println("»»» First Case");
                System.out.println("Index\nItem: " + item + ". Pre analysis:  " + preAn + ".");
                this.buscarIndices(item, this.preAn);

                if (err)
                    break;

                this.production();
                System.out.println("Production: " + prod + ".");
                this.addBatteryInv();
                this.item = pila.pop();
                System.out.println("Item: " + this.item + ".");
                System.out.println("»»» End first case");

            } else if (((item.equals("select")) && (this.preAn.tipo.equals(TipoToken.SELECT)))
                    || ((item.equals("from")) && (this.preAn.tipo.equals(TipoToken.FROM)))
                    || ((item.equals("distinct")) && (this.preAn.tipo.equals(TipoToken.DISTINCT)))
                    || ((item.equals("*")) && (this.preAn.tipo.equals(TipoToken.ASTERISCO)))
                    || ((item.equals(",")) && (this.preAn.tipo.equals(TipoToken.COMA)))
                    || ((item.equals(".")) && (this.preAn.tipo.equals(TipoToken.PUNTO)))
                    || ((item.equals("id")) && (this.preAn.tipo.equals(TipoToken.IDENTIFICADOR)))
                    || ((item.equals("$")) && (this.preAn.tipo.equals(TipoToken.EOF)))) {

                System.out.println("»»» Second case");
                //? Si son iguales
                item = pila.pop();
                i++;
                this.preAn = this.tokens.get(i);
                System.out.println("Item: " + item + ". Pre analysis:  " + preAn + ".");
                System.out.println("»»» End second case");

            } else if (item.equals("E")) {
                System.out.println("»»» Third case");
                //? No se inserta nada en la pila
                item = pila.pop();
                System.out.println("Item: " + item + ". Pre analysis:  " + preAn + ".");
                System.out.println("»»» End third case");

            } else if (item.equals("#")) {
                System.out.println("»»» Errors");
                this.err = true;
                System.out.println("La sintaxis es erronea. Token:" + this.preAn.lexema + ". Tipo: " + this.preAn.tipo +
                        ". position: " + this.preAn.posicion + ".");
                System.out.println("Item: " + item + ". Pre analysis:  " + preAn + ".");
                System.out.println("»»» End errors");
            }
        }

        if (preAn.tipo == TipoToken.EOF && !err && this.pila.isEmpty()) {
            System.out.println("Consulta correcta");
            return true;
        } else {
            System.out.println("Se encontraron errores");
        }
        return false;
    }

    public void buscarIndices(String noTerm, Token term) {
        switch (noTerm) {
            case "Q":
                this.noTerm = 0;
                break;
            case "D":
                this.noTerm = 1;
                break;
            case "P":
                this.noTerm = 2;
                break;
            case "A":
                this.noTerm = 3;
                break;
            case "A1":
                this.noTerm = 4;
                break;
            case "A2":
                this.noTerm = 5;
                break;
            case "A3":
                this.noTerm = 6;
                break;
            case "T":
                this.noTerm = 7;
                break;
            case "T1":
                this.noTerm = 8;
                break;
            case "T2":
                this.noTerm = 9;
                break;
            case "T3":
                this.noTerm = 10;
                break;
            default:
                err = true;
                System.out.println("Error. Indice (noTerm) no encontrado");
                break;
        }

        switch (term.tipo) {
            case SELECT:
                this.term = 0;
                break;
            case FROM:
                this.term = 1;
                break;
            case DISTINCT:
                this.term = 2;
                break;
            case ASTERISCO:
                this.term = 3;
                break;
            case COMA:
                this.term = 4;
                break;
            case PUNTO:
                this.term = 5;
                break;
            case IDENTIFICADOR:
                this.term = 6;
                break;
            case EOF:
                this.term = 7;
                break;
            default:
                err = true;
                System.out.println("Error. Indice (Terminal) no encontrado");
                break;
        }
    }

    public void production() {
        this.prod = this.ta.tabla[this.noTerm][this.term];
    }

    public void addBatteryInv() {
        System.out.println("»»» Inverse added");
        char c; //? Distingue palabras de producciónes
        String aux = "";
        int x = this.prod.length() - 1;

        while (x >= 0) {
            c = this.prod.charAt(x);//? Asigna último char del lexema
            if ((c == ' ') || (x == 0)) {
                if (x == 0)
                    aux += c;

                System.out.println("Before reverse: " + aux);
                this.pila.push(this.reverse(aux));
                aux = "";
                System.out.println("Battery start: " + pila.peek());

            } else {
                aux += c;
                System.out.println("X = " + x + " Aux = " + aux);
            }
            x--;
        }
    }

    public String reverse(String cad) {
        //? Revertir la cadena usando bucle y concatenación
        String inverted = "";
        for (int i = cad.length() - 1; i >= 0; i--) {
            inverted += cad.charAt(i);
        }
        return inverted;
    }
}
