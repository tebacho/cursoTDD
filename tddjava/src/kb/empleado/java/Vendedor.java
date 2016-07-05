package kb.empleado.java;

public class Vendedor extends Empleado {

	public Vendedor(){
		super.setTipo(TipoEmpleado.VENDEDOR);
		super.setSalarioBase(1000);
	}
}
