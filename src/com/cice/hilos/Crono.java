/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cice.hilos;

import com.cice.views.Principal;

public class Crono extends Thread {

    boolean esActivo = true;
    private int segundos = 0;
    private int minutos = 0;
    private int horas = 0;
    private Principal principal;
    public Crono(){
        
    }
    public Crono(Principal principal){
        this.principal = principal;
    }
    @Override
    public void run() {

        try {
            while(true){
            while (esActivo) {
                  Thread.sleep(1000L);
                ++segundos;
                if (segundos == 60) {
                    ++minutos;
                    segundos = 0;
                }
                if (minutos == 60) {
                    ++horas;
                    minutos = 0;
                }
                if (horas == 24) {
                    horas = 0;
                }
                principal.setTime(horaFormateada());
            }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
     public String horaFormateada(){
        String horaFormateada = null;
        String h = "";
        String m = "";
        String s = "";
        if(horas <= 9){
            h="0"+horas;
        }else{
            h=String.valueOf(horas);
        }
        if(minutos <=9){
            m="0"+ minutos;
            
        }else{
            m =String.valueOf(minutos);
        }
        if(segundos <= 9){
            s="0" + segundos;
        }else{
            s = String.valueOf(segundos);
        }
        horaFormateada = h + ":" + m + ":" + s;
        return horaFormateada;
    }

    public boolean isEsActivo() {
        return esActivo;
    }

    public void setEsActivo(boolean esActivo) {
        this.esActivo = esActivo;
    }
    public void reset(){
        horas = 0;
        minutos = 0;
        segundos = 0;
        principal.setTime(horaFormateada());
    }
   

}
