package Principal;





import Controle.*;
import java.util.ArrayList;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Gustavo
 */
public class Main {

    /**
     * @param args the command line arguments
     */

    public static  Projeto p;
    public static void main(String[] args) {
     
        ArrayList<IFila> lista = new ArrayList<>();

//        lista.add(new Fila("inicio", 0,0));
//        lista.add(new Fila("fim", 0,0));
//        lista.add(new Fila("S1", 3,1));
//

    
        p = new Projeto();
   //     p.setLista_itens(lista);
       
//        addAresta("inicio", "S1", "CH1", 3, 7, 1);
//        addAresta("S1", "fim", "SA1", 2, 3, 1);

       // System.out.println( p.calcula());
       p.executa(13);
    
        
        //ArrayList<ItemDeProjeto> encontrarORaiz = p.encontrarORaiz();
   //     g.excuta(encontrarORaiz.get(0));
        
    }

    private static void addAresta(String orgiem, String destino,String nomeAresta, int tempo1, int tempo2, double probabilidade ){
    //    p.addAresta(orgiem, destino,nomeAresta, tempo1, tempo2, probabilidade);
     
      
    }
    
   
}
