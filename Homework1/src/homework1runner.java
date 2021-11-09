import edu.princeton.cs.algs4.*;

public class homework1runner {

	public static void main(String[] args) {

		question1();

	}
	
	public static void question1() {
		
		Stackulator stackCalc = new Stackulator();
				
		//This method in stackulator uses StdIn() from the book, asking for a user input.
		//For the homeworks sack, we will manually give it strings in code, but feel free to uncomment this next line.
		//System.out.println(stackCalc.stackCalculateStdIn());
		
		System.out.println(stackCalc.stackCalculate("( 1 + ( ( 2 + 3 ) * ( 4 * 5 ) ) )"));
		System.out.println(stackCalc.stackCalculate("( ( 1 / 2 ) + ( 5 * 6 ) )"));
		System.out.println(stackCalc.stackCalculate("( ( 1 + sqrt ( 5.0 ) ) / 2.0 )"));
		
		//Under proper PEMDAS, this should return 30.5.
		//for the stackulator to work, every expression needs to be in a parenthesis
		//As 1 / 2 is not surrounded by parenthesis, the stackulator will return an incorrect number
		System.out.println(stackCalc.stackCalculate("( 1 / 2 + ( 5 * 6 ) )"));
		
		//Added ceiling function and modulus function to stackulator
		System.out.println(stackCalc.stackCalculate("( 1 + ( ceil ( 0.4 ) )"));
		System.out.println(stackCalc.stackCalculate("( 5 * ( 9 % 5 ) )"));
	}
	
}