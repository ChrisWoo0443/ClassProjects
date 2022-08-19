//Chris Woo

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class DataAnalysisOld
{
/* checkpoint 1
{
	public static void main(String[]args) throws FileNotFoundException
	{
		File file = new File("dataLog.txt");
		Scanner input = new Scanner(file);
		String getString = input.nextLine();
		String email = "";
		
		while(!getString.equals("end"))
		{
			email = getString;
			int sessionTime = 0;

			String sessionNum = input.nextLine();
			int count = Integer.parseInt(sessionNum);
				
			for(int i = 1; i <= count; i++)
			{
				String time = input.nextLine();
				sessionTime = Integer.parseInt(time) + sessionTime;
			}
			double average = (double) sessionTime / count;
			String getPassword = input.nextLine();
			String password = getPassword.substring(4);
				
			System.out.println(email);
			System.out.println("Password: " + password);
			System.out.println("Logged in " + count + " times");
			System.out.println("Total time spent: " + sessionTime);
			System.out.println("Average session length: " + average);
			System.out.println("");
				
			getString = input.nextLine();
		}
		input.close();
	}
}

//checkpoint 2
{
	public static void main(String[]args) throws FileNotFoundException
	{
		File file = new File("dataLog.txt");
		Scanner input = new Scanner(file);
		String getString = input.nextLine();
		String email = "";
		
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
				
			System.out.println(emailToUsername(email));
			System.out.println("Password: " + password);
			System.out.println("Logged in " + count + " times");
			System.out.println("Total time spent: " + sessionTime);
			System.out.printf("Average session length: %.2f", average(sessionLengths));
			System.out.println("\n");
			
			getString = input.nextLine();


		}
		input.close();
	}
	
	public static double average(int[] arr)
	{
		double sumOfArr = 0;
		for(int i = 0; i < arr.length; i++)
		{
			sumOfArr += arr[i];
		}
		return sumOfArr/arr.length;
	}
	
	
	public static String emailToUsername(String email)
	{

		String user = email.substring(2, email.indexOf("@")- 2);
		char first = user.charAt(user.length() - 1);
		String finalUser = first + user.substring(0, user.length() - 1);
		return finalUser;
	}
}
*/

	//checkpoint 3
	public static void main (String[] args) throws FileNotFoundException
	{
		File file = new File("dataLogOLD.txt");
		Scanner input = new Scanner(file);
		String getString = input.nextLine();
		String email = "";
		UserOld[] userList = new UserOld[10];
		int k = 0;
		
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
			UserOld data = new UserOld(email, sessionLengths, password);
			
			userList[k] = data;
			
			
			/*to add new session or change password for specific user
			if(k == 0)
			{
				data.changePassword("justin");
				data.addNewSession(10);
			}
			*/
			
			//increment userList
			k++;
			
			getString = input.nextLine();
		}	
		
		System.out.println(printUserData(userList));
		System.out.println("The most experienced user is " + mostExperiencedUser(userList) + ".");
		
		input.close();
	}
	
	public static String printUserData(UserOld[] userData)
	{
		int length = 0;
		String results = "";
		
		for (int i = 0; i < userData.length; i++)
		{
			if(userData[i] != null)
			{
				length++;
			}
		}
		UserOld [] newUserData = new UserOld [length];
		
		for (int k = 0; k < length; k++)
		{
			newUserData[k] = userData[k];
			results += newUserData[k];
		}
		return results;
	}
	
	public static String mostExperiencedUser(UserOld[] loginData)
	{
		int mostTime = 0;
		String userWithTime = "";
		
		for (int i = 0; i < loginData.length; i++)
		{
			if(loginData[i] != null && loginData[i].getTotalTimeSpent() > mostTime)
			{
				mostTime = loginData[i].getTotalTimeSpent();
				userWithTime = loginData[i].getUsername();
			}
		}
		return userWithTime;
	}
}