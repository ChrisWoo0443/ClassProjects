//Chris Woo
//October 3, 2021
//This class contains methods used by QuadraticClient to provide information on a quadratic equation given by the user
public class Quadratic 
{
	//method provides all the information about a quadratic
	public static void quadDescriber (double coefA, double coefB, double coefC)
	{	
		System.out.println("");
		System.out.println(coefA + "x^2 + " + coefB + "x + " + coefC);
		
		System.out.println("");
		if(coefA > 0)
		{
			System.out.println("Opens: up");
		}
		else
		{
			System.out.println("Opens: down");
		}
		
		System.out.println("Axis of Symmetry: " + round2(lineOfSymmetry(coefA,coefB)));
		System.out.println("Vertex: " + vertex(coefA,coefB,coefC));
		System.out.println("x-intercept(s): " + quadForm(coefA,coefB,coefC));
		System.out.println("y-intercept: " + coefC);
		
		System.out.println("");
	}
	
	//gives the line of symmetry of a quadratic 
	public static double lineOfSymmetry(double coefA, double coefB)
	{
		double symmetry;
		symmetry = (-coefB/(2 * coefA));
		return symmetry;
	}
	
	//rounds a number to have 2 decimal places
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
	
	//gives the vertex of a quadratic equation
	public static String vertex (double coefA, double coefB, double coefC)
	{
		String result;
		double quad;
		quad = coefA * square(lineOfSymmetry(coefA,coefB)) + coefB * lineOfSymmetry(coefA,coefB) + coefC;
		result = "(" + round2(lineOfSymmetry(coefA,coefB)) + "," + round2(quad) + ")";
		return result;
	}
	
	//squares a number
	public static double square(double num1)
	{
		return num1 * num1;
	}
	
	//gives the absolute value of a number
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
	
	//gives the discriminant of a quadratic equation
	public static double discriminant(double coefA, double coefB, double coefC)
	{
		return (coefB * coefB) - 4 * (coefA * coefC);
	}
	
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

	//provides the roots of a quadratic equation
	public static String quadForm(double coefA, double coefB, double coefC)
	{
		double root1, root2;
		String result = "";
		
		if(discriminant(coefA, coefB, coefC) < 0)
		{
			return result = "no real roots";
		}
		if(discriminant(coefA, coefB, coefC) == 0)
		{
			root1 = ((-1 * coefB) + (sqrt(discriminant(coefA, coefB, coefC)))) / (2 * coefA);
			return result = "" + round2(root1);
		}
		if(discriminant(coefA, coefB, coefC) > 0)
		{
			root1 = ((-coefB) + (sqrt(discriminant(coefA, coefB, coefC)))) / (2 * coefA);
			root2 = ((-coefB) - (sqrt(discriminant(coefA, coefB, coefC)))) / (2 * coefA);
			if(root1 > root2)
				return result = round2(root2) + " and " + round2(root1);
			else
				return result = round2(root1) + " and " + round2(root2);
		}
		return result;
	}
}
