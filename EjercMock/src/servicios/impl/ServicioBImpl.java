package servicios.impl;

import servicios.ServicioA;
import servicios.ServicioB;

public class ServicioBImpl implements ServicioB {

	private ServicioA servicioA;
	
	@Override
	public ServicioA getServicioA() {
		// TODO Auto-generated method stub
		return servicioA;
	}

	@Override
	public void setServicioA(ServicioA servicioA) {
		// TODO Auto-generated method stub
		this.servicioA=servicioA;
	}

	@Override
	public int multiplicarSumar(int a, int b, int multiplicador) {
		// TODO Auto-generated method stub
		return servicioA.sumar(a, b)*multiplicador;
	}

	@Override
	public int multiplicar(int a, int b) {
		// TODO Auto-generated method stub
		return a*b;
	}

}
