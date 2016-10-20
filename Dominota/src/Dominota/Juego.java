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
import javax.swing.JOptionPane;
/**
 *
 * @author JOSE
 */
public class Juego {
    
    private Dbgestor db;
    private initial frame;
    
    public Juego(initial frame){
        db = new Dbgestor();
        this.frame = frame;
    }
    
    public void domino(){
        Scanner sc = new Scanner(System.in);
        int opc = 0;
        System.out.println("Partida nueva-- 1.Equipo  2.Individual");
        opc = sc.nextInt();
        partida(opc);
    }
    
    public void dominoInterface(){
        Object[] options = {"Equipo", "Individual"};
        int n = JOptionPane.showOptionDialog(this.frame,
        "Tipo de partida",
        "Nuevo juego",
        JOptionPane.YES_NO_OPTION,
        JOptionPane.QUESTION_MESSAGE,
        null,     //do not use a custom Icon
        options,  //the titles of buttons
        options[1]); //default button title
        System.out.println(n);
        partidaInterfaz(n);
    }
    
    public void partidaInterfaz(int opc){
        if(opc == 0){
            this.frame.addPanelEquipo(db);
        }else if (opc == 1){
            this.frame.addPanelIndividual(db);
        }
    }
    
    public void partida(int opc){
        int puntos = 0, turno = 0;
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
                ju.get(player-1).setTurno(turno);
                puntos=ju.get(player-1).GetPuntos();
                System.out.println("Puntos: " + puntos);
                turno++;
        }while(maxpto>puntos);
        
            par.SetJugador(ju);
            db.AgregarPartida(par);
        }
        
        if(opc == 1){
            
             List<Equipo> eq =  AgregarEquipo();
            
            Partida par = new Partida() ;
            int maxpto = 0;
            Scanner sc = new Scanner(System.in);
        
            System.out.println("Puntos maximos");
            maxpto = sc.nextInt();
            par.SetPuntos(maxpto);
        
        //ineficiente pero que mas
        
            do{
                System.out.println("1."+eq.get(0).getNombre() + " " + "2."+eq.get(1).getNombre());
            
                puntos = 0;
                player = 0;
                System.out.println("Equipo : " );
                player = sc.nextInt();
                System.out.println("Puntos : ");
                puntos = sc.nextInt();
                
                eq.get(player-1).SetManos(puntos);
                eq.get(player-1).asignar_puntos(puntos);
                eq.get(player-1).setTurno(turno);
                puntos=eq.get(player-1).GetPuntos();
                System.out.println("Puntos: " + puntos);
                turno++;
            }while(maxpto>puntos);
        
            par.SetEquipo(eq);
            db.AgregarPartida(par);
        } 
        
        turno=0;
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
    
    public List<Equipo> AgregarEquipo(){
        List<Equipo> eq = new ArrayList <Equipo>();
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
            eq.add(e);
           // System.out.println("Desea agrega otro Equipo: ");
            //resp = sc.nextLine();
            con_e++;
        }while(con_e <= 1);
        con_e = 0;
        
       // db.DbClose();
    
     return (List<Equipo>) eq;
    
    }
    //obtener todos los equipos
    public void ObtenerEquipos () {
         List <Equipo> result = db.GetBddatos().query(Equipo.class);
         for (Equipo e : result) {
             e.listarEquipos();
         }
         db.DbClose();
    }
   //Uobtener todos los jugadores 
    public void ObtenerJugadores () {
        List <Jugador> j = db.GetBddatos().query(Jugador.class);
        for (Jugador ju : j) {
            System.out.println("Nombre del jugador: " + ju.getNombre());
           }
         db.DbClose();
    }
    
    //obtener todas las partidas por jugador
    public void ObtenerPartidaJugador () {
        int contador = 0;
        List <Partida> p = db.GetBddatos().query(Partida.class);
        for (Partida pa : p) {
            System.out.println("Puntos de partida: " + pa.GetPuntos());
            for(Jugador j : pa.getJugador()){
                System.out.println("Jugador: " + j.getNombre());
                System.out.println("Puntos Totales: " + j.GetPuntos());
                for(int point : j.GetMano()){
                    System.out.println("Puntos en mano: " + point);
                    System.out.println("Turno: " + j.GetTurno().get(contador));
                    contador++;
                }
                contador = 0;
                }
           }
         db.DbClose();
    
    }
    
      //obtener todas las partidas por equipo
    public void ObtenerPartidaEquipo () {
        int contador = 0;
        List <Partida> p = db.GetBddatos().query(Partida.class);
        for (Partida pa : p) {
            System.out.println("Puntos de partida: " + pa.GetPuntos());
            for(Equipo eq : pa.getEquipo()){
                System.out.println("Equipo: " + eq.getNombre());
                System.out.println("Puntos Totales: " + eq.GetPuntos());
                for(int point : eq.getManos()){
                    System.out.println("Puntos en mano: " + point);
                    System.out.println("Turno: " + eq.GetTurno().get(contador));
                    contador++;
                }
                contador = 0;
                }
           }
         db.DbClose();
    
    }

}
       
    
    

