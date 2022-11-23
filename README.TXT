Student name: Michael Peres
Student number: 200362146 

Now complete the statements below for each level you wish to be marked. Replace all text in square brackets.

LEVEL ONE

My code demonstrates inheritance in the following way...

I have a superclass called [Tools]

This superclass is extended into at least two subclasses called [Buy, Sell, randomEvents, ForiegnCurrencyConvertor]

For each of the named subclasses complete the following...

Subclass 1.

Subclass [Buy] extends the superclass by adding at least one property and its getters and setters. The name(s) of the added properties are [buyFee].

These/this new properties/property are used by the subclass in the following way: [This attribute is in charge of applying a fee when buying a stock and can be changed through setFeeRise(). Apparent on Line 71, 76]

Subclass [Buy] extends the superclass by overriding the following methods (there must be at least one): [setFeeRise() ].

These overridden methods are used in the working code in the following places: Line 84.

Subclass 2.

Subclass [Sell] extends the superclass by adding at least one property and its getters and setters. The name(s) of the added properties are [sellFee]

These/this new properties/property are used by the subclass in the following way: [This attribute is in charge of applying a fee when buying a stock and can be changed through setFeeRise(). Apparent on Line 74, 88.]

Subclass [Sell] extends the superclass by overriding the following methods (there must be at least one): [setFeeRise()]

These overridden methods are used in the working code in the following places: Line 74.


LEVEL TWO

Polymorphism consists of the use of the Substitution principle and Late Dynamic binding.

In my code, polymorphism is implemented in at least two places…

Example 1.

The substitution principle can be seen in use in [SimulatedMarket class and line number 25, 35, 46, 57]. The name of the superclass used in this example is [MarketSectors] and the subclasses used are [ConsumerStocks, EnergyStocks, HealthcareStocks, IndustrialStocks].

Late dynamic binding can be seen in [mainActivity class and line number 209].

[This example of polymorphism is necessary in the code, because we need to differentiate different types of stocks, all sectors need to showStocks().]

Example 2.

The substitution principle can be seen in use in [mainActivity Line:268]. The name of the superclass used in this example is [Tools] and the subclasses used are [Buy, Sell, randomEvents, ForiegnCurrencyConvertor].

Late dynamic binding can be seen in [mainActivity Line:306].

[When a user does not know what a tool does, they can press (h) to see all the tools behaviours and what they do.]
