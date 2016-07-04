package kb.empleado.exception;

public enum ErrorMessageEnum {
	SALARIO_MENOR_A_CERO("Salario menor a cero");
	public final String mensaje;
	private ErrorMessageEnum(String mensaje) {
		this.mensaje = mensaje;
	}
}
