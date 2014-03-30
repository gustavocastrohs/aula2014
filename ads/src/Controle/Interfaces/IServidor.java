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
public interface IServidor {


/**
     * retorna a quantidade de servidores usados
     *
     * @return
     */
    public void reduzACapacidadeEm1();

    public void aumentaACapacidadeEm1();

    public int getCapacidadeUsada();

    public int getQuantidadeDeServidores();

    public int getCapacidade();

    public String getNome();
      
}
