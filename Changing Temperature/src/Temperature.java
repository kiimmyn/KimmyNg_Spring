import java.io.*;
import java.util.*;

public class Temperature {
	public static void main (String[] args) throws FileNotFoundException {
	Scanner input= new Scanner(new File("./resources/weather.txt"));
		double todayTemp = input.nextDouble();
		while (input.hasNextDouble()) {
		double tomorrowTemp = input.nextDouble();
		double change = tomorrowTemp - todayTemp;
		double intNumber = (int)(change*100);
		double roundedChange = intNumber/100;
		System.out.println(todayTemp + " to "  + tomorrowTemp + ", change = " + roundedChange);
		todayTemp = tomorrowTemp;
		}
	}
}

