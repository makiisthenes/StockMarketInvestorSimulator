package Coursework;   

import java.util.ArrayList;

public class ConsumerStocks extends MarketSectors implements java.io.Serializable{
	private static final long serialVersionUID = 8730523416688227317L;

	ConsumerStocks(ArrayList<Stock> options) {
		super("Consumer", options);
	}
	
	@Override
	public void showStocks() {
		System.out.println("Consumer Specific Market");
		for (Stock stock: this.getStock_options()) {
			System.out.println(String.format("%s - %s", stock.getShortname(), stock.getStock_fullname()));
		}
	}
}
