package Controle;


import java.util.ArrayList;
import java.util.LinkedList;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 09201801
 */
public abstract class  Item implements IItem{

    private String nome;
    
    private int tempo1;
    private int tempo2;
    private double probabilidade;
    
    
    private ArrayList<IItem> listaDeArestas = new ArrayList<>();
    
    private boolean  temPai = false;



    public Item(String nome, int tempo1, int tempo2, double probabilidade) {
        this.nome = nome;
        this.tempo1 = tempo1;
        this.tempo2 = tempo2;
        this.probabilidade = probabilidade;
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

    public String toString() {
        return nome;
    }
    
    public ArrayList<IItem> getListaDeArestas() {
        return listaDeArestas;
    }

    public void addAresta(Item aresta){
     listaDeArestas.add(aresta);
    }

    public boolean isTemPai() {
        return temPai;
    }

    public void setTemPai(boolean temPai) {
        this.temPai = temPai;
    }
    public abstract int tipo();
    
}
