package Dominota;

import java.util.ArrayList;
import java.util.List;

public class Jugador {

    private String nombre;
    private int puntos;
    private List <Integer> manos;
    private List <Integer> turno_mano;
    
   
    
    
    
    public Jugador(String nombre) {
        this.nombre = nombre;
        puntos = 0;
        manos = new ArrayList <Integer>();
        turno_mano = new ArrayList <Integer>();
    }
    
   
    
    public void asignar_puntos(int puntos){
        this.puntos+=puntos;
        
    }
            
            
    public void cuenta(){
        int aux = 0;
        for (int ju : manos) {
            aux+=ju;
        }
    }

    public String getNombre() {
        return nombre;
    }
    
    public int GetPuntos(){
        return puntos;
    }
    
    public List<Integer> GetMano(){
        return (List<Integer>) manos;
    }
    
    public List<Integer> GetTurno(){
        return (List<Integer>)turno_mano;
    }
            
            
    public void SetPuntos(int puntos){
        this.puntos = puntos;
    
    }
    public void SetJugador(String nombre) {
        this.nombre = nombre;
    }
    
    public void setManos(int manos){
        this.manos.add(manos);
    }
    
    public void setTurno(int turno){
        this.turno_mano.add(turno);
    }
    
}
