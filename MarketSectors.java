package Coursework;    
 
import java.util.ArrayList;

/* This class will simulate the operations of specific market and will be used to add Stock objects to it. */
public abstract class MarketSectors implements java.io.Serializable{
	private static final long serialVersionUID = -1445908288576258907L;
	private String market_type;
	private ArrayList<Stock> stock_options = new ArrayList<Stock>();
	MarketSectors(String type, ArrayList<Stock> options){
		this.setMarket_type(type);
		this.setStock_options(options);
	};
	public String getMarket_type() {
		return market_type;
	}
	public void setMarket_type(String market_type) {
		this.market_type = market_type;
	}
	public ArrayList<Stock> getStock_options() {
		return stock_options;
	}
	public void setStock_options(ArrayList<Stock> stock_options) {
		this.stock_options = stock_options;
	}
	public void showStocks() {
		System.out.println("Specific Market");
		for (Stock stock: this.getStock_options()) {
			System.out.println(String.format("%s - %s", stock.getShortname(), stock.getStock_fullname()));
		}
	}
}











