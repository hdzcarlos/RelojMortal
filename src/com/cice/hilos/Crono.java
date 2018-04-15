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
        horaFormateada = horas + ":" + minutos+ ":" + segundos;
        return horaFormateada;
    }

    public boolean isEsActivo() {
        return esActivo;
    }

    public void setEsActivo(boolean esActivo) {
        this.esActivo = esActivo;
    }
   

}
