package test;

import static org.junit.Assert.*;

import org.junit.Test;

import servicios.ServicioA;
import servicios.impl.ServicioAImpl;

public class TestServicioA {

	@Test
	public void testSuma() {
		int a=2;
		int b=2;
		ServicioA servicio= new ServicioAImpl();
		assertEquals(servicio.sumar(a, b), 4);
	}

}
