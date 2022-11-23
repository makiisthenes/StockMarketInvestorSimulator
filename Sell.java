package Coursework; 

import java.text.DecimalFormat;
import java.util.HashMap;

/* Class Used to Sell Stocks on the market. */
class Sell extends Tools implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8684134380504536183L;
	private float sellFee;
	DecimalFormat df = new DecimalFormat("#.00");
	
	/* Sell Constructor */ 
	public Sell(float fee){
		fee = Float.valueOf(df.format(fee));
		this.setSellFee(fee);
		
	}
	
	@Override
	public void toolDescription(){
		   /* Prints out a description of what the tool does */
			System.out.println("This tool allows users to sells stocks from thier portfolio");
	   }
	
	
	/* Checks Portfolio in order to sell stock, and get money in return. */
	public boolean sellStock(int amount, Stock stock) {
		// First check if user can afford to buy this stock.
		Portfolio user = (Portfolio) Portfolio.getObject();
		String shortname = stock.getShortname();
		HashMap<String, Integer> stocks = user.getStocks();
		char userCurrency = user.getCurrency();
		char stockCurrency = stock.getCurrency();
		if (stocks == null) {
			System.out.println("Currently your portfolio is empty!, \ndo you have a stock in this company?");
			return false;
		}else {
			try {
			Integer n = stocks.get(shortname);
			if (n < amount) {
				System.out.println(String.format("Not enough stock! \nYou currently have %d stock(s) in this company", n));
				return false;
			}else {
				stocks.put(shortname, n-amount);
				float total_value = stock.getSell_price() * amount;
				if (!(userCurrency == stockCurrency)) {
					// The two currencies are not equal condition...
					ForiegnCurrencyConverter conversionTool = user.getConversionTool();
					// Conditions to determine conversion necessary.
					if (userCurrency == '£' && stockCurrency == '$') {
						total_value = conversionTool.gbp2usd(total_value);
					}else {
						total_value = conversionTool.usd2gbp(total_value);
					}
				}
				user.deposit(total_value);
				System.out.println("Successfully sold one stock!");
				System.out.println("Saving to changes... please wait");
				user.saveObject();
				return true;
			}}catch (Exception e) {
				System.out.println("You don't have any stock in this company.");
				return false;
			}	
		}
	}


	/* Sets the sell fee according to the percentage increase. */ 
	@Override
	public void setFeeRise(int percentage) {
		float fee = this.getSellFee();
		fee *= percentage;
		this.setSellFee(Float.valueOf(df.format(fee)));
	}
	
	/* Gets the sell fee the user has to buy in order to buy stock. */ 
	public float getSellFee() {
		return Float.valueOf(df.format(this.sellFee));
	}
	/* Sets the sell fee the user has to buy in order to buy stock. */ 
	public void setSellFee(float sellFee) {
		sellFee = Float.valueOf(df.format(this.sellFee));
		this.sellFee = sellFee;
	}
	

	
}