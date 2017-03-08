package textExcel;

public class TextCell implements Cell {
	
	private String content;
	
		public TextCell (String str){
			str= content;
		}

	@Override
	public String abbreviatedCellText() {
		// TODO Auto-generated method stub
		return content;
	}

	@Override
	public String fullCellText() {
		// TODO Auto-generated method stub
		return content;
	}

}
