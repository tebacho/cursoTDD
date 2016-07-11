package kb.tdd.imc.enumeracion;

import kb.tdd.imc.exception.NoSuchClasificationException;

public enum ImcClasification {
	
	BAJO_PESO(0.0f,17.9f,"Peso bajo. Necesario valorar signos de desnutrición"),
	NORMAL(18.0f,24.9f,"Normal"),
	SOBREPESO(25.0f,26.9f,"Sobrepeso"),
	OBESIDAD_GRADO_UNO(27.0f,29.9f,"Obesidad grado I. Riesgo relativo alto para desarrollar enfermedades cardiovasculares"),
	OBESIDAD_GRADO_DOS(30.0f,39.9f,"Obesidad grado II. Riesgo relativo muy alto para desarrollar enfermedades cardiovasculares"),
	OBESIDAD_GRADO_TRES(40.0f,99f,"Obesidad grado III Extrema o mórbida. Riesgo relativo extremadamente alto para desarrollar enfermedades cardiovasculares");
	
	public static final String IMC_FUERA_DE_RANGO = "IMC fuera de rango";
	private float imcMinimo;
	private float imcMaximo;
	private String clasificacion;
	private ImcClasification(float imcMinimo, float imcMaximo, String clasificacion){
		this.imcMinimo= imcMinimo;
		this.imcMaximo= imcMaximo;
		this.clasificacion=clasificacion;
	}
	public float getImcMinimo() {
		return imcMinimo;
	}
	public float getImcMaximo() {
		return imcMaximo;
	}
	public String getClasificacion() {
		return clasificacion;
	}
	public static ImcClasification getClasificacionByImc(float imc){
		for(ImcClasification clasif : ImcClasification.values()){
			if(clasif.imcMinimo<imc&&imc<clasif.imcMaximo){
				return clasif;
			}
		}
		throw new NoSuchClasificationException(IMC_FUERA_DE_RANGO);
	}
	
}
