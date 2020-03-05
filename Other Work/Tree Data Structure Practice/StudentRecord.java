public class StudentRecord {
	private static int nextID = 1;
	
	String firstName;
	String lastName;
	String email;
	int bannerID;
	double gpa;
	
	public StudentRecord(String f, String l) {
		firstName = f;
		lastName = l;
		
		email = f.toLowerCase() + "." + l.toLowerCase() + "@sandiego.edu";
		
		bannerID = getNextID();
		gpa = 4.0;
	}
	
	private int getNextID() {
		return nextID++;
	}
	
	public String toString() {
		String r = "Name: " + firstName + " " + lastName 
				+ " Email: " + email + "ID: " + bannerID;
		return r;
	}

}
