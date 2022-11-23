package Coursework;        

import java.util.ArrayList;

public class IndustrialStocks extends MarketSectors implements java.io.Serializable{
	private static final long serialVersionUID = 401786530177953791L;

	IndustrialStocks(ArrayList<Stock> options) {
		super("Industrial", options);
	}
	
	@Override
	public void showStocks() {
		System.out.println("Industrial Specific Market");
		for (Stock stock: this.getStock_options()) {
			System.out.println(String.format("%s - %s", stock.getShortname(), stock.getStock_fullname()));
		}
	}
}