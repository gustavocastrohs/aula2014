package Controle;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 09201801
 */
public class OperacoesDoPrograma implements Interfaces.IOperacoesDoPrograma{
  
 

    /**
     *
     * @param a
     * @param b
     * @return
     */
    @Override
   public double calculaRandomicoProblema(double a,double b){
   GeraRandomico g = GeraRandomico.getInstance();
   //U(A,B) = (B – A) * U(0,1) + A
    
   return (b-a)*g.proximoRandomico()+a;
   }

}
