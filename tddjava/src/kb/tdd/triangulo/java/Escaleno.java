package kb.tdd.triangulo.java;

import kb.tdd.triangulo.java.interfaces.Triangulo;

public class Escaleno implements Triangulo {

	public static final String TRIANGULO_ESCALENO = "Triángulo Escaleno";
	private long xAxys;
	private long yAxys;
	private long zAxys;
	
	public Escaleno(long xLado, long yLado, long zLado) {
		this.xAxys=xLado;
		this.yAxys=yLado;
		this.zAxys=zLado;
	}

	@Override
	public long getxAxys() {
		return xAxys;
	}

	@Override
	public String getMensaje() {
		
		return TRIANGULO_ESCALENO;
	}

	public long getyAxys() {
		return yAxys;
	}
	public long getzAxys() {
		return zAxys;
	}

}
