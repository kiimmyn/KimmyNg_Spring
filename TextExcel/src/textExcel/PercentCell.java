package textExcel;

public class PercentCell extends RealCell{
	
	public PercentCell(String input){
		super(input);
	}
	
	public String abbreviatedCellText(){
		String input=getCellText();
		if(input.length() < 10){
			input=input.substring(0,input.indexOf("."))+"%";
			int diff = 10 - input.length();
			for(int i = 0; i < diff; i++){
				input += " ";
			}
		}
		return input.substring(0,10);
	}
	
	public String fullCellText() {
		return (getDoubleValue()/100.0) + "";					
	}
	
	public double getDoubleValue(){
		return Double.parseDouble(super.fullCellText().substring(0, super.fullCellText().length()-1));
	}
}