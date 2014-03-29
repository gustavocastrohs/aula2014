/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import java.util.ArrayList;

/**
 *
 * @author Gustavo
 */
public class Servidor implements IServidor {

    private double capacidade;
    private double quantidadeDeServidores;
    private double capacidadeUsada;
    private double servidoresUsados;
    private String nome;
    

    public Servidor(String nome, double capacidade, double quantidadeDeServidores) {
        this.nome = nome;
        this.capacidade = capacidade;
        this.quantidadeDeServidores = quantidadeDeServidores;
        this.capacidadeUsada = 0;
        this.servidoresUsados = 0;
    }

    @Override
    public double getCapacidade() {
        return capacidade;
    }

    @Override
    public double getQuantidadeDeServidores() {
        return quantidadeDeServidores;
    }

    @Override
    public double getCapacidadeUsada() {
        return capacidadeUsada;
    }

    @Override
    public void aumentaACapacidadeEm1() {
        this.capacidadeUsada += 1;
    }

    @Override
    public void reduzACapacidadeEm1() {
        this.capacidadeUsada -= 1;
    }




    @Override
    public String getNome() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
