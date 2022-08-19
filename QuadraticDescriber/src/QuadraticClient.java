//Chris Woo
//October 3, 2021
//This class calls methods made in the class Quadratic to describe a quadratic equation and its graph 
// given by the user
import java.util.Scanner;
public class QuadraticClient 
{
	public static void main(String[] args)
	{
		double coefA, coefB, coefC;
		String goAgain = "continue";

		Scanner input = new Scanner(System.in);
		
		//loop runs until user types quit 
		while(!"quit".equals(goAgain))
		{
			System.out.println("Welcome to the Quadratic Describer");
			System.out.println("Please provide coefficients for a, b, and c"); 
			
			//asks user for each value
			System.out.print("a: ");
			coefA = input.nextDouble();
			System.out.print("b: ");
			coefB = input.nextDouble();
			System.out.print("c: ");
			coefC = input.nextDouble();
			
			//runs method quadDescriber, gives all information of quadratic
			Quadratic.quadDescriber(coefA, coefB, coefC);

			//asks user if they want to continue, any int/double/char/string will continue loop
			System.out.println("Do you want to keep going? (Type \"quit\" to end)");
			goAgain = input.next();
		}
		input.close();
		
	}
}
