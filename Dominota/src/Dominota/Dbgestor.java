/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominota;


import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.query.Predicate;
import com.db4o.query.Query;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.List;

/**
 *
 * @author JOSE
 */
public class Dbgestor {
    private ObjectContainer bdatos;
    final static String DB4ONOMBRE = "C:\\Users\\Principal\\Desktop\\Dominota\\basededatos.db4o";
    static InputStreamReader isr = new InputStreamReader(System.in);
    static BufferedReader leer = new BufferedReader(isr);
    
    public Dbgestor(){
      bdatos = null ;
      iniciarBD();
    }
    
    public void iniciarBD() {
        File archivo = new File(DB4ONOMBRE);
        if (!archivo.exists()) {
             bdatos  = Db4oEmbedded.openFile(Db4oEmbedded
                    .newConfiguration(), DB4ONOMBRE);
        } else {
             bdatos  = Db4oEmbedded.openFile(DB4ONOMBRE);
        }

         
    }
    
    public void DbClose(){
        bdatos.close();
    }
    
    public void AgregarPartida (Partida p){
        bdatos.store(p);
    }
    
    public void AgregarJugador(Jugador j){
        bdatos.store(j);
    
    
    }
    
    public void agregarEquipo(Equipo eq){
        bdatos.store(eq);
    }
    
    public ObjectContainer GetBddatos (){
    return bdatos;
    }
    
    
        public List<Equipo> JugadorPorEquipo(String name){
        
        final String nombre = name; 
        List <Equipo> equipo = bdatos.query(new Predicate<Equipo>() {
        @Override
            
       public boolean match(Equipo eq) {
                
            for(Jugador jugador : eq.getJugador()){
                if (jugador.getNombre().equals(nombre))
                    return jugador.getNombre().equals(nombre);
                    
                
            }
           return eq.GetPuntos()==-1;
       }
        });
            return equipo;
                
    }
                
        
    public List<Partida> PartidaJugador(String name){
        
        final String nombre = name; 
        List <Partida> partida = bdatos.query(new Predicate<Partida>() {
        @Override
            
       public boolean match(Partida pa) {
                
            for(Jugador ju : pa.getJugador()){
                if(ju.GetPuntos()>=pa.GetPuntos() && ju.getNombre().equals(nombre))
                    return ju.GetPuntos()>=pa.GetPuntos() && ju.getNombre().equals(nombre);
                        
                }
                return pa.GetPuntos()==0;
            }
           
         });
            return partida;
    }
    
     public List<Partida> PartidaJugadorPerdidas(String name){
        
        final String nombre = name; 
        List <Partida> partida = bdatos.query(new Predicate<Partida>() {
        @Override
            
       public boolean match(Partida pa) {
                
            for(Jugador ju : pa.getJugador()){
                if(ju.GetPuntos()<pa.GetPuntos() && ju.getNombre().equals(nombre))
                    return ju.GetPuntos()<pa.GetPuntos() && ju.getNombre().equals(nombre);
                        
                }
                return pa.GetPuntos()==0;
            }
           
         });
            return partida;
    }
    
    
      public List<Partida> PartidaJugadorGanadas(String name,String fecha){
        
            final String nombre = name; 
            final String date = fecha;
            List <Partida> partida = bdatos.query(new Predicate<Partida>() {
            @Override
            
            public boolean match(Partida pa) {
                
                for(Jugador ju : pa.getJugador()){
                     if( ju.GetPuntos()>=pa.GetPuntos() && ju.getNombre().equals(nombre)&&  pa.GetFecha().equals(date)){
                         System.out.println("hola"); 
                        return ju.GetPuntos()>=pa.GetPuntos() && ju.getNombre().equals(nombre) && pa.GetFecha().equals(date);
                     }
                }
                return pa.GetPuntos()==0;
            }
           
         });
            return partida;
        }
        
        
          public List<Partida> PartidaJugadorPerdidas(String name,String fecha){
        
            final String nombre = name; 
            final String date = fecha;
            List <Partida> partida = bdatos.query(new Predicate<Partida>() {
            @Override
            
            public boolean match(Partida pa) {
                
                for(Jugador eq : pa.getJugador()){
                     if( eq.GetPuntos()< pa.GetPuntos() && eq.getNombre().equals(nombre) &&  pa.GetFecha().equals(date)){
                        return eq.GetPuntos()<pa.GetPuntos() && eq.getNombre().equals(nombre) 
                        && pa.GetFecha().equals(date);
                        }
                }
                return pa.GetPuntos()==0;
            }
           
         });
            return partida;
        }  
        
        public List<Partida> JugadorZapato (String name,String fecha){
        
            final String nombre = name; 
            final String date = fecha;
            List <Partida> partida = bdatos.query(new Predicate<Partida>() {
            @Override
            
            public boolean match(Partida pa) {
                
                for(Jugador eq : pa.getJugador()){
                     if( eq.GetPuntos()== 0 && eq.getNombre().equals(nombre) &&  pa.GetFecha().equals(date)){
                        return eq.GetPuntos()== 0 && eq.getNombre().equals(nombre) 
                        && pa.GetFecha().equals(date);
                        }
                }
                return pa.GetPuntos()==0;
            }
           
         });
            return partida;
        }  
          
          
    
    
    
        public List<Partida> PartidaEquipo(String name){
        
            final String nombre = name; 
            List <Partida> partida = bdatos.query(new Predicate<Partida>() {
            @Override
            
                public boolean match(Partida pa) {
                
                    for(Equipo eq : pa.getEquipo()){
                        if( eq.GetPuntos()>=pa.GetPuntos() && eq.getNombre().equals(nombre))
                            return eq.GetPuntos()>=pa.GetPuntos() && eq.getNombre().equals(nombre);
                        
                        
                    }
                    System.out.println("Nada");
                    return pa.GetPuntos()==0;
            }
           
         });
            return partida;
        }
        
        public List<Partida> PartidaEquipoPerdidas(String name){
        
            final String nombre = name; 
            List <Partida> partida = bdatos.query(new Predicate<Partida>() {
            @Override
            
                public boolean match(Partida pa) {
                
                    for(Equipo eq : pa.getEquipo()){
                        if( eq.GetPuntos()<pa.GetPuntos() && eq.getNombre().equals(nombre))
                            return eq.GetPuntos()<pa.GetPuntos() && eq.getNombre().equals(nombre);
                        
                        
                    }
                    System.out.println("Nada");
                    return pa.GetPuntos()==0;
            }
           
         });
            return partida;
        }
        
        public List<Partida> PartidaEquipoGanadas(String name,String fecha){
        
            final String nombre = name; 
            final String date = fecha;
            List <Partida> partida = bdatos.query(new Predicate<Partida>() {
            @Override
            
            public boolean match(Partida pa) {
                
                for(Equipo eq : pa.getEquipo()){
                     if( eq.GetPuntos()>=pa.GetPuntos() && eq.getNombre().equals(nombre)&&  pa.GetFecha().equals(date)){
                        return eq.GetPuntos()>=pa.GetPuntos() && eq.getNombre().equals(nombre) && pa.GetFecha().equals(date);
                     }
                }
                return pa.GetPuntos()==0;
            }
           
         });
            return partida;
        }
        
        
          public List<Partida> PartidaEquipoPerdidas(String name,String fecha){
        
            final String nombre = name; 
            final String date = fecha;
            List <Partida> partida = bdatos.query(new Predicate<Partida>() {
            @Override
            
            public boolean match(Partida pa) {
                
                for(Equipo eq : pa.getEquipo()){
                     if( eq.GetPuntos()< pa.GetPuntos() && eq.getNombre().equals(nombre) &&  pa.GetFecha().equals(date)){
                        return eq.GetPuntos()<pa.GetPuntos() && eq.getNombre().equals(nombre)
                        && pa.GetFecha().equals(date);
                        }
                }
                return pa.GetPuntos()==0;
            }
           
         });
            return partida;
        }

           
        public List<Partida> EquipoZapato(String name,String fecha){
        
            final String nombre = name; 
            final String date = fecha;
            List <Partida> partida = bdatos.query(new Predicate<Partida>() {
            @Override
            
            public boolean match(Partida pa) {
                
                for(Equipo eq : pa.getEquipo()){
                     if( eq.GetPuntos()==0 && eq.getNombre().equals(nombre) &&  pa.GetFecha().equals(date)){
                        return eq.GetPuntos()==0 && eq.getNombre().equals(nombre)
                        && pa.GetFecha().equals(date);
                        }
                }
                return pa.GetPuntos()==0;
            }
           
         });
            return partida;
        }

    

    
}
