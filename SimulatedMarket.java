package Coursework;       
import java.util.*;
/*
 * @author: Michael Peres
 *  01/03/2021
 */

// Data Source: [https://finance.yahoo.com/]  [02/03/2021] [16:20]
public class SimulatedMarket implements java.io.Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 9001396743647643530L;

	public static MarketSectors[] getMarkets() {
	/* Energy Stocks and Market */
	Stock es1 = new Stock("Exxon Mobil Corporation", "XOM", "Energy", 56.62f, 56.59f, 56.60f, -5.25f, 5495551, 1, '$');
	Stock es2 = new Stock("Chevron Corporation", "CVX", "Energy", 102.51f, 102.55f, 102.53f, -2.96f, 2628009, 1, '$');
	Stock es3 = new Stock("BP p.l.c.", "BP", "Energy", 24.91f, 24.92f, 24.88f, -6.02f, 3649529, 1, '$');
	ArrayList<Stock> energy_stocks = new ArrayList<Stock>();
	energy_stocks.add(es1);
	energy_stocks.add(es2);
	energy_stocks.add(es3);
	MarketSectors energy_market = new EnergyStocks(energy_stocks);  // Dynamic Binding.
	
	/* Health Care Stocks and Market */
	Stock hs1 = new Stock("Johnson & Johnson", "JNJ", "Healthcare", 159.11f, 159.06f, 159.10f, 5.51f, 1934527, 1,'$');
	Stock hs2 = new Stock("Pfizer Inc.", "PFE", "Healthcare", 33.73f, 33.72f, 33.75f, 1.71f, 6537473, 1, '$');
	Stock hs3 = new Stock("Abbott Laboratories", "ABT", "Healthcare", 121.64f, 121.58f, 121.40f, 2.50f, 601288, 1, '$');
	ArrayList<Stock> healthcare_stocks = new ArrayList<Stock>();
	healthcare_stocks.add(hs1);
	healthcare_stocks.add(hs2);
	healthcare_stocks.add(hs3);
	MarketSectors healthcare_market = new HealthcareStocks(healthcare_stocks);  // Dynamic Binding.
	
	
	/* Industrial Stocks and Market */
	Stock is1 = new Stock("Honeywell International Inc.", "HON", "Industrial", 205.57f, 205.49f, 205.72f, 6.72f, 487518, 1, '$');
	Stock is2 = new Stock("The Boeing Company", "BA", "Industrial", 225.76f, 225.61f, 225.09f, -20.88f, 4794531, 1, '$');
	Stock is3 = new Stock("FedEx Corporation", "FDX", "Industrial", 261.27f, 260.97f, 260.42f, 9.26f, 390012, 1, '$');
	ArrayList<Stock> industry_stocks = new ArrayList<Stock>();
	industry_stocks.add(is1);
	industry_stocks.add(is2);
	industry_stocks.add(is3);
	MarketSectors industry_market = new IndustrialStocks(industry_stocks);  // Dynamic Binding.
	
	
	/* Consumer Stocks and Market */
	Stock cs1 = new Stock("Tesla, Inc.", "TSLA", "Consumer", 710.56f, 710.33f, 708.57f, 0.64f, 9472819, 1, '$');
	Stock cs2 = new Stock("Amazon.com, Inc.", "AMZN", "Consumer", 3149.46f, 3148.20f, 3138.60f, 41.83f, 914320, 1, '$');
	Stock cs3 = new Stock("NIKE, Inc.", "NKE", "Consumer", 136.21f, 136.20f, 135.83f, 1.77f, 1451539, 1, '$');
	ArrayList<Stock> consumer_stocks = new ArrayList<Stock>();
	consumer_stocks.add(cs1);
	consumer_stocks.add(cs2);
	consumer_stocks.add(cs3);
	MarketSectors consumer_market = new ConsumerStocks(consumer_stocks);  // Dynamic Binding.
	
	
	MarketSectors[] markets = {energy_market, healthcare_market, industry_market, consumer_market};
	return markets;
	}
}
