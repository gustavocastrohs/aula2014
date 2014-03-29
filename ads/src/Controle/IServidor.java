/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

/**
 *
 * @author Gustavo
 */
public interface IServidor {

    public void aumentaServidoresUsadosEm1();

    public void reduzServidoresUsadosEm1();

    public int getServidoresUsados();

    public void reduzACapacidadeEm1();

    public void aumentaACapacidadeEm1();

    public int getCapacidadeUsada();

    public int getQuantidadeDeServidores();
 
    public int getCapacidade();
}
