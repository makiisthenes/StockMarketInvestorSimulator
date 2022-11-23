package Coursework;     
/*
 * @author: Michael Peres
 *  01/03/2021
 */

import java.text.DecimalFormat;

class ForiegnCurrencyConverter extends Tools implements java.io.Serializable{
	private static final long serialVersionUID = 8972725670279491129L;
	private float GBPconversionFee;
	private float USDconversionFee;
	DecimalFormat df = new DecimalFormat("#.00");
	
	
	// ForiegnCurrencyConverter Constructor
	public ForiegnCurrencyConverter(float GPBfee, float USDfee){
		/* Set initial GPB conversion fee */
		GPBfee = Float.valueOf(df.format(GPBfee));
		this.setGBPConversionFee(GPBfee);
		/* Set initial USD conversion fee */
		USDfee = Float.valueOf(df.format(USDfee));
		this.setUSDconversionFee(USDfee);
	}
	
	
	
	public void toolDescription(){
		/* Prints out a description of what the tool does */
		System.out.println("This tool allows users to convert between currencies.");
	}
	
	
	
	/* Conversion Methods for Currencies */
	public float gbp2usd(float gbp_amount) {
		/* Check the conversion rate */
		float usd_amount = gbp_amount * 1.00f;
		usd_amount += this.getUSDconversionFee();
		System.out.println("Addition of conversion fee: $" + this.getUSDconversionFee());
		return usd_amount;
	}
	public float usd2gbp(float usd_amount) {
		/* Check the conversion rate, and apply conversion fee. */
		float gbp_amount = usd_amount * 1.00f;
		gbp_amount += this.getGBPConversionFee();
		System.out.println("Addition of conversion fee: £" + this.getGBPConversionFee());
		return gbp_amount;
	}
	/* Other Currency Support */


	@Override
	public void setFeeRise(int percentage) {
		// Setting new conversation fee for GBP transactions.
		float fee = this.getGBPConversionFee();
		fee *= percentage;
		this.setGBPConversionFee(Float.valueOf(df.format(fee)));
		
	}


	public float getGBPConversionFee() {
		return Float.valueOf(df.format(this.GBPconversionFee));
	}


	public void setGBPConversionFee(float conversionFee) {
		conversionFee = Float.valueOf(df.format(this.GBPconversionFee));
		this.GBPconversionFee = conversionFee;
	}


	public float getUSDconversionFee() {
		return Float.valueOf(df.format(this.USDconversionFee));
	}


	public void setUSDconversionFee(float USDconversionFee) {
		USDconversionFee = Float.valueOf(df.format(this.USDconversionFee));
		this.USDconversionFee = USDconversionFee;
	}
	
}