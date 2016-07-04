package kb.empleado.java;

import kb.empleado.exception.BRException;
import static kb.empleado.exception.ErrorMessageEnum.*;

public class CalculadoraSalarioKB {

	public float calculaSalarioNeto(float salarioBruto) {
		if (salarioBruto<0){
			throw new BRException(SALARIO_MENOR_A_CERO.mensaje);
		}
		if(salarioBruto<1000){
			return round(salarioBruto);
		}else if(salarioBruto<1500){
			return round(salarioBruto,0.16f);
		}else{
			return round(salarioBruto,0.18f);
		}
	}
	private float round(float salarioBruto){
		return round(salarioBruto, 0);
	}
private float round(float salarioBruto, float desc){
	return Math.round((salarioBruto*(1-desc))*10000)/10000f;
}
}