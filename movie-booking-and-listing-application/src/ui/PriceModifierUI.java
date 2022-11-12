package ui;

import model.PriceUtil;

public class PriceModifierUI {
	public static void printStartingDisplay() {
		 System.out.println("\n**************************************************************************************************");
	        System.out.print("1. Base Price.\n"
	                + "2. Bronze Cinema Multiplier\n"
	                + "3. Silver Cinema Multiplier\n"
	                + "4. Gold Cinema Multiplier\n"
	                + "5. Blockbuster Multiplier\n"
	                + "6. Movie in 3D Multiplier"
	                + "7. Weekend Multiplier\n"
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
					input = CheckUserInput.loopUntilValidDouble("Enter new bronze cinema multiplier: ", 0.1, 2.0);
					PriceUtil.setBronzeCinemaMultiplier(input);
					System.out.println("Bronze Cinema Multiplier has been modified.\n");
					break;
				case 3:
					input = CheckUserInput.loopUntilValidDouble("Enter new silver cinema multiplier: ", 0.1, 2.0);
					PriceUtil.setSilverCinemaMultiplier(input);
					System.out.println("Silver Cinema Multiplier has been modified.\n");
					break;
				case 4:
					input = CheckUserInput.loopUntilValidDouble("Enter new gold cinema multiplier: ", 0.1, 2.0);
					PriceUtil.setGoldCinemaMultiplier(input);
					System.out.println("Gold Cinema Multiplier has been modified.\n");
					break;
				case 5:
					input = CheckUserInput.loopUntilValidDouble("Enter new blockbuster multiplier: ", 1.0, 2.0);
					PriceUtil.setBlockbusterMultiplier(input);
					System.out.println("Blockbuster Multiplier has been modified.\n");
					break;
				case 6:
					input = CheckUserInput.loopUntilValidDouble("Enter new 3D Movie multiplier: ",1.0, 2.0);
					PriceUtil.setMovie3DMultiplier(input);
					System.out.println("3D Movie Multiplier has been modified.\n");
					break;
				case 7:
					input = CheckUserInput.loopUntilValidDouble("Enter new weekend multiplier: ", 1.0, 3.0);
					PriceUtil.setWeekendMultiplier(input);
					System.out.println("Weekend Multiplier has been modified.\n");
					break;
				case 8:
					input = CheckUserInput.loopUntilValidDouble("Enter new public holiday multiplier: ", 1.0, 3.0);
					PriceUtil.setPublicHolidayMultiplier(input);
					System.out.println("Public Holiday Multiplier has been modified.\n");
					break;
				case 9:
					input = CheckUserInput.loopUntilValidDouble("Enter new student multiplier: ", 0.1, 1.0);
					PriceUtil.setStudentMultiplier(input);
					System.out.println("Student Multiplier has been modified.\n");
					break;
				case 10:
					input = CheckUserInput.loopUntilValidDouble("Enter new elderly multiplier: ", 0.1, 1.0);
					PriceUtil.setElderlyMultiplier(input);
					System.out.println("Elderly Multiplier has been modified.\n");
					break;
				case 11: 
					return;
				default: 
					System.out.println("Something went wrong. Help Please.");
					break;
			}
		}
			
	}
}
