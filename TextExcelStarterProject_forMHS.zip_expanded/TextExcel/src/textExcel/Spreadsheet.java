package textExcel;

// Update this file with your own code.

public class Spreadsheet implements Grid
{
	private Cell[][] Grid = new Cell[20][12];
	private int rows = 20;
	private int cols =  12;
	
	public Spreadsheet()
	{
		for(int j = 0; j < 20; j++)
		{
			for(int k = 0; k < 12; k++)
			{
				//creates grid full of empty cells
				Grid[j][k] = new EmptyCell();
			}
		}
	}
	
	
	@Override
	public String processCommand(String command)
	{ 
		//checks if comman has equals sign
		if(command.equals(""))
		{
			return "";
		}
		if(command.contains("="))
		{
			//splits command at the equals and spaces before and after it to create an array of 2 elemenets
			String[] commandSplit = command.split(" = ", 2);
			SpreadsheetLocation loc = new SpreadsheetLocation(commandSplit[0]);
			//checks if command has quotes for text cell
			if(commandSplit[1].startsWith("\""))
			{
				Grid[loc.getRow()][loc.getCol()] = new TextCell(commandSplit[1]);
			}
			//checks if command has parentheses for formula cell
			else if(commandSplit[1].startsWith("("))
			{
				Grid[loc.getRow()][loc.getCol()] = new FormulaCell(commandSplit[1], this);
			}
			//checks if command has % for percent cell
			else if(commandSplit[1].endsWith("%"))
			{
				Grid[loc.getRow()][loc.getCol()] = new PercentCell(commandSplit[1]);
			}
			//if it does not contain any of them its a value cell
			else 
			{
				Grid[loc.getRow()][loc.getCol()] = new ValueCell(commandSplit[1]);
			}
		}
		else if(command.toLowerCase().contains("clear"))
		{
			if(command.equalsIgnoreCase("clear"))
			{
				//clears entire grid
				clearAll();
			}
			//cleaer single cell
			else
			{
				String[] commandSplit = command.split(" ", 2); 
				SpreadsheetLocation loc = new SpreadsheetLocation(commandSplit[1]);
				Grid[loc.getRow()][loc.getCol()] = new EmptyCell();
			}
		}
		//displays the contents of the cell
		else if(command.length() < 4)
		{
			SpreadsheetLocation loc = new SpreadsheetLocation(command);
			return getCell(loc).fullCellText();
		}
		return getGridText();
	}

	public int getRows()
	{
		return rows;
	}

	public int getCols()
	{
		return cols;
	}

	//gives the data in a cell
	public Cell getCell(Location loc)
	{
		return Grid[loc.getRow()][loc.getCol()];
	}
	
	//gives the data in a cell
	public Cell getCell(int row, int col)
	{
		return Grid[row][col];
	}

	//returns entire spreadsheet
	public String getGridText()
	{
		String cells = "   ";

		
		for(char letter = 'A'; letter < 'M'; letter++)
		{
			cells += "|" + letter + "         ";
		}
		cells += "|\n";
		
		for(int i = 1; i < 21; i++)
		{
			if(i > 9)
			{
				cells += i + " |";
			}
			else
			{
				cells += i + "  |";
			}
			
			for(int j = 0; j < 12; j++)
			{
				cells += Grid[i-1][j].abbreviatedCellText() + "|";
			}
			cells += "\n";
		}
		return cells;
	}
	
	//clearAll method to clear entire spreadsheet
	public void clearAll()
	{
		for(int j = 0; j < 20; j++)
		{
			for(int k = 0; k < 12; k++)
			{
				Grid[j][k] = new EmptyCell();
			}
		}
	}
}










