# Stock Market Investor Simulator
A Java Based Stock Market Investor Simulator Game, where users try to make us much money investing in different companies where random events can occur that can lower or increase your position.
![layout](https://user-images.githubusercontent.com/52138450/203656433-1c67223a-6a7b-458c-8875-ac659fb13d79.png)

This simulation uses object orientated features including:
- Polymoriphism for different classes of stocks.
- Abstraction, usage in abstract classes.
- Inheritance, using parent or abstract classes to create classes.
- Encapsulating, keeping only some data accessible to other classes.

#### Running of project:

Main Menu:

![image](https://user-images.githubusercontent.com/52138450/203657453-89871b8b-46dc-49f6-b29d-afb0305a6960.png)

Profolio Menu:

![image](https://user-images.githubusercontent.com/52138450/203657476-a10b95b2-f15b-4859-95c9-e194c0831832.png)

Program Settings:

![image](https://user-images.githubusercontent.com/52138450/203657555-30fe9a64-3673-4bbb-9544-731b1b94570c.png)


-------
#### How it works:

We have a set amount of money at the start of the game:

![image](https://user-images.githubusercontent.com/52138450/203657763-c8de6779-b8b7-4935-9546-3c6578f4b00a.png)

We then have options of buying specific stocks, as shown above, I am interested in buying some XOM stock. This allows you to buy or sell stock depending on your portfolio.


-------
#### Buying stock

![image](https://user-images.githubusercontent.com/52138450/203657965-878b96b0-9a62-477b-8b8c-db0cf1034dc2.png)

If stock is bought, a number of things will occur:

- Addition of stock in portfolio.
- Removing of funds from account balance.
- Conversion fees applied if stock currency is not portfolio currency

-------
#### Events
When an event has occured, which is period, examples are below:
![image](https://user-images.githubusercontent.com/52138450/203658266-dcd1ae2f-afca-4d47-ad1a-6f3540c477a2.png)

Or 

![image](https://user-images.githubusercontent.com/52138450/203658301-911ce631-5bf0-4360-b6df-a0fd945de341.png)

Prices of stocks are adjusted, as these events have weighted randoms it is possible to profit based on them. Of course this may seem like a game of luck. 

-------
#### Selling Stock
We can check which stocks we own by opening the portfolio settings, 

![image](https://user-images.githubusercontent.com/52138450/203658557-37cccde9-6ae6-4bce-a06c-ee8f6034523a.png)

And sell them by going to the stock via sector and selling it.

If we try sell more stock then we currently have as an attempt to beat the game, it will tell us we cannot do that action.

![image](https://user-images.githubusercontent.com/52138450/203658803-728f7d1d-af4e-4fbc-bb22-5f5a211b531c.png)

Selling the correct amount, results in a removing of stock increase of funds available and applied conversion fees.

![image](https://user-images.githubusercontent.com/52138450/203658898-349e80d7-bc90-4ea5-90d8-2ae28ecbebe0.png)

------
#### Changes
All changes made to a portfolio are saved to a local file, to be read from later on.

A file name `profile.maki` is used for this within the same directory.


