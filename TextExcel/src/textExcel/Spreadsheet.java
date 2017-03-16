package textExcel;

// Update this file with your own code.

public class Spreadsheet implements Grid
{
	
	Cell[][] excelSpreadsheet;
	
	public Spreadsheet(){
		excelSpreadsheet= new Cell[getRows()][getCols()];
		for(int i = 0; i < getRows(); i++){
			for(int j = 0; j < getCols(); j++){
				excelSpreadsheet[i][j] = new EmptyCell();
			}
		}
	}

	@Override
	public String processCommand(String command){  	
		
		String[] splitted = command.split(" ");
		
		if(command.equals(" ")){
			return "";
		}
		else if(command.equalsIgnoreCase("clear")){
			for(int i = 0; i < getRows(); i++){
				for(int j = 0; j < getCols(); j++){
					excelSpreadsheet[i][j] = new EmptyCell();
				}
			}
			return getGridText();	
		}
		else if(command.toLowerCase().contains("clear ")){
			String changeLoc = splitted[1];
			SpreadsheetLocation location = new SpreadsheetLocation(changeLoc);
			excelSpreadsheet[location.getRow()][location.getCol()] = new EmptyCell();
			return getGridText();
		}
		else if(command.contains("=")){
			String[] splitInput = command.split(" = ");
			String loc = splitInput[0];
			String cell = splitInput[1];
			if(splitInput.length >= 3){
				System.out.println(cell += " = " + splitInput[2]);
			}
			if(cell.contains("\"")){
				cell = cell.replace("\"", "");
			}
			SpreadsheetLocation location = new SpreadsheetLocation(loc);
			excelSpreadsheet[location.getRow()][location.getCol()] = new TextCell(cell);
	    	return getGridText(); 
		}
		else if(splitted.length <= 3){
			SpreadsheetLocation location = new SpreadsheetLocation(command);
			return excelSpreadsheet[location.getRow()][location.getCol()].fullCellText();
		}
		return getGridText();
	}

	
	@Override
	public int getRows()
	{
		return 20;
	}

	@Override
	public int getCols()
	{
		return 12;
	}

	@Override
	public Cell getCell(Location loc)
	{
		return excelSpreadsheet[loc.getRow()][loc.getCol()];	
	}

	@Override
	public String getGridText(){
		String grid = "   |";
		for(int i=0; i < getCols(); i++){
			grid += (char) (i + 'A') + "         |";
		}
		grid += "\n";
		for(int i=1; i <= getRows(); i++){
			if(i > 9){
				grid += i + " ";
			}
			if(i < 10){
				grid += i + "  ";
			}
			for(int j=0; j < getCols(); j++){
				grid += "|" + excelSpreadsheet[i-1][j].abbreviatedCellText();
			}
			grid += "|\n";
		}
		return grid;
	}
}