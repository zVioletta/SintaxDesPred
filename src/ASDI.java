import java.util.List;
import java.util.Stack;

public class ASDI implements Parser{

    private int i = 0, noTerm = 0, term = 0;
    private boolean err = false;
    private Token preAn;
    private final List<Token> tokens;
    private final Tabla ta = new Tabla();
    private String prod, item;
    //private static List<Token> auxItem;
    private Stack<String> pila = new Stack<>(); //Decalracion de la pila
        

    //Ejemplo para acceder a los incides de la tabla String a = this.ta.tabla[ noTerm ][ term ];

    public ASDI(List<Token> tokens){
        this.tokens = tokens;
        preAn = this.tokens.get(i);
    }

    @Override
    public boolean parse() {

        //Definimo la pila con 2 caracteres iniciales
        //Stack<String> pila = new Stack<>(); //Decalracion de la pila
        this.pila.push("$"); //Primer item (ultimo en salir): $. Indica el final de la cadena.
        this.pila.push("Q"); //Siguinte item: Q. Axioma de la gramatica.
        this.item = pila.pop();
        //this.preAn = this.tokens.get(i);
        
        while( !pila.empty() ){//Miestras la pila no este vacia

            if( this.err ) return false;//Se checa que no haya errores

            //Comprobar que item es un noTerm o un termina (alguin tipo de Token)
            if( ( item.equals("Q") )  || ( item.equals("D") )  || ( item.equals("P") ) || ( item.equals("A") )  || ( item.equals("A1") ) || ( item.equals("A2") ) || ( item.equals("A3") ) || ( item.equals("T") ) || ( item.equals("T1") ) || ( item.equals("T2") ) || ( item.equals("T3") ) ){
                System.out.println("****Primer caso****");
                //Concideramos que es un No term
                //Buscar indices
                System.out.println("Indices\nItem: " + item + " preAn:  " + preAn );
                this.buscarIndices(item, this.preAn);
                if(err) break;//Se checa que los indices se hayan encontrado
                //Asignamos prod
                this.Produccion();
                System.out.println("Produccion: " + prod);
                //Agregamos a la pila de manera inversa
                this.addPilaInv();
                this.item = pila.pop();//Reapuntamos al tope de la pila
                System.out.println( "Item " + this.item );
                System.out.println("------Fin primer caso------"); 

            //}else if( this.auxItem.get(0).tipo == preAn.tipo ){
            }else if( ( ( item.equals("select") ) && ( this.preAn.tipo.equals(TipoToken.SELECT) ) )
                   || ( ( item.equals("from") )   && ( this.preAn.tipo.equals(TipoToken.FROM) ) )
                   || ( ( item.equals("distinct")) && ( this.preAn.tipo.equals(TipoToken.DISTINCT) ) )
                   || ( ( item.equals("*") )      && ( this.preAn.tipo.equals(TipoToken.ASTERISCO) ) )
                   || ( ( item.equals(",") )      && ( this.preAn.tipo.equals(TipoToken.COMA) ) )
                   || ( ( item.equals("." ))      && ( this.preAn.tipo.equals(TipoToken.PUNTO) ) )
                   || ( ( item.equals("id") )     && ( this.preAn.tipo.equals(TipoToken.IDENTIFICADOR) ) )
                   || ( ( item.equals("$") )      && ( this.preAn.tipo.equals(TipoToken.EOF) ) ) ){
                

                System.out.println("*****Segundo caso******");
                //Si son iguales
                item = pila.pop(); //Sacamos de la pila
                i++;//Avanzamos uno en la lista de tokens
                this.preAn = this.tokens.get(i); //Tomamos el siguiente token
                System.out.println("Item: " + item + " preAn:  " + preAn );
                System.out.println("------Fin segundo caso------"); 

            }else if( item.equals("E") ){

                System.out.println("*****Terce caso****");
                //No se inserta nada en la pila (se saca el tope de la pila)
                item = pila.pop(); //Sacamos de la pila
                System.out.println("Item: " + item + " preAn:  " + preAn );
                System.out.println("------Fin tercer caso------"); 


            }else if( item.equals("#") ){

                System.out.println("*******Caso de error******");
                //La istaxis no es correcta
                this.err = true;
                System.out.println("La sintaxis es erroena.Token:" + this.preAn.lexema + ".Tipo: " + this.preAn.tipo + ".Posicion: " + this.preAn.posicion );
                System.out.println("Item: " + item + " preAn:  " + preAn );
                System.out.println("------Fin caso de error------");

            }else{

                System.out.println("*******Default*****");
                System.out.println("Item: " + item);
                System.out.println("Lexema: "+ this.preAn.lexema + " Tipo: " + this.preAn.tipo );
                if (  ( item.equals("select") ) && ( this.preAn.tipo.equals(TipoToken.SELECT) ) ){
                    System.out.println( "Son iguales" );
                    return false;
                }
                System.out.println( "No son iguales" );
                System.out.println("------Fin default------");
                return false;

            }
            
        }

        if( preAn.tipo == TipoToken.EOF && !err && this.pila.isEmpty() ){
            System.out.println("Consulta correcta");
            return  true;
        }else {
            System.out.println("Se encontraron errores");
            
        }
        return false;
    
    }

    public void buscarIndices( String noTerm, Token term  ){

        //No termes ( Q D P A A1 A2 A3 T T1 T2 T3 )
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
                //Mandar error
                err = true;
                System.out.println("Error. Indice (noTerm) no encontrado");
            break;
        
        }

        //Terminales ( select from distinc * , . id $ )
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
                //Mandar error
                err = true;
                System.out.println("Error. Indice (Terminal) no encontrado");
            break;
        
        }        

    }

    public void Produccion(){

        //Asignamos la producdión
        this.prod = this.ta.tabla [ this.noTerm ] [ this.term ];

    }

    public void addPilaInv(){

         System.out.println("+++++++++++Inicio de addPilaInv++++++++++++");
        //Añadimos a la pila de manera inversa
        char c; //Caracter para distinuir las palabras de la producción
        String aux = ""; //Para insertas las palabras en las listas
        int x = this.prod.length() - 1;//Le asignamos la longitud de lexema
       
        //System.out.println( " sadfasdgfasdfasdfasdfasdf" );
               
        while( x >= 0 ){//Miesntras que x  no haya llegado al inico de la prod

           
            c = this.prod.charAt(x);//Len asignamos el ultimo caracter del lexema

            if ( c == ' ' || c == this.prod.charAt(0) ) {
                
                //Se debe invertir y guardad

                if( x == 0 ) aux+=c;

                System.out.println("Antes de reverse: "+ aux);
                this.pila.push(this.reverse(aux));
                aux = "";
                System.out.println("Inicio de la pila: "+ pila.peek());

            }else{
                
                //sigue leyendo
                aux+=c;
                System.out.println("X = "+ x + " Aux = "+ aux);
            
            }

            x--;

        }


    }

    public String reverse( String cadena ){

        // Invertir la cadena usando bucle y concatenación
        String invertida = "";
        for ( int i = cadena.length() - 1; i >= 0; i-- ) {
            invertida += cadena.charAt(i);
        }

        return invertida;

    }
}
