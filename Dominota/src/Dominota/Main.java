package Dominota;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import java.io.*;
import java.util.List;


public class Main {
   

    final static String DB4ONOMBRE = "C:\\Users\\JOSE\\Downloads\\Dominota\basededatos.db4o";
    static ObjectContainer bdatos;
    static InputStreamReader isr = new InputStreamReader(System.in);
    static BufferedReader leer = new BufferedReader(isr);

    public static void main(String[] args) throws IOException {
         
      Juego j = new Juego ();
      //j.ObtenerJugadores();
      //j.AgregarJugador();
      //j.AgregarEquipo();
      //j.ObtenerEquipos();
      j.domino();
      j.ObtenerPartida();
    }

    public static void insert(ObjectContainer db) throws IOException {

        System.out.println("Nombre del Equipo: ");
        String nombre = leer.readLine();
        Equipo e = new Equipo();
        /*persona p = new persona(true, cedentera, "Pepe", "Zambrano", "123456");
        db.store(p);

        empleado emp = new empleado(true, cedentera, "Pepe", "Zambrano", "123456", 100000, "Jefe Supremo");
        db.store(emp);*/
    }

    public static void consultarBD(ObjectContainer db) {
        ObjectSet resultado = db.queryByExample(persona.class);
        imprimirLista(resultado);

        resultado = db.queryByExample(empleado.class);
        imprimirLista(resultado);

        System.out.println(" Muestro personas con cabello y  cedula 1083");
        persona prototipo = new persona();
        prototipo.setCedula(1083);
        prototipo.setCabello(false);
        resultado = db.queryByExample(prototipo);
        imprimirLista(resultado);
    }

    public static void actualizarBD(ObjectContainer db) {
        System.out.println(" Aumento salario en 5% ");
        System.out.println(" ANTES ");
        ObjectSet<empleado> resultado = db.queryByExample(empleado.class);
        imprimirLista(resultado);
        for (empleado emp : resultado) {
            emp.setSalario(emp.getSalario() * 1.05);
            db.store(emp);
        }
        System.out.println(" DESPUES ");
        resultado = db.queryByExample(empleado.class);
        imprimirLista(resultado);
    }

    public static void borrarempBD(ObjectContainer db) {
        System.out.println(" BORRO EMPLEADOS ");
        System.out.println(" ANTES ");
        ObjectSet<empleado> resultado = db.queryByExample(empleado.class);
        imprimirLista(resultado);
        for (empleado emp : resultado) {
            db.delete(emp);
        }
        System.out.println(" DESPUES ");
        resultado = db.queryByExample(empleado.class);
        imprimirLista(resultado);
    }

    public static void imprimirLista(List<?> result) {
        System.out.println("Total Objetos recuperados" + result.size());
        int nl = 0;
        for (Object o : result) {
            System.out.println(nl + ". " + o);
            nl++;
        }
    }

    public static ObjectContainer iniciarBD() {
        File archivo = new File(DB4ONOMBRE);
        ObjectContainer db = null;
        if (!archivo.exists()) {
            db = Db4oEmbedded.openFile(Db4oEmbedded
                    .newConfiguration(), DB4ONOMBRE);
        } else {
            db = Db4oEmbedded.openFile(DB4ONOMBRE);
        }

        return db;
    }

}
