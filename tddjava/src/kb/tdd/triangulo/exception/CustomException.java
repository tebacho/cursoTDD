package kb.tdd.triangulo.exception;

public class CustomException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public CustomException(ErrorMsg ladoIngresadoConValorIncorrecto){
		super(ladoIngresadoConValorIncorrecto.toString());
	}
	
	public enum ErrorMsg{
		NO_SUCH_TRIANGLE, LADO_INGRESADO_CON_VALOR_INCORRECTO;
	}
}
