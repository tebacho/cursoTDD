package kb.tdd.triangulo.java;

import kb.tdd.triangulo.java.interfaces.Triangulo;

public class TrianguloFactory {

	private static TrianguloFactory instance;
	private TrianguloFactory(){
		
	}
	
	public static TrianguloFactory getInstance() {
		if(instance==null){
			instance = new TrianguloFactory();
		}
		return instance;
	}
	
	public Equilatero getEquilatero(long lado){
		return new Equilatero(lado);
	}

	public Triangulo getEscaleno(long xLado,long yLado,long zLado) {
		
		return new Escaleno(xLado,yLado,zLado);
	}

	public Triangulo getIsosceles(long xLado,long yLado,long zLado) {
		
		return new Isosceles(xLado,yLado,zLado);
	}
	
	
	
}
