
public final class CheckAge {
	
	private static int studentAge = 15;
	private static int elderlyAge = 55;
	
	public static Age checkAgeCategory(int age) {
		if (age <= studentAge) {
			return Age.STUDENT;
		}else if (age >= elderlyAge) {
			return Age.ELDERLY;
		}else {
			return Age.ADULT;
		}
	}
	
	public static int getStudentAge() {
		return studentAge;
	}
	
	public static int getElderlyAge() {
		return elderlyAge;
	}
	
	public static void setStudentAge(int newStudentAge) {
		studentAge = newStudentAge;
	}
	
	public static void setElderlyAge(int newElderlyAge) {
		elderlyAge = newElderlyAge;
	}
}	

