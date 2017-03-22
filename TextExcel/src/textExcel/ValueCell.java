package textExcel;

public class ValueCell extends RealCell {
	
	public ValueCell(String input)
	{
		super(input);
	}
	
	public double getDoubleInput()
	{
		String input=getCellText();
		double integer=Double.parseDouble(input);
		return integer;
	}
	
	public String abbreviatedCellText()
	{
		String input = getCellText();
		double abbreviated=Double.parseDouble(input);
		input = abbreviated + "";
		if(input.length() > 10){
			input += (".0");
		}
		int difference = 10 - input.length();
		for (int i = 0; i < difference; i++) {
			input += " ";
		}
		return input.substring(0,10);
	}
	
	public String fullTextCell()
	{
		return  getDoubleInput()+"";
	}
}