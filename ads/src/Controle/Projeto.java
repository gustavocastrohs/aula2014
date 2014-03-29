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

    ArrayList<IItem> lista_itens = new ArrayList<>();
    ArrayList<IServidor> lista_servidores = new ArrayList<>();
    ArrayList<IItem> agenda = new ArrayList<>();
    private int perda;
    //static int valortotal = 0;

    public void adicionaServidor(String nomeServidor, String nomeAresta, int capacidade, int quantidadeDeServidores) {

        lista_servidores.add(new Servidor(nomeServidor, capacidade, quantidadeDeServidores));
        perda = 0;
    }


    public void executa(double quantidadeDeExecucoes) {
        GeraRandomico g = GeraRandomico.getInstance();
        for (int i = 1; i <= quantidadeDeExecucoes; i++) {

        }

    }

      

    public void adicionaNaAgenda(Item i) {

    }

    public double calculaRandomicoProblema(double a, double b) {
        GeraRandomico g = GeraRandomico.getInstance();
   //U(A,B) = (B – A) * U(0,1) + A

        return (b - a) * g.proximoRandomico() + a;
    }

}
