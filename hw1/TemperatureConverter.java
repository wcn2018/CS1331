//Worked with Bryan Zhao.
import java.util.Scanner;
import java.lang.Math;
public class TemperatureConverter{
	public static void main(String[] args) {
		Scanner Kelvin = new Scanner(System.in);
		System.out.println("Enter a temperature in Kelvin: ");
		Double k = Kelvin.nextDouble();
		Double f = k*9/5 - 459.67; 
		System.out.println(k+" Kelvin is "+f+" degrees Fahrenheit\n");
	}
}