package textExcel;

public abstract class RealCell implements Cell {

	private String content;
	
	public String getCellText()
	{
		return content;
	}
	
	public void setCellText(String update){
		content = update;
	}
	
	public RealCell(String input){
		content = input;
	}
	
	public double getDoubleValue(){
		return 0;
	}
	
	public String abbreviatedCellText() 
	{
		String newContent = content;
		if (content.length()>10){
			return content.substring(0,10);
		}
		int spaces=10-content.length();
		for (int i=0;i<spaces;i++)
			newContent=newContent+" ";
		return newContent;
	}

	@Override
	public String fullCellText() 
	{
		return content;
	}
}