/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import java.util.ArrayList;

/**
 *
 * @author Gustavo
 */

public class Projeto {
ArrayList<ItemServidor> lista_Servidores = new ArrayList<>   ();
private int perda;
        //static int valortotal = 0;

        public void adicionaItensDeProjeto(String nomeServidor,String nomeAresta,  int capacidade,int quantidadeDeServidores)
        {
            
            lista_Servidores.add(new ItemServidor(nomeServidor, capacidade,quantidadeDeServidores));
            perda = 0;
        }

        public void addAresta(String origem, String destino,String nomeAresta, int tempo1, int tempo2, double probabilidade)
        {
            for (ItemServidor item: lista_Servidores)
            {
                if (item.getNome().equalsIgnoreCase(origem))
                {
                    for (ItemServidor itemDestino: lista_Servidores)
                    {
                        if (itemDestino.getNome().equalsIgnoreCase(destino))
                        {
                            itemDestino.setTemPai(true);
                            Aresta aresta = new Aresta(itemDestino,nomeAresta,tempo1,tempo2,probabilidade);
                            item.addAresta(aresta);
                        }
                    }
                }
            }
        }

        public  ArrayList<ItemServidor> encontrarORaiz()
        {
            ArrayList<ItemServidor> listaaux = new ArrayList<>();
            for (ItemServidor i : lista_Servidores){
            
                if (!i.isTemPai()){
                     
                   System.out.println("O raiz é : "+i.getNome());
                   listaaux.add(i);
                }
            }
            
            return listaaux;
        
        }
        

//        public double calcula()
//        {
//            ArrayList<ItemServidor> encontrarORaiz = encontrarORaiz();
//            double calculo = 0;
//            for (ItemServidor s : encontrarORaiz){
//                calculo += calcula(s);
//        }
//         return calculo;   
//        }

//     public double calcula(ItemServidor raiz)
//        {
//            double valor = raiz.getValor();
//            
//            for (Aresta arestas: raiz.getListaDeArestas())
//            {
//              
//             
//            //   valor = valor + (arestas.getValor() * calcula(arestas.getDestino()));
//                
//               arestas.getDestino().setValorCalculado(valor); 
//               
//            }
//            raiz.setValorCalculado(valor);
//            return valor;
//        }
        
     public void executa(double quantidadeDeExecucoes)
        {
            GeraRandomico g = GeraRandomico.getInstance();
        for (int i = 1; i <= quantidadeDeExecucoes; i++) {
            ArrayList<ItemServidor> encontrarORaiz = encontrarORaiz();
            for (ItemServidor raiz : encontrarORaiz) {
                if (raiz.getCapacidadeUsada()<raiz.getCapacidade()){
                    raiz.aumentaServidoresEm1();
                    if ( raiz.getQuantidadeDeServidores()<raiz.getServidoresUsados()){
                        for (Aresta a : raiz.getListaDeArestas()){
                        if ( g.proximoRandomico()>a.getProbabilidade())
                        {
                        
                        }
                        }
                    }
                }
            }
        }

    }

    public void setLista_itens(ArrayList<ItemServidor> lista_Servidores) {
        this.lista_Servidores = lista_Servidores;
    }
    
    
    
    
  
      
        public void imprimeGrafico()
        {
           
            String resultado = "";
            System.out.println( "digraph G{");
            ArrayList<ItemServidor> listAux = new ArrayList<>(lista_Servidores);
            
            for (ItemServidor item: listAux)
            {
          //          resultado+=item.getNome()+"[label=\""+item.getNome()+"$ "+item.getValor()+"\"];";
          //          for (Aresta  aresta: item.getListaDeArestas())
            //        {
            //            resultado+=item.getNome()+"->"+aresta.getDestino().getNome()+"[label="+aresta.getValor()+"];";
            //        }
                   // resultado +=";";
                }
            
            System.out.println(resultado);
            System.out.println( "}");
            }
        
    
    

    
        public void contabilizaChegada(){
            
    
    
    }
    
        
        
           public double calculaRandomicoProblema(double a,double b){
   GeraRandomico g = GeraRandomico.getInstance();
   //U(A,B) = (B – A) * U(0,1) + A
    
   return (b-a)*g.proximoRandomico()+a;
   }

    
}
    
    
    
    

    
    
    
        






