package kb.empleado.test;

import static kb.empleado.exception.ErrorMessageEnum.SALARIO_MENOR_A_CERO;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import kb.empleado.exception.BRException;
import kb.empleado.exception.ErrorMessageEnum;
import kb.empleado.java.CalculadoraSalarioKB;
import kb.empleado.java.Empleado;
import kb.empleado.java.Encargado;
import kb.empleado.java.Vendedor;

public class CalculaSalarioTest {
	private CalculadoraSalarioKB calculadoraSalario;
	private Empleado vendedor;
	private Empleado encargado;
	
	@Before
	public void setUp() throws Exception {
		calculadoraSalario = new CalculadoraSalarioKB();
		vendedor = new Vendedor();
		encargado = new Encargado();
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
	@Test
	public void CalculaSalarioBrutoVendedorCorrecto() {
		float ventasMes = 2000f;
		float horasExtra = 8;
		float SalarioBrutoEsperado = 1360;
		assertEquals(SalarioBrutoEsperado,calculadoraSalario.calculaSalarioBruto(vendedor, ventasMes, horasExtra),0);
	}
	@Test
	public void CalculaSalarioBrutoVendedorCorrectoBordeVenta() {
		float ventasMes = 1500;
		float horasExtra = 3;
		float SalarioBrutoEsperado = 1260;
		assertEquals(SalarioBrutoEsperado,calculadoraSalario.calculaSalarioBruto(vendedor, ventasMes, horasExtra),0);
	}
	@Test
	public void CalculaSalarioBrutoVendedordecimales() {
		float ventasMes = 1499.99f;
		float horasExtra = 0;
		float SalarioBrutoEsperado = 1100;
		assertEquals(SalarioBrutoEsperado,calculadoraSalario.calculaSalarioBruto(vendedor, ventasMes, horasExtra),0);
	}
	@Test
	public void CalculaSalarioBrutoEncargado() {
		float ventasMes = 1250f;
		float horasExtra = 8;
		float SalarioBrutoEsperado = 1760;
		assertEquals(SalarioBrutoEsperado,calculadoraSalario.calculaSalarioBruto(encargado, ventasMes, horasExtra),0);
	}
	@Test
	public void CalculaSalarioBrutoEncargadoMilUsd() {
		float ventasMes = 1000f;
		float horasExtra = 0;
		float SalarioBrutoEsperado = 1600;
		assertEquals(SalarioBrutoEsperado,calculadoraSalario.calculaSalarioBruto(encargado, ventasMes, horasExtra),0);
	}
	@Test
	public void CalculaSalarioBrutoEncargadoFronteraMil() {
		float ventasMes = 999.99f;
		float horasExtra = 3;
		float SalarioBrutoEsperado = 1560;
		assertEquals(SalarioBrutoEsperado,calculadoraSalario.calculaSalarioBruto(encargado, ventasMes, horasExtra),0);
	}
	@Test
	public void CalculaSalarioBrutoEncargadoMedio() {
		float ventasMes = 500f;
		float horasExtra = 0;
		float SalarioBrutoEsperado = 1500;
		assertEquals(SalarioBrutoEsperado,calculadoraSalario.calculaSalarioBruto(encargado, ventasMes, horasExtra),0);
	}
	@Test
	public void CalculaSalarioBrutoEncargadoSinVentas() {
		float ventasMes = 0f;
		float horasExtra = 8;
		float SalarioBrutoEsperado = 1660;
		assertEquals(SalarioBrutoEsperado,calculadoraSalario.calculaSalarioBruto(encargado, ventasMes, horasExtra),0);
	}
	@Test
	public void CalculaSalarioBrutoEncargadoErrorDolar() {
		float ventasMes = -1f;
		float horasExtra = 1;
		exception.expect(BRException.class);
		exception.expectMessage(ErrorMessageEnum.VENTAS_MES_NEGATIVO.mensaje);
		calculadoraSalario.calculaSalarioBruto(encargado, ventasMes, horasExtra);
	}
	@Test
	public void CalculaSalarioBrutoEncargadoErrorHoras() {
		float ventasMes = 0f;
		float horasExtra = -1;
		exception.expect(BRException.class);
		exception.expectMessage(ErrorMessageEnum.HORAS_EXTRA_NEGATIVO.mensaje);
		calculadoraSalario.calculaSalarioBruto(encargado, ventasMes, horasExtra);
	}
	@Test
	public void CalculaSalarioBrutoNullEmpleado() {
		float ventasMes = 10f;
		float horasExtra = 10;
		exception.expect(BRException.class);
		exception.expectMessage(ErrorMessageEnum.NO_SUCH_EMPLEADO.mensaje);
		calculadoraSalario.calculaSalarioBruto(null, ventasMes, horasExtra);
	}

}
