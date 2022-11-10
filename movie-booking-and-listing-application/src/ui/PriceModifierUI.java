package ui;

import model.PriceUtil;

public class PriceModifierUI {
	public static void printStartingDisplay() {
		 System.out.println("\n**************************************************************************************************");
	        System.out.print("1. Base Price.\n"
	                + "2. Bronze Cinema Multiplier\n"
	                + "3. Silver Cinema Multiplier\n"
	                + "4. Gold Cinema Multiplier\n"
	                + "5. Blockbuster Multipler\n"
	                + "6. Movie in 3D Multipler"
	                + "7. Weekend Multipler\n"
	                + "8. Public Holiday Multiplier\n"
	                + "9. Student Multiplier\n"
	                + "10. Elderly Multiplier\n"
	                + "11. Exit\n");
	        System.out.println("**************************************************************************************************\n");
	        //System.out.println("**************************************************************************************************");
	}
	
	public static void display() {
		int choice;
		double input = 0.0;
		printStartingDisplay();
		while(true) {
			input = 0.0;
			choice = CheckUserInput.loopUntilValidInt("Please select which modifier you will like to change: " , 1, 11);
			switch(choice) {
				case 1: 
					input = CheckUserInput.loopUntilValidDouble("Enter new base price: ", 0.1, 100.0);
					PriceUtil.setBasePrice(input);
					System.out.println("Base Price has been modified.\n");
					break;
				case 2: 
					input = CheckUserInput.loopUntilValidDouble("Enter new bronze cinema multuplier: ", 0.1, 2.0);
					PriceUtil.setBronzeCinemaMultipler(input);
					System.out.println("Bronze Cinema Multiplier has been modified.\n");
					break;
				case 3:
					input = CheckUserInput.loopUntilValidDouble("Enter new silver cinema multuplier: ", 0.1, 2.0);
					PriceUtil.setSilverCinemaMultipler(input);
					System.out.println("Silver Cinema Multiplier has been modified.\n");
					break;
				case 4:
					input = CheckUserInput.loopUntilValidDouble("Enter new gold cinema multuplier: ", 0.1, 2.0);
					PriceUtil.setGoldCinemaMultipler(input);
					System.out.println("Gold Cinema Multiplier has been modified.\n");
					break;
				case 5:
					input = CheckUserInput.loopUntilValidDouble("Enter new blockbuster multuplier: ", 1.0, 2.0);
					PriceUtil.setBlockbusterMultipler(input);
					System.out.println("Blockbuster Multiplier has been modified.\n");
					break;
				case 6:
					input = CheckUserInput.loopUntilValidDouble("Enter new 3D Movie multuplier: ",1.0, 2.0);
					PriceUtil.setMovie3DMultipler(input);
					System.out.println("3D Movie Multiplier has been modified.\n");
					break;
				case 7:
					input = CheckUserInput.loopUntilValidDouble("Enter new weekend multuplier: ", 1.0, 3.0);
					PriceUtil.setWeekendMultipler(input);
					System.out.println("Weekend Multipler has been modified.\n");
					break;
				case 8:
					input = CheckUserInput.loopUntilValidDouble("Enter new public holiday multuplier: ", 1.0, 3.0);
					PriceUtil.setPublicHolidayMultipler(input);
					System.out.println("Public Holiday Multipler has been modified.\n");
					break;
				case 9:
					input = CheckUserInput.loopUntilValidDouble("Enter new student multuplier: ", 0.1, 1.0);
					PriceUtil.setStudentMultipler(input);
					System.out.println("Student Multipler has been modified.\n");
					break;
				case 10:
					input = CheckUserInput.loopUntilValidDouble("Enter new elderly multuplier: ", 0.1, 1.0);
					PriceUtil.setElderlyMultipler(input);
					System.out.println("Elderly Multipler has been modified.\n");
					break;
				case 11: 
					return;
				default: 
					System.out.println("Soemthing went wrong. Help Please.");
					break;
			}
		}
			
	}
}
