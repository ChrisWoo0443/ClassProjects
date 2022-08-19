import java.util.Arrays;

public class LotsOfCopies 
{
	public static void main(String[]args)
	{
		int num = 7;
		String strMain = "APCS";
		int[] arrMain = {1, 2, 3, 4, 5};
		
		System.out.println(num);
		System.out.println(strMain);
		System.out.println(Arrays.toString(arrMain));
		changeMe(num, strMain, arrMain);
		System.out.println(num);
		System.out.println(strMain);
		System.out.println(Arrays.toString(arrMain));
	}
	
	public static void changeMe (int x, String str, int[] arr)
	{
		x = 2 * x;
		str = str + " is cool";
		arr [4] = 2;
	}
}
