package Coursework; 

import java.util.Random;

@SuppressWarnings("unused")
public class randomEvents extends Tools implements java.io.Serializable {
	private static final long serialVersionUID = 343881494451587414L;
	private int occuranceRate;  			// How many announcements are stated when looking at stocks. 
	private int likelihoodOccuranceRate; 	// How likely an announcement will be something other than neutral.
	
	randomEvents(){
		// Default Values.
		occuranceRate =1;
		likelihoodOccuranceRate = 5;
	}
	
	
	@Override
	public void toolDescription() {
		System.out.println("This tool will randomly announce random events occuring during the program session.");
	}
	
	// Method controls how many and likelihood of an event.
	public void randomOccurance() {
		Stock randomStock;
		int randomValue = determineRandomValue(0,5);
		if (randomValue == 0) {
			// Random Good Occurrence.
			announceGoodNews();
		}else if (randomValue == 1){
			// Random Bad Occurrence.
			announceBadNews();
		}else if (randomValue >= 2) {
			// Neutral Occurrence nothing happens.
			System.out.println("Just another day in the stock market day. No new announcements.");
		}
	}
	
	
	/* In charge of selecting a random stock when an occurrence happens. */
	public Stock getRandomStock() {
		Portfolio user = (Portfolio) Portfolio.getObject();
		// Get random marketSector.
        MarketSectors[] markets = user.getMarkets();
        int randomIndex = determineRandomValue(0, markets.length-1);
        // Get random stock from that sector.
        MarketSectors randomSector = markets[randomIndex];
        randomIndex = determineRandomValue(0, randomSector.getStock_options().size()-1);
        Stock randomStock = randomSector.getStock_options().get(randomIndex);
        return randomStock;
	}
	
	
	/* In charge of announcing good news. */
	public void announceGoodNews() {
		Portfolio user = (Portfolio) Portfolio.getObject();
		Stock randomStock = getRandomStock();
		String CompanyName = randomStock.getStock_fullname();
		String CompanySector = randomStock.getMarket_name();
		int StockRoseInt = determineRandomValue(1, 10);
		String[] goodNews = {
			String.format("%s quartly reports show good growth in the %s sector, stocks rose %d %%", CompanyName, CompanySector, StockRoseInt), 
			String.format("%s's new C-Level mix up has increased its productivity, stocks rose %d %%", CompanyName, StockRoseInt), 
			String.format("New Contract Deal with the government, stocks rose %d %%", StockRoseInt), 
			String.format("The %s sector has grown in the past week due to coronavirus, stocks rose %d %%", CompanyName, StockRoseInt)
		};
		int randomIndex = determineRandomValue(0, goodNews.length-1);
		// Select random good news.
		String news = goodNews[randomIndex];
		// We want to change that stocks values.
		randomStock.setActual_price(randomStock.getActual_price()*(1+(StockRoseInt/100)));
		randomStock.setSell_price(randomStock.getSell_price()*(1+(StockRoseInt/100)));
		randomStock.setBuy_price(randomStock.getBuy_price()*(1+(StockRoseInt/100)));
		user.saveObject();
	}
	
	/* In charge of announcing bad news. */
	public void announceBadNews() {
		Portfolio user = (Portfolio) Portfolio.getObject();
		Stock randomStock = getRandomStock();
		String CompanyName = randomStock.getStock_fullname();
		String CompanySector = randomStock.getMarket_name();
		int StockRoseInt = -determineRandomValue(1, 10);
		String[] badNews = {
				String.format("%s CEO charged with assualt on a primary school teacher, stocks plummetted by %d %%", CompanyName, StockRoseInt), 
				String.format("PLANE CRASHES INTO HQ OF %s!, OPERATIONS DIED STOCKS DROPPED %d %%", CompanyName, StockRoseInt), 
				String.format("Decline in the %s, has led %s under pressure to perform, stocks dropped by %d %%", CompanySector, CompanyName, StockRoseInt),
				String.format("%s Office rage leaves C suite executives dead, stocks dropped by %d %%", CompanyName, StockRoseInt),
				String.format("Vandalism and theft in %s branch has left them unable to operate, stocks drooped by %d %%", CompanyName, StockRoseInt), 
				
			};
		int randomIndex = determineRandomValue(0, badNews.length-1);
		// Select random good news.
		String news = badNews[randomIndex];
		System.out.println(news);
		// We want to change that stocks values.
		randomStock.setActual_price(randomStock.getActual_price()*(1+(StockRoseInt/100)));
		randomStock.setSell_price(randomStock.getSell_price()*(1+(StockRoseInt/100)));
		randomStock.setBuy_price(randomStock.getBuy_price()*(1+(StockRoseInt/100)));
		user.saveObject();
	}
	
	/* Determines a random number between given parameters */
	public int determineRandomValue(int min, int max) {
		// int max = 10; int min = 1;
		Random rand = new Random();
		int randomNum = rand.nextInt((max - min) + 1) + min;
		return randomNum;
	}

	
	public int getOccuranceRate() {
		return this.occuranceRate;
	}
	
	
	public void setOccuranceRate(int rate) {
		this.occuranceRate = rate;
	}
	
	
	@Override
	public void setFeeRise(int percentage) {
		// Fees do not effect randomEvents Tools class;
		;
	}
	

}
