//Chris Woo
//December 6, 20201
public class UserOld 
{
	private String email;
	private int[] sessionTimes;
	private String password; 
	
	public UserOld(String e, int[] st, String pass)
	{
		email = e;
		sessionTimes = st;
		password = pass;
	}
	
	public double average(int[] arr)
	{
		double sumOfArr = 0;
		for(int i = 0; i < arr.length; i++)
		{
			sumOfArr += arr[i];
		}
		return sumOfArr/arr.length;
	}
	
	public double round2(double num1)
	{
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
	
	public String emailToUsername(String email)
	{
		String user =email.substring(2, email.indexOf("@")- 2);
		char first = user.charAt(user.length() - 1);
		String finalUser = first + user.substring(0, user.length() - 1);
		return finalUser;
	}
	
	public String getEmail()
	{
		return email;
	}
	
	public String getUsername()
	{
		return emailToUsername(email);
	}
	
	public int[] getSessionTimes()
	{
		return sessionTimes;
	}
	
	public int getTotalTimeSpent()
	{
		int results = 0;
		for(int i = 0; i < sessionTimes.length; i++)
		{
			results += sessionTimes[i];
		}
		return results;
	}
	
	public void changePassword(String str)
	{
		password = str;
	}
	
	public void addNewSession(int time)
	{
		int [] temp = new int[sessionTimes.length+1];
		for (int i = 0; i < sessionTimes.length; i++)
		{
			temp [i] = sessionTimes[i];
		}
		temp[sessionTimes.length] = time;
		
		sessionTimes = temp;
	}
	
	public String toString()
	{
		String result = "";
		result += getUsername() + "\nPassword: " + password + "\nLogged in " + sessionTimes.length + " times"
				+ "\nTotal time spent: " + getTotalTimeSpent() + "\nAverage session length: " +  round2(average(sessionTimes)) + "\n\n";	
		return result;
	}
}
