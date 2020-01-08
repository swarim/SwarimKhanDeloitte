
public class CalculatorTest {
	public static void main(String[] Args)
	{
		Calculator calc=new Adder();
		int sum= calc.calculate(45,55);
		System.out.println("Sum + "+sum);
		calc = new Subtractor();
		System.out.println("Diff = "+calc.calculate(77, 11));
		/*
		 * calc = new Calculator() { public int calculate(int first, int second) {
		 * return first*second; }};
		 */
		calc = (first , second) ->first*second; // lambda exoression
		System.out.println("Product = "+calc.calculate(33, 3));
		calc=(n,m)->n/m;
		System.out.println("Quotient = "+calc.calculate(33, 3));
		
}
}