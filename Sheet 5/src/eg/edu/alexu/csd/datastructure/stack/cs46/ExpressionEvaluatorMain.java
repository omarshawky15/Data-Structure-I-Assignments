package eg.edu.alexu.csd.datastructure.stack.cs46;

public class ExpressionEvaluatorMain {
	public static void main(String[] args) {
		String expression = "(-(2 + 3) * 4)";
		int a =0;
		ExpressionEvaluator tester = new ExpressionEvaluator();
		expression = tester.infixToPostfix(expression);
		 a = tester.evaluate(expression);
		System.out.println(expression+"\n"+a);
		
	}

}