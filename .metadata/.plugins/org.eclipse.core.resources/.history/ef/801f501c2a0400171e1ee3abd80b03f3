package textExcel;

// Update this file with your own code.

public class Spreadsheet implements Grid
{
	private int row;
	private int column;
	
		Cell[][] excellSpreadsheet = new EmptyCell [12][20];
		
	@Override
	public String processCommand(String command)
	{
		String[] splitted = command.split(" ");
		if (splitted.equals("clear")) {
			if (splitted.length > 6) {
				// clears the given cell
				Location clear= new SpreadsheetLocation(splitted[1]);
				Cell change=getCell(clear);
				change=new EmptyCell();
			} else {
				// clears the entire spreadsheet
				excellSpreadsheet=new Cell [20][12];
				for(int i=0; i<20; i++){
					for(int j=0; j<12;j++){
						excellSpreadsheet[i][j]=new EmptyCell();
					}
				}
			}
		} else if (splitted[1].equals("=")) {
			Location equals = new SpreadsheetLocation(splitted[0]);
			Cell change = getCell(equals);
			change = new TextCell splitted[2]);
			return getGridText();
		} else if (splitted.length == 1) {
			Location one = new SpreadsheetLocation(splitted[0]);
			Cell n = getCell(one);
			return n.fullCellText();
		}
		return command;
	
		// TODO Auto-generated method stub
		return command;
	}

	@Override
	public int getRows()
	{
		// TODO Auto-generated method stub
		row = 20;
		return row;
	}

	@Override
	public int getCols()
	{
		// TODO Auto-generated method stub
		column= 12;
		return column;
	}

	@Override
	public Cell getCell(Location loc)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getGridText()
	{
		// TODO Auto-generated method stub
		return null;
	}

}
