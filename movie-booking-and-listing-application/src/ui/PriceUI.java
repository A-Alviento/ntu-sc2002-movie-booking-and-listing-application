package ui;

public final class PriceUI {
	private static int choice;
	private static void printStartingDisplay() {
		 System.out.println("\n**************************************************************************************************");
		 System.out.println("1. Query Prices\n" +
							"2. Change Prices\n" +
				 			"3. Exit");
		 System.out.println("**************************************************************************************************");
	}
	
	public static void display() {
		while(true) {
			printStartingDisplay();
			choice = CheckUserInput.loopUntilValidInt("Select which price setting will you access: ", 1, 3);
			switch(choice) {
				case 1: PriceQueryUI.display();break;
				case 2: PriceModifierUI.display(); break;
				case 3: return;
				default: 
					System.out.println("Something went wrong. Help Please.");
					break;
			}
		}
		
	}
}
