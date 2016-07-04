package kb.empleado.test;

import static kb.empleado.exception.ErrorMessageEnum.SALARIO_MENOR_A_CERO;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import kb.empleado.exception.BRException;
import kb.empleado.java.CalculadoraSalarioKB;

public class CalculaSalarioTest {
	private CalculadoraSalarioKB calculadoraSalario;
	
	@Before
	public void setUp() throws Exception {
		calculadoraSalario = new CalculadoraSalarioKB();
	}
	@Rule
	public ExpectedException exception = ExpectedException.none();
	@Test
	public void CalculaSalarioNetoCorrecto() {
		float salarioBruto = 2000f;
		float resultado = 1640f;
		assertEquals(calculadoraSalario.calculaSalarioNeto(salarioBruto),resultado,0);
		
	}
	@Test
	public void CalculaSalarioNetoCorrectoDos() {
		float salarioBruto = 1500f;
		float resultado = 1230f;
		assertEquals(calculadoraSalario.calculaSalarioNeto(salarioBruto),resultado,0);
		
	}
	@Test
	public void CalculaSalarioNetoCorrectoDecimales() {
		float salarioBruto = 1499.99f;
		float resultado = 1259.9916f;
		assertEquals(calculadoraSalario.calculaSalarioNeto(salarioBruto),resultado,0.001);
	}
	@Test
	public void CalculaSalarioNetoCorrectoIntermedio() {
		float salarioBruto = 1250f;
		float resultado = 1050f;
		assertEquals(calculadoraSalario.calculaSalarioNeto(salarioBruto),resultado,0.001);
	}
	@Test
	public void CalculaSalarioNetoCorrectoBordeUno() {
		float salarioBruto = 1000f;
		float resultado = 840f;
		assertEquals(calculadoraSalario.calculaSalarioNeto(salarioBruto),resultado,0.001);
	}
	@Test
	public void CalculaSalarioNetoCorrectoBordeUnoInferior() {
		float salarioBruto = 999.99f;
		float resultado = 999.99f;
		assertEquals(calculadoraSalario.calculaSalarioNeto(salarioBruto),resultado,0.001);
	}
	@Test
	public void CalculaSalarioNetoCorrectoIntermedioUno() {
		float salarioBruto = 500f;
		float resultado = 500f;
		assertEquals(calculadoraSalario.calculaSalarioNeto(salarioBruto),resultado,0.001);
	}
	@Test
	public void CalculaSalarioNetoCorrectoCero() {
		float salarioBruto = 0f;
		float resultado = 0f;
		assertEquals(calculadoraSalario.calculaSalarioNeto(salarioBruto),resultado,0.001);
	}
	@Test
	public void CalculaSalarioNetoIncorrectoNegativo() {
		float salarioBruto = -1f;
		exception.expect(BRException.class);
		exception.expectMessage(SALARIO_MENOR_A_CERO.mensaje);
		calculadoraSalario.calculaSalarioNeto(salarioBruto);
	}
	
	

}
