package kb.tdd.triangulo.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import kb.tdd.triangulo.exception.CustomException;
import kb.tdd.triangulo.exception.CustomException.ErrorMsg;
import kb.tdd.triangulo.java.Equilatero;
import kb.tdd.triangulo.java.Escaleno;
import kb.tdd.triangulo.java.Isosceles;
import kb.tdd.triangulo.java.TrianguloUtil;
import kb.tdd.triangulo.java.interfaces.Triangulo;

public class TrianguloTest {
	TrianguloUtil trianguloUtil;
	String mensaje;
	
	@Before
	public void setUp() throws Exception {
		trianguloUtil = new TrianguloUtil();
	}
	
	@Rule
	public ExpectedException exception = ExpectedException.none();
	
	
	@Test
	public void equilateroTest() {
		long xAxys=90, yAxys=90, zAxys = 90;
		mensaje = Equilatero.TRIANGULO_EQUILATERO;
		Triangulo triangulo = trianguloUtil.generarTriangulo(xAxys,yAxys,zAxys);
		assertEquals(mensaje,triangulo.getMensaje());
		
		
	}
	@Test
	public void isoscelesTest() {
		long xAxys=80, yAxys=90, zAxys = 90;
		mensaje = Isosceles.TRIANGULO_ISOSCELES;
		Triangulo triangulo = trianguloUtil.generarTriangulo(xAxys,yAxys,zAxys);
		assertEquals(mensaje,triangulo.getMensaje());
	}
	@Test
	public void escalenoTest() {
		long xAxys=70, yAxys=80, zAxys = 90;
		mensaje = Escaleno.TRIANGULO_ESCALENO;
		Triangulo triangulo = trianguloUtil.generarTriangulo(xAxys,yAxys,zAxys);
		assertEquals(mensaje,triangulo.getMensaje());
	}
	
	@Test
	public void xNegativeInputTest() {
		long xAxys=-70, yAxys=80, zAxys = 90;
		exception.expect(CustomException.class);
		exception.expectMessage(ErrorMsg.LADO_INGRESADO_CON_VALOR_INCORRECTO.toString());
		trianguloUtil.generarTriangulo(xAxys,yAxys,zAxys);	
	}
	
	@Test
	public void yNegativeInputTest() {
		long xAxys=70, yAxys=-80, zAxys = 90;
		exception.expect(CustomException.class);
		exception.expectMessage(ErrorMsg.LADO_INGRESADO_CON_VALOR_INCORRECTO.toString());
		trianguloUtil.generarTriangulo(xAxys,yAxys,zAxys);		
	}
	
	@Test
	public void zNegativeInputTest() {
		long xAxys=70, yAxys=80, zAxys = -90;
		exception.expect(CustomException.class);
		exception.expectMessage(ErrorMsg.LADO_INGRESADO_CON_VALOR_INCORRECTO.toString());
		trianguloUtil.generarTriangulo(xAxys,yAxys,zAxys);
	}
	
	@Test
	public void xZeroInputTest() {
		long xAxys=0, yAxys=80, zAxys = 90;
		exception.expect(CustomException.class);
		exception.expectMessage(ErrorMsg.LADO_INGRESADO_CON_VALOR_INCORRECTO.toString());
		trianguloUtil.generarTriangulo(xAxys,yAxys,zAxys);	
	}
	
	@Test
	public void yZeroInputTest() {
		long xAxys=70, yAxys=0, zAxys = 90;
		exception.expect(CustomException.class);
		exception.expectMessage(ErrorMsg.LADO_INGRESADO_CON_VALOR_INCORRECTO.toString());
		trianguloUtil.generarTriangulo(xAxys,yAxys,zAxys);		
	}
	
	@Test
	public void zZeroInputTest() {
		long xAxys=70, yAxys=80, zAxys = 0;
		exception.expect(CustomException.class);
		exception.expectMessage(ErrorMsg.LADO_INGRESADO_CON_VALOR_INCORRECTO.toString());
		trianguloUtil.generarTriangulo(xAxys,yAxys,zAxys);
	}
	
	
	
}
