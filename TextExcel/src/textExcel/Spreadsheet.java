package textExcel;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

// Update this file with your own code.

public class Spreadsheet implements Grid
{
	
	Cell[][] excelSpreadsheet = new Cell[getRows()][getCols()];	// 20 rows, 12 columns
	
	public Spreadsheet(){
		for(int i = 0; i < getRows(); i++){
			for(int j = 0; j < getCols(); j++){
				excelSpreadsheet[i][j] = new EmptyCell();
			}
		}
	}

	@Override
	public String processCommand(String direct){  	
		
		// split command at spaces
		String[] split = direct.split(" ");
		SpreadsheetLocation loc;
		
		if(split[0].toLowerCase().equals("save")) {
			return writeFile(split[1]);
		} 
		else if(split[0].toLowerCase().equals("access")) {
			return readFile(split[1]);
		}
		
		if(direct.equals("")){
			return direct;
		}
		// if command, clear entire sheet
		else if(direct.toLowerCase().equals("clear")){ //command changes into lower case; gets rid of case issue
			for(int i = 0; i < getRows(); i++){
				for(int j = 0; j < getCols(); j++){
					excelSpreadsheet[i][j] = new EmptyCell();
				}
			}
			return getGridText();	
		}
		// if command is to clear a specific cell
		else if(split.length == 2){
			String location = split[1];
			loc = new SpreadsheetLocation(location);
			excelSpreadsheet[loc.getRow()][loc.getCol()] = new EmptyCell();
			return getGridText();
		}
		// if command is to assigning to a new cell 
		else if(direct.contains("\"")){
			String[] splitInput = direct.split(" = ");
			String location = splitInput[0];
			String value = splitInput[1];
			if(splitInput.length >= 3){
				System.out.println(value += " = " + splitInput[2]);
			}
			loc = new SpreadsheetLocation(location);
			excelSpreadsheet[loc.getRow()][loc.getCol()] = new TextCell(value.substring(1, value.length()-1)); // pass wo quotes
	    	return getGridText(); 
		}	
		else if(split.length>1&&split[1].equals("=")){
			loc=new SpreadsheetLocation(split[0]);
			if (split[2].charAt(0) == 34){ //text cell
				excelSpreadsheet [loc.getRow()] [loc.getCol()] = new TextCell (split[2].trim());
			}
			else if (split[2].substring(split[2].length()-1).equals("%")){ //a percent cell
				excelSpreadsheet [loc.getRow()] [loc.getCol()] = new PercentCell (split[2].trim());	
			}
			else if (split[2].charAt(0) == ('(')){ //a formula cell
				excelSpreadsheet [loc.getRow()] [loc.getCol()] = new FormulaCell (split[2].trim());	
			}
			else { //value cell
				excelSpreadsheet [loc.getRow()] [loc.getCol()] = new ValueCell (split[2].trim());	
			}
			return getGridText();
		} 	
		else {
			loc = new SpreadsheetLocation(direct);
			return excelSpreadsheet[loc.getRow()][loc.getCol()].fullCellText();
		}
	}
	
	@Override
	public int getRows()
	{
		return 20;	// # of rows
	}

	@Override
	public int getCols()
	{
		return 12;	// # of columns
	}

	@Override
	public Cell getCell(Location loc)
	{
		return excelSpreadsheet[loc.getRow()][loc.getCol()];	
	}

	@Override
	public String getGridText(){
		String grid = "   |";	//left of spreadsheet
		for(int i=0; i < getCols(); i++){	// create top of the column
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
	
	private String writeFile (String filename){
	     PrintStream outputFile;
	     try {
	    	 outputFile = new PrintStream(new File(filename));
	     }
	     catch (FileNotFoundException e) {
	    	 return "File not found: " + filename;
	     }
	     String enter="";
			//for loop checks all cells to return location, type, values stored in each
			for(int i=0;i<20;i++){
				for(char j='A';j<'M';j++){
					Cell test=excelSpreadsheet[i][j-'A'];
					if(excelSpreadsheet[i][j-'A'] instanceof FormulaCell){
						enter+=j+""+(i+1)+",FormulaCell,"+test.fullCellText()+"\n";
					}
					if(excelSpreadsheet[i][j-'A'] instanceof TextCell){
						enter+=j+""+(i+1)+",TextCell,"+test.fullCellText()+"\n";
					}
					if(excelSpreadsheet[i][j-'A'] instanceof ValueCell){
						enter+=j+""+(i+1)+",ValueCell,"+test.fullCellText()+"\n";
					}
					if(excelSpreadsheet[i][j-'A'] instanceof PercentCell){
						enter+=j+""+(i+1)+",PercentCell,"+test.fullCellText()+"\n";
					}
				}	
			}
			outputFile.print(enter);
			outputFile.close();
			return  "0";
	}
	private String readFile(String filename){
		Scanner inputFile;
		try {
			inputFile = new Scanner(new File(filename));
		}
		catch (FileNotFoundException e) {
			return "File not found: " + filename;
		}
		while(inputFile.hasNextLine()){
			//Reads input and decides what cell to construct
			String line=inputFile.nextLine();
			String[] lineParts = line.split(",");
			SpreadsheetLocation loc = new SpreadsheetLocation(lineParts[0]);
			if(lineParts[1].equals("ValueCell"))
				excelSpreadsheet[loc.getRow()][loc.getCol()]=new ValueCell(lineParts[2]);
			else if(lineParts[1].equals("TextCell"))
				excelSpreadsheet[loc.getRow()][loc.getCol()]=new TextCell(lineParts[2]);
			else if(lineParts[1].equals("FormulaCell"))
				excelSpreadsheet[loc.getRow()][loc.getCol()]=new TextCell(lineParts[2]);
			else if(lineParts[1].equals("PercentCell")){
				String percent = Double.parseDouble(lineParts[2])*100.0+"";
				excelSpreadsheet[loc.getRow()][loc.getCol()]=new PercentCell(percent);
			}
		}
		inputFile.close();
		return getGridText();
	}
}