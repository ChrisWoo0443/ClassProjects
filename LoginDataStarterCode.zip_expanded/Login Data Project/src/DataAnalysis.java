import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class DataAnalysis {

	public static void main(String[] args) throws FileNotFoundException
	{
		File file = new File("dataLog.txt");
		Scanner input = new Scanner(file);
		String getString = input.nextLine();
		String email = "";

		ArrayList<User> userList = new ArrayList<User>();
			
		while(!getString.equals("end"))
		{
			email = getString;
			int sessionTime = 0;
			
			String sessionNum = input.nextLine();
			int count = Integer.parseInt(sessionNum);
			int[] sessionLengths = new int [count];
			
			for(int i = 1; i <= count; i++)
			{
				String time = input.nextLine();
				sessionTime = Integer.parseInt(time) + sessionTime;
				sessionLengths[i-1] = Integer.parseInt(time);
			}
			
			String getPassword = input.nextLine();
			String password = getPassword.substring(4);
			
			//create object
			User data = new User(email, sessionLengths, password);
			userList.add(data);
			
			getString = input.nextLine();
		}	
		
		Scanner newInput = new Scanner(System.in);
		String newEmail = "";
		int sesh = 0;
		
		System.out.println("Do you want to add a new user?\n (type y or n)");
		String yesNo= newInput.nextLine();
		if(!yesNo.equals("n"))
		{
			System.out.println("What is the email?");
			newEmail = newInput.nextLine();
			System.out.println("How long was the session?");
			sesh = newInput.nextInt();
			addUser(userList, newEmail, sesh);
		}
		
		removeInactiveUser(userList);
		System.out.println(printUserData(userList));
		System.out.println("The most experienced user is " + mostExperiencedUser(userList) + ".");
		
		newInput.close();
		input.close();
	}
	
	public static String printUserData(ArrayList<User> userData)
	{
		String results = "";
		for(int i = 0; i < userData.size(); i++)
		{
			results += userData.get(i);
		}
		return results;
	}
	
	public static String mostExperiencedUser(ArrayList<User> loginData)
	{
		int mostTime = 0;
		String userWithTime = "";
		
		for (int i = 0; i < loginData.size(); i++)
		{
			if(loginData.get(i) != null && loginData.get(i).getTotalTimeSpent() > mostTime)
			{
				mostTime = loginData.get(i).getTotalTimeSpent();
				userWithTime = loginData.get(i).getUsername();
			}
		}
		return userWithTime;
	}
	
	public static void addUser(ArrayList<User> users, String email, int timeInFirstSession)
	{
		int[] sessionT = new int[] {timeInFirstSession};
		User newUser = new User(email, sessionT);
		users.add(newUser);
	}
	public static void removeInactiveUser(ArrayList<User> userList)
	{
		for(int i = 0; i < userList.size(); i++)
		{
			if(userList.get(i).getTotalTimeSpent() < 10)
			{
				userList.remove(i);
				i--;
			}
		}
	}
}












