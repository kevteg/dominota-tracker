/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominota;
import com.db4o.ObjectSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 *
 * @author JOSE
 */
public class Juego {
    
    private Dbgestor db;
    
    public Juego(){
        db = new Dbgestor();
        
    }
    
    
    public void domino(){
        Scanner sc = new Scanner(System.in);
        String resp =" ";
        int opc = 0;
        System.out.println("Partida nueva-- 1.Equipo  2.Individual");
        opc = sc.nextInt();
        
        if (opc == 1){
            AgregarEquipo();
            
        }
        else{
            partida(opc);
            //db.DbClose();
         }
            
    }
    
    public void partida(int opc){
        int puntos = 0;
        int player = 0;
        if (opc != 1){
            
        
        List<Jugador> ju =  AgregarJugador();
        
        Partida par = new Partida() ;
        int maxpto = 0;
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Puntos maximos");
        maxpto = sc.nextInt();
        par.SetPuntos(maxpto);
        //par.SetJugador(ju);
        //ineficiente pero que mas
        
        do{
            
            if(ju.size() == 2){
                System.out.println("1."+ju.get(0).getNombre() + " " + "2."+ju.get(1).getNombre());
            }
            if(ju.size() == 3){
                System.out.println("1."+ju.get(0).getNombre() + " " + "2."+ju.get(1).getNombre()
                                     + " " + "3." + ju.get(2).getNombre());
            }
            if(ju.size() == 4){
                System.out.println("1."+ju.get(0).getNombre() + " " + "2."+ju.get(1).getNombre()
                                   + " " + "3." + ju.get(2).getNombre()+ " " + "4." + ju.get(3).getNombre() );
            }
             
            puntos = 0;
            player = 0;
            System.out.println("Puntos: " );
            puntos = sc.nextInt();
            System.out.println("Jugador ");
            player = sc.nextInt();
            
            ju.get(player-1).setManos(puntos);
            ju.get(player-1).asignar_puntos(puntos);
            puntos=ju.get(player-1).GetPuntos();
            System.out.println("Puntos: " + puntos);
            
        }while(maxpto>puntos);
        
        par.SetJugador(ju);
        db.AgregarPartida(par);
        }
        }
    
    public void asignar_puntos(List<Jugador> ju,int puntos,int player){
        
        
        
        
    }
    
    public List<Jugador> AgregarJugador () {
        String resp="",nombre="";
        Jugador j;
        List<Jugador> ju = new ArrayList <Jugador>(); ;
        Scanner sc = new Scanner(System.in);
        
        do{
            System.out.println("Nombre de jugador: ");
            nombre = sc.nextLine();
            j = new Jugador(nombre);
            db.AgregarJugador(j);
            ju.add(j);
            System.out.println("Desea agrega otro jugador: ");
            resp = sc.nextLine();
            
        }while(resp.equalsIgnoreCase("si"));
        
        //db.DbClose();
        return (List<Jugador>) ju;
    
    }
    
    public void AgregarEquipo(){
        
        String resp="si",nombre="";
        int con_j = 0 , con_e = 0 ;
        Jugador j;
        Equipo e; 
        Scanner sc = new Scanner(System.in);
        
        do{
            e = new Equipo(); 
            System.out.println("Nombre del equipo: ");
            nombre = sc.nextLine();
            e.setNombre(nombre);
            
            while(con_j <= 1){
                System.out.println("Nombre de jugador: ");
                nombre = sc.nextLine();
                j = new Jugador(nombre);
                e.setJugador(j);
                //System.out.println("Desea agrega otro jugador: ");
                //resp = sc.nextLine();
                con_j++;
            }
            con_j = 0;
            
            db.agregarEquipo(e);
           // System.out.println("Desea agrega otro Equipo: ");
            //resp = sc.nextLine();
            con_e++;
        }while(con_e <= 1);
        con_e = 0;
        
        db.DbClose();
    
    
    
    }
    
    public void ObtenerEquipos () {
         List <Equipo> result = db.GetBddatos().query(Equipo.class);
         for (Equipo e : result) {
             e.listarEquipos();
         }
         db.DbClose();
    }
    
    public void ObtenerJugadores () {
        List <Jugador> j = db.GetBddatos().query(Jugador.class);
        for (Jugador ju : j) {
            System.out.println("Nombre del jugador: " + ju.getNombre());
           }
         db.DbClose();
    }
    
    public void ObtenerPartida () {
         List <Partida> p = db.GetBddatos().query(Partida.class);
        for (Partida pa : p) {
            System.out.println("Puntos de partida: " + pa.GetPuntos());
            for(Jugador j : pa.getJugador()){
                System.out.println("Jugador: " + j.getNombre());
                System.out.println("Puntos Totales: " + j.GetPuntos());
                for(int point : j.GetMano()){
                    System.out.println("Puntos en mano: " + point);
                }
                
                }
           }
         db.DbClose();
    
    }

}
       
    
    

