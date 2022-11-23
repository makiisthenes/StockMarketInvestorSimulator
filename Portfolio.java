package Coursework;      
/*
 * @author: Michael Peres
 *  01/03/2021
 */

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.Scanner;


/* This class will deal with the main users preferences and names etc. */ 
public class Portfolio implements saveProfile, java.io.Serializable {

	private static final long serialVersionUID = -125996106959580845L;
	DecimalFormat df = new DecimalFormat("#.00");  
	private String name;
	public static String label = "profile";
	private float bank_balance;
	private float portfolio_value;
	private char currency;
	private MarketSectors[] markets;
	private randomEvents eventManager;
	private Buy buyTool = new Buy(1.00f);
	private Sell sellTool = new Sell(1.00f);
	private ForiegnCurrencyConverter conversionTool = new ForiegnCurrencyConverter(0.30f , 0.30f);
	private HashMap<String, Integer> stocks = new HashMap<String, Integer>();  // Used to keep track of stocks bought by this user.
	
	
	// Portfolio Constructor
	public Portfolio(String name) {
		this.setName(name);
		// New Portfolio currency set to £;
		this.setCurrency('£'); 
		// New Portfolio balance set to 0;
		this.setBank_balance(0.00f);
		// First Time accessing market.
		this.setMarkets(SimulatedMarket.getMarkets());
		// Setting up event manager for the first time.
		this.setEventManager(new randomEvents());
	}
	
	
	/* Getter and Setter Methods for Class */
	public float getBank_balance() {
		return bank_balance;
	}
	public void setBank_balance(float bank_balance) {
		this.bank_balance = bank_balance;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public float getPortfolio_value() {
		Float.valueOf(df.format(portfolio_value));
		return Float.valueOf(df.format(portfolio_value));
	}

	public void setPortfolio_value(float portfolio_value) {
		this.portfolio_value = Float.valueOf(df.format(portfolio_value));
	}
	
	public HashMap<String, Integer> getStocks() {
		return stocks;
	}

	public void setStocks(HashMap<String, Integer> stocks) {
		this.stocks = stocks;
	}
	

	public boolean withdraw(float amount) {
		if (amount < 0) {
			System.out.println("Cannot withdraw a negative amount!");
			return false;
		}
		float balance = this.getBank_balance();
		balance = Float.valueOf(df.format(balance));
		if (!((balance-amount) < 0)) {
			this.setBank_balance(Float.valueOf(df.format(balance-amount)));
			return true;
		}
		return false;
	}
	
	public Buy getBuyTool() {
		return buyTool;
	}

	public void setBuyTool(Buy buyTool) {
		this.buyTool = buyTool;
	}

	public Sell getSellTool() {
		return sellTool;
	}

	public void setSellTool(Sell sellTool) {
		this.sellTool = sellTool;
	}

	public ForiegnCurrencyConverter getConversionTool() {
		return conversionTool;
	}

	public void setConversionTool(ForiegnCurrencyConverter conversionTool) {
		this.conversionTool = conversionTool;
	}
	
	
	/* Deposits money into the bank account */
	public boolean deposit(float amount) {
		if (amount < 0) {
			System.out.println("Cannot deposit a negative amount!");
			return false;
		}
		float balance = this.getBank_balance();
		balance = Float.valueOf(df.format(balance));
		this.setBank_balance(Float.valueOf(df.format(balance+amount)));
		return true;
	}

	@Override
	public void saveObject() {
		// Overridden method, dealing with saving object to file.
		IOClass.serialiseObject(this, Portfolio.label);
	}
	
	public static boolean checkExsistance(){
		return IOClass.checkFileExsistance(Portfolio.label);
	}
	
	public static Object getObject() {
		Object value = IOClass.deserialiseObject(Portfolio.label);
		return value;
		
	}
	
	public void printPortfolioStocks() {
		HashMap<String, Integer> stocks = this.getStocks();
		if (stocks == null) {
			System.out.println("You currently have no stocks.");
		}else {
			Set<String> keys = stocks.keySet();
			Iterator<String> iter = keys.iterator();
			while (iter.hasNext()) {
				String key = iter.next();
				System.out.println(String.format("Stock: %s --> Qnty: %d", key, stocks.get(key)));
			}
			
		}
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		System.out.println("Press Enter to Continue back to main menu...");
		input.nextLine();
		return;
	}


	public char getCurrency() {
		return currency;
	}


	public void setCurrency(char currency) {
		this.currency = currency;
	}


	public MarketSectors[] getMarkets() {
		return this.markets;
	}


	public void setMarkets(MarketSectors[] markets) {
		this.markets = markets;
	}


	public randomEvents getEventManager() {
		return eventManager;
	}


	public void setEventManager(randomEvents eventManager) {
		this.eventManager = eventManager;
	}
	

	
}
