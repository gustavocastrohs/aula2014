/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controle;

import Interfaces.IGeraRandomico;

/**
 *
 * @author Gustavo
 */
public class GeraRandomico implements IGeraRandomico{
   
    private static GeraRandomico instancia;
    
    private double a ;
    private double c;
    private double m;
    private double s;
    
    public static GeraRandomico getInstance()  {
        try {

            if (instancia == null) {
                instancia = new GeraRandomico();
            }
            return instancia;


    }catch(ExceptionInInitializerError e){
     
        
    }
        return null;
    }
    private GeraRandomico(){
        this.c = 4579;
        this.a = 16657807; 
        this.m  = 2147483647;
        this.s = 1567177967;
        
    
    }

    public GeraRandomico(double a, double c, double m, double s) {
        this.a = a;
        this.c = c;
        this.m = m;
        this.s = s;
    }

    
    @Override
    public double proximoRandomico() {
     
        s = (a*s + c ) % m;
        
        return s/m;
    }


    public double getA() {
        return a;
    }

    public double getC() {
        return c;
    }

    public double getM() {
        return m;
    }

    public double getSemente() {
        return s;
    }

    
}
