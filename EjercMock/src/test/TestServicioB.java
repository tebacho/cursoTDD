package test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;

import servicios.ServicioA;
import servicios.ServicioB;
import servicios.impl.ServicioBImpl;

public class TestServicioB {

	@Test
	public void testMultiplicacion() {
		ServicioB servicioB = new ServicioBImpl();
		assertEquals(servicioB.multiplicar(2, 3), 6);
	}
	
	@Test
	public void testMultiplicarSuman() {
		ServicioA servicioA = mock(ServicioA.class);
		when(servicioA.sumar(2, 3)).thenReturn(5);
		when(servicioA.sumar(3, 3)).thenReturn(6);
		
		ServicioB servicioB = new ServicioBImpl();
		
		servicioB.setServicioA(servicioA);
		
		assertEquals(servicioB.multiplicarSumar(2, 3, 2), 10);
	}

}
