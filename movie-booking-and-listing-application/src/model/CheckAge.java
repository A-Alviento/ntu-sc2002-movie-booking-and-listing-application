package model;
/**
 * CheckAge class is a static class whose function is to check the age category of the customer.
 */
public final class CheckAge {
	
	/**
	 * Current threshold for student's age
	 */
	private static int studentAge = 15;
	/**
	 * Current threshold for elderly's age
	 */
	private static int elderlyAge = 55;
	
	/**
	 * A public static function to check the age category of the input age
	 * @return an enum value
	 * Age.STUDENT - if age <= studentAge
	 * Age.ELDERLY - if age >= elderlyAge
	 * Age.ADULT - otherwise
	 */
	public static Age checkAgeCategory(int age) {
		if (age <= studentAge) {
			return Age.STUDENT;
		}else if (age >= elderlyAge) {
			return Age.ELDERLY;
		}else {
			return Age.ADULT;
		}
	}
	/**
	 * Getter for student's age
	 */
	public static int getStudentAge() {
		return studentAge;
	}
	/**
	 * Getter for elderly's age
	 */
	public static int getElderlyAge() {
		return elderlyAge;
	}
	/**
	 * Setter for student's age
	 */
	public static void setStudentAge(int newStudentAge) {
		studentAge = newStudentAge;
	}
	/**
	 * Setter for elderly's age
	 */
	public static void setElderlyAge(int newElderlyAge) {
		elderlyAge = newElderlyAge;
	}
}	

