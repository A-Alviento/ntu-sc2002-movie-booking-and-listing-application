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
	
}
