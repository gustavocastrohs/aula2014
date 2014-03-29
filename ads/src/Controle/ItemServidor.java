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
public class ItemServidor {
   private int capacidade;
   private int quantidadeDeServidores;
   private int capacidadeUsada;
   private int servidoresUsados;
   
    private String nome;
    
    
    private ArrayList<Aresta> listaDeArestas = new ArrayList<>();
    
    private boolean  temPai = false;

    public ItemServidor(String nome, int capacidade,int quantidadeDeServidores) {
        this.nome = nome;
        this.capacidade = capacidade;
        this.quantidadeDeServidores = quantidadeDeServidores;
        this.capacidadeUsada=0;
        this.servidoresUsados=0;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    public String toString() {
        return nome;
    }
    
    public ArrayList<Aresta> getListaDeArestas() {
        return listaDeArestas;
    }

    public void setListaDeArestas(ArrayList<Aresta> listaDeArestas) {
        this.listaDeArestas = listaDeArestas;
    }
    public void addAresta(Aresta aresta){
    listaDeArestas.add(aresta);
    }

    public boolean isTemPai() {
        return temPai;
    }

    public void setTemPai(boolean temPai) {
        this.temPai = temPai;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public int getQuantidadeDeServidores() {
        return quantidadeDeServidores;
    }

    public void setQuantidadeDeServidores(int quantidadeDeServidores) {
        this.quantidadeDeServidores = quantidadeDeServidores;
    }

    public int getCapacidadeUsada() {
        return capacidadeUsada;
    }

    public void aumentaACapacidadeEm1() {
        this.capacidadeUsada += 1;
    }
    public void reduzACapacidadeEm1() {
        this.capacidadeUsada -= 1;
    }

    public int getServidoresUsados() {
        return servidoresUsados;
    }
    
    public void aumentaServidoresEm1() {
        this.servidoresUsados += 1;
    }
    public void reduzServidoresEm1() {
        this.servidoresUsados -= 1;
    }
    
}
