/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominota;
import com.db4o.ObjectSet;
import com.db4o.query.Predicate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import java.io.File;
import org.jfree.chart.plot.*;
import java.io.*;
import java.util.Collections;
import javax.swing.JOptionPane;
import org.jfree.data.category.DefaultCategoryDataset;
/**
 *
 * @author JOSE
 */
public class Juego {
    
    public Dbgestor db;
    private initial frame;
    
    public Juego(initial frame){
        if(frame != null){
            db = new Dbgestor();
            this.frame = frame;
        }
    }
    
    
    public void domino(){
        Scanner sc = new Scanner(System.in);
        String resp =" ";
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
    public void save(){
        
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
        String fecha=" ";
        
        if (opc != 1){
            
            List<Jugador> ju =  AgregarJugador();
            Partida par = new Partida() ;
            int maxpto = 0;
            Scanner sc = new Scanner(System.in);
            System.out.println("Fecha de partida en formato dd/mm/yyyy");
            fecha = sc.nextLine();
            par.SetFecha(fecha);
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
                System.out.println("Jugador ");
                player = sc.nextInt();
                System.out.println("Puntos: " );
                puntos = sc.nextInt();
                
            
                ju.get(player-1).setManos(puntos);
                ju.get(player-1).asignar_puntos(puntos);
                ju.get(player-1).setTurno(turno);
                puntos=ju.get(player-1).GetPuntos();
                System.out.println("Puntos: " + puntos);
                turno++;
        }while(maxpto>puntos);
        
            par.SetJugador(ju);
            db.AgregarPartida(par);
            GraficaPartidaIndividual(par);
            for(Jugador jugador : ju){
            db.AgregarJugador(jugador);
            }
        }
        
        if(opc == 1){
            
             List<Equipo> eq =  AgregarEquipo();
            
            Partida par = new Partida() ;
            int maxpto = 0;
            Scanner sc = new Scanner(System.in);
            
            System.out.println("Fecha de partida en formato dd/mm/yyyy");
            fecha = sc.nextLine();
            par.SetFecha(fecha);
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
            System.out.println("GRAFICA");
            GraficaPartidaEquipos(par);
            for(Equipo equipo : eq){
            db.agregarEquipo(equipo);
            }
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
           // db.AgregarJugador(j);
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
            
            //db.agregarEquipo(e);
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
            // System.out.println(e.getNombre());             
//e.listarEquipos();
         }
        // db.DbClose();

    
   //obtener todos los jugadores 
    public void ObtenerJugadores () {
        List <Jugador> j = db.GetBddatos().query(Jugador.class);
        for (Jugador ju : j) {
            System.out.println("Nombre del jugador: " + ju.getNombre());
            System.out.println("Puntos: " + ju.GetPuntos());
           }
        // db.DbClose();
    }
    
    //obtener todas las partidas por jugador
    public String ObtenerPartidaJugador () {
        int contador = 0;
        String info = "";
        List <Partida> p = db.GetBddatos().query(Partida.class);
        for (Partida pa : p) {
            if(pa.getJugador().size() > 0)
                info += "-------------Puntos de partida: " + pa.GetPuntos() + " (" + pa.GetFecha()+ ")" + "-------------\n";
            for(Jugador j : pa.getJugador()){
                info += ">Jugador: " + j.getNombre() + "\n";
                info += "Puntos Totales: " + j.GetPuntos() + "\n";
                for(int point : j.GetMano()){
                    info += "Puntos en mano: " + point + "\n";
                    info += "Turno: " + j.GetTurno().get(contador) + "\n";
                    contador++;
                }
                contador = 0;
                }
           }
      return info;
    }
    
    //comprobar consulta partidas ganadas
    public void ListPlayer(String nombre){
         
        int partidas_ganadas = 0;
        List <Partida> p = db.GetBddatos().query(Partida.class);
        
        for(Partida pa : p){
            for(Jugador j : pa.getJugador()){
                if(j.GetPuntos()>=pa.GetPuntos() && j.getNombre().equals(nombre)){
                    partidas_ganadas++;
                }
            }
             
        }
        
        System.out.println(nombre + " ha ganado " + partidas_ganadas + " partidas");
       // db.DbClose();
        }
    
    //comprobar la consulta partidas ganadas
      public void ListTeam(String nombre){
         
        int partidas_ganadas = 0;
        List <Partida> p = db.GetBddatos().query(Partida.class);
        
        for(Partida pa : p){
            for(Equipo j : pa.getEquipo()){
                if(j.GetPuntos()>=pa.GetPuntos() && j.getNombre().equals(nombre)){
                    partidas_ganadas++;
                }
            }
             
        }
        
        System.out.println(nombre + " ha ganado " + partidas_ganadas + " partidas");
       // db.DbClose();
        }
      
      //numero de veces que un jugador ha ganado
    
    public int ListarJugador(String name){
        List <Partida> jugador = db.PartidaJugador(name);
        int con = 0;
        for (Partida pa : jugador){
            con++;
        }
        return con;
     //   db.DbClose();
    }
    //numero de veces que un equipo ha ganado
    public int ListarEquipo(String name){
        List <Partida> equipo = db.PartidaEquipo(name);
        return equipo.size();
        //   db.DbClose();
    }
    //cantidad de veces que jugador obtuvo cero puntos     
    public int ZapatoJugador(String name,String fecha){
        List <Partida> zapato = db.JugadorZapato(name, fecha);
        System.out.println(name + " obtuvo " + zapato.size() + " zapatos en la partidas");
        return zapato.size();
    }
    
       //cantidad de veces que un equipo obtuvo cero puntos     
    public int ZapatoEquipo(String name,String fecha){
        List <Partida> zapato = db.EquipoZapato(name, fecha);
        System.out.println(name + " obtuvo " + zapato.size() + " zapatos en la partidas");
        return zapato.size();
    }

   
   //cantidad de veces que gano el equipo en una fecha
    public int ListarEquipoGanadas(String name,String fecha){
        List <Partida> equipo = db.PartidaEquipoGanadas(name,fecha);
        System.out.println(name + " ha ganado " + equipo.size() + " partidas");
        return equipo.size();
        //   db.DbClose();
    }
       //cantidad de veces que perdio el equipo en una fecha
    public int ListarEquipoPerdidas(String name,String fecha){
        List <Partida> equipo = db.PartidaEquipoPerdidas(name,fecha);
        System.out.println(name + " ha perdido " + equipo.size() + " partidas");
        return equipo.size();
        //   db.DbClose();
    }  
    //cantidad de veces que gano el jguador en una fecha
     public int ListarJugadorGanadas(String name,String fecha){
        List <Partida> jugador = db.PartidaJugadorGanadas(name,fecha);
        System.out.println(name + " ha ganado " + jugador.size() + " partidas");
        return jugador.size();
        //   db.DbClose();
    }
       //cantidad de veces que perdio el jugador en una fecha
    public int ListarJugadorPerdidas(String name,String fecha){
        List <Partida> jugador = db.PartidaJugadorPerdidas(name,fecha);
        System.out.println(name + " ha perdido " + jugador.size() + " partidas");
        return jugador.size();
        //   db.DbClose();
    }  
       //metodo para obtener el porcentaje del equipo
    public float Porcentaje_victoria_equipo(String name,String fecha){
        float ganadas = 0,perdidas = 0;
        float total = 0;
        ganadas = ListarEquipoGanadas(name,fecha);
        perdidas = ListarEquipoPerdidas(name,fecha);
        total = (float)((ganadas/(ganadas + perdidas))*100);
        System.out.println(name + " ha ganado el " + total + " porciento de sus partidas");
        return total;
    }
        // metodo para obtener el porcentaje del jugador
    public float Porcentaje_victoria_jugador(String name,String fecha){
        float ganadas = 0,perdidas = 0;
        float total = 0;
        ganadas = ListarJugadorGanadas(name,fecha);
        perdidas = ListarJugadorPerdidas(name,fecha);;
        total = (float)((ganadas/(ganadas + perdidas))*100);
        System.out.println(name + " ha ganado el " + total + " porciento de sus partidas");
        return total;
    }
    
    
    public void Cerrar_Sesion(){
        db.DbClose();
    }
    
      //obtener todas las partidas por equipo
    public String ObtenerPartidaEquipo () {
        int contador = 0;
        String info = "";
        List <Partida> p = db.GetBddatos().query(Partida.class);
        for (Partida pa : p) {
            if(pa.getEquipo().size() > 0)
                info += "-------------Puntos de partida: " + pa.GetPuntos() + " (" + pa.GetFecha()+ ")" + "-------------\n";
            for(Equipo eq : pa.getEquipo()){
                if(eq!= null){
                    info += ">Equipo: " + eq.getNombre() + "\n";
                    info += "Puntos Totales: " + eq.GetPuntos() + "\n";
                    for(int point : eq.getManos()){
                        info += "Puntos en mano: " + point + "\n";
                        info += "Turno: " + eq.GetTurno().get(contador) + "\n";
                        contador++;
                    }
                    contador = 0;
                }
                }
           }
        return info;
    }
    
    //Grafica de partida actual para jugadores individuales
    public void GraficaPartidaIndividual(Partida par){
      List <Jugador> jugadores = par.getJugador();
      DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (int i = 0; i < jugadores.size(); i++) {
           // System.out.println("n: "+jugadores.get(i).getNombre()+"   p: "+jugadores.get(i).GetPuntos());
            dataset.setValue(jugadores.get(i).GetPuntos(), "Puntos", jugadores.get(i).getNombre());
        }
      JFreeChart chart = ChartFactory.createBarChart("Puntos por Jugador",
        "Jugadores", "Puntos", dataset, PlotOrientation.VERTICAL, false,true, false);
        try {
            ChartUtilities.saveChartAsJPEG(new File("img/gra.jpg"), chart, 500,300);
        } catch (IOException e) {
            System.err.println("Error creando grafico de barras.");
        }
    }
    
    //Grafica de partida actual de equipos
    public void GraficaPartidaEquipos(Partida par){
        List <Equipo> equipos = par.getEquipo();
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (int i = 0; i < equipos.size(); i++) {
           // System.out.println("e: "+equipos.get(i).getNombre()+"   p:"+equipos.get(i).GetPuntos());
            dataset.setValue(equipos.get(i).GetPuntos(), "Puntos", equipos.get(i).getNombre());
        }
        JFreeChart chart = ChartFactory.createBarChart("Puntos por Equipo",
        "Equipos", "Puntos", dataset, PlotOrientation.VERTICAL, false,true, false);
        try {
            ChartUtilities.saveChartAsJPEG(new File("img/gra.jpg"), chart, 500,300);
        } catch (IOException e) {
            System.err.println("Error creando grafico de barras.");
        }
    }
    
    public Integer[] Estadisticas () {
        //Numero de jugadores
        Integer[] info = new Integer[3];
        List <Jugador> j = db.GetBddatos().query(Jugador.class);
        System.out.println("Número de jugadores: "+j.size());
        info[0] = j.size();
        //Numero de equipos
        List <Equipo> result = db.GetBddatos().query(Equipo.class);
        System.out.println("Número de equipos: "+result.size());
        info[1] = result.size();
        //Partidas jugadas
        List <Partida> p = db.GetBddatos().query(Partida.class);
        System.out.println("Partidas jugadas: "+p.size());
        info[2] = p.size();
        return info;
    }

    
    
      public String EmparejarJugadoresOponentes(float porcentaje, String nombre) {
        List<Jugador> jugador = db.GetBddatos().query(Jugador.class);
        List<Jugador> oponente = new ArrayList<Jugador>();
        List<Float> por = new ArrayList<Float>();
        List<Partida> partida = db.GetBddatos().query(Partida.class);
        float ganadas = 0, perdidas = 0, total = 0;
        ganadas = perdidas = total = 0;
        String message = "";
        for (Jugador ju : jugador) {
            if (ju.getNombre().equals(nombre) == false) {
                for (Partida pa : partida) {
                    for (Jugador jug : pa.getJugador()) {
                        if (ju.getNombre().equals(jug.getNombre()) && jug.GetPuntos() >= pa.GetPuntos()) {
                            ganadas++;
                        }
                        if (ju.getNombre().equals(jug.getNombre()) && jug.GetPuntos() < pa.GetPuntos()) {
                            perdidas++;
                        }
                    }
                }

                total = (ganadas / (ganadas + perdidas)) * 100;

                if (porcentaje >= total - 10 && porcentaje <= total + 10) {
                    oponente.add(ju);
                    por.add(total);
                }
            }
        }

        message += "El jugador " + nombre + "con " + porcentaje + " % " + "se empareja mejor con: \n";
        int contador = 0;
        for (Jugador opo : oponente) {
            message += opo.getNombre() + " " + por.get(contador) + "\n";
            contador++;
        }
        return message;
    }

    public String EmparejarEquiposOponentes(float porcentaje, String nombre) {

        List<Equipo> jugador = db.GetBddatos().query(Equipo.class);
        List<Equipo> oponente = new ArrayList<Equipo>();
        List<Float> por = new ArrayList<Float>();
        List<Partida> partida = db.GetBddatos().query(Partida.class);
        float ganadas = 0, perdidas = 0, total = 0;
        String message = "";
        for (Equipo ju : jugador) {
            ganadas = perdidas = total = 0;
            if (ju.getNombre().equals(nombre) == false) {
                for (Partida pa : partida) {
                    for (Equipo jug : pa.getEquipo()) {
                        if (ju.getNombre().equals(jug.getNombre()) && jug.GetPuntos() >= pa.GetPuntos()) {
                            ganadas++;
                        }
                        if (ju.getNombre().equals(jug.getNombre()) && jug.GetPuntos() < pa.GetPuntos()) {
                            perdidas++;
                        }
                    }
                }

                total = (ganadas / (ganadas + perdidas)) * 100;
                System.out.println("Jugador " + ju.getNombre() + " " + total);
                if (porcentaje >= total - 10 && porcentaje <= total + 10) {
                    oponente.add(ju);
                    por.add(total);
                }

            }
        }

        message += "El equipo " + nombre + " con " + porcentaje + " % " + "se empareja mejor con: \n";
        System.out.println("--");
        int contador = 0;
        for (Equipo opo : oponente) {
            message += opo.getNombre() + " " + por.get(contador) + "\n";
            System.out.println(opo.getNombre() + " " + por.get(contador));
            contador++;
        }
        return message;
    }

    public String EmparejarJugador(String nombre) {
        String message = "";
        List<Partida> ganadas = db.PartidaJugador(nombre);
        List<Partida> perdidas = db.PartidaJugadorPerdidas(nombre);
        float ganar = ganadas.size();
        float perder = perdidas.size();
        float porcentaje_victoria = (ganar / (ganar + perder)) * 100;
        message = this.EmparejarJugadoresOponentes(porcentaje_victoria, nombre);
        return message;
    }

    public String EmparejarEquipo(String nombre) {
        String message = "";
        List<Partida> ganadas = db.PartidaEquipo(nombre);
        List<Partida> perdidas = db.PartidaEquipoPerdidas(nombre);
        float ganar = ganadas.size();
        float perder = perdidas.size();
        float porcentaje_victoria = (ganar / (ganar + perder)) * 100;
        message = this.EmparejarEquiposOponentes(porcentaje_victoria, nombre);
        return message;
    }

    public String Top3Puntos() {

        List<Jugador> j = db.GetBddatos().query(Jugador.class);
        String info = "";
        String[] nombres = new String[9000];
        int[] puntos = new int[9000];
        int tam = 0;

        for (Jugador ju : j) {
            nombres[tam] = ju.getNombre();
            puntos[tam] = ju.GetPuntos();
            //System.out.println(nombres[tam] + " " + puntos[tam]);
            //System.out.println("Nombre del jugador: " + ju.getNombre());
            //System.out.println("Puntos: " + ju.GetPuntos());
            tam++;
        }

        //---------------------------Ordena-------------------------------------
        int k;
        boolean flag = true;   // set flag to true to begin first pass
        int tempp;   //holding variable
        String tempn;

        while (flag) {
            flag = false;    //set flag to false awaiting a possible swap
            for (k = 0; k < tam - 1; k++) {
                if (puntos[k] < puntos[k + 1]) {

                    tempp = puntos[k];
                    tempn = nombres[k];

                    puntos[k] = puntos[k + 1];
                    nombres[k] = nombres[k + 1];

                    puntos[k + 1] = tempp;
                    nombres[k + 1] = tempn;
                    flag = true;              //shows a swap occurred  
                }//Fin if
            }//Fin for
        }// fin bandera
        info += "Mejores jugadores: \n";
        for (int i = 0; i < 3; i++)
           info += nombres[i] + ": " + puntos[i] + "\n";
        return info;
    }//Fin top3

    public void TopMejoresJugadores() {
        List<Jugador> jugador = db.GetBddatos().query(Jugador.class);
        List<Jugador> oponente = new ArrayList<Jugador>();
        List<Float> por = new ArrayList<Float>();
        List<Partida> partida = db.GetBddatos().query(Partida.class);
        float ganadas = 0, perdidas = 0, total = 0;

        for (Jugador ju : jugador) {

            for (Partida pa : partida) {
                for (Jugador jug : pa.getJugador()) {
                    if (ju.getNombre().equals(jug.getNombre()) && jug.GetPuntos() >= pa.GetPuntos()) {
                        ganadas++;
                    }
                    if (ju.getNombre().equals(jug.getNombre()) && jug.GetPuntos() < pa.GetPuntos()) {
                        perdidas++;
                    }
                }
            }

            total = (ganadas / (ganadas + perdidas)) * 100;
            ju.SetPuntos((int) total);

            oponente.add(ju);
            por.add(total);

        }

        Collections.sort(por, Collections.reverseOrder());

        Jugador[] player = new Jugador[oponente.size()];
        int contador = 0;
        for (Jugador jug : oponente) {
            player[contador] = jug;
            contador++;
        }

        for (int i = 0; i < player.length - 1; i++) {
            for (int j = 0; j < player.length - 1; j++) {
                if (player[j].GetPuntos() < player[j + 1].GetPuntos()) {
                    Jugador tmp = player[j + 1];
                    player[j + 1] = player[j];
                    player[j] = tmp;
                }
            }
        }

        if (player.length >= 5) {
            for (int i = 0; i < 5; i++) {
                System.out.print(player[i].getNombre() + " " + player[i].GetPuntos() + "\n");
            }
        }

    }
    public boolean isTeam(){
        List <Partida> p = db.GetBddatos().query(Partida.class);
        int cargar = p.size() - 1;
        boolean team = false;
        if (p.get(cargar).getEquipo().isEmpty()==false)
            team = true;
        
        return team;
    }
    public List <Equipo> cargar_partidaTeam(){
        List <Partida> p = db.GetBddatos().query(Partida.class);
        List <Equipo> equ = new ArrayList<Equipo>();
        int cargar = p.size() - 1;
        if (p.get(cargar).getEquipo().isEmpty()==false)
            for (Equipo j : p.get(cargar).getEquipo())
                equ.add(j);
        return equ;
    }
    public Partida cargar_partida(){
        List <Partida> p = db.GetBddatos().query(Partida.class);
        List <Equipo> equ = new ArrayList<Equipo>();
        int cargar = p.size() - 1;
        return p.get(cargar);
    }
    public List <Jugador> cargar_partidaPlayer(){
        List <Partida> p = db.GetBddatos().query(Partida.class);
        List <Jugador> jug = new ArrayList<Jugador>();
        int cargar = p.size() - 1;
        if (p.get(cargar).getEquipo().isEmpty()==true)
            for (Jugador j : p.get(cargar).getJugador())
                jug.add(j);
        
        return jug;
    }

}
       
    
    

