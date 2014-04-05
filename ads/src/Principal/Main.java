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

  
    public static  Projeto p;
    
    /**
     * @param args the command line arguments
     */
  
    public static void main(String[] args) {
    p = Projeto.getInstance();
    IServidor s = new Servidor("SR1",1,3);
    IFila f = new Fila("CH1", 1, 2, 0);
    IFila f2 = new Fila("SAI1", 1, 4, 2);
    

    
    p.adicionaNaAgenda(new ItemAgenda(3, adicionaFilaServidor(f,s,0,1)));

    p.adicionaServidor(s);
    
    p.executa(100);
      
        
    }
    
    public static  IFilaServidor adicionaFilaServidor(IFila fila,IServidor servidor,double p1, double p2){
    IFilaServidor fs = new FilaServidor(fila, servidor);    
    fs.setProbabilidade1(p1);
    fs.setProbabilidade2(p2);
    if (fila.getTipoDeFila() ==0){
        fila.addEnventoDeEntrada(fs);
    }
    if (fila.getTipoDeFila() ==1){
        fila.addEnventoDeEntrada(fs);
    }
    return fs;
    }

   
}

