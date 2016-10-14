package Dominota;

public class persona {

	boolean cabello;
	long cedula;
	String nombre;
	String apellido;
	String telefono;
	
	public persona(boolean cabello, long cedula, String nombre, String apellido, String telefono) {
		super();
		this.cabello = cabello;
		this.cedula = cedula;
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefono = telefono;
	}
	
	public persona()
	{
		super();
	}

	public boolean isCabello() {
		return cabello;
	}

	public void setCabello(boolean cabello) {
		this.cabello = cabello;
	}

	public long getCedula() {
		return cedula;
	}

	public void setCedula(int cedula) {
		this.cedula = cedula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String toString() {
		return " Cedula " + cedula + " Nombre: "+ nombre + " Apellido: "+ apellido+" Cabello: " + cabello + " Telefono: " + telefono;
	}
	
}
