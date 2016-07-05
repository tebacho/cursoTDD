package kb.empleado.java;

public class CalculadoraFactory {

	private static CalculadoraFactory instance;
	
	private CalculadoraFactory(){
		
	}
	
	public static CalculadoraFactory getInstance(){
		if(instance==null){
			instance = new CalculadoraFactory();
		}
		return instance;
	}
	public CalculadoraSalarioKBNeto getCalculadoraSalarioKBNeto(){
		return new CalculadoraSalarioKBNeto();
	}
	public CalculadoraSalarioKBBruto getCalculadoraSalarioKBBruto(){
		return new CalculadoraSalarioKBBruto();
	}
	
}
