package kb.empleado.java;

public abstract class Empleado {

	private TipoEmpleado tipo;
	private float salarioBase;
	
	public Empleado(){

	}
	public TipoEmpleado getTipo() {
		return tipo;
	}
	public void setTipo(TipoEmpleado tipo) {
		this.tipo = tipo;
	}
	public float getSalarioBase() {
		return salarioBase;
	}
	public void setSalarioBase(float salarioBase) {
		this.salarioBase = salarioBase;
	}
}
