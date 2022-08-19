
public class BestOfThree 
{
	
	/* Given low and high integers, getRandomInt picks a random number lying
	 * between them (inclusive).
	 */
	public static int getRandomInt(int low, int high)
	{
		return (int)(Math.random()*(high-low +1))+ low;
	}
	
	/* The roll method accepts no inputs and returns an int, representing 
	 * the result of a dice roll. It must call getRandomInt.
	 */
	public static int roll()
	{
		return getRandomInt(1,6);
		
	}
	
	/* The method bestOf3 accepts 2 strings representing the names of 2 people.
	 * It calls the roll method for each person three times, printing out what 
	 * happened in each roll as shown:
	 *   In roll 1, _______ rolled a ___ and _______ rolled a ___
	 *   In roll 2, _______ rolled a ___ and _______ rolled a ___
	 *   In roll 3, _______ rolled a ___ and _______ rolled a ___
	 * Tracking number of wins for each person, it returns the name of the winner.
	 * (If there's a tie overall, it returns the word "tie".)
	 */
	public static String bestOf3(String name1, String name2)
	{
		int winnerCount1 = 0;
		int winnerCount2 = 0;
		int roundCount = 1;
		String winner = "";
		
		
		for(int i = 1; i <= 3; i++)
		{
			int roll1 = roll();
			int roll2 = roll();
			System.out.println("In roll " + roundCount + ", " + name1 + " rolled a " + roll1 + " and " + name2 + " rolled a " + roll2);
			
			if(roll1 > roll2)
			{
				winnerCount1++;
			}
			else if(roll1 < roll2)
			{
				winnerCount2++;
			}
			else if(roll1 == roll2) {
				System.out.println("In roll " + roundCount + " there was a tie!");
			}
			roundCount++;
		}
		if(winnerCount1 > winnerCount2)
		{
			System.out.println("The winner is " + name1);
		}
		else if(winnerCount1 < winnerCount2)
		{
			System.out.println("The winner is " + name2);
		}
		else if(winnerCount1 == winnerCount2)
		{
			return "tie";
		}
		return winner;
	}
	
	
	public static void main(String[] args) 
	{
		// Call the bestOf3 method passing it the names of 2 people in the class.
		// Print the name of the winner of the dice-rolling competition with !!!" 

		System.out.println(bestOf3("Justin", "Mark"));
		

	}

}
