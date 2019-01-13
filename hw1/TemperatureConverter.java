public class TemperatureConverter{
	public static void main(String[] args) {
		Scanner kelvin = new Scanner(System.in);
		System.out.println("Enter a temperature in Kelvin: ");
		float k = kelvin.nextLine();
		float f = (float)k*9/5 - 459.67; 
		System.out.println(k+" Kelvin is "+f+" degrees Fahrenheit\n");
	}
}