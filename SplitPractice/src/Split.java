import java.util.*;
//Chris Woo
//November 4, 2021
//Practice using String method split()

public class Split 
{
	public static void main(String[] args) 
	{

// Your task Part 0

//String.split();

//It's a method that acts on a string, <StringName>.split(<sp>);

//Where sp is the string where the string splits

//And it returns an array

// Example: "I like apples!".split(" ");

// it will split at spaces and return an array of ["I","like","apples!"]
		String[] arr1 = "I like apples!".split(" ");
		System.out.println(Arrays.toString(arr1));

// Example 2: "I really like really red apples!".split("really")

// it will split at the word "really" and return an array of ["I "," like ","red apples!"]
		String[] arr2 = "I really like really red apples!".split("really");
		System.out.println(Arrays.toString(arr2));

//play around with String.split!
		String[] arr3 = "I really like really red apples!".split("the");
		System.out.println(Arrays.toString(arr3));

//What happens if you "I reallyreally likeapples".split("really") ?
		String[] arr4 = "I reallyreally likeapples".split("really");
		System.out.println(Arrays.toString(arr4));
		
		//test part 1
		System.out.println(Arrays.toString(sandwich("applespineapplesbreadlettucetomatobaconmayohambreadcheese")));
		
		System.out.println(Arrays.toString(sandwichIng2("apples pineapples bread lettuce tomato bacon mayo ham bread cheese")));
	}
		
//Your task Part 1:

/*Write a method that take in a string like

* "applespineapplesbreadlettucetomatobaconmayohambreadcheese"

* describing a sandwich.

* Use String.split to split up the sandwich by the word "bread" and return what's in the middle of

* the sandwich and ignores what's on the outside

* What if it's a fancy sandwich with multiple pieces of bread?

*/
	public static String[] sandwich(String str)
	{
		String [] splitIngredient = str.split("bread");
		String[] middleOfSandwich = new String [1];

		if(splitIngredient.length == 0)
		{
			middleOfSandwich[0] = "Not a sandwich";
		}
		else
		{
			if(splitIngredient.length > 1)
			{
				middleOfSandwich[0] = splitIngredient[1];
			}
			if(middleOfSandwich[0] == null)
			{
				middleOfSandwich[0] = "Not a sandwich";
			}
			if(splitIngredient[1].equals(""))
			{
				middleOfSandwich[0] = "Not a sandwich";
			}
		}
		return middleOfSandwich;
	}
	
	
//Your task pt 2:

/*Write a method that take in a string like

* "apples pineapples bread lettuce tomato bacon mayo ham bread cheese"

* describing a sandwich

* use String.split to split up the sandwich at the spaces, " ", and return what's in the middle of

* the sandwich and ignores what's on the outside.

*The output for the example above should be lettucetomatobaconmayoham

* You should call the method from part one in order to increase your reuse of code and reduce

*the complexity of part 2.

*/

	public static String[] sandwichIng2 (String str)
	{
		String[] arr1 = str.split(" ");
		String[] arr2 = str.split("bread");
		String[] arr3 = new String[1];
		int count = 0;
		
		for(int i = 0; i < arr1.length; i++)
		{
			if(arr1[i].equals("bread"))
				count++;
		}

		if(count < 2)
		{
			arr3[0] = "Not a sandwich";
		}
		else
		{
				arr3[0] = arr2[1].replaceAll(" ","");
				
				if(arr3[0].equals(""))
				{
					arr3[0] = "Not a sandwich";
				}
		}
		return arr3;
	}
}