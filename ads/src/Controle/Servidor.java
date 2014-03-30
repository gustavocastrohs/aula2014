/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Controle.Interfaces.IServidor;
import java.util.ArrayList;

/**
 *
 * @author Gustavo
 */
public class Servidor implements IServidor {

    private int capacidade;
    private int quantidadeDeServidores;
    private int capacidadeUsada;
    private int servidoresUsados;
    private String nome;
    

    public Servidor(String nome, int quantidadeDeServidores, int capacidade) {
        this.nome = nome;
        this.capacidade = capacidade;
        this.quantidadeDeServidores = quantidadeDeServidores;
        this.capacidadeUsada = 0;
        this.servidoresUsados = 0;
    }

    @Override
    public int getCapacidade() {
        return capacidade;
    }

    @Override
    public int getQuantidadeDeServidores() {
        return quantidadeDeServidores;
    }

    @Override
    public int getCapacidadeUsada() {
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
        return  nome;
    }
}
