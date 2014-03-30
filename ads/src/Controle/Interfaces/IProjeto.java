/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controle.Interfaces;

/**
 *
 * @author Gustavo
 */
public interface IProjeto {
    
    public void adicionaServidor(String nomeServidor, String nomeAresta, int capacidade, int quantidadeDeServidores);

    public void executa(double quantidadeDeExecucoes);

    public double calculaRandomicoProblema(double a, double b);

    public void processaFilaChegada(IFilaServidor evento, double tempo);

    public void processaFilaPassagem(IFilaServidor evento, double tempo);

    public void processaFilaSaida(IFilaServidor evento, double tempo);

    public void adicionaNaAgenda(IItemAgenda novoItem);
    public void adicionaServidor(IServidor servidor) ;
}
