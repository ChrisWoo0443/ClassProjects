// Program written by Chris Woo
// Created on June 25, 2021
// Lab3, Keyboad Input and Basic Math
// This program gives the target number for cups of coffee per day based on how many cups of coffee your friend drank the day before

import java.util.Scanner;
public class CoffeeCups
{
    public static void main(String[] args)
    {
        Scanner cups = new Scanner(System.in);
        System.out.println("How many cups of coffee did you drink yesterday?");

        int coffeeYesterday;
        coffeeYesterday = cups.nextInt();

        System.out.println("You drank " + coffeeYesterday + " cup(s) of coffee yesterday.");

        if (coffeeYesterday <= 0)
            System.out.println("Try not to drink coffee today.");
        else 
            System.out.println("Try to drink " + --coffeeYesterday + " cup(s) of coffee today.");

        cups.close();
    }
}

// How many cups of coffee did you drink yesterday?
// 5
// You drank 5 cup(s) of coffee yesterday.
// Try to drink 4 cup(s) of coffee today.