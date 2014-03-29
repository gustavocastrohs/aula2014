/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controle;

import java.util.LinkedList;

/**
 *
 * @author Gustavo
 */
public class Agendador {
    private LinkedList agenda;

    public Agendador(LinkedList agenda) {
        this.agenda = agenda;
    }

    public Agendador() {
    }

    public LinkedList getAgenda() {
        return agenda;
    }
    
    
}
