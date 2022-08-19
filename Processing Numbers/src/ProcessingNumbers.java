//Chris Woo
//October 20, 2021
//This program takes in numbers from a user and process the numbers to give you the smallest, largest, sum of the even numbers, and largest even number

import java.util.Scanner;

public class ProcessingNumbers {

	public static void main(String[] args) 
	{
		Scanner input = new Scanner(System.in);
		int max = 0;
		int min = 0;
		int maxEven = 0;
		int sumOfEven = 0;
		
		System.out.println("Give me some numbers. \nType a negative number to stop.");
		String userNum = input.next();
		
		while(!userNum.equals("quit"))
		{	
			int userInput = Integer.parseInt(userNum);
			
			if(min == 0)
				min = userInput;
			
			if(userInput > max)
				max = userInput;
			
			if(userInput < min)
				min = userInput;
			
			if(userInput % 2 == 0 && userInput > maxEven) 
				maxEven = userInput;
			
			if(userInput % 2 == 0)
				sumOfEven += userInput;
		
			userNum = input.next();
		}
		System.out.println("The smallest number was " + min);
		System.out.println("The largest number was " + max);
		System.out.println("The sum of even numbers is " + sumOfEven);
		System.out.println("The largest even number is " + maxEven);
		
		input.close();
	}
}