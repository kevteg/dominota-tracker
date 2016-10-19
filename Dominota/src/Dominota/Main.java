package Dominota;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import java.io.*;
import java.util.List;
import Dominota.initial;

public class Main {
   

    final static String DB4ONOMBRE = "basededatos.db4o";
    static ObjectContainer bdatos;
    static InputStreamReader isr = new InputStreamReader(System.in);
    static BufferedReader leer = new BufferedReader(isr);

    public static void main(String[] args) throws IOException {
         
      //Juego j = new Juego ();
      initial dinterface = new initial();
      dinterface.setVisible(true);
      //j.ObtenerJugadores();
      //j.AgregarJugador();
      //j.AgregarEquipo();
      //j.ObtenerEquipos();
      //j.ObtenerJugadores();

      //j.domino();
      
      //j.ObtenerPartidaJugador();
      //j.ObtenerPartidaEquipo();
              
    }
}
