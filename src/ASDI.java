import java.util.List;

public class ASDI implements Parser {
    private final List<Token> tokens;
    private Token preAn;
    private int i = 0;
    private int err = 0;

    private void error() {
        System.out.println("Error on: " + (i + 1) + ". Expecting:" + tokens.get(i));
        err = 1;
    }

    public ASDI (List<Token> tokens) {
        this.tokens = tokens;
        preAn = this.tokens.get(i);
    }

    @Override
    public boolean parse() {
        if (Q()) {
            if(this.preAn.equals("EOF")) {
                System.out.println("Success!");
            } else {
                error();
            }
        } else {
            error();
        }
        return err == 0;
    }

    private boolean Q() {
        if (tokens.get(i).equals("select")) {
            i++;
            if (D()) {
                if (tokens.get(i).equals("from")) {
                    i++;
                    return T();
                    } else {
                        error();
                    }
                } else {
                    error();
                }
            }
        return false;
    }

    private boolean D() {
        if (tokens.get(i).equals("distinct")) {
            i++;
            return P();
        } else {
            return P();
        }
    }

    private boolean P() {
        if (tokens.get(i).equals("*")) {
            i++;
        } else {
            return A();
        }
        return false;
    }

    private boolean A() {
        if (A2()) {
            if (A1()) {
                return true;
            } else {
                error();
            }
        }
        return false;
    }

    private boolean A1() {
        if (tokens.get(i).equals(",")) {
            i++;
            if (A()) {
                return true;
            } else {
                error();
            }
        } else {
            return true;
        }
        return false;
    }

    private boolean A2() {
        if (tokens.get(i).equals("id")) {
            i++;
            return A3();
        } else {
            return false;
        }
    }

    private boolean A3() {
        if (tokens.get(i).equals(",")) {
            i++;
            if (tokens.get(i).equals("id")) {
                i++;
                return true;
            } else {
                error();
            }
        } else {
            return true;
        }
        return false;
    }

    private boolean T() {
        if (T2()) {
            return T1();
        }
        return false;
    }

    private boolean T1() {
        if (tokens.get(i).equals(",")) {
            i++;
            if (T()) {
                return true;
            } else {
                error();
            }
        } else {
            return true;
        }
        return false;
    }

    private boolean T2() {
        if (tokens.get(i).equals("id")) {
            i++;
            return T3();
        } else {
            return false;
        }
    }

    private boolean T3() {
        if (tokens.get(i).equals("id")) {
            i++;
        }
        return false;
    }
}