//Worked with Bryan Zhao (also in 1331 Statsko B)
//Used mostly the notes and TA
//Stack overflow for the string output %6.2f stuff and setting up java.
import java.util.Scanner;
import java.lang.Math;
public class TemperatureConverter{
	public static void main(String[] args) {
		Scanner Kelvin = new Scanner(System.in);
		System.out.println("Enter a temperature in Kelvin: ");
		String inp = Kelvin.nextLine();
		double k;
		if (inp.contains(".")){
			k = Double.parseDouble(inp);
		}else{
			k = Integer.parseInt(inp);
		}
		Double fl = ((double)k)*9/5 - 459.67; 
		System.out.printf(inp + " Kelvin is %3.2f degrees Fahrenheit\n", fl);
		//how does the %.2f stuff work
		Kelvin.close();
	}
}