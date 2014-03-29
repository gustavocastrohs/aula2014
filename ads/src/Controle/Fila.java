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
public class  Fila implements IFila{

    private String nome;   
    private double tempo1;
    private double tempo2;


    private double tipoDeFila;
    
    
    private ArrayList<IFilaServidor> eventosDeEntrada = new ArrayList<>();
    private ArrayList<IFilaServidor> eventosDeSaida = new ArrayList<>();

    public Fila(String nome, double tempo1, double tempo2,double tipoDeFila) {
        this.nome = nome;
        this.tempo1 = tempo1;
        this.tempo2 = tempo2;

        this.tipoDeFila = tipoDeFila;
    }
    



    @Override
    public double getTempo1() {
        return tempo1;
    }


    @Override
    public double getTempo2() {
        return tempo2;
    }


    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return nome;
    }




    @Override
    public double getTipoDeFila() {
        return tipoDeFila;
    }

    @Override
    public void setTipoDeFila(double tipoDeFila) {
        this.tipoDeFila = tipoDeFila;
    }

    @Override
    public ArrayList<IFilaServidor> getEventosDeEntrada() {
        return eventosDeEntrada;
    }

    @Override
    public void setEventosDeEntrada(ArrayList<IFilaServidor> eventosDeEntrada) {
        this.eventosDeEntrada = eventosDeEntrada;
    }

    @Override
    public ArrayList<IFilaServidor> getEventosDeSaida() {
        return eventosDeSaida;
    }

    @Override
    public void setEventosDeSaida(ArrayList<IFilaServidor> eventosDeSaida) {
        this.eventosDeSaida = eventosDeSaida;
    }
    

    
    
}
