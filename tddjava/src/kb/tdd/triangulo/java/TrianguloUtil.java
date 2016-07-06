package kb.tdd.triangulo.java;

import kb.tdd.triangulo.exception.CustomException;
import kb.tdd.triangulo.exception.CustomException.ErrorMsg;
import kb.tdd.triangulo.java.interfaces.Triangulo;

public class TrianguloUtil {



	public Triangulo generarTriangulo(long xAxys, long yAxys, long zAxys) {
		
		if(xAxys<=0 || yAxys<=0 || zAxys<=0){
			throw new CustomException(ErrorMsg.LADO_INGRESADO_CON_VALOR_INCORRECTO);
		}
		
		if(validaEquilatero(xAxys, yAxys, zAxys)){
			return TrianguloFactory.getInstance().getEquilatero(xAxys);
			
		}else if(validaEscaleno(xAxys, yAxys, zAxys)){
			return TrianguloFactory.getInstance().getEscaleno(xAxys, yAxys, zAxys);
		
		}else if(validaIsosceles(xAxys, yAxys, zAxys)){
			return TrianguloFactory.getInstance().getIsosceles(xAxys, yAxys, zAxys);
		
		}
		
		throw new CustomException(ErrorMsg.NO_SUCH_TRIANGLE);
		
	}

	private boolean validaIsosceles(long xAxys, long yAxys, long zAxys) {
		return (xAxys==yAxys && xAxys!=zAxys) || (zAxys==yAxys && xAxys!=zAxys) || (zAxys==xAxys && xAxys!=yAxys);
	}

	private boolean validaEscaleno(long xAxys, long yAxys, long zAxys) {
		return xAxys!=yAxys && xAxys!=zAxys && yAxys!=zAxys;
	}

	private boolean validaEquilatero(long xAxys, long yAxys, long zAxys) {
		return xAxys==yAxys&&xAxys==zAxys;
	}
	

}
