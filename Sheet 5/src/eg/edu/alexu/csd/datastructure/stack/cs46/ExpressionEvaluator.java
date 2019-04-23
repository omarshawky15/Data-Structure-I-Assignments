package eg.edu.alexu.csd.datastructure.stack.cs46;

public class ExpressionEvaluator implements IExpressionEvaluator {
	public char test(char c) {
		char[] lower = { '-', '+' };
		char[] higher = { '*', '/' };
		for (int i = 0; i < 2; i++) {
			if (lower[i] == c) {
				return 'l';
			}
		}
		for (int i = 0; i < 2; i++) {
			if (higher[i] == c) {
				return 'h';
			}
		}
		// just to make the method work , no meaning for the 'n' 
		return 'n';
	}

	/*
	 * 'h' ASCII number is lower that 'l' , so if c2 = 'h' , c1 = 'l' this means c2
	 * < c1 but c2 has higher precedence than c1 so if c2 < c1 then i should return
	 * true to add c2 to the stack , for all other cases returning false from this
	 * method will result in removing c1 first then add c2
	 */
	public boolean highOrLow(char c1, char c2) {
		c1 = test(c1);
		c2 = test(c2);

		if (c2 < c1)
			return true;
		else
			return false;
	}

	
	public String infixToPostfix(String expression) {
		Stack st1= new Stack();
		StringBuilder postfixExpression = new StringBuilder();
		// flag1 -> marks adding new operator to the stack with or without removing the
		// previous one
		boolean flag1 = true;
		int counter = 0;
		char open = '(', closed = ')';
		for (int i = 0; i < expression.length(); i++) {
			char x = expression.charAt(i);
			if (x == open) {
				st1.push(x);
				counter++;
			} else if (x == closed) {
				if(counter == 0)throw new RuntimeException("Invalid Input: Redundant \")\" ");
				while (((char) st1.peek()) != open) {
					postfixExpression.append(" ");
					postfixExpression.append(st1.pop());
				}
				st1.pop();
				counter--;
			} else if (x == '*' || x == '+' || x == '/' || x == '-') {
				while (!st1.isEmpty() && (char) st1.peek() != '(') {
					flag1 = highOrLow((char) st1.peek(), x);
					if (flag1)
						break;
					else {
						postfixExpression.append(" ");
						postfixExpression.append(st1.pop());
					}
				}
				st1.push(x);
			} else if (x != ' ' || (char) postfixExpression.charAt(postfixExpression.length()-1) != ' ')
				postfixExpression.append(x);
		}
		while (!st1.isEmpty()) {
			if ((char) st1.peek() == '(')
				throw new RuntimeException("Invalid Input : Redundant \"(\" ");
			postfixExpression.append(" ");
			postfixExpression.append(st1.pop());
		}
		for (int i = 0; i < postfixExpression.length() - 1; i++) {
			if (postfixExpression.charAt(i) == ' ' && postfixExpression.charAt(i + 1) == ' ') {
				postfixExpression.deleteCharAt(i);
				i--;
			}
		}
		return postfixExpression.toString();

	}
}
