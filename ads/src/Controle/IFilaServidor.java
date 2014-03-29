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
public interface IFilaServidor {

    public IFila getFila();

    public IServidor getServidor();

    public void setProbabilidade1(double probabilidade);

    public double getProbabilidade1();

    public void setProbabilidade2(double probabilidade);

    public double getProbabilidade2();
}
