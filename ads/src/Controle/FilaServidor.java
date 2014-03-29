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
public class FilaServidor implements IFilaServidor{
    private IFila fila;
    private IServidor servidor;
    private double probabilidade1;
    private double probabilidade2;

    public FilaServidor(IFila fila, IServidor servidor) {
        this.fila = fila;
        this.servidor = servidor;
    }

    @Override
    public IFila getFila() {
        return fila;
    }

    

    @Override
    public IServidor getServidor() {
        return servidor;
    }

    
    @Override
    public double getProbabilidade1() {
        return probabilidade1;
    }

    @Override
    public void setProbabilidade1(double probabilidade) {
        this.probabilidade1 = probabilidade;
    }
    @Override
    public double getProbabilidade2() {
        return probabilidade2;
    }

    @Override
    public void setProbabilidade2(double probabilidade) {
        this.probabilidade2 = probabilidade;
    }
    
    
}
