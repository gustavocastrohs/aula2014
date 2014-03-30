/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controle;

import Controle.Interfaces.IObjetooContavel;
import Controle.Interfaces.IServidor;
import Controle.Interfaces.IContabilizador;
import java.util.ArrayList;

/**
 *
 * @author Gustavo
 */
public class Contabilizador implements IContabilizador{
    private static Contabilizador instancia;
    private ArrayList<IObjetooContavel> lista;
    
    @Override
    public void contabilia(IServidor servAntes, IServidor servDepois,double tempo) {
        IServidor servidorAnalisado;

        for (IObjetooContavel o : lista) {

            if (o.getServidor().getNome().equalsIgnoreCase(servAntes.getNome())) {
                if (servAntes.getCapacidadeUsada() < servDepois.getCapacidadeUsada()) {
                    o.getLista().set(servDepois.getCapacidadeUsada(), tempo+o.getLista().get(servDepois.getCapacidadeUsada()));
                }
            }

        }
    }

    public ArrayList<IObjetooContavel> getLista() {
        return lista;
    }

    public void setLista(ArrayList<IObjetooContavel> lista) {
        this.lista = lista;
    }

public void cadastraServidores (IServidor server){
    IObjetooContavel oc = new ObjetooContavel(server);
lista.add(oc);
}

     public static Contabilizador getInstance() {

        if (instancia == null) {
            instancia = new Contabilizador();
        }
        return instancia;

    }
     
     private Contabilizador(){
     
     }

}
