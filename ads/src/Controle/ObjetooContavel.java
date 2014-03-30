/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Controle.Interfaces.IObjetooContavel;
import Controle.Interfaces.IServidor;
import java.util.ArrayList;

/**
 *
 * @author Gustavo
 */
public class ObjetooContavel implements IObjetooContavel{

    private IServidor servidor;
    private ArrayList<Double> lista;

    public ObjetooContavel(IServidor servidor) {
        this.servidor = servidor;
        lista = new ArrayList<>();
        for (int i = 0; i < servidor.getCapacidade(); i++) {
            lista.add(0.0);
        }
    }

    public IServidor getServidor() {
        return servidor;
    }

    public ArrayList<Double> getLista() {
        return lista;
    }

    public void setLista(ArrayList<Double> lista) {
        this.lista = lista;
    }
    
    
    
}
