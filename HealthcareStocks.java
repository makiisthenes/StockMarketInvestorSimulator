package Coursework;    
   

import java.util.ArrayList;

public class HealthcareStocks extends MarketSectors implements java.io.Serializable{
	private static final long serialVersionUID = -1532677899802072109L;
	HealthcareStocks(ArrayList<Stock> options) {
		super("Healthcare", options);
	}
	
	@Override
	public void showStocks() {
		System.out.println("Healthcare Specific Market");
		for (Stock stock: this.getStock_options()) {
			System.out.println(String.format("%s - %s", stock.getShortname(), stock.getStock_fullname()));
		}
	}
}