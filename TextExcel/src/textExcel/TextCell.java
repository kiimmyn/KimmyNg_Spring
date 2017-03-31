package textExcel;

public class TextCell implements Cell {
	
	private String txt;
	private int length;
	
	public TextCell(String txtCell){
		txt = txtCell;
		length = txtCell.length();
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


