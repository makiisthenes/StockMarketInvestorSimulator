package Coursework;        
/*
 * @author: Michael Peres
 *  01/03/2021
 */
import java.text.DecimalFormat;


public abstract class Tools{
	DecimalFormat df = new DecimalFormat("#.00");
    public abstract void toolDescription();
           /* Prints out a description of what the tool does */
    
    public abstract void setFeeRise(int percentage);
    	/* Increases the fee for using a specific tool as a percentage. */
    
    
    // 2 more abstract methods required.
}



