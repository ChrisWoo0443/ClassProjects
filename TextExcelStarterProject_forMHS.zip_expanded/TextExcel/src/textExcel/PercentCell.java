package textExcel;

public class PercentCell extends RealCell{
	
	public PercentCell(String input) 
	{
		super(input.substring(0, input.length() - 1));
	}
	
	//shortens user input to 10 spaces and add percent sign back to the end of string
	public String abbreviatedCellText()
	{
		String abbrevText = getDoubleValue() + "";
		if(abbrevText.contains("."))
		{
			abbrevText = abbrevText.substring(0, abbrevText.indexOf("."));
		}
		abbrevText += "%         ";
		return abbrevText.substring(0, 10);
	}
	
	//converts percent into decimal
	public String fullCellText()
	{
		double input = getDoubleValue();
		String fullText = (input/100) + "";
		return fullText;
	}
	
	//returns input as a double
	public double getDoubleValue()
	{
		return super.getDoubleValue();
	}
}
