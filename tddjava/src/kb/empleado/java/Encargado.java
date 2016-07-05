package kb.empleado.java;

public class Encargado extends Empleado {

	public Encargado(){
		super.setTipo(TipoEmpleado.ENCARGADO);
		super.setSalarioBase(1500);
	}
}
