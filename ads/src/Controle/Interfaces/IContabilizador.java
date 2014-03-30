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
public interface IContabilizador {
   public void contabilia(IServidor a, IServidor b,double tempo);
   public void cadastraServidores (IServidor server);
}
