package tddjava;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestMatematicas {

	@Test
	public void testAdd() {
		int num1=3;
		int num2=2;
		int result=6;
		assertEquals(Matematicas.suma(num1, num2), result);
		
	}

}
