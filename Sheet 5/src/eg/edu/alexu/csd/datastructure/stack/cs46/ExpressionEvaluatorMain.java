package eg.edu.alexu.csd.datastructure.stack.cs46;

public class ExpressionEvaluatorMain {
	public static void main(String[] args) {
		String expression = "(1 + 2) * 7";
		ExpressionEvaluator omar2 = new ExpressionEvaluator();
		expression = omar2.infixToPostfixString(expression);
		System.out.println(expression);
		
	}

}