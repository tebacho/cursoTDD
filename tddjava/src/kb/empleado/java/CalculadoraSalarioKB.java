package kb.empleado.java;

import kb.empleado.exception.BRException;
import static kb.empleado.exception.ErrorMessageEnum.*;

public class CalculadoraSalarioKB {

	private static final float PORCENTAJE_RETENCION_SOBRE_MILQUINIENTOS = 0.18f;
	private static final float PORCENTAJE_RETENCION_MIL_MILQUINIENTOS = 0.16f;
	private static final int VALOR_HORA_EXTRA = 20;

	public float calculaSalarioNeto(float salarioBruto) {
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

	public float calculaSalarioBruto(Empleado tipoEmpleado, float ventasMes, float horasExtra) {
		if (tipoEmpleado == null) {
			throw new BRException(NO_SUCH_EMPLEADO.mensaje);
		}
		float base = tipoEmpleado.getSalarioBase();
		float prima = 0;
		float pagoHoraExtra;
		prima = calculaPrima(ventasMes);
		pagoHoraExtra = calculaPagoHorasExtra(horasExtra);

		return base + prima + pagoHoraExtra;
	}

	private float calculaPagoHorasExtra(float horasExtra) {
		if (horasExtra < 0) {
			throw new BRException(HORAS_EXTRA_NEGATIVO.mensaje);
		}
		return VALOR_HORA_EXTRA * horasExtra;
	}

	private float calculaPrima(float ventasMes) {
		if (ventasMes < 0) {
			throw new BRException(VENTAS_MES_NEGATIVO.mensaje);
		}
		float prima = 0f;
		if (ventasMes >= 1500) {
			prima = 200;
		} else if (ventasMes >= 1000) {
			prima = 100;
		}
		return prima;
	}
}