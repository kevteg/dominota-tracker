package Dominota;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import java.io.*;
import java.util.List;


public class Main {
   

    final static String DB4ONOMBRE = "C:\\Users\\Principal\\Desktop\\Dominota\\basededatos.db4o";
    static ObjectContainer bdatos;
    static InputStreamReader isr = new InputStreamReader(System.in);
    static BufferedReader leer = new BufferedReader(isr);

    public static void main(String[] args) throws IOException {
         
      Juego j = new Juego ();
      //j.ObtenerJugadores();
      //j.AgregarJugador();
      //j.AgregarEquipo();
       //j.ObtenerEquipos();
      //j.ListTeam("barcelona");
        j.domino();
       // j.EmparejarEquipo(DB4ONOMBRE);
        //j.EmparejarJugador(DB4ONOMBRE);
         //j.ListarJugadorPorEquipo(DB4ONOMBRE);
//j.ZapatoEquipo("madrid","19/10/2016");
      // j.Porcentaje_victoria_jugador("alex","19/10/2016");
       // j.ListPlayer("alex");
        //j.ListarJugador("pedro");
         //j.ListarEquipo("barcelona");
        // j.Porcentaje_victoria_equipo("madrid", "20/07/2016");
       // j.listar_fecha();
//j.ObtenerJugadores();
     //j.ObtenerPartidaJugador();
      //j.ObtenerPartidaEquipo();
      j.Cerrar_Sesion();
              
    }

   

   
    


 

 

}
