/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominota;


import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
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
    final static String DB4ONOMBRE = "/home/keeeevin/Documents/dominota-tracker/Dominota/basededatos.db4o";
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
    
    
      public static void imprimirLista(List<?> result) {
        System.out.println("Total Objetos recuperados" + result.size());
        int nl = 0;
        for (Object o : result) {
            System.out.println(nl + ". " + o);
            nl++;
        }
    }
    
}
