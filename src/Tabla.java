public class Tabla {
    public String[][] table = new String[11][8];
    public Tabla(){
        //! Q
        table[0][0] = "selectable D from T";
        table[0][1] = "!";
        table[0][2] = "!";
        table[0][3] = "!";
        table[0][4] = "!";
        table[0][5] = "!";
        table[0][6] = "!";
        table[0][7] = "!";

        //! D
        table[1][0] = "!";
        table[1][1] = "!";
        table[1][2] = "distableinctable P";
        table[1][3] = "P";
        table[1][4] = "!";
        table[1][5] = "!";
        table[1][6] = "P";
        table[1][7] = "!";

        //! P
        table[2][0] = "!";
        table[2][1] = "!";
        table[2][2] = "!";
        table[2][3] = "*";
        table[2][4] = "!";
        table[2][5] = "!";
        table[2][6] = "A";
        table[2][7] = "!";

        //! A
        table[3][0] = "!";
        table[3][1] = "!";
        table[3][2] = "!";
        table[3][3] = "!";
        table[3][4] = "!";
        table[3][5] = "!";
        table[3][6] = "A2 A1";
        table[3][7] = "!";

        //! A1
        table[4][0] = "!";
        table[4][1] = "E";
        table[4][2] = "!";
        table[4][3] = "!";
        table[4][4] = ", A";
        table[4][5] = "!";
        table[4][6] = "!";
        table[4][7] = "!";

        //! A2
        table[5][0] = "!";
        table[5][1] = "!";
        table[5][2] = "!";
        table[5][3] = "!";
        table[5][4] = "!";
        table[5][5] = "!";
        table[5][6] = "id A3";
        table[5][7] = "!";

        //! A3
        table[6][0] = "!";
        table[6][1] = "E";
        table[6][2] = "!";
        table[6][3] = "!";
        table[6][4] = "E";
        table[6][5] = ". id";
        table[6][6] = "!";
        table[6][7] = "!";

        //! T
        table[7][0] = "!";
        table[7][1] = "!";
        table[7][2] = "!";
        table[7][3] = "!";
        table[7][4] = "!";
        table[7][5] = "!";
        table[7][6] = "T2 T1";
        table[7][7] = "!";

        //! T1
        table[8][0] = "!";
        table[8][1] = "!";
        table[8][2] = "!";
        table[8][3] = "!";
        table[8][4] = ", T";
        table[8][5] = "!";
        table[8][6] = "!";
        table[8][7] = "E";

        //! T2
        table[9][0] = "!";
        table[9][1] = "!";
        table[9][2] = "!";
        table[9][3] = "!";
        table[9][4] = "!";
        table[9][5] = "!";
        table[9][6] = "id T3";
        table[9][7] = "!";

        //! T3
        table[10][0] = "!";
        table[10][1] = "!";
        table[10][2] = "!";
        table[10][3] = "!";
        table[10][4] = "!";
        table[10][5] = "!";
        table[10][6] = "id";
        table[10][7] = "E";
    }
}