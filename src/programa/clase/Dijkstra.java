//package programa.clase;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Neomadara
 */

public class Dijkstra {
    int nVertices;
    int inicio;
    int W[][];
    ArrayList <Integer> L;
    
    public Dijkstra(){
    nVertices = 0;
    inicio = 0;
    W = null;
    //L = null;
    L = null;
    //Camino = null;
    }    

    public int getInicio() {
        return inicio;
    }

    public int getnVertices() {
        return nVertices;
    }

    public int[][] getW() {
        return W;
    }

    public void setInicio(int inicio) {
        this.inicio = inicio;
    }

    public void setnVertices(int nVertices) {
        this.nVertices = nVertices;
    }

    public void setL(ArrayList<Integer> L) {
        this.L = L;
    }

    public ArrayList<Integer> getL() {
        return L;
    }
   
    public void llenarL(){
        L = new ArrayList<Integer>();
        for(int i=0; i<nVertices;i++){
        L.add(i,100);
        }
    }
    
    public void setW(Scanner s) {
        W = new int[nVertices][nVertices];
        for(int i = 0; i < nVertices; i++){
            for(int j = 0; j < nVertices; j++){
                W[i][j] = s.nextInt();
            }
        }
    }
 
   //buscar un L(V) menor que aun este en T;
   public int elegirV(ArrayList <Integer> T, ArrayList <Integer> L){
       int minimo = 99;
       int elegido = 0;
       int vL = 0;
       
       
       for(int i = 0; i<L.size(); i++){
            if(L.get(i)<minimo){
                vL=i; //elegir el vertice
                //preguntar si el minimo elegido de L AUN ESTA PRESENTE EN T
                for(int j = 0; j<T.size(); j++){
                    if(T.get(j)==vL){
                        elegido = T.get(j); //elijo el vertice 
                    }
                }
            }
        }
       return elegido; //retorno vertice
   }
   
   public void caminoMasCorto(){
       //System.out.println("inicio:"+inicio);
       L.set(inicio, 0);
       //los demas vertices ya estan en infinito.
       ArrayList<Integer> T = new ArrayList<Integer>();//CONJUNTO DE VERTICES CUYA DISTANCIA MAS CORTA AUN NO AH SIDO DETERMINADA   
       ArrayList<Integer> X = new ArrayList<Integer>();//adyacentes de un vertice
       
       //llenar el ArrayList T
       for(int x = 0; x<nVertices; x++ ){
           T.add(x);
       }
        //mientras T no este vacio.      
       while(!T.isEmpty()){
           int posicionV=0;
           posicionV = elegirV(T,L); 
           System.out.println(posicionV+":");//IMPRIMO LOS VERTICES QUE SELECCIONO
          
           for(int a = 0; a<T.size(); a++){
               if(posicionV==(int)T.get(a)){ 
                   //remover vertice del ArrayList
                   T.remove(a);//PASO T = T-{V}
                   break;
               }
           }
           //vertices adyacentes de un vertice
           int contador=0;
           for(int t = 0; t < nVertices; t++){
                if(W[posicionV][t]!=0){ //si es distinto de cero guardar T que seria el vertice adyacente de posicionV
                    X.add(contador, t);
                    contador++;
                }
            }
           int peso=0;
           for(int d = 0 ; d < X.size() ; d++){
               
               if(L.get(X.get(d)) < L.get(posicionV)+W[posicionV][X.get(d)] ){ 
                   peso=L.get(X.get(d));
                   L.set(X.get(d),L.get(X.get(d)));
                   System.out.println("-"+X.get(d)+"("+peso+")");
                   
               }
               else{
                   peso=L.get(posicionV)+W[posicionV][X.get(d)];
                   L.set(X.get(d), L.get(posicionV)+W[posicionV][X.get(d)]);
                   System.out.println("-"+X.get(d)+"("+peso+")");
                   
               }
           }
           X.clear();
       }
   }
   
   
   
    
}
