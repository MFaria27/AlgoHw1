import java.util.Scanner;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Stackulator {
	
	public Stackulator() {
		
	}
	
	public Double stackCalculateStdIn() {
		Stack<String> ops = new Stack<String>();
		Stack<Double> vals = new Stack<Double>();
		while (!StdIn.isEmpty()) {
			String s = StdIn.readString();
			if (s.equals("("));
			else if (s.equals("+")) ops.push(s);
			else if (s.equals("-")) ops.push(s);
			else if (s.equals("*")) ops.push(s);
			else if (s.equals("/")) ops.push(s);
			else if (s.equals("sqrt")) ops.push(s);
			else if (s.equals("ceil")) ops.push(s);
			else if (s.equals("%")) ops.push(s);
			else if (s.equals(")")) {
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
			else vals.push(Double.parseDouble(s));
		}
		return vals.pop();
	}
	
	public String stackCalculate(String expression) {
		Stack<String> ops = new Stack<String>();
		Stack<Double> vals = new Stack<Double>();
		Scanner sc = new Scanner(expression);
		while (sc.hasNext()) {
			String s = sc.next();
			if (s.equals("("));
			else if (s.equals("+")) ops.push(s);
			else if (s.equals("-")) ops.push(s);
			else if (s.equals("*")) ops.push(s);
			else if (s.equals("/")) ops.push(s);
			else if (s.equals("sqrt")) ops.push(s);
			else if (s.equals("ceil")) ops.push(s);
			else if (s.equals("%")) ops.push(s);
			else if (s.equals(")")) {
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
			else vals.push(Double.parseDouble(s));
		}
		return expression + " = " + vals.pop();
	}
}
