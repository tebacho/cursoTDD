package kb.empleado.java;

import static kb.empleado.exception.ErrorMessageEnum.SALARIO_MENOR_A_CERO;

import javax.management.RuntimeErrorException;

import kb.empleado.exception.BRException;

public class CalculadoraSalarioKBNeto implements CalculadoraSalarioKB {

	public float calculaSalario(float salarioBruto) {
		float retencion = calculaRetencion(salarioBruto);
		return calculaPago(salarioBruto, retencion);
	}

	private float calculaRetencion(float salarioBruto) {
		if (salarioBruto < 0) {
			throw new BRException(SALARIO_MENOR_A_CERO.mensaje);
		} else if (salarioBruto < 1000) {
			return 0;
		} else if (salarioBruto < 1500) {
			return PORCENTAJE_RETENCION_MIL_MILQUINIENTOS;
		} else {
			return PORCENTAJE_RETENCION_SOBRE_MILQUINIENTOS;
		}
	}

	private float calculaPago(float salarioBruto, float desc) {
		return Math.round((long) ((salarioBruto * (1 - desc)) * 10000)) / 10000f;
	}

	@Override
	public float calculaSalario(Empleado tipoEmpleado, float ventasMes, float horasExtra) {
		throw new RuntimeException("No implementado");
	}

	
}
