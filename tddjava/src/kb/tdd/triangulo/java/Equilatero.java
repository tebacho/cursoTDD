package kb.tdd.triangulo.java;

import kb.tdd.triangulo.java.interfaces.Triangulo;

public class Equilatero implements Triangulo {

	public static final String TRIANGULO_EQUILATERO = "Triángulo Equilatero";
	private long xAxys;
	private long yAxys;
	private long zAxys;

	public Equilatero(long lado) {
		this.xAxys=lado;
		this.yAxys=lado;
		this.zAxys=lado;
	}
	@Override
	public String getMensaje() {
		
		return TRIANGULO_EQUILATERO;
	}
	@Override
	public long getxAxys() {
		
		return xAxys;
	}
	public long getyAxys() {
		return yAxys;
	}

	public long getzAxys() {
		return zAxys;
	}
	@Override
	public void draw() {
		System.out.println("dibujando un "+TRIANGULO_EQUILATERO);
		
	}


}
