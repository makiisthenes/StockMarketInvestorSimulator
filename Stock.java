package Coursework;     
/*
 * @author: Michael Peres
 *  01/03/2021
 */

import java.text.DecimalFormat;

/* Stock Class for all stock in this market simulation */  // Completed
@SuppressWarnings("unused")
public class Stock implements java.io.Serializable{
	private static final long serialVersionUID = 1791537827816689568L;
	DecimalFormat df = new DecimalFormat("#.00");
	static final long BILLION = 1000000000L;
	// Properties of Stock
	private String stock_fullname;
	private String shortname; // GME
	private String market_name;
	private float market_cap; // Actual Price * Shares
	private float buy_price;
	private float sell_price;
	private float actual_price;
	private float net_profit;
	private float eps; // Earning per share, total earnings / stock_volume;
	private int stock_volume; // Total Amount Stocks
	private int min_buy_qty = 1;
	private char currency; // Currencies available: $ | £
	
	public Stock(String fullname, String shortnm, String marktn,  float bprice, float sprice, float aprice, float eps, int stockvol, int minqty, char crcny) {
		this.setStock_fullname(fullname);
		this.setShortname(shortnm);
		this.setMarket_name(marktn);
		this.setBuy_price(bprice);
		this.setSell_price(sprice);
		this.setActual_price(aprice);
		this.setEps(eps);
		this.setStock_volume(stockvol);
		this.setMin_buy_qty(minqty);
		this.setCurrency(crcny);
	}
	
	
	/* Getter and Setter Methods */
	public void setShortname(String shortnm) {
		this.shortname = shortnm;
	}

	public void setMarket_cap(float market_cap) {
		this.market_cap = market_cap;
	}
	
	public float getMarket_cap() {
		return getCalculatedMarketCap();
	}
	
	public String getStock_fullname() {
		return stock_fullname;
	}
	public void setStock_fullname(String stock_fullname) {
		this.stock_fullname = stock_fullname;
	}
	public String getShortname() {
		return shortname;
	}

	public String getMarket_name() {
		return market_name;
	}

	public void setMarket_name(String market_name) {
		this.market_name = market_name;
	}

	public float getBuy_price() {
		return buy_price;
	}

	public void setBuy_price(float buy_price) {
		buy_price = Float.valueOf(df.format(buy_price));
		this.buy_price = buy_price;
	}

	public float getSell_price() {
		return sell_price;
	}

	public void setSell_price(float sell_price) {
		sell_price = Float.valueOf(df.format(sell_price));
		this.sell_price = sell_price;
	}

	public float getActual_price() {
		return actual_price;
	}

	public void setActual_price(float actual_price) {
		actual_price = Float.valueOf(df.format(actual_price));
		this.actual_price = actual_price;
	}

	public float getEps() {
		return eps;
	}

	public void setEps(float eps) {
		this.eps = eps;
	}

	public int getMin_buy_qty() {
		return min_buy_qty;
	}

	public void setMin_buy_qty(int min_buy_qty) {
		this.min_buy_qty = min_buy_qty;
	}

	public int getStock_volume() {
		return stock_volume;
	}

	public void setStock_volume(int stock_volume) {
		this.stock_volume = stock_volume;
	}

	public char getCurrency() {
		return currency;
	}

	public void setCurrency(char currency) {
		this.currency = currency;
	}
	
	public void setNetProfit(float profit) {
		this.net_profit = profit;
	}
	
	public float getNetProfit() {
		float profit = getCalculatedNetProfit();
		return profit;
	}
	

	/* Will Calculate through Actual Price * Shares values */
	public float getCalculatedMarketCap() {
		float marketCap = this.getActual_price() * this.getStock_volume();
		DecimalFormat df = new DecimalFormat("#.00");
		marketCap = Float.valueOf(df.format(marketCap));
		this.setMarket_cap(marketCap);
		return marketCap;
	}
	
	
	/* Will calculate net profit through EPS * stock volume*/
	public float getCalculatedNetProfit() {
		float netProfit = this.getEps() * this.getStock_volume();
		DecimalFormat df = new DecimalFormat("#.00");
		netProfit = Float.valueOf(df.format(netProfit));
		this.setNetProfit(netProfit);
		return netProfit;
	}
	
	
	/* Showing specific stock information */
	public void showStockInfo() {
		System.out.println("Stock Name: " + this.getStock_fullname());
		System.out.println("Stock Code: " + this.getShortname());
		System.out.println("Market Name: " + this.getMarket_name());
		System.out.println("Buy Price: " + this.getBuy_price());
		System.out.println("Sell Price: " + this.getSell_price());
		System.out.println("Actual Price: " + this.getActual_price());
		System.out.println("Earning per Share: " + this.getEps());
		System.out.println("Min Buy Qnty: " + this.getMin_buy_qty());
		System.out.println("Stock Volume: " + this.getStock_volume());
		System.out.println("Stock Currency: " + this.getCurrency());
		System.out.println("Market Cap: " + this.getMarket_cap());
		System.out.println("\n");
	}

	/* Get stock price in users preferred currency */
	public float getUserPrice() {
		return 0.0f;
	}
	

}
