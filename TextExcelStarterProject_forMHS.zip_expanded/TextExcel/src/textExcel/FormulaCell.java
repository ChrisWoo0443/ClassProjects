package textExcel;

public class FormulaCell extends RealCell
{
	private Spreadsheet grid;
	
	
	public FormulaCell(String input, Spreadsheet sheet) 
	{
		//gets rid of parentheses
		super(input.substring(1, input.length() - 1));
		grid = sheet;
		

	}
	
	//calculates formula from left to right no order of operations
	public double getDoubleValue()
	{
		//without pemdas
		//splits formula command at " "
		double total = 0;
		String [] formulaSplit = super.fullCellText().split(" ");
		
		//checks for sum or average
		if(formulaSplit[1].toUpperCase().equals("SUM") || formulaSplit[1].toUpperCase().equals("AVG"))
		{
			total = SumAvg(formulaSplit);
		}
		//normal math operations
		else
		{
			total = getValue(formulaSplit[1]);
			for(int i = 2; i < formulaSplit.length; i += 2)
			{
				//checks for addition
				if(formulaSplit[i].contains("+"))
				{
					total += getValue(formulaSplit[i + 1]);
				}
				//checks for subtraction
				if(formulaSplit[i].contains("-"))
				{
					total -= getValue(formulaSplit[i + 1]);
				}
				//checks for division
				if(formulaSplit[i].contains("/"))
				{
					total /= getValue(formulaSplit[i + 1]);
				}
				//checks for multiplication
				if(formulaSplit[i].contains("*"))
				{
					total *= getValue(formulaSplit[i + 1]);
				}
			}
		}
		return total; 
		
	}
	
	//returns entire user input of formula
	public String fullCellText()
	{
		return "(" + super.fullCellText() + ")";
		//return "( " + super.fullCellText() + " )";
	}
	
	//method from live agenda, checks if string is a numerical value
	public static boolean isNumeric(String str) 
	{ 
		  try 
		  {  
		    Double.parseDouble(str);  
		    return true;
		  } 
		  catch(NumberFormatException e)
		  {
		    return false;  
		  }  
	}
	
	//uses isNumeric to check if string has a cell label to get its value
	public double getValue(String value)
	{
		double val;
		//if it is a value return it as a double
		if(isNumeric(value))
		{
			val = Double.parseDouble(value);
		}
		//else, it is a cell identifier, return the value in that cell
		else
		{
			SpreadsheetLocation loc = new SpreadsheetLocation(value);
			RealCell cell = (RealCell)grid.getCell(loc);
			val = cell.getDoubleValue();
		}
		return val;
	}
	
	//this methods calculates the sum or average based on the command given by the user
	public double SumAvg(String [] formula)
	{
		//splits command at the hyphen to find the two cell locations of the cell range
		String [] formulaSplit = formula[2].split("-");
		double total = 0;
		double addUp = 0;
		double counter = 0;
		
		//location of the first and last cell
		SpreadsheetLocation firstLocation = new SpreadsheetLocation(formulaSplit[0]); 
		SpreadsheetLocation lastLocation = new SpreadsheetLocation(formulaSplit[1]);
		
		//adds up all the values in the cell range given by the user
		for(int col = firstLocation.getCol(); col <= lastLocation.getCol(); col++)
		{
			for(int row = firstLocation.getRow(); row <= lastLocation.getRow(); row++)
			{
				RealCell cell = (RealCell) grid.getCell(row, col);
				addUp += cell.getDoubleValue();
				//counts how many cells were looked at
				counter++;
			}
		}
		
		//sets total = to all the values added up
		if(formula[1].toUpperCase().equals("SUM"))
		{
			total = addUp;
		}
		
		//takes all the values added up divided by how many cells were counted
		if(formula[1].toUpperCase().equals("AVG"))
		{
			total = addUp / counter;
		}
		return total;
	}
}
