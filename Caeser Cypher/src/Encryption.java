import java.util.*;

//Chris Woo
//Ms. Dreyer
//This program contains methods to encrypt messages using the Caeser Shift method
public class Encryption 
{
	public static void main(String [] args)
	{
		
		/*System.out.println("The encrypted message for \"Chris Woo\" with the key 5 is: " + caeserShift("Chris Woo", 5) + "\n");
		System.out.println("The decrypted message for \"Rfwp Xtqnrfs\" with the key 5 is: " + decryptCaeserShift("Rfwp Xtqnrfs", 5) + "\n");
		
		System.out.println("The 10 digit encryption for \"Hello World\" with the key 1234567891 is: " + tenDigitEncrypt("Hello World", "1234567891") + "\n");
		System.out.println("The 10 digit decryption for \"Igopt Cvzue\" with the key 1234567891 is: " + tenDigitDecrypt("Igopt Cvzue", "1234567891"));
		*/
		
	
		Scanner input = new Scanner(System.in).useDelimiter("\n");
		String quit  = "";
		System.out.println("Do you want to encrypt or decrypt your message");
		System.out.println("Type e or d\n(Type quit to stop)");
		quit = input.next();
		
		while (!quit.equals("quit"))
		{
			if(quit.equals("e"))
			{
				System.out.println("What is your message?");
				String str = input.next(); 
			
				System.out.println("What is the key? (1 digit or 10 digit separated with spaces)");
				String k = input.next();
				
				if(k.contains(" "))
				{
					System.out.println("Your encrypted message is:\n" + tenDigitEncrypt(str, k) + "\n");
				}
				else
				{
					int m = Integer.parseInt(k);
					System.out.println("Your encrypted message is:\n" + caeserShift(str, m) + "\n");
				}
			
				
			}
			else if(quit.equals("d"))
			{
				System.out.println("What do you want to decrypt?");
				String str2 = input.next();
			
				System.out.println("What is the key? (1 digit or 10 digit separated with spaces)");
				String z = input.next();
			
				if(z.length() > 1)
				{
					System.out.println("the decrypted message is:\n"+ tenDigitDecrypt(str2, z) + "\n");
				}
				else
				{
					int x = Integer.parseInt(z);
					System.out.println("The decrypted message is:\n" + decryptCaeserShift(str2, x) + "\n");
				}
					
				
			}
			System.out.println("Do you want to encrypt or decrypt another message");
			System.out.println("Type e or d\n(Type quit to stop)");
			quit = input.next();
		}
		
		input.close(); 
	}
	
	
	//works with both upercase and lowercase
	public static String caeserShift(String plainText, int n)
	{
		String encrypt = "";
		
		for(int i = 0; i < plainText.length(); i++)
		{	
			int j = (int) plainText.charAt(i);

			if(Character.isLetter(plainText.charAt(i)) == true)
			{
				if(j + n > 122)
				{
					encrypt += (char) ((j + n - 122) + 96);
				}
				else if(j + n >= 97 && j + n <= 122)
				{
					encrypt += (char) (j + n);
				}
				else if(j + n >= 65 && j + n <= 90)
				{
					encrypt += (char) (j + n);
				}
				else if(j + n > 90 && j + n < 96)
				{
					encrypt += (char) ((j + n - 90) + 64);
				}
				
			}
			else
			{
				encrypt += plainText.charAt(i);
			}
		}
		
		return encrypt;
	}
	
	//works with both lowercase and uppercase
	public static String decryptCaeserShift(String plainText, int n)
	{
		String decrypt = "";
		
		for(int i = 0; i < plainText.length(); i++)
		{
			int k = (int) plainText.charAt(i);
			
			if(Character.isLetter(plainText.charAt(i)) == true)
			{
				if(k - n < 97 && k - n > 90)
				{
					decrypt += (char) ((k - n + 26));
				}
				else if(k - n <= 122 && k - n >= 97)
				{
					decrypt += (char) (k - n);
				}
				else if(k - n <= 90 && k - n >= 65)
				{
					decrypt += (char) (k - n);
				}
				else if(k - n < 65)
				{
					decrypt += (char) ((k - n) + 26);
				}
			}
			else
			{
				decrypt += plainText.charAt(i);
			}
		}
		return decrypt;
	}
	
	//encryption using 10 digits
	public static String tenDigitEncrypt(String text, String key)
	{
		String newEncryption = "";
		
		int [] num = new int[10];
		char [] arr1 = new char[text.length()];
		String [] arr2 = key.split(" ");
		
		for(int k = 0; k < 10; k++)
		{
		//	num[k] = Integer.parseInt(key.substring(k, k + 1));
		//	num[9] = Integer.parseInt(key.substring(9));
			
			num[k] = Integer.parseInt(arr2[k]);
		}
		
		for(int i = 0; i < text.length(); i++)
		{
			arr1[i] = text.charAt(i);
		}
		
		int count = 0;
		for(int j = 0; j < arr1.length; j++)
		{
			if(Character.isLetter(arr1[j]))
			{
				newEncryption += caeserShift(Character.toString(arr1[j]), num[count]);
				count++;
				if(count > 9)
				{
					count = 0;
				}
			}
			else
			{
				newEncryption += arr1[j];
			}
		}

		return newEncryption;
	}
	
	public static String tenDigitDecrypt(String text, String key)
	{
		String newEncryption = "";
		
		int [] num = new int[10];
		char [] arr1 = new char[text.length()];
		String [] arr2 = key.split(" ");
		
		for(int k = 0; k < 10; k++)
		{
			//num[k] = Integer.parseInt(key.substring(k, k + 1));
			//num[9] = Integer.parseInt(key.substring(9));
			
			num[k] = Integer.parseInt(arr2[k]);
		}
		
		for(int i = 0; i < text.length(); i++)
		{
			arr1[i] = text.charAt(i);
		}
		
		int count = 0; 
		for(int j = 0; j < arr1.length; j++)
		{
			if(Character.isLetter(arr1[j]))
			{
				newEncryption += decryptCaeserShift(Character.toString(arr1[j]), num[count]);
				count++;
				if(count > 9)
				{
					count = 0;
				}
			}
			else
			{
				newEncryption += arr1[j];
			}
		}
		return newEncryption;
	}
	
}
