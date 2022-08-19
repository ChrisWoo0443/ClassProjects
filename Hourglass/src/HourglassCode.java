import java.util.*;

public class HourglassCode 
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		System.out.println("How big do you want the hourglass to be?");
		int numberOfRows = input.nextInt();
		
		
		System.out.println(base(numberOfRows));
		System.out.print(topHalf(numberOfRows));
		System.out.println(middle(numberOfRows));
		System.out.print(bottomHalf(numberOfRows));
		System.out.print(base(numberOfRows));
		
		ArrayList <Integer> list1 = new ArrayList<Integer>();
		list1.add(5);
		list1.add(6);
		list1.add(7);
		list1.add(1,9);
		
		for(int i = 0; i < list1.size(); i++)
		{
			System.out.println(list1.get(i));
		}
		
		
		input.close();
	}
	

	
	public static String base(int num1)
	{
		String result = "|";
		for (int i = 1; i <= num1; i++)
		{
			result += "\"";
		}
		result += "|";
		return result;
	}

	public static String topHalf(int num1)
	{
		String results = "";
		for(int rows = 1; rows < (num1)/2; rows++)
		{
			for(int spaces= 0; spaces < rows; spaces++)
			{
				results += " ";
			}
			results += "\\";
			
			for(int dots = 1; dots <= num1 - (2 * rows); dots++)
			{
				results += ":";
			}
			results += "/\n";
		}
		return results;
	}
	
	public static String middle(int num1)
	{
		String results = "";
		for(int i = 1; i <= num1/2; i++)
		{
			results += " ";
		}
		results += "|";
		if (num1 % 2 != 0)
		{
			results += " ";
		}
		results += "|";
		return results;
	}
	
	public static String bottomHalf(int num1)
	{
		String results = "";
		for(int rows = 1; rows < num1/2; rows++)
		{
			for(int spaces = num1/2; spaces > rows; spaces--)
			{
				results += " ";
			}
			results += "/";
			
			for (int dots = 1; dots <= (rows * 2); dots++)
			{
				results += ":";
			}
			if(num1 % 2 != 0)
			{
				results += ":";
			}
			results += "\\\n";
		}
		return results;
	}
	
	/*
	Original working hourglass code for 10 rows
	
	public static void main(String[] args)
	{
		//System.out.print(base());
		//System.out.print(topHalf());
		//System.out.println(middle());
		//System.out.println(bottomHalf());
		//System.out.print(base());
	}
	
	public static String base()
	{
		return "|\"\"\"\"\"\"\"\"\"\"|";
	}
	
	public static String middle()
	{
		return ("     ||");
	}
	
	public static String topHalf()
	{
		String results = "";
		for(int row = 1; row <= 4; row++)
		{
			for(int spaces = 1; spaces <= row; spaces++)
			{
				results += " ";
			}
			results += "\\";
			
			for(int dots= 1; dots <= 10-2*row; dots++)
			{
				results += ":";
			}
			results += "/\n";
		}
		return results;
	}
	
	public static String bottomHalf()
	{
		String results = "";
		for(int row = 1; row <=4; row++)
		{
			for(int spaces = 4; spaces >= row; spaces--)
			{
				results += " ";
			}
			results += "/";
			
			for(int dots = 1; dots <= 2*row; dots++)
			{
				results += ":";
			}
			results += "\\\n";
		}
		return results;
	}*/
}

