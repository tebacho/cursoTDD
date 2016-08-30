package test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import services.CalculadoraService;


public class CalculadoraAppTest {

	
	@Rule
	public ExpectedException exception = ExpectedException.none();
	
	
	@Test
	public void testAdd() {
		CalculadoraService calcService = mock(CalculadoraService.class);
		when(calcService.add(2d, 3d)).thenReturn(5d);
		
		assertEquals(calcService.add(2d, 3d), 5d,0);
	}
	
	@Test
	public void testSubstract() {
		CalculadoraService calcService = mock(CalculadoraService.class);
		when(calcService.substract(5d, 3d)).thenReturn(2d);
		
		assertEquals(calcService.substract(5d, 3d), 2d,0);
	}
	
	@Test
	public void testMultiply() {
		CalculadoraService calcService = mock(CalculadoraService.class);
		when(calcService.multiply(2d, 3d)).thenReturn(6d);
		
		assertEquals(calcService.multiply(2d, 3d), 6d,0);
	}
	
	@Test
	public void testDivide() {
		CalculadoraService calcService = mock(CalculadoraService.class);
		when(calcService.divide(6d, 3d)).thenReturn(2d);
		
		assertEquals(calcService.divide(6d, 3d), 2d,0);
	}
	
	@Test
	public void testAddNOK() {
		CalculadoraService calcService = mock(CalculadoraService.class);
		//when(calcService.add(2d, 3d)).thenReturn(5d);
		
		assertNotEquals(calcService.add(2d, 3d), 5d,0);
	}
	
	@Test
	public void testSubstractNOK() {
		CalculadoraService calcService = mock(CalculadoraService.class);
		//when(calcService.substract(5d, 3d)).thenReturn(2d);
		
		assertNotEquals(calcService.substract(5d, 3d), 2d,0);
	}
	
	@Test
	public void testMultiplyNOK() {
		CalculadoraService calcService = mock(CalculadoraService.class);
		//when(calcService.multiply(2d, 3d)).thenReturn(6d);
		
		assertNotEquals(calcService.multiply(2d, 3d), 6d,0);
	}
	
	@Test
	public void testDivideNOK() {
		CalculadoraService calcService = mock(CalculadoraService.class);
		//when(calcService.divide(6d, 3d)).thenReturn(2d);
		
		assertNotEquals(calcService.divide(6d, 3d), 2d,0);
	}
	
	@Test
	public void testDivideByZero() {
		CalculadoraService calcService = mock(CalculadoraService.class);
		when(calcService.divide(6d, 0d)).thenThrow(ArithmeticException.class);
		
		exception.expect(ArithmeticException.class);
		calcService.divide(6d, 0d);
	}
	

}
