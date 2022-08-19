//Chris Woo
//August 31, 2021
//This class reates methods to be run in the class DoMath or other future coding projects
public class Calculate 
{
	//takes an integer and squares it (input is 7)
	public static int square(int x)
	{
		return x * x;
	}
	
	//takes an integer and cubes it (input is 2)
	public static int cube(int x)
	{
		return x * x * x;
	} 
	
	//takes two doubles and gets the average (input is 5, 15 and the result is 10)
	public static double average(double num1, double num2)
	{
		return (num1 + num2) / 2;
	}
	
	//takes 3 doubles and gets the average (input is 4,10,7 and the result is 7)
	public static double average(double num1, double num2, double num3)
	{
		return (num1 + num2+ num3) / 3;
	}
	
	//takes an input double for radians and converts it to degrees
	public static double toDegrees(double x)
	{
		return (x * 180) / 3.14159;
	}
	
	//takes an input double for degrees and converts it to radians
	public static double toRadians(double x)
	{
		return (x * 3.14159) / 180;
	}
	
	//takes three doubles and plugs them into the equation for the discriminant
	public static double discriminant(double a, double b, double c)
	{
		return (b * b) - 4 * (a * c);
	}
	
	//takes 3 integers and converts them into an improper fraction
	public static String toImproperFrac(int num1, int num2, int num3)
	{
		int numerator;
		numerator = num1 * num3 + num2;
		String fraction = numerator + "/" + num3;
		return fraction;
	}
	
	//takes 2 integers and converts them into a mixed fraction
	public static String toMixedNum(int num1, int num2)
	{
		String mixed;
		int whole = num1 / num2;
		int numerator = num1 % num2;
		mixed = whole + "_" + numerator + "/" + num2;
		return mixed;
	}
	
	//Takes 4 integers and a string to convert a binomial multiplication into a quadratic equation
	public static String foil(int num1, int num2, int num3, int num4, String letter)
	{
		int groupOne = num1 * num3;
		int groupTwo = (num1 * num4) + (num2 * num3);
		int groupThree = num2 * num4;
		String quad = groupOne + letter + "^2 " + "+ " + groupTwo + letter + " + " + groupThree;
		return quad;
		
		// String quadratic = (num1 * num2) + "x^2" +  "+" + ((num1 * num4) + (num2 * num3)) + "x+ " + (num2 * num4);
		// return quadratic;
	}
	
	//this method determines whether or not one integer is evenly divisible by another
	public static Boolean isDivisibleBy(int num1, int num2)
	{
		if(num2 == 0)throw new IllegalArgumentException("cannot divide by 0");
		if(num1 % num2 == 0)
			return true;
		else
			return false;
	}
	
	//this method returns the absolute value of the number passed
	public static double absValue(double num1)
	{
		if (num1 < 0)
		{
			num1 = num1 * -1;
			return num1;
		}
		else
			return num1;
	}
	
	//this method returns the larger of the values passed
	public static double max(double num1, double num2)
	{
		if(num1 > num2)
			return num1;
		else
			return num2;
	}
	
	//this methods returns the larger of the values passed
	public static double max(double num1, double num2, double num3)
	{
		if(num1 >= num2 && num1 >= num3)
			return num1;
		if(num2 >= num1 && num2 >= num3)
			return num2;
		if(num3 >= num1 && num3 >= num2)
			return num3;
		else
			return num1;
		
	}
	
	//this method returns the smaller of the values passed
	public static int min(int num1, int num2)
	{
		if(num1 < num2)
			return num1;
		else
			return num2;
	}
	
	//This method rounds a double correctly to 2 decimal places
	public static double round2(double num1)
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
	
	//raises a value to a positive integer
	public static double exponent(double num1, int num2)
	{
		double num3 = num1;
		if(num2 < 0 )throw new IllegalArgumentException("negative number, try again");
		if (num1 == 0 && num2 == 0) throw new IllegalArgumentException("error try a different number");
		for(int i = 1; i < num2; i++)
		{
			num1 *= num3;
		}
		if(num2 == 0)
		{
			num1 = 1;
		}
		return num1;
	}	
	
	//returns the factorial of the value passed
	public static int factorial(int num1)
	{
		int count = num1;
		if(num1 < 0)throw new IllegalArgumentException("negative number, try again");
		while(count != 1)
		{
			num1 *= (count - 1);
			count--;
		}
		if(num1 == 0)
		{
			num1 = 1;
		}
		return num1;
	}
	
	//this method determines whether or not an integer is prime
	public static Boolean isPrime(int num1)
	{ 
		int check = num1 - 1;
		Boolean result = false;
		while(check > 1 && result == false)
		{
			result = isDivisibleBy(num1,check);
			check--;
		}
		return !result;
	}
	
	//a call to gcf finds the greatest common factor of two integers
	public static int gcf(int num1, int num2)
	{
		int big = (int) max(num1,num2);
		int small = min(num1,num2);
		int replace;
		while(small != 0)
		{
			replace = big % small;
			big = small;
			small = replace;
		}
		return big;
	}
		

	//a call to sqrt returns an approximation of the square root of the value passed, rounded to two decimal places
	public static double sqrt(double num1)
	{	
		double replace, guess;
		guess = num1 / 2;
		if(num1 < 0)throw new IllegalArgumentException("negative number, try again");
		while((absValue(num1 - (guess * guess)) >= 0.005))
		{
			replace = guess;
			guess = (((num1 / replace) + replace) / 2);
		}
		return round2(guess);
	}
	
	//Uses quadratic formula to approximate the real roots, if any.
	public static String quadForm(int num1, int num2, int num3)
	{
		double root1, root2;
		String result = "";
		
	
		//no roots
		if(discriminant(num1, num2, num3) < 0)
		{
			return result = "no real roots";
		}
		//one root
		if(discriminant(num1, num2, num3) == 0)
		{
			root1 = ((-1 * num2) + (sqrt(discriminant(num1, num2, num3)))) / (2 * num1);
			return result = "" + round2(root1);
		}
		//two roots
		if(discriminant(num1, num2, num3) > 0)
		{
			root1 = ((-num2) + (sqrt(discriminant(num1, num2, num3)))) / (2 * num1);
			root2 = ((-num2) - (sqrt(discriminant(num1, num2, num3)))) / (2 * num1);
			if(root1 > root2)
				return result = round2(root2) + " and " + round2(root1);
			else
				return result = round2(root1) + " and " + round2(root2);
		}
		return result;
	}
	
	public static int deal()
	{	
	return (int) (Math.random() * 10 + 1);
	}

	
	public static boolean play()
	{
		int hand = 0;
		while (hand < 18)
		{
			hand += deal();
		}
		if(hand < 21)
			return true;
		return false;
	}
} 




















