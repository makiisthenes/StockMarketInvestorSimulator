package Coursework;    
    
/*
 * @author: Michael Peres
 *  01/03/2021
 */

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


// Deals with saving and loading object from memory, persistence in the state of the program
public class IOClass {
	// Global Variable used by whole system.
	public static String currentDirectory = System.getProperty("user.dir");
	
	
	/* Debug Method to find current working directory of project. */
	public static void cwd() {
		System.out.println(currentDirectory);
	}
	
	
	/* Class in charge of saves, the state of stocks */
	public static void serialiseObject(Object obj, String filename) {
			// Serialise object here.
			String filepath = currentDirectory + "\\" + filename+".maki";
			try {
				// First create a file output stream object that takes path as parameter.
				FileOutputStream fileOut = new FileOutputStream(filepath);
				// Then make a object output stream using the file output stream as a parameter.
				ObjectOutputStream out = new ObjectOutputStream(fileOut);
				// Now that we have the object output stream object we can now write a object to it.
				out.writeObject(obj);
				// Then close both output streams and tell the user of the new save in the given file path.
				out.close();
				fileOut.close();
				// System.out.println("Object stored @: " + filepath);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	
	/* Takes a save file object and deserialise it to usable object in code. */
	public static Object deserialiseObject(String filename) {
			// DeSerialise object here.
			String filepath = currentDirectory + "\\" + filename+".maki";
			Object e3 = null;
			try {
		         FileInputStream fileIn = new FileInputStream(filepath);
		         ObjectInputStream in = new ObjectInputStream(fileIn);
		         e3 = in.readObject();
		         // in.close();
		         // fileIn.close();
		      } catch (IOException i) {
		         i.printStackTrace();
		         return e3;
		      } catch (ClassNotFoundException c) {
		         System.out.println("Employee class not found");
		         c.printStackTrace();
		         return e3;
		      }
			return e3;
		}
	
	/* This method will check object exsistance in current working directory returning a boolean. */
	public static boolean checkFileExsistance(String filename){
		String filepath = currentDirectory + "\\" + filename +".maki";
		try {
			FileInputStream fileIn = new FileInputStream(filepath);
			ObjectInputStream in = new ObjectInputStream(fileIn);
			fileIn.close();
			in.close();
		}catch (Exception e) {
			// Add this to an error log file instead of printing.
			return false;
	      }
		return true;
	}
}



