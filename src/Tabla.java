public class Tabla {
    public String[][] t = new String[11][8];
    public Tabla(){
        //! Q
        t[0][0] = "select D from T";
        t[0][1] = "!";
        t[0][2] = "!";
        t[0][3] = "!";
        t[0][4] = "!";
        t[0][5] = "!";
        t[0][6] = "!";
        t[0][7] = "!";

        //! D
        t[1][0] = "!";
        t[1][1] = "!";
        t[1][2] = "distinct P";
        t[1][3] = "P";
        t[1][4] = "!";
        t[1][5] = "!";
        t[1][6] = "P";
        t[1][7] = "!";

        //! P
        t[2][0] = "!";
        t[2][1] = "!";
        t[2][2] = "!";
        t[2][3] = "*";
        t[2][4] = "!";
        t[2][5] = "!";
        t[2][6] = "A";
        t[2][7] = "!";

        //! A
        t[3][0] = "!";
        t[3][1] = "!";
        t[3][2] = "!";
        t[3][3] = "!";
        t[3][4] = "!";
        t[3][5] = "!";
        t[3][6] = "A2 A1";
        t[3][7] = "!";

        //! A1
        t[4][0] = "!";
        t[4][1] = "E";
        t[4][2] = "!";
        t[4][3] = "!";
        t[4][4] = ", A";
        t[4][5] = "!";
        t[4][6] = "!";
        t[4][7] = "!";

        //! A2
        t[5][0] = "!";
        t[5][1] = "!";
        t[5][2] = "!";
        t[5][3] = "!";
        t[5][4] = "!";
        t[5][5] = "!";
        t[5][6] = "id A3";
        t[5][7] = "!";

        //! A3
        t[6][0] = "!";
        t[6][1] = "E";
        t[6][2] = "!";
        t[6][3] = "!";
        t[6][4] = "E";
        t[6][5] = ". id";
        t[6][6] = "!";
        t[6][7] = "!";

        //! T
        t[7][0] = "!";
        t[7][1] = "!";
        t[7][2] = "!";
        t[7][3] = "!";
        t[7][4] = "!";
        t[7][5] = "!";
        t[7][6] = "T2 T1";
        t[7][7] = "!";

        //! T1
        t[8][0] = "!";
        t[8][1] = "!";
        t[8][2] = "!";
        t[8][3] = "!";
        t[8][4] = ", T";
        t[8][5] = "!";
        t[8][6] = "!";
        t[8][7] = "E";

        //! T2
        t[9][0] = "!";
        t[9][1] = "!";
        t[9][2] = "!";
        t[9][3] = "!";
        t[9][4] = "!";
        t[9][5] = "!";
        t[9][6] = "id T3";
        t[9][7] = "!";

        //! T3
        t[10][0] = "!";
        t[10][1] = "!";
        t[10][2] = "!";
        t[10][3] = "!";
        t[10][4] = "!";
        t[10][5] = "!";
        t[10][6] = "id";
        t[10][7] = "E";
    }
}