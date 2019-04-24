package eg.edu.alexu.csd.datastructure.stack.cs46;

import java.util.Scanner;

public class Application {

	public static void main(String[] args) {
		String expression = new String(), n = new String();
		int a = 0;
		ExpressionEvaluator tester = new ExpressionEvaluator();
		Scanner s1 = new Scanner(System.in);
		while (true) {
			System.out.println("Choose An Option :\n===============================" + "\n1: Infix To Postfix\n"
					+ "2: Evaluate Postfix Expression\n" + "3: Evaluate Previous Expression\n");
			n = s1.nextLine();
			if (n.equals("1")) {
				System.out.println("Enter Expression Numbers or Letters");
				expression = s1.nextLine();
				expression = tester.infixToPostfix(expression);
				System.out.println(expression);
			} else if (n.equals("2")) {
				System.out.println("Enter Expression (Numbers only) ");
				expression = s1.nextLine();
				a = tester.evaluate(expression);
				System.out.println(a);
			} else if (n.equals("3")) {
				if (expression.length() != 0) {
					a = tester.evaluate(expression);
					System.out.println(a);
				} else {
					System.out.println("Empty");
					continue;
				}
			} else {
				throw new RuntimeException("Invalid Choice");
			}
			System.out.println("Press Enter Key To Continue....");
			s1.nextLine();
	}
	}
}
