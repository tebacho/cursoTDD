package kb.tdd.imc;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import kb.tdd.imc.enumeracion.ImcClasification;
import kb.tdd.imc.exception.InvalidInputException;

public class ImcCalculatorTest {
	
	private ImcCalculator imcCalculator;
	
	@Before
	public void setUp() {
		imcCalculator = new ImcCalculator();
	}
	
	@Rule
	public ExpectedException exception = ExpectedException.none();
	
	@Test
	public void calculaImcBajoPeso() {
		float pesoKg = 40;
		float estaturaMetros = 1.75f;
		ImcClasification clasif = imcCalculator.getClasificacionImc(pesoKg, estaturaMetros);
		assertEquals(ImcClasification.BAJO_PESO.toString(),clasif.toString());
	}
	@Test
	public void obtenerClasificacionNormal() {
		float pesoKg = 70;
		float estaturaMetros = 1.75f;
		ImcClasification clasif = imcCalculator.getClasificacionImc(pesoKg, estaturaMetros);
		assertEquals(ImcClasification.NORMAL.toString(),clasif.toString());
	}
	@Test
	public void getClasificacionSobrePeso() {
		float pesoKg = 80;
		float estaturaMetros = 1.75f;
		ImcClasification clasif = imcCalculator.getClasificacionImc(pesoKg, estaturaMetros);
		assertEquals(ImcClasification.SOBREPESO.toString(),clasif.toString());
	}
	@Test
	public void getClasificacionImcObesidadUno() {
		float pesoKg = 90;
		float estaturaMetros = 1.75f;
		ImcClasification clasif = imcCalculator.getClasificacionImc(pesoKg, estaturaMetros);
		assertEquals(ImcClasification.OBESIDAD_GRADO_UNO.toString(),clasif.toString());
	}
	@Test
	public void getClasificacionImcObesidadDos() {
		float pesoKg = 100;
		float estaturaMetros = 1.75f;
		ImcClasification clasif = imcCalculator.getClasificacionImc(pesoKg, estaturaMetros);
		assertEquals(ImcClasification.OBESIDAD_GRADO_DOS.toString(),clasif.toString());
	}
	@Test
	public void getClasificacionImcObesidadTres() {
		float pesoKg = 150;
		float estaturaMetros = 1.75f;
		ImcClasification clasif = imcCalculator.getClasificacionImc(pesoKg, estaturaMetros);
		assertEquals(ImcClasification.OBESIDAD_GRADO_TRES.toString(),clasif.toString());
	}
	@Test
	public void calculaImcPesoNegativo() {
		float pesoKg = -60;
		float estaturaMetros = 1.75f;
		exception.expect(InvalidInputException.class);
		exception.expectMessage(ImcCalculator.VALORES_INGRESADOS_INVALIDOS);
		imcCalculator.getClasificacionImc(pesoKg, estaturaMetros);
	}
	@Test
	public void calculaImcEstaturaNegativo() {
		float pesoKg = 60;
		float estaturaMetros = -1.75f;
		exception.expect(InvalidInputException.class);
		exception.expectMessage(ImcCalculator.VALORES_INGRESADOS_INVALIDOS);
		imcCalculator.getClasificacionImc(pesoKg, estaturaMetros);
	}
	
	@Test
	public void calculaImcBajo() {
		float pesoKg = 40;
		float estaturaMetros = 1.75f;
		float imsEsperado = 13f;
		assertEquals(imsEsperado, imcCalculator.getImc(pesoKg,estaturaMetros),0);
	}
	@Test
	public void calculaImcNormal() {
		float pesoKg = 70;
		float estaturaMetros = 1.75f;
		float imsEsperado = 22.8f;
		assertEquals(imsEsperado, imcCalculator.getImc(pesoKg,estaturaMetros),0);
	}
	@Test
	public void calculaImcSobrePeso() {
		float pesoKg = 80;
		float estaturaMetros = 1.75f;
		float imsEsperado = 26.1f;
		assertEquals(imsEsperado, imcCalculator.getImc(pesoKg,estaturaMetros),0);
	}
	@Test
	public void calculaImcObesidadUno() {
		float pesoKg = 90;
		float estaturaMetros = 1.75f;
		float imsEsperado = 29.3f;
		assertEquals(imsEsperado, imcCalculator.getImc(pesoKg,estaturaMetros),0);
	}
	@Test
	public void calculaImcObesidadDos() {
		float pesoKg = 100;
		float estaturaMetros = 1.75f;
		float imsEsperado = 32.6f;
		assertEquals(imsEsperado, imcCalculator.getImc(pesoKg,estaturaMetros),0);
	}
	@Test
	public void calculaImcObesidadTres() {
		float pesoKg = 150;
		float estaturaMetros = 1.75f;
		float imsEsperado = 48.9f;
		assertEquals(imsEsperado, imcCalculator.getImc(pesoKg,estaturaMetros),0);
	}
}
