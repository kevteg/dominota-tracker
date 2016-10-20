/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominota;

import com.db4o.ObjectSet;
import com.db4o.query.Predicate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author JOSE
 */
public class Juego {

    private Dbgestor db;
    private int con;

    public Juego() {
        db = new Dbgestor();
        con = -1;
    }

    public void domino() {
        Scanner sc = new Scanner(System.in);
        String resp = " ";
        int opc = 0;
        System.out.println("Partida nueva-- 1.Equipo  2.Individual");
        opc = sc.nextInt();

        if (opc == 1) {
            partida(opc);

        } else {
            partida(opc);
            //db.DbClose();
        }

    }

    public void partida(int opc) {
        int puntos = 0, turno = 0;
        int player = 0;
        String fecha = " ";

        if (opc != 1) {

            List<Jugador> ju = AgregarJugador();
            Partida par = new Partida();
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

            do {

                if (ju.size() == 2) {
                    System.out.println("1." + ju.get(0).getNombre() + " " + "2." + ju.get(1).getNombre());
                }
                if (ju.size() == 3) {
                    System.out.println("1." + ju.get(0).getNombre() + " " + "2." + ju.get(1).getNombre()
                            + " " + "3." + ju.get(2).getNombre());
                }
                if (ju.size() == 4) {
                    System.out.println("1." + ju.get(0).getNombre() + " " + "2." + ju.get(1).getNombre()
                            + " " + "3." + ju.get(2).getNombre() + " " + "4." + ju.get(3).getNombre());
                }

                puntos = 0;
                player = 0;
                System.out.println("Jugador ");
                player = sc.nextInt();
                System.out.println("Puntos: ");
                puntos = sc.nextInt();

                ju.get(player - 1).setManos(puntos);
                ju.get(player - 1).asignar_puntos(puntos);
                ju.get(player - 1).setTurno(turno);
                puntos = ju.get(player - 1).GetPuntos();
                System.out.println("Puntos: " + puntos);
                turno++;
            } while (maxpto > puntos);

            par.SetJugador(ju);
            db.AgregarPartida(par);
            for (Jugador jugador : ju) {
                db.AgregarJugador(jugador);
            }

        }

        if (opc == 1) {

            List<Equipo> eq = AgregarEquipo();

            Partida par = new Partida();
            int maxpto = 0;
            Scanner sc = new Scanner(System.in);

            System.out.println("Fecha de partida en formato dd/mm/yyyy");
            fecha = sc.nextLine();
            par.SetFecha(fecha);
            System.out.println("Puntos maximos");
            maxpto = sc.nextInt();
            par.SetPuntos(maxpto);

            //ineficiente pero que mas
            do {
                System.out.println("1." + eq.get(0).getNombre() + " " + "2." + eq.get(1).getNombre());

                puntos = 0;
                player = 0;
                System.out.println("Equipo : ");
                player = sc.nextInt();
                System.out.println("Puntos : ");
                puntos = sc.nextInt();

                eq.get(player - 1).SetManos(puntos);
                eq.get(player - 1).asignar_puntos(puntos);
                eq.get(player - 1).setTurno(turno);
                puntos = eq.get(player - 1).GetPuntos();
                System.out.println("Puntos: " + puntos);
                turno++;
            } while (maxpto > puntos);

            par.SetEquipo(eq);
            db.AgregarPartida(par);
            for (Equipo equipo : eq) {
                db.agregarEquipo(equipo);
            }
        }

        turno = 0;
    }

    public void asignar_puntos(List<Jugador> ju, int puntos, int player) {

    }

    public List<Jugador> AgregarJugador() {
        String resp = "", nombre = "";
        Jugador j;
        List<Jugador> ju = new ArrayList<Jugador>();;
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("Nombre de jugador: ");
            nombre = sc.nextLine();
            j = new Jugador(nombre);
            // db.AgregarJugador(j);
            ju.add(j);
            System.out.println("Desea agrega otro jugador: ");
            resp = sc.nextLine();

        } while (resp.equalsIgnoreCase("si"));

        //db.DbClose();
        return (List<Jugador>) ju;

    }

    public List<Equipo> AgregarEquipo() {
        List<Equipo> eq = new ArrayList<Equipo>();;
        String resp = "si", nombre = "";
        int con_j = 0, con_e = 0;
        Jugador j;
        Equipo e;
        Scanner sc = new Scanner(System.in);

        do {
            e = new Equipo();
            System.out.println("Nombre del equipo: ");
            nombre = sc.nextLine();

            e.setNombre(nombre);

            while (con_j <= 1) {
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
        } while (con_e <= 1);
        con_e = 0;

        // db.DbClose();
        return (List<Equipo>) eq;

    }

    public void ObtenerEquipos() {
        List<Equipo> result = db.GetBddatos().query(Equipo.class);
        for (Equipo e : result) {
            System.out.println(e.getNombre());
//e.listarEquipos();
        }
        // db.DbClose();
    }

    public void ObtenerJugadores() {
        List<Jugador> j = db.GetBddatos().query(Jugador.class);
        for (Jugador ju : j) {
            System.out.println("Nombre del jugador: " + ju.getNombre());
            System.out.println("Puntos: " + ju.GetPuntos());
        }
        // db.DbClose();
    }

    public void ObtenerPartidaJugador() {
        int contador = 0;
        List<Partida> p = db.GetBddatos().query(Partida.class);
        for (Partida pa : p) {
            System.out.println("Puntos de partida: " + pa.GetPuntos());
            System.out.println("Fecha " + pa.GetFecha());
            for (Jugador j : pa.getJugador()) {
                System.out.println("Jugador: " + j.getNombre());
                System.out.println("Puntos Totales: " + j.GetPuntos());
                for (int point : j.GetMano()) {
                    // System.out.println("Puntos en mano: " + point);
                    //System.out.println("Turno: " + j.GetTurno().get(contador));
                    contador++;
                }
                contador = 0;
            }
        }
        // db.DbClose();

    }

    public void ListPlayer(String nombre) {

        int partidas_ganadas = 0;
        List<Partida> p = db.GetBddatos().query(Partida.class);

        for (Partida pa : p) {
            for (Jugador j : pa.getJugador()) {
                if (j.GetPuntos() >= pa.GetPuntos() && j.getNombre().equals(nombre)) {
                    partidas_ganadas++;
                }
            }

        }

        System.out.println(nombre + " ha ganado " + partidas_ganadas + " partidas");
        // db.DbClose();
    }

    public void ListTeam(String nombre) {

        int partidas_ganadas = 0;
        List<Partida> p = db.GetBddatos().query(Partida.class);

        for (Partida pa : p) {
            for (Equipo j : pa.getEquipo()) {
                if (j.GetPuntos() >= pa.GetPuntos() && j.getNombre().equals(nombre)) {
                    partidas_ganadas++;
                }
            }

        }

        System.out.println(nombre + " ha ganado " + partidas_ganadas + " partidas");
        // db.DbClose();
    }

    public void ListarJugador(String name) {
        List<Partida> jugador = db.PartidaJugador(name);
        int con = 0;
        for (Partida pa : jugador) {
            con++;
        }

        System.out.println(name + " ha ganado " + con + " partidas");
        //   db.DbClose();
    }

    public void ListarEquipo(String name) {

        List<Partida> equipo = db.PartidaEquipo(name);
        System.out.println(name + " ha ganado " + equipo.size() + " partidas");

        //   db.DbClose();
    }

    public void ListarJugadorPorEquipo(String nombre) {
        List<Equipo> equipo = db.JugadorPorEquipo(nombre);
        System.out.println(nombre + " ha estado en los siguientes equipos: ");

        for (Equipo eq : equipo) {
            System.out.println(eq.getNombre());
        }

    }

    public void ZapatoJugador(String name, String fecha) {

        List<Partida> zapato = db.JugadorZapato(name, fecha);
        System.out.println(name + " obtuvo " + zapato.size() + " zapatos en la partidas");

        //   db.DbClose();
    }

    public void ZapatoEquipo(String name, String fecha) {

        List<Partida> zapato = db.EquipoZapato(name, fecha);
        System.out.println(name + " obtuvo " + zapato.size() + " zapatos en la partidas");

        //   db.DbClose();
    }

    public void listar_fecha() {
        List<Partida> p = db.GetBddatos().query(Partida.class);
        for (Partida pa : p) {
            System.out.println(pa.GetFecha());
            if (pa.GetFecha().equals("19/10/2016")) {

                for (Jugador ju : pa.getJugador()) {
                    System.out.println(ju.getNombre() + " " + ju.GetPuntos());
                }
            }
// System.out.println(pa.GetFecha());
        }

    }

    public int ListarEquipoGanadas(String name, String fecha) {
        List<Partida> equipo = db.PartidaEquipoGanadas(name, fecha);
        System.out.println(name + " ha ganado " + equipo.size() + " partidas");
        return equipo.size();
        //   db.DbClose();
    }

    public int ListarEquipoPerdidas(String name, String fecha) {
        List<Partida> equipo = db.PartidaEquipoPerdidas(name, fecha);
        System.out.println(name + " ha perdido " + equipo.size() + " partidas");
        return equipo.size();
        //   db.DbClose();
    }

    public int ListarJugadorGanadas(String name, String fecha) {
        List<Partida> jugador = db.PartidaJugadorGanadas(name, fecha);
        System.out.println(name + " ha ganado " + jugador.size() + " partidas");
        return jugador.size();
        //   db.DbClose();
    }

    public int ListarJugadorPerdidas(String name, String fecha) {
        List<Partida> jugador = db.PartidaJugadorPerdidas(name, fecha);
        System.out.println(name + " ha perdido " + jugador.size() + " partidas");
        return jugador.size();
        //   db.DbClose();
    }

    public void Porcentaje_victoria_equipo(String name, String fecha) {
        float ganadas = 0, perdidas = 0;
        float total = 0;
        ganadas = ListarEquipoGanadas(name, fecha);
        perdidas = ListarEquipoPerdidas(name, fecha);
        total = (float) ((ganadas / (ganadas + perdidas)) * 100);
        System.out.println(name + " ha ganado el " + total + " porciento de sus partidas");
        //   db.DbClose();
    }

    public void Porcentaje_victoria_jugador(String name, String fecha) {
        float ganadas = 0, perdidas = 0;
        float total = 0;
        ganadas = ListarJugadorGanadas(name, fecha);
        perdidas = ListarJugadorPerdidas(name, fecha);
        total = (float) ((ganadas / (ganadas + perdidas)) * 100);
        System.out.println(name + " ha ganado el " + total + " porciento de sus partidas");
        //   db.DbClose();
    }

    public void EmparejarJugadoresOponentes(float porcentaje, String nombre) {
        List<Jugador> jugador = db.GetBddatos().query(Jugador.class);
        List<Jugador> oponente = new ArrayList<Jugador>();
        List<Float> por = new ArrayList<Float>();
        List<Partida> partida = db.GetBddatos().query(Partida.class);
        float ganadas = 0, perdidas = 0, total = 0;
        ganadas = perdidas = total = 0;
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

        System.out.println("El jugador " + nombre + "con " + porcentaje + " % " + "se empareja mejor con: ");
        int contador = 0;
        for (Jugador opo : oponente) {
            System.out.println(opo.getNombre() + " " + por.get(contador));
            contador++;
        }

    }

    public void EmparejarEquiposOponentes(float porcentaje, String nombre) {

        List<Equipo> jugador = db.GetBddatos().query(Equipo.class);
        List<Equipo> oponente = new ArrayList<Equipo>();
        List<Float> por = new ArrayList<Float>();
        List<Partida> partida = db.GetBddatos().query(Partida.class);
        float ganadas = 0, perdidas = 0, total = 0;

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

        System.out.println("El equipo " + nombre + " con " + porcentaje + " % " + "se empareja mejor con: ");
        int contador = 0;
        for (Equipo opo : oponente) {
            System.out.println(opo.getNombre() + " " + por.get(contador));
            contador++;
        }
    }

    public void EmparejarJugador(String nombre) {

        List<Partida> ganadas = db.PartidaJugador(nombre);
        List<Partida> perdidas = db.PartidaJugadorPerdidas(nombre);
        float ganar = ganadas.size();
        float perder = perdidas.size();
        float porcentaje_victoria = (ganar / (ganar + perder)) * 100;
        this.EmparejarJugadoresOponentes(porcentaje_victoria, nombre);

    }

    public void EmparejarEquipo(String nombre) {
        List<Partida> ganadas = db.PartidaEquipo(nombre);
        List<Partida> perdidas = db.PartidaEquipoPerdidas(nombre);
        float ganar = ganadas.size();
        float perder = perdidas.size();
        float porcentaje_victoria = (ganar / (ganar + perder)) * 100;
        this.EmparejarEquiposOponentes(porcentaje_victoria, nombre);

    }

    public void Cerrar_Sesion() {
        db.DbClose();
    }

    public void ObtenerPartidaEquipo() {
        int contador = 0;
        List<Partida> p = db.GetBddatos().query(Partida.class);
        for (Partida pa : p) {
            System.out.println("Puntos de partida: " + pa.GetPuntos());
            for (Equipo eq : pa.getEquipo()) {
                System.out.println("Equipo: " + eq.getNombre());
                System.out.println("Puntos Totales: " + eq.GetPuntos());
                for (int point : eq.getManos()) {
                    System.out.println("Puntos en mano: " + point);
                    System.out.println("Turno: " + eq.GetTurno().get(contador));
                    contador++;
                }
                contador = 0;
            }
        }
        // db.DbClose();
    }

    public void Top3Puntos() {

        List<Jugador> j = db.GetBddatos().query(Jugador.class);

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

        for (int i = 0; i < 3; i++) {
            System.out.println(nombres[i] + " " + puntos[i]);
        }

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

}
