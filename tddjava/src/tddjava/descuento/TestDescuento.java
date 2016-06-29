package tddjava.descuento;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestDescuento {

	
	@Test
	public void testCalculaPrecioFinalCorrecto() {
		CalculadorPrecioFinal calculador = new CalculadorPrecioFinal();
		int precioUnitario = 100;
		int descuento = 10;
		int precioFinal = 90;
		assertEquals(calculador.calculaPrecioFinal(precioUnitario, descuento), precioFinal);
	}
	@Test(expected=AssertionError.class)
	public void testCalculaPrecioFinalErrorResultado() {
		CalculadorPrecioFinal calculador = new CalculadorPrecioFinal();
		int precioUnitario = 100;
		int descuento = 10;
		int precioFinal = 50;
		assertEquals(calculador.calculaPrecioFinal(precioUnitario, descuento), precioFinal);
	}
	@Test(expected=IllegalArgumentException.class)
	public void testCalculaPrecioFinalErrorIllegalInputPrecio() {
		CalculadorPrecioFinal calculador = new CalculadorPrecioFinal();
		int precioUnitario = -100;
		int descuento = 10;
		int precioFinal = 50;
		assertEquals(calculador.calculaPrecioFinal(precioUnitario, descuento), precioFinal);
	}
	@Test(expected=IllegalArgumentException.class)
	public void testCalculaPrecioFinalErrorIllegalInputDescuentoNegativo() {
		CalculadorPrecioFinal calculador = new CalculadorPrecioFinal();
		int precioUnitario = 100;
		int descuento = -10;
		int precioFinal = 50;
		assertEquals(calculador.calculaPrecioFinal(precioUnitario, descuento), precioFinal);
	}
	@Test (expected=IllegalArgumentException.class)
	public void testCalculaPrecioFinalUllegalInputDescuento200() {
		CalculadorPrecioFinal calculador = new CalculadorPrecioFinal();
		int precioUnitario = 100;
		int descuento = 200;
		calculador.calculaPrecioFinal(precioUnitario, descuento);
	}
	@Test()
	public void testCalculaPrecioFinalErrorFailResult() {
		CalculadorPrecioFinal calculador = new CalculadorPrecioFinal();
		int precioUnitario = 100;
		int descuento = 10;
		int precioFinal = 50;
		assertNotEquals(calculador.calculaPrecioFinal(precioUnitario, descuento), precioFinal);
	}
	@Test()
	public void testCalculaPrecioFinalFronteraMinDescuento() {
		CalculadorPrecioFinal calculador = new CalculadorPrecioFinal();
		int precioUnitario = 100;
		int descuento = 0;
		int precioFinal = 100;
		assertEquals(calculador.calculaPrecioFinal(precioUnitario, descuento), precioFinal);
	}
	@Test()
	public void testCalculaPrecioFinalFronteraMaxDescuento() {
		CalculadorPrecioFinal calculador = new CalculadorPrecioFinal();
		int precioUnitario = 100;
		int descuento = 100;
		int precioFinal = 0;
		assertEquals(calculador.calculaPrecioFinal(precioUnitario, descuento), precioFinal);
	}
	
	@Test()
	public void testCalculaPrecioFinalFronteraMaxPrecio() {
		CalculadorPrecioFinal calculador = new CalculadorPrecioFinal();
		int precioUnitario = 2147483647;
		int descuento = 10;
		int precioFinal = 1932735282;
		assertEquals(calculador.calculaPrecioFinal(precioUnitario, descuento), precioFinal);
	}
	@Test()
	public void testCalculaPrecioFinalRoundUp() {
		CalculadorPrecioFinal calculador = new CalculadorPrecioFinal();
		int precioUnitario = 99;
		int descuento = 50;
		int precioFinal = 50;
		assertEquals(calculador.calculaPrecioFinal(precioUnitario, descuento), precioFinal);
	}
	@Test(expected=IllegalArgumentException.class)
	public void testCalculaPrecioFinalPrecioCero() {
		CalculadorPrecioFinal calculador = new CalculadorPrecioFinal();
		int precioUnitario = 0;
		int descuento = 50;
		int precioFinal = 50;
		assertEquals(calculador.calculaPrecioFinal(precioUnitario, descuento), precioFinal);
	}
}
