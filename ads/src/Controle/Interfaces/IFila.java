/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle.Interfaces;

import java.util.ArrayList;

/**
 *
 * @author Gustavo
 */
public interface IFila {

    public String getNome();

    public double getTempo1();

    public double getTempo2();



    /**
     * se o tipo = 0 quer dizer que é um inicio
     * se o tipo = 1 quer dizer que é uma passagem
     *  se o tipo = 2 quer dizer que é uma saida
     * @return
     */
    
    public double getTipoDeFila();

    /**
     * se o tipo = 0 quer dizer que é um inicio
     * se o tipo = 1 quer dizer que é uma passagem
     * se o tipo = 2 quer dizer que é uma saida
     * @param tipo
     */
    public void setTipoDeFila(double tipo);
    
    public ArrayList<IFilaServidor> getEventosDeEntrada();

    public ArrayList<IFilaServidor> getEventosDeSaida();

    public void setEventosDeEntrada(ArrayList<IFilaServidor> eventosDeEntrada);
    
    public void setEventosDeSaida(ArrayList<IFilaServidor> eventosDeSaida);
    
    public void setEventosDePassagem(ArrayList<IFilaServidor> eventosDeSaida);
    
    public ArrayList<IFilaServidor> getEventosDePassagem();

    public void addEnventoDeEntrada(IFilaServidor fs);
    public void addEnventoDePassagem(IFilaServidor fs);
    public void addEnventoDeSaida(IFilaServidor fs);
}
