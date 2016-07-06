package kb.tdd.triangulo.java;

import kb.tdd.triangulo.java.interfaces.Triangulo;

public class Isosceles implements Triangulo {

	public static final String TRIANGULO_ISOSCELES = "Triángulo Isosceles";
	private long xAxys;
	private long yAxys;
	private long zAxys;
	
	
	public Isosceles(long xLado, long yLado, long zLado) {
		this.xAxys=xLado;
		this.yAxys=yLado;
		this.zAxys=zLado;
	}


	@Override
	public String getMensaje() {
		
		return TRIANGULO_ISOSCELES;
	}

	@Override
	public long getxAxys() {
		return xAxys;
	}

	@Override
	public long getyAxys() {
		return yAxys;
	}

	@Override
	public long getzAxys() {
		return zAxys;
	}
}
