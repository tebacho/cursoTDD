package kb.empleado.java;

import kb.empleado.exception.BRException;
import static kb.empleado.exception.ErrorMessageEnum.*;

public interface CalculadoraSalarioKB {

	 static final float PORCENTAJE_RETENCION_SOBRE_MILQUINIENTOS = 0.18f;
	 static final float PORCENTAJE_RETENCION_MIL_MILQUINIENTOS = 0.16f;
	 static final int VALOR_HORA_EXTRA = 20;
	
	public float calculaSalario(float salarioBruto);
	public float calculaSalario(Empleado tipoEmpleado, float ventasMes, float horasExtra);
	
}