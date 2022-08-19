public class PickAMountain 
{
	public static void reportTallest(String mt1, int h1, String mt2, int h2)
	{
		
		int tallest;
		String tallName;
		String shortName;
		if(h1 > h2)
		{
			tallest = h1;
			tallName = mt1;
			shortName = mt2;
		}
		else
		{
			tallest = h2;
			tallName = mt2;
			shortName = mt1;
		}
		System.out.println("At " + tallest + " ft, " + tallName + " is taller than " + shortName);	
	}
	

	public static int getRandomInt(int low, int high)
	{
		return (int)(Math.random()*(high-low +1))+ low;
	}
	
	
	public static void main(String[] args) 
	{
		// Initialize personA and personB
		String personA = "Justin";
		String personB = "Mathew";
		
		// Welcome the people by name.  Use the variables you just created.
		System.out.println("Welcome " + personA + " and " + personB);
		System.out.println("Let's see who gets to make the choice.");
		System.out.println("Roll the dice - highest number goes first!");
		
		// Call getRandomInt to set numA and numB 

		int numA = getRandomInt(1,6);
		int numB = getRandomInt(1,6);
		
		// Print result of dice roll: 
		//    _________ rolled a ___, and ________ rolled a ___ so __________ chooses.
		
		String higherRoll;
		
		if(numA > numB)
		{
			higherRoll = personA;
		}
		else
		{
			higherRoll = personB;
		}
		if(numA == numB)
		{
			numA = getRandomInt(1,6);
			numB = getRandomInt(1,6);
		}
		
		System.out.println(personA + " rolled a " + numA + ", and " + personB + " rolled a " + numB + " so " + higherRoll + " chooses.");
		
		// Call reportTallest with the following mountains and heights:
		//    Mount Diablo... 3849ft
		//    Half Dome... 8839 ft
		
		reportTallest("Mount Diablo", 3849, "Half Dome", 8839);
		
		System.out.println("Liking a challenge, that's the one they choose.");
	}

}
