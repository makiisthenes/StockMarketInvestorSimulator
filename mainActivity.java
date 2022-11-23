package Coursework;  
/*
 * @author: Michael Peres
 *  01/03/2021
 */
import java.text.DecimalFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

// Polymorphism - Showing all markets available to user, adding option in settings to list all tools and their showDescription() in a list;
// Instances of defaultBuyAmount, defaultSellAmount and getter and setters for both.



/* This class will be in charge of dealing with the overall running of the CLI program. */ 
public class mainActivity {
    public static DecimalFormat df = new DecimalFormat("#.00");  
    public static void main(String[] args) {
        // First check if profile saved data is located in working directory.
        Portfolio userProfile = StartupProfileDataCheck();
        IOClass.cwd();
        showMainMenu(userProfile);
        
        System.out.println("Program shutting down...");
        try {Thread.sleep(2000);} catch (InterruptedException e) {}
        System.exit(0);
    }
    
    
    
    /* Loading and Saving Portfolio Methods. */
    public static Portfolio StartupProfileDataCheck() {
        // IOClass.cwd(); Debugging Save Directory
        if (Portfolio.checkExsistance() == true) {
            System.out.println("Loading Saved Portfolio...");
            Portfolio user = (Portfolio) Portfolio.getObject();
            System.out.println(String.format("Hello there, %s.", user.getName()));
            return user;
            
        }else {
            System.out.print("\b\b\b\b\b\b\b\b\b\b\b\b\b\b");
            System.out.print ('\f');
            System.out.println("It seems like this is your first time, using this program! Welcome.");
            Scanner input = new Scanner(System.in);
            System.out.println("Lets get started!, what's your name:: ");
            String name = input.nextLine();
            Portfolio user = new Portfolio(name);
            System.out.println(String.format("Great, nice name %s. We will save your progress now!", user.getName()));
            user.saveObject();
            return user;
        }
    }
    
    
    /* In charge of showing main menu options */
    public static void showMainMenu(Portfolio user) {
        String option = "";
        // Now we display main menu: Portfolio Settings, Stocks Setting.
        while (!option.equals("q")) {
            user = (Portfolio) Portfolio.getObject();
            System.out.print("\b\b\b\b\b\b\b\b\b\b\b\b\b\b");
            System.out.print ('\f');
            System.out.println("##########Main Menu##########");
            Scanner input = new Scanner(System.in);
            System.out.println("Press (0) for Portfolio settings. \nPress (1) for Stock Options. \nPress (2) for Program Settings. \nPress (q) to Quit Program.");
            // Program Settings, to delete current saved profile and refresh completely.
            System.out.println("Enter now:: ");
            option = input.nextLine();
            System.out.println(option.strip());  // Debugging.
            option = option.strip();
            if (option.equals("0")) {
                // Portfolio Settings - Nested Method
                portfolioMenu();
            } else if (option.equals("1")) {
                // Stock Options - Nested Method
                stockMenu();
            }else if (option.equals("2")) {
                // Program Options - Nested Method
                showProgramSettings();
            }
            else if (option.equals("q")) {
                System.out.println("Quiting Program...");
                input.close();
            }
            else {
                System.out.println("Please use only the values 0 or 1 or q to navigate.");
            }
        }
        
    }
    
    
    /* In charge of managing portfolio options. */ 
    @SuppressWarnings("resource")
    public static void portfolioMenu() {
        // System.out.println("Your current stocks value equate to:: £#.##")
        String option = "";
        while (!option.equals("b")) {
            Portfolio user = (Portfolio) Portfolio.getObject();
            System.out.println("##########Portfolio Menu##########");
            System.out.println(String.format("Welcome %s!, your current balance is: £ %f", user.getName(), user.getBank_balance()));
            Scanner input = new Scanner(System.in);
            System.out.println("Press (0) to deposit an amount. \nPress (1) to withdraw an amount. \nPress (2) to view stocks portfolio. \nPress (b) to go back to main menu.");
            user = invokeEvent(user);
            System.out.println("Enter now:: ");
            option = input.nextLine();
            // System.out.println(option.strip());  // Debugging.
            option = option.strip();
            if (option.equals("0")) {
                // Deposit Money into Account.
                System.out.println("Enter amount to deposit into account £: ");
                float amount = Float.valueOf(df.format(input.nextFloat()));;
                Boolean success = user.deposit(amount);
                // Saving changes to file.
                if (success) {
                    System.out.println(String.format("£%f has been depositted into this bank account, new balance: %f.", amount, Float.valueOf(df.format(user.getBank_balance())) ));
                    System.out.println("Saving to changes... please wait");
                    user.saveObject();
                }else {
                    System.out.println("There was an error depositing this amount!, please try again with a smaller amount.");
                }
            } else if (option.equals("1")) {
                // Withdraw Money from an Account.
                System.out.println("Enter amount to withdraw from account £: ");
                float amount = Float.valueOf(df.format(input.nextFloat()));;
                Boolean success = user.withdraw(amount);
                // Saving changes to file.
                if (success) {
                    System.out.println(String.format("£%f has been withdrawn from the bank account, new balance: %f.", amount, Float.valueOf(df.format(user.getBank_balance())) ));
                    System.out.println("Saving to changes... please wait");
                    user.saveObject();
                }else {
                    System.out.println("There was an error withdrawing this amount!, please try again with a smaller amount.");
                }
            }else if (option.equals("2")) {
                user = (Portfolio) Portfolio.getObject();
                user.printPortfolioStocks();
                
            }else if (option.equals("b")) {
                // Return back to Main Menu.
                break;
            }
            else {
                System.out.println("Please use only the values 0, 1, 2 or b to navigate.");
            }
        }
        return;
    }
    
    /* In charge of managing stock options. */ 
    public static void stockMenu() {
        System.out.println("Getting Simulated Market Data...");
        Portfolio user = (Portfolio) Portfolio.getObject();
        MarketSectors[] markets = user.getMarkets();
        // System.out.println(markets.length); Debugging
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        // Here we can use a range of tools from the class Tools and also Indicators and also Stocks to trade stocks.
        String option = "";
        while (!option.equals("b")) {
            System.out.print("\b\b\b\b\b\b\b\b\b\b\b\b\b\b");
            System.out.print ('\f');
            Scanner input = new Scanner(System.in);
            System. out.println("##########Stock Menu##########");
            System.out.println("Select which market you would like to trade in::  \nPress (b) to go back to main menu. \nPress (a) to view all stocks in market ");
            // Show markets to trade in.
            for (int i=0; i<markets.length; i++) {
                System.out.println(String.format("(%d) --> %s Market",i, markets[i].getMarket_type() )); // Polymorphism
            }
            user = invokeEvent(user);
            System.out.println("Enter option now:: ");
            option = input.nextLine();
            // System.out.println(option.strip());  // Debugging.
            option = option.strip();
            // Range of options == (0 <-> markets.length-1)
            if (option.equals("b")) {
                break;
            }else if(option.equals("a")){
                // Print out all options, this is use of polymorphism.
                showAllStocks(markets);
                
            }else{
                try {
                    Integer num_option = Integer.parseInt(option);
                    if (-1<num_option && num_option < markets.length) {
                        // We got a valid choice from the user.
                        ArrayList<Stock> stocks = markets[num_option].getStock_options();
                        showStocks(stocks);
                        
                    }
                    else {
                        System.out.println("This integer is not a valid option in this list.");
                    }
                }catch (Exception e) {
                    System.out.println("Please use only the values 0 or 1 or b to navigate.");
                    // e.printStackTrace();  // Debugging
                }
            }   
        }
        return;
    }
    
    public static void showAllStocks(MarketSectors[] markets) {
        for (MarketSectors market : markets) {
            market.showStocks();  // Polymorphism
        
        }
        Scanner input = new Scanner(System.in);
        System.out.println("Press Enter to Continue back to main menu...");
        input.nextLine();
        return;
    }
    
    
    
    public static void showStocks(ArrayList<Stock> stocks) {
        String option = "";
        while (!option.equals("b")) {
            System.out.print("\b\b\b\b\b\b\b\b\b\b\b\b\b\b");
            System.out.print ('\f');
            Scanner input = new Scanner(System.in);
            System.out.println(String.format(" \n \n #####%s Stock Search#####", stocks.get(0).getMarket_name()));
            System.out.println("Select which stock you would like to trade::  \nPress (b) to go back to main menu.");
            // Show markets to trade in.
            for (int i=0; i<stocks.size(); i++) {
                String full_name = stocks.get(i).getStock_fullname();
                String short_name = stocks.get(i).getShortname();
                System.out.println(String.format("(%d) --> %s | %s Stock",i, short_name, full_name));
            }
            System.out.println("Enter option now:: ");
            option = input.nextLine();
            // System.out.println(option.strip());  // Debugging.
            option = option.strip();
            if (option.equals("b")) {
                break;
            }else {
                try {
                    Integer num_option = Integer.parseInt(option);
                    if (-1<num_option && num_option < stocks.size()) {
                        // We got a valid choice from the user.
                        Stock s1 = stocks.get(num_option);
                        // Show this stock and the tools associated with it.
                        showStockOptions(s1);
                    }
                    else {
                        System.out.println("This integer is not a valid option in this list.");
                    }
                }catch (Exception e) {
                    System.out.println("Please use only the values 0 or 1 or b to navigate.");
                    e.printStackTrace();  // Debugging
                }
            }       
        }
        return;
    }
    
    
    public static void showStockOptions(Stock s1) {
    	Portfolio user = (Portfolio) Portfolio.getObject();
        String option = "";
        Buy buyTool = user.getBuyTool();
        Sell sellTool = user.getSellTool();
        ForiegnCurrencyConverter conversionTool = user.getConversionTool();
        Tools[] tools = {buyTool, sellTool, conversionTool};
        s1.showStockInfo();
        while (!option.equals("b")) {
            user = (Portfolio) Portfolio.getObject();
            Scanner input = new Scanner(System.in);
            System.out.println(String.format(" \n \n #####%s Stock Tools#####", s1.getShortname()));
            // Show stock info.
            
            System.out.println("What operation do you want to do with this stock.");
            System.out.println("Press (0) to buy stock. \nPress (1) to sell stock. \nPress (h) for tool help. \nPress (b) to go back to main menu.");
            System.out.println("Enter option now:: ");
            option = input.nextLine();
            // System.out.println(option.strip());  // Debugging.
            option = option.strip();
            // Range of options == (0 <-> markets.length-1)
            if (option.equals("0")) {
                // Set chosen amount.
                int amount = 1;
                amount = getChosenAmount();
                Boolean success = buyTool.buyStock(amount, s1);
                if (success) {
                    System.out.println("Successfully bought one stock!");
                    System.out.println("Saving to changes... please wait");
                    user = (Portfolio) Portfolio.getObject();
                    
                }
                else {
                    System.out.println("Unfortunately there was not suffiecent funds in balance to buy a stock.");
                }
            } else if (option.equals("1")) {
            	// Set chosen amount.
                int amount = 1;
                amount = getChosenAmount();
                sellTool.sellStock(amount, s1);
            }else if (option.equals("b")) {
                // Return back to Main Menu.
                break;
             }else if (option.equals("h")) {
                 for (Tools tool : tools){
                        tool.toolDescription(); // Polymorphism.
                    }
             }else {
                    System.out.println("Please use only the values 0 or 1 or b to navigate.");
                }
                    
        }
        return;
    }
    
    /* Allows user to enter a chosen amount to buy or sell stock. */
    public static int getChosenAmount() {
    	Scanner input = new Scanner(System.in);
    	System.out.println("How much stock [1-99999]:: ");
    	try {
    	int amount = input.nextInt();
    	System.out.println("Amount: " + String.valueOf(amount));
    	return amount;
    	}catch (Exception ignored){
    		System.out.println("Given you selected a value that was not an int, we selected default 1");
    		return 0;
    	}
    }
    
    
    /* Method is called when an event should be called. */
    public static Portfolio invokeEvent(Portfolio user) {
    	randomEvents eventManager =  user.getEventManager();
    	eventManager.randomOccurance();
    	return (Portfolio) Portfolio.getObject();
    }
    
    
    /* In charge of showing program settings. */
    public static void showProgramSettings() {
        System.out.println("Program Settings");
        // Choose to delete account.
        // Choose the occurrence rate of randomEvents.
        // Set the currency of account.
        
    }
    
    
    
}


/* Need another document that explains the code, with class hierarchy and polymorphism */
