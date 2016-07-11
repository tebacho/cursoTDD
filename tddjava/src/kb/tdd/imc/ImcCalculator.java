package kb.tdd.imc;

import kb.tdd.imc.enumeracion.ImcClasification;
import kb.tdd.imc.exception.InvalidInputException;

public class ImcCalculator {

	public static final String VALORES_INGRESADOS_INVALIDOS = "Valores ingresados inválidos";

	public ImcClasification getClasificacionImc(float pesoKg, float estaturaMetros) {
			float imc = getImc(pesoKg, estaturaMetros);
			return getClasificacionImc(imc);
	}
	
	public ImcClasification getClasificacionImc(float imc) {
		return ImcClasification.getClasificacionByImc(imc);
	}

	public float getImc(float pesoKg, float estaturaMetros) {
		if(pesoKg<=0 || estaturaMetros<=0){
			throw new InvalidInputException(VALORES_INGRESADOS_INVALIDOS);
		}
		return ((int)(pesoKg/(estaturaMetros*estaturaMetros)*10))/10.0f;
	}
	

}
