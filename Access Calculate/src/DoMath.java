//Chris Woo
//August 31, 2021
//Calls methods from the class Calculate
public class DoMath 
{
	public static void main(String[] args) 
	{
		System.out.println(Calculate.square(-7));
		System.out.println(Calculate.cube(2));
		System.out.println(Calculate.average(5,15));
		System.out.println(Calculate.average(4,10,7));
		System.out.println(Calculate.toDegrees(5));
		System.out.println(Calculate.toRadians(180));
		System.out.println(Calculate.discriminant(3,24,48));
		System.out.println(Calculate.toImproperFrac(3,1,2));
		System.out.println(Calculate.toMixedNum(7,2));
		System.out.println(Calculate.foil(2,3,6,-7, "n"));
		System.out.println(Calculate.isDivisibleBy(5,1));
		System.out.println(Calculate.absValue(25));
		System.out.println(Calculate.max(5,30));
		System.out.println(Calculate.max(0,0,-0.1));
		System.out.println(Calculate.min(30,10));
		System.out.println(Calculate.round2(0.00000));
		System.out.println(Calculate.exponent(1,2));
		System.out.println(Calculate.factorial(9));
		System.out.println(Calculate.isPrime(17));
		System.out.println(Calculate.gcf(0,0));
		System.out.println(Calculate.sqrt(10));
		System.out.println(Calculate.quadForm(6,10,-1));
		System.out.println(Calculate.play());
	}

}
