//denise dreyer
//December 6, 2021
//Class to represent a user and all it's login data


public class User {
	private String email;
	private String password;
	private int[] sessionTimes;
	
	//constructor
	public User(String email, int[] sessionTimes, String password) {
		this.email=email;
		this.password = password;
		this.sessionTimes=sessionTimes;
	}
	
	
	//getter for email field
	public String getEmail() {
		return email;
	}
	//getter for password
	public String getPassword() {
		return password;
	}
	//getter for SessionTimes field
	public int[] getSessionTimes() {
		return sessionTimes;
	}
	
	//returns the username
	public String getUsername() {
		return emailToUserName(email);
	}
	
	//strips the domain and extra numbers from the email.  
	//puts the first initial before the last name
	public String emailToUserName(String email) {
		String user = email.substring(2, email.indexOf("@")- 2);
		char first = user.charAt(user.length() - 1);
		String finalUser = first + user.substring(0, user.length() - 1);
		return finalUser;
	}
	
	//adds up all the session times
	public int getTotalTimeSpent() {
		int results = 0;
		for(int i = 0; i < sessionTimes.length; i++)
		{
			results += sessionTimes[i];
		}
		return results;
	}
	
	//calculates the average session time
	public double average(int [] arr) {
		double sumOfArr = 0;
		for(int i = 0; i < arr.length; i++)
		{
			sumOfArr += arr[i];
		}
		return sumOfArr/arr.length;
	}
	
	//returns a string describing all the info for a user
	public String toString() {
		String result = "";
		result += getUsername() + "\nPassword: " + password + "\nLogged in " + sessionTimes.length + " times"
				+ "\nTotal time spent: " + getTotalTimeSpent() + "\nAverage session length: " +  round2(average(sessionTimes)) + "\n\n";	
		return result;
	}
	
	//rounds to 2 decimal places
	public static double round2(double num1) {
		if (num1 >= 0)
		{
			num1 = (num1 * 100) + 0.5;
			num1 = (int) num1;
			num1 = num1 / 100.0;
			return num1;
		}
		else
		{
			num1 = (num1 * 100) - 0.5;
			num1 = (int) num1;
			num1 = num1 / 100.0;
			return num1;
		}
	}
	
	//changes password
	public void changePassword(String newPwd) {
	}
	
	//accepts a new time and adds it to the existing array
	public void addNewSession(int newSesh) {
		int [] temp = new int[sessionTimes.length+1];
		for (int i = 0; i < sessionTimes.length; i++)
		{
			temp [i] = sessionTimes[i];
		}
		temp[sessionTimes.length] = newSesh;
		
		sessionTimes = temp;
	}
	
	private void setDefaultPassword()
	{
		String dPass ="";
		String name = getUsername();
		if(name.length() < 5)
		{
			dPass += name.substring(1);
			dPass += "_" + name.charAt(0);
			dPass += "_2021";
		}
		else
		{
			dPass += name.substring(1, 5);
			dPass += "_" + name.charAt(0);
			dPass += "_2021";
		}
		this.password = dPass;
	}
	
	public User(String email, int [] sessionTimes)
	{
		this.email = email;
		this.sessionTimes = sessionTimes;
		setDefaultPassword();
	}
}

