package cl.kibernum.refactoring;

import java.util.ArrayList;
import java.util.List;

public class Refactoring {
	
	private static final int DEFAULT_AMOUNT = 100;
	private final List<Integer> list = new ArrayList<>();
	private int numberOfDeliveries;
	private Order anOrder;
	private int quantity;
	private int itemPrice;
	private String platform;
	private int resize;

	public void printAmount(){
		int amount = DEFAULT_AMOUNT;
		amount = getAmount(amount);
		printDetails(amount);
	}
	public int getRating(){
		return (numberOfDeliveries>5)?2:1;
	}
	
	private int getAmount(int amount) {
		for(final Integer integer : list){
			amount+=integer;
		}
		return amount;
	}

	private void printDetails(final int amount) {
		System.out.println("amount "+amount);
		
	}
	
	// InlineTemp
	public boolean test(){
		return anOrder.getPrice() > 1000;
	}
	
	//Replace Temp With Query
	public double testBasePrice(){
		final double basePrice = getBasePrice();
		if(basePrice>1000){
			return itemPrice*0.95;
		}else{
			return itemPrice*0.98;
		}
	}
	private int getBasePrice() {
		return quantity * itemPrice;
	}
	//5.- Introduce Explaining Variable
	public void tesExplainingVariables(){
		
		final boolean IsMacOS = platform.toUpperCase().indexOf("MAC")> -1;
		final boolean isIEBrowser = platform.toUpperCase().indexOf("IE")> -1;
		final boolean wasResized = resize >0;
		if( IsMacOS && isIEBrowser && wasInitialized() && wasResized
			){
			//TODO Include code here
		}
	}
	private boolean wasInitialized() {
		// TODO Auto-generated method stub
		return false;
	}
	
	//6.- Remove Asignments to parameters
	public void discount(int inputVal, final int quantity, final int yearToDate){
		
		if (inputVal>50){
			inputVal-=2;
		}
		//do stg;
	}
	//queda
	public void discountRf(final int inputVal,final  int quantity,final  int yearToDate){
		int result = inputVal;
		if (result>50){
			result-=2;
		}
		//do stg;
	}
	
	//.- Move Method
	/*
	 * En Clase Account
	 */
	
	//.- 8.- Extract Class
	
	/*
	 * Clase Persona
	 */
}
