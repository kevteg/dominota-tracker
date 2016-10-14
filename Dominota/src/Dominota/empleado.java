package Dominota;

public class empleado extends persona {

    double salario;
    String cargo;

    public empleado(boolean cabello, long cedula, String nombre, String apellido, String telefono, float salario, String cargo) {
        super(cabello, cedula, nombre, apellido, telefono);
        this.salario = salario;
        this.cargo = cargo;
    }

    public empleado() {
        super();
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double d) {
        this.salario = d;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String toString() {
        return super.toString() + " Salario: " + salario + " Cargo " + cargo;
    }
}
