package cl.kibernum.refactoring;

public class Account {
	private AccountType type;
	private int daysOverdrawn;
	
	double overdraftCharge(){
		return type.overdraftCharge(this);
	}
	
	double bankCharge(){
		double result = 4.5;
		if(daysOverdrawn>0){
			result+=overdraftCharge();
		}
		return result;
	}

	public AccountType getType() {
		return type;
	}

	public void setType(final AccountType type) {
		this.type = type;
	}

	public int getDaysOverdrawn() {
		return daysOverdrawn;
	}

	public void setDaysOverdrawn(final int daysOverdrawn) {
		this.daysOverdrawn = daysOverdrawn;
	}
	
}
