// Program created by Chris Woo
// Created on July 1, 2021
// Lab 4, More Math in Java
// This program converts degrees from Fahrenheit to Celsius

import java.util.Scanner;
public class Degrees
{
    public static void main(String[] args)
    {
        Scanner temp = new Scanner(System.in);
        
        System.out.println("Enter a temperature in degrees Fahrenheit:");
        
        int fahrenheit = temp.nextInt();
        double celcius = (double) 5*(fahrenheit-32)/9;
        
        System.out.printf(fahrenheit + " degrees Fahrenheit is %.1f degrees"
                          + " Celcius.", celcius);

        temp.close();
    }
}

// Enter a temperature in degrees Fahrenheit:
// 90
// 90 degrees Fahrenheit is 32.2 degrees Celcius.