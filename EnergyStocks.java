package Coursework; 

import java.util.ArrayList;

public class EnergyStocks extends MarketSectors implements java.io.Serializable{
	private static final long serialVersionUID = -5757394842962057356L;

	EnergyStocks(ArrayList<Stock> options) {
		super("Energy", options);
	}
	
	@Override
	public void showStocks() {
		System.out.println("Energy Specific Market");
		for (Stock stock: this.getStock_options()) {
			System.out.println(String.format("%s - %s", stock.getShortname(), stock.getStock_fullname()));
		}
	}
	
}
