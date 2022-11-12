package ui;
import java.util.Scanner;
import java.util.InputMismatchException;

public final class CheckUserInput {
	private static Scanner sc = new Scanner(System.in); 
	
	private static void withinRangeDouble(double min, double max, double input) {
		if(input < min || input > max) {
			throw new IllegalArgumentException("Enter an input between "+ min +" and "+ max);
		}
	}
	
	public static double loopUntilValidDouble(String str, double min, double max) {
		double input = 0.0;
		while(true) {
			try {
				System.out.print(str);
				input = sc.nextDouble();
				withinRangeDouble(min,max,input);
				break;
			}catch(InputMismatchException e){
				System.out.println("You did not enter a input of type double.\n" );
				sc.nextLine();
			}catch(IllegalArgumentException ex) {
				System.err.println(ex);
				System.out.println("");
			}
		}
		return input;
	}
	
	private static void withinRangeInt(int min, int max, int input) {
		if(input < min || input > max) {
			throw new IllegalArgumentException("Enter an input between "+ min +" and "+ max);
		}
	}
	public static int loopUntilValidInt(String str, int min, int max) {
		int input = 0;
		while(true) {
			try {
				System.out.print(str);
				input = sc.nextInt();
				sc.nextLine(); 
				withinRangeInt(min,max,input);
				break;
			}catch(InputMismatchException e){
				System.out.println("You did not enter a input of type Int.\n" );
				sc.nextLine();
			}catch(IllegalArgumentException ex) {
				System.err.println(ex);
				System.out.println("");
			}
		}
		return input;
	}
	
	private static void withinRangeStringLength(String s, int length) {
	    if (s.length() != length) {
	        throw new IllegalArgumentException("Please enter a string of " + length + " characters only!");
	    }
	}
	
	// enter length = 0 if length can be anything
	public static String loopUntilValidString(String str, int length) {
	    String s = new String();
	    
	    while(true) {
	        try {
	            System.out.print(str);
	            s = sc.nextLine();
	            if (length != 0)
	                withinRangeStringLength(s, length);
	            break;
	        }catch(InputMismatchException e) {
	            System.out.println("You did not enter an input of type String.\n");
	        }catch(IllegalArgumentException ex) {
	            System.err.print(ex);
	            System.out.println("");
	        }
	    }
	    
	    return s;
	}
	
}
