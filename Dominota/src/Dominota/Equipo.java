package Dominota;

import com.db4o.ObjectSet;
import java.util.ArrayList;
import java.util.List;

public class Equipo {

    private String nombre;
    private int puntos;
    private List <String> manos;
    private List<Jugador> jugador;

    public Equipo() {
        nombre = "";
        puntos = 0;
        manos = new ArrayList <String>();
        this.jugador = new ArrayList <Jugador>();
    }

    public String getNombre() {
        return nombre;
    }
    
    public int GetPuntos() {
        return puntos;
    }
    
    public List<String> getManos(){
        return (List<String>) manos;
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
    
    public void SetManos(String manos){
    this.manos.add(manos);
    }
    
    public void setJugador(Jugador jugador){
        this.jugador.add(jugador);
    
    }
    
    public void listarEquipos(){
        System.out.println("Equipo: " + nombre);
        System.out.println("Jugadores: ");  
        for (Jugador ju : jugador) {
        System.out.println(ju.getNombre());
           
      
        }
    }

    public String toString() {
        return "Nombre: " + nombre;
    }
    
    
}
