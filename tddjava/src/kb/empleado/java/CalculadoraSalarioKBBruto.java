package kb.empleado.java;

import static kb.empleado.exception.ErrorMessageEnum.HORAS_EXTRA_NEGATIVO;
import static kb.empleado.exception.ErrorMessageEnum.NO_SUCH_EMPLEADO;
import static kb.empleado.exception.ErrorMessageEnum.VENTAS_MES_NEGATIVO;

import kb.empleado.exception.BRException;

public class CalculadoraSalarioKBBruto implements CalculadoraSalarioKB {

	public float calculaSalario(Empleado tipoEmpleado, float ventasMes, float horasExtra) {
		if (tipoEmpleado == null) {
			throw new BRException(NO_SUCH_EMPLEADO.mensaje);
		}
		float base = tipoEmpleado.getSalarioBase();
		float prima = calculaPrima(ventasMes);
		float pagoHoraExtra = calculaPagoHorasExtra(horasExtra);
		
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

	@Override
	public float calculaSalario(float salarioBruto) {
		throw new RuntimeException("No implementado");
	}
}
