import java.util.Scanner;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Stackulator {
	
	public Stackulator() {
		
	}
	
	//This function uses the algs4.jar StdIn function, but that is really janky and I hate it
	//The function itself works, so you can use it as well, but I would recommend just looking at the manual input function
	public Double stackCalculateStdIn() {
		Stack<String> ops = new Stack<String>(); //Store operations
		Stack<Double> vals = new Stack<Double>(); //Store values
		while (!StdIn.isEmpty()) {
			String s = StdIn.readString(); //Asks for user input
			if (s.equals("("));
			else if (s.equals("+")) ops.push(s);
			else if (s.equals("-")) ops.push(s);
			else if (s.equals("*")) ops.push(s);
			else if (s.equals("/")) ops.push(s);
			else if (s.equals("sqrt")) ops.push(s);
			else if (s.equals("ceil")) ops.push(s);
			else if (s.equals("%")) ops.push(s);
			else if (s.equals(")")) { //Once the function reads an end parenthesis, it will preform the equation within the parenthesis
				String op = ops.pop();
				double v = vals.pop();
				if (op.equals("+")) v = vals.pop() + v;
				else if (op.equals("-"))  v = vals.pop() - v;
				else if (op.equals("*"))  v = vals.pop() * v;
				else if (op.equals("/"))  v = vals.pop() / v;
				else if (op.equals("sqrt"))  v = Math.sqrt(v);
				else if (op.equals("ceil"))  v = Math.ceil(v);
				else if (op.equals("%"))  v = vals.pop() % v;
				vals.push(v);
			}
			else vals.push(Double.parseDouble(s)); //Stores the value (End result)
		}
		return vals.pop(); //Returns the final edited value, which would be on the top of the stack
	}
	
	public String stackCalculate(String expression) {
		Stack<String> ops = new Stack<String>(); //Stores operations
		Stack<Double> vals = new Stack<Double>(); //Stores values
		Scanner sc = new Scanner(expression); //Scanner reads the input expression
		while (sc.hasNext()) { //As long as there is another string to read, it will run (until last ")")
			String s = sc.next();
			if (s.equals("("));
			else if (s.equals("+")) ops.push(s);
			else if (s.equals("-")) ops.push(s);
			else if (s.equals("*")) ops.push(s);
			else if (s.equals("/")) ops.push(s);
			else if (s.equals("sqrt")) ops.push(s);
			else if (s.equals("ceil")) ops.push(s);
			else if (s.equals("%")) ops.push(s);
			else if (s.equals(")")) { //Once the function reads an end parenthesis, it will preform the equation within the parenthesis
				String op = ops.pop();
				double v = vals.pop();
				if (op.equals("+")) v = vals.pop() + v;
				else if (op.equals("-"))  v = vals.pop() - v;
				else if (op.equals("*"))  v = vals.pop() * v;
				else if (op.equals("/"))  v = vals.pop() / v;
				else if (op.equals("sqrt"))  v = Math.sqrt(v);
				else if (op.equals("ceil"))  v = Math.ceil(v);
				else if (op.equals("%"))  v = vals.pop() % v;
				vals.push(v);
			}
			else vals.push(Double.parseDouble(s)); //Stores the value (End result)
		}
		return expression + " = " + vals.pop(); //Returns the final edited value, which would be on the top of the stack
	}
}
