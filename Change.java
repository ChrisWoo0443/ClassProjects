// Program written by Chris Woo
// Created on July 6, 2021
// Lab5, Making decisions
// This program will determine the amount of change dispensed
// from a vending machine 

import java.util.Scanner;
public class Change
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        int cents, amount, quarters, dimes, nickels;

        System.out.println("Enter price of item (from 25 cents to a dollar "
                            + "in 5 cent increments)");
        cents = input.nextInt();
        amount = cents;
        
        if (cents >= 25 && cents <= 100 && cents %5 == 0)
        {
            System.out.println("You bought an item for " + cents + " cents and " 
                                + "gave me a dollar");
            
            amount = 100 - cents;

            System.out.println("So your change is " + amount + " cents");
          
            quarters = amount / 25;
            amount = amount % 25;
            dimes = amount / 10;
            amount = amount % 10;
            nickels = amount / 5;
            amount = amount % 5; 
            
            System.out.println(quarters + " quarter(s), " + dimes + 
                                " dime(s), " + nickels + " nickel(s), ");
        }
        else 
        {
            if (cents < 25)
                System.out.println("Error: your price is less than 25 cents");
            else if (cents > 100)
                System.out.println("Error: your price is more than 1 dollar");
            else if (cents %5 != 0)
                System.out.println("Error: your price isn't a multiple of 5");
        }

        input.close();
    }
}

// Enter price of item (from 25 cents to a dollar in 5 cent increments)
// 45
// You bought an item for 45 cents and gave me a dollar
// So your change is 55 cents
// 2 quarter(s), 0 dime(s), 1 nickel(s),