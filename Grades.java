// Program written by Chris Woo
// Created July 13, 2021
// Lab7, Looping
// This program will allow the user to input multiple test scores and
// give the average, lowest, highest, and number 

import java.util.Scanner;
public class Grades
{
    public static void main (String[] args)
    {
        Scanner input = new Scanner(System.in);
        double scores, number, highest, lowest, last, average;

        number = 0;
        highest = 0;
        lowest = 0;
        scores = 0;
        last = 0;

        System.out.println("Enter student test scores." +
                            " Enter a number less than 0 to stop.");

        last = input.nextDouble();

        while (last >= 0)
        {
            // gives the error if a score above 100 is entered
            if (last > 100)
            {
                System.out.println("Error: Try a score less than 100.");
                last = 0; 
            }
            
            // finds the lowest and highest scores
            // adds the scores and counts how many scores
            else
            {   
                if (lowest == 0.0)
                    lowest = last;

                if (last < lowest)
                    lowest = last;

                if (last > highest)
                    highest = last;

                scores += last;
                number++;
            }
            last = input.nextDouble();   
        }

        // print the amount of scores, the lowest score, the highest score
        // and the average of the scores
        if (number > 0)
        {
            average = scores/number;
            System.out.println("The number of scores is " + number);
            System.out.println("The highest score is " + highest);
            System.out.println("The lowest score is " + lowest);
            System.out.printf("The average is %.2f", average);
        }
        input.close();
    }
}
// output:
// Enter student test scores. Enter a number less than 0 to stop.
// 125
// Error: Try a score less than 100.
// 25
// 50
// 75
// 100
// -1
// The number of scores is 4.0
// The highest score is 100.0
// The lowest score is 25.0
// The average is 62.50