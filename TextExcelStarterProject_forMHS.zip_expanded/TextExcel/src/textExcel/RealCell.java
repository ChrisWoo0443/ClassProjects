package textExcel;

public class RealCell implements Cell
{
	private String userInput;
	
	public RealCell(String input)
	{
		userInput = input;
	}
	
	//shortens user input to 10 spaces
	public String abbreviatedCellText() 
	{
		return (getDoubleValue() + "         ").substring(0,10);
	}

	//returns entire user input
	public String fullCellText() 
	{
		return userInput;
	}
	
	//converts input into a double
	public double getDoubleValue()
	{
		return Double.parseDouble(userInput);
	}
}
