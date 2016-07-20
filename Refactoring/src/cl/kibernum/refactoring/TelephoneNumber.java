package cl.kibernum.refactoring;

public class TelephoneNumber {

	private String officeAreaCode;
	private String officeNumber;
	
	public String getTelephoneNumber(){
		return ("("+officeAreaCode+")"+officeNumber);
	}
	
	public String getOfficeAreaCode() {
		return officeAreaCode;
	}
	public void setOfficeAreaCode(final String officeAreaCode) {
		this.officeAreaCode = officeAreaCode;
	}
	public String getOfficeNumber() {
		return officeNumber;
	}
	public void setOfficeNumber(final String officeNumber) {
		this.officeNumber = officeNumber;
	}
	
	
}
