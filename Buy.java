package Coursework;

import java.text.DecimalFormat;
import java.util.HashMap;

/* Class Used to Buy Stocks on the market. */
class Buy extends Tools implements java.io.Serializable{
	private static final long serialVersionUID = -6732770778588983223L;
	private float buyFee;
	DecimalFormat df = new DecimalFormat("#.00");
	
	/* Buy Constructor */ 
	public Buy(float fee){
		fee = Float.valueOf(df.format(fee));
		this.setBuyFee(fee);
		
	}
	
	@Override
	public void toolDescription(){
		   /* Prints out a description of what the tool does */
			System.out.println("The buy tool allows users to obtain stocks from a market, in exchange for currency.");
	}
	
	/* Method for user to buy stock. */
	public boolean buyStock(int amount, Stock stock) {
		// First check if user can afford to buy this stock.
		Portfolio user = (Portfolio) Portfolio.getObject();
		float total_price = amount * stock.getBuy_price();
		
		// TODO: Check the conversion if not base currency, add currency to Portfolio attributes.;
		char userCurrency = user.getCurrency();
		char stockCurrency = stock.getCurrency();
		if (!(userCurrency == stockCurrency)) {
			// The two currencies are not equal...
			ForiegnCurrencyConverter conversionTool = user.getConversionTool();
			// Conditions to determine conversion necessary.
			if (userCurrency == '£' && stockCurrency == '$') {
				total_price = conversionTool.gbp2usd(total_price);
			}else {
				total_price = conversionTool.usd2gbp(total_price);
			}
		}
		Boolean success = user.withdraw(total_price);
		if (success) {
			String shortname = stock.getShortname();
			HashMap<String, Integer> stocks = user.getStocks();
			if (stocks != null) {
			if (stocks.containsKey(shortname)) {
				Integer n = stocks.get(shortname) + 1;
				stocks.put(shortname, n);
				user.setStocks(stocks);
			}else {
				stocks.put(shortname, 1);
				user.setStocks(stocks);
			}
			}else {
				stocks = new HashMap<String, Integer>();
				stocks.put(shortname, 1);
				user.setStocks(stocks);
			}
			user.saveObject();
			return true;
		}else {
			return false;
		}	
	}

	/* Gets the buy fee the user has to buy in order to buy stock. */ 
	public float getBuyFee() {
		buyFee = Float.valueOf(df.format(this.buyFee));
		return buyFee;
	}

	/* Sets the buy fee the user has to buy in order to buy stock. */ 
	public void setBuyFee(float buyFee) {
		buyFee = Float.valueOf(df.format(buyFee));
		this.buyFee = buyFee;
	}
	

	/* Sets the buy fee according to the percentage increase. */ 
	@Override
	public void setFeeRise(int percentage) {
		float fee = this.getBuyFee();
		fee *= percentage;
		this.setBuyFee(Float.valueOf(df.format(fee)));
	}

	
	
}
