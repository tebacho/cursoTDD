package cl.kibernum.refactoring;

public class Person {

	private String name;
	private final TelephoneNumber telephoneNumber = new TelephoneNumber();
	
	public String getTelephoneNumber(){
		return telephoneNumber.getTelephoneNumber();
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}
	
}
