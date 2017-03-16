package textExcel;

//Update this file with your own code.

public class SpreadsheetLocation implements Location
{
	private int row;
    private int column;
    
	@Override
    public int getRow(){
        return this.row;
    }

    @Override
    public int getCol(){
    	return this.column;
    }
    
    public SpreadsheetLocation(String cellName){
    	row = Integer.parseInt(cellName.substring(1)) - 1;
    	column = cellName.charAt(0);
    	column = Character.toUpperCase(column) - 'A';
    }
}
