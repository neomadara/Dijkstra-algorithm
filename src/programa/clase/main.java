//package programa.clase;

import java.util.Scanner;

/**
 *
 * @author Neomadara
 */
public class main {

    public static void main(String[] args) {
      Scanner s = new Scanner(System.in);
        Dijkstra d = new Dijkstra();
        //System.out.println("ingrese cantidad de vertices >> ");
        d.setnVertices(s.nextInt());
        //System.out.println("ingrese vertice inicial >> ");
        d.setInicio(s.nextInt());
        d.setW(s);
        d.llenarL();
        d.caminoMasCorto();
    }
    
}
