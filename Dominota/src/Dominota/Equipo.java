package Dominota;

import com.db4o.ObjectSet;
import java.util.ArrayList;
import java.util.List;

public class Equipo {

    private String nombre;
    private int puntos;
    private List<Jugador> jugador;
    private List <Integer> manos;
    private List <Integer> turno_mano;

    public Equipo() {
        nombre = "";
        puntos = 0;
        manos = new ArrayList <Integer>();
        turno_mano = new ArrayList <Integer>();
        this.jugador = new ArrayList <Jugador>();
    }
    
     public void asignar_puntos(int puntos){
        this.puntos+=puntos;
        
    }
            

    public String getNombre() {
        return nombre;
    }
    
    public int GetPuntos() {
        return puntos;
    }
    
    public List<Integer> getManos(){
        return (List<Integer>) manos;
    }
    
    public List<Integer> GetTurno(){
        return (List<Integer>)turno_mano;
    } 
    
    public List<Jugador> getJugador(){
       
       return (List<Jugador>) jugador;
   }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public void SetPuntos(int puntos){
        this.puntos = puntos;
    }
    
    public void SetManos(int manos){
    this.manos.add(manos);
    }
    
    public void setTurno(int turno){
        this.turno_mano.add(turno);
    }
    
    public void setJugador(Jugador jugador){
        this.jugador.add(jugador);
    }
    
    
    
    public void listarEquipos(){
        System.out.println("Equipo: " + nombre);
        System.out.println("Jugadores: ");  
        for (Jugador ju : jugador) {
        System.out.println(ju.getNombre());
            System.out.println("Puntos " + this.puntos);
           
      
        }
    }

    public String toString() {
        return "Nombre: " + nombre;
    }
    
    
}
