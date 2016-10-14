/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominota;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author JOSE
 */
public class Partida {
    private int puntos_maximo;
    private List<Jugador> jugador;
    private List<Equipo> equipo;
    
    public Partida(){
        puntos_maximo = 0;
        jugador = new ArrayList <Jugador>();
        equipo = new ArrayList <Equipo>();
    }
    
    public Partida(int puntos,List<Jugador> jugador,List<Equipo> equipo){
        puntos_maximo = puntos;
    }
    
    public int GetPuntos(){
        return puntos_maximo;
    }
    
    public void SetPuntos(int puntos_maximo) {
        this.puntos_maximo = puntos_maximo;
        
    }
    
    public void SetJugador(List<Jugador> jugador){
        this.jugador.addAll(jugador);
        
    }
    
    public List<Jugador> getJugador(){
       
       return (List<Jugador>) jugador;
   }
}
