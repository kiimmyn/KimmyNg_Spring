package textExcel;

public abstract class RealCell implements Cell {

	private String input;
	
	public String getCellText()
	{
		return input;
	}
	
	public void setCellText(String restore){
		input = restore;
	}
	
	public RealCell(String output){
		input = output;
	}
	
	public double getDoubleValue(){
		return 0;
	}
	
	public String abbreviatedCellText() 
	{
		String newContent = input;
		if (input.length()>10){
			return input.substring(0,10);
		}
		int spaces=10-input.length();
		for (int i=0;i<spaces;i++)
			newContent=newContent+" ";
		return newContent;
	}

	@Override
	public String fullCellText() 
	{
		return input;
	}
}