package textExcel;

public class TextCell implements Cell {
	
	private String txt;
	private int length;
	
	public TextCell(String textCell){
		txt = textCell;
		length = textCell.length();
	}
	
	@Override
	public String abbreviatedCellText() {
		return (txt + "          ").substring(0, 10);
	}
	
	@Override
	public String fullCellText() {
		return ("\"" + txt.substring(0, length) + "\"");
	}
}


