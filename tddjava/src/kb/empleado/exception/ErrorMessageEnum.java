package kb.empleado.exception;

public enum ErrorMessageEnum {
	SALARIO_MENOR_A_CERO("Salario menor a cero"),
	ERROR_INGRESO_VALORES("Valores ingresados no son válidos"),
	NO_SUCH_EMPLEADO("Tipo de Empleado no registrado"),
	HORAS_EXTRA_NEGATIVO("Item Hora Extra no puede ser menor a 0"),
	VENTAS_MES_NEGATIVO("Monto ventas mes no puede ser negativo");
	public final String mensaje;
	private ErrorMessageEnum(String mensaje) {
		this.mensaje = mensaje;
	}
}
