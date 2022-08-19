package textExcel;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.*;
// Update this file with your own code.

public class TextExcel
{
	public static void main(String[] args)
	{
	    // Add your command loop here
		Scanner input = new Scanner(System.in);
		Spreadsheet sheet = new Spreadsheet();
		System.out.println(sheet.getGridText());
		System.out.println("Type your command (type quit to stop)");
		String command = input.nextLine();
		
		//checks if user input is "quit"
		while(!command.equalsIgnoreCase("quit"))
		{
			System.out.println(sheet.processCommand(command));
			System.out.println("Type your command (type quit to stop)");
			command = input.nextLine();
		}
		input.close(); 
	}
}
