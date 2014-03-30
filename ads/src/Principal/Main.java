package Principal;





import Controle.Interfaces.*;
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

    public static  IProjeto p;
    
    public static void main(String[] args) {
    p = new Projeto();
    IServidor s = new Servidor("1",1,3);
    IFila f = new Fila("CH1", 1, 2, 0);
    IFilaServidor fs = new FilaServidor(f, s);
    if (f.getTipoDeFila() ==0){
        f.addEnventoDeEntrada(fs);
    }
    p.adicionaNaAgenda(new ItemAgenda(3, fs));
    p.adicionaServidor(s);
    
       p.executa(13);
    

       
       
        
    }

    private static void addAresta(String orgiem, String destino,String nomeAresta, int tempo1, int tempo2, double probabilidade ){
    //    p.addAresta(orgiem, destino,nomeAresta, tempo1, tempo2, probabilidade);
     
      
    }
    
   
}
