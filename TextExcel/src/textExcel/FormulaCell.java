package textExcel;

public class FormulaCell extends RealCell{
	
	public FormulaCell(String form){
		super(form);
	}
	
	public String abbreviatedTextCell1(){
		
	String input = getDoubleValue() + ""; 
		if (input.length() > 10) {
			return input.substring(0, 10);
		}
			else{
				for (int i = input.length(); i<10; i++){
					input += "";
				}
			return input;
		}
	}
	
		public String fullCellText() {
			return super.fullCellText();
			}
		 public double getDoubleValue(){
			 String formula = getCellText();
			 String[] split= formula.split(""); 
			 double value = Double.parseDouble(split[0]);
			 for (int i=1; i < split.length; i++){
 				 if (split[i].equals(""))
					 value *= Double.parseDouble(split[i+1]);
				 else if (split[i].equals ("/"))
					 value /= Double.parseDouble(split[i+1]);
				 else if (split[i].equals("+"))
					 value += Double.parseDouble(split[i+1]);
				 else if (split[i].equals("-"))
					 value -= Double.parseDouble(split[i+1]);
				 else{
			 }
			 }
			 return value;
		 }
}
	
	
	
	