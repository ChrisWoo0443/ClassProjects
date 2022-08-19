package textExcel;

public class TextCell implements Cell 
{
	private String cellText;
	
	public TextCell(String text)
	{
		cellText = text;
	}

	//returns the abbreviated cell without quotes
	public String abbreviatedCellText()
	{
		String abbreviatedString = cellText;
		abbreviatedString = (cellText.substring(0, cellText.length() - 1) + "          ").substring(1,11);
		return abbreviatedString;
	}

	public String fullCellText() 
	{
		return cellText;
	}

}
