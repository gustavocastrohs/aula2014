/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

/**
 *
 * @author Gustavo
 */
public class Aresta {

    private ItemServidor destino;
    private int tempo1;
    private int tempo2;
    private double probabilidade;
    private String nome;

    public Aresta(ItemServidor destino,String nome, int tempo1, int tempo2, double probabilidade ) {
        this.destino = destino;
        this.tempo1 = tempo1;
        this.tempo2 = tempo2;
        this.probabilidade = probabilidade;
        this.nome = nome;
    }





    public ItemServidor getDestino() {
        return destino;
    }

    public void setDestino(ItemServidor destino) {
        this.destino = destino;
    }

    public int getTempo1() {
        return tempo1;
    }

    public void setTempo1(int tempo1) {
        this.tempo1 = tempo1;
    }

    public int getTempo2() {
        return tempo2;
    }

    public void setTempo2(int tempo2) {
        this.tempo2 = tempo2;
    }

    public double getProbabilidade() {
        return probabilidade;
    }

    public void setProbabilidade(double probabilidade) {
        this.probabilidade = probabilidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    
    
}
