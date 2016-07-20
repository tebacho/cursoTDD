package cl.kibernum.refactoring;

public class AccountType {

	public boolean isPremium() {
		// TODO Auto-generated method stub
		return false;
	}

	double overdraftCharge(final Account account){
		if(account.getType().isPremium()){
			double result =10;
			if(account.getDaysOverdrawn()>7){
				result += (account.getDaysOverdrawn()-7)*0.85;
			}
			return result;
		} else{
			return account.getDaysOverdrawn()*1.75;
		}
	}

	

}
