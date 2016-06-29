package tddjava.descuento;

public class CalculadorPrecioFinal{

	public int calculaPrecioFinal(int precioUnitario, int descuento) {
		if(precioUnitario<=0 || descuento<0 || descuento>100){
			throw new IllegalArgumentException();
		}
		return (int)Math.round((precioUnitario*((100-descuento)/100.0)));
		
	}

}
