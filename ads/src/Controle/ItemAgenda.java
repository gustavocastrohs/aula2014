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
public class ItemAgenda implements IItemAgenda{
    private double tempo;
    private IFilaServidor objetoASerExecutado;

    public ItemAgenda(double tempo, IFilaServidor objetoASerExecutado) {
        this.tempo = tempo;
        this.objetoASerExecutado = objetoASerExecutado;
    }

    @Override
    public double getTempo() {
        return tempo;
    }
    @Override
    public IFilaServidor getObjetoASerExecutado() {
        return objetoASerExecutado;
    }

    
}
