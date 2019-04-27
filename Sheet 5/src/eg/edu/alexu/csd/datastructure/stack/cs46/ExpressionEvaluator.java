package eg.edu.alexu.csd.datastructure.stack.cs46;

public class ExpressionEvaluator implements IExpressionEvaluator {
	/**
	 * to know if character has a higher or lower precedence
	 * 
	 * @param c character
	 * @return 'l' if c has lower precedence , 'h' if c has higher precedence , 'n'
	 *         null to make the method work
	 */
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

	/**
	 * 'h' ASCII number is lower that 'l' , so if c2 = 'h' , c1 = 'l' this means c2
	 * c1 but c2 has higher precedence than c1 so if c2 less than c1 in value then i
	 * should return true to add c2 to the stack , for all other cases returning
	 * false from this method will result in removing c1 first then add c2
	 * 
	 * @param c1 the first character to compare
	 * @param c2 the second character to compare
	 * @return true if c2 has higher precedence than c1 , false otherwise
	 */
	public boolean highOrLow(char c1, char c2) {
		c1 = test(c1);
		c2 = test(c2);

		if (c2 < c1)
			return true;
		else
			return false;
	}

	/**
	 * check if String is number or not
	 * 
	 * @param x String to be checked
	 * @return true if x was a Fully Functional number , false otherwise
	 */

	public boolean isNum(String x) {
		for (int i = 0; i < x.length(); i++) {
			char c = x.charAt(i);
			if ((c == '-' || c == '+') && x.length() > 1)
				continue;
			if ((int) c > 47 && (int) c < 58)
				continue;
			else
				return false;
		}
		return true;
	}

	/**
	 * check if String is Valid Alphabetic character or not
	 * 
	 * @param x String to be checked
	 * @return true if x was a Valid Alphabetic character , false otherwise
	 */

	public boolean isChar(String x) {
		for (int i = 0; i < x.length(); i++) {
			char c = x.charAt(i);
			if ((c == '-' || c == '+') && x.length() > 1)
				continue;
			if (((int) c > 64 && (int) c < 90) || ((int) c > 96 && (int) c < 123))
				continue;
			else
				return false;
		}
		return true;
	}

	/**
	 * check if String is an operator or not or not
	 * 
	 * @param substring String to be checked
	 * @return true if x wasn't an operator , false otherwise
	 */
	public boolean isNotOperator(String substring) {
		String[] Operators = { "*", "-", "+", "/" };
		for (int i = 0; i < 4; i++) {
			if (substring.equals(Operators[i]))
				return false;
		}
		return true;
	}

	/**
	 * Takes a symbolic/numeric infix expression as input and converts it to postfix
	 * notation. There is no assumption on spaces between terms or the length of the
	 * term (e.g., two digits symbolic or numeric term)
	 *
	 * @param expression infix expression
	 * @return postfix expression
	 */

	public String infixToPostfix(String expression) {
		Stack oPSt = new Stack();
		Stack Sign = new Stack();
		StringBuilder PFE = new StringBuilder();
		String n = "";
		// flag -> marks adding new operator to the stack with or without removing the
		// previous one
		boolean flag = true;
		//negflag -> if (true) previous character was operator thus next(-) is negative sign
		//			 if (false) previous character was operand thus next (-) is operator
		boolean negflag = true; 
		int counter = 0; // expresses number of open parenthesis at the moment and if it matches the
		// counter inside Sign Stack it means that the Sign was changed at this Counter
		String open = "(", closed = ")";
		for (int i = 0; i < expression.length(); i++) {
			String x = expression.substring(i, i + 1);
			StringBuilder longIntegers = new StringBuilder();
			if (x.equals("-") && !expression.substring(i + 1, i + 2).equals(" ")) {
				if(negflag) {
				if (n.equals(""))
					n = "-";
				else
					n = "";
				Sign.push(counter);
				continue;
				}
			} else {
				int counter2 = 0;
				while (counter2 + i < expression.length()
						&& (isChar(expression.substring(i + counter2, i + counter2 + 1))
								|| isNum(expression.substring(i + counter2, i + counter2 + 1)))
						&& isNotOperator(expression.substring(i + counter2, i + counter2 + 1))) {
					longIntegers.append(expression.substring(i + counter2, i + 1 + counter2));
					counter2++;
				}
				i = i + counter2;
				if (counter2 > 0) {
					i--;
					x = longIntegers.toString();
				}
			}
			// end of taking the expression

			// testing the expression

			// if the char. is an open parenthesis
			if (x.equals(open)) {
				oPSt.push(x);
				counter++;
			}
			// if the char is a close parenthesis
			else if (x.equals(closed)) {
				if (counter == 0)
					throw new RuntimeException("Invalid Input: Redundant \")\" ");
				while (!((String) oPSt.peek()).equals(open)) {
					PFE.append(" ");
					PFE.append(oPSt.pop());
				}
				oPSt.pop();
				counter--;
			}
			// checks if char was an operator
			else if (x.equals("*") || x.equals("+") || x.equals("/") || x.equals("-")) {
				negflag = true;
				while (!oPSt.isEmpty() && !((String) oPSt.peek()).equals("(")) {
					// see which character has higher precedence
					flag = highOrLow(((String) oPSt.peek()).charAt(0), x.charAt(0));
					if (flag)
						break;
					else {
						PFE.append(" ");
						PFE.append(oPSt.pop());
					}
				}
				oPSt.push(x);
			}
			// if the char is space then check if the previous was space to avoid having two
			// spaces after each other
			// if the char was a new space/wasn't a space then it's definitely a
			// number/variable and will be pushed to PFE
			else if (!x.equals(" ") || (PFE.length() > 0 && (char) PFE.charAt(PFE.length() - 1) != ' ')) {
				PFE.append(" ");
				if (!x.equals(" ")) {
					negflag = false;
					PFE.append(n + x);
			}else 
					PFE.append(x);
				
			}
			while (!Sign.isEmpty() && counter == (int) Sign.peek()) {
				if (n.equals(""))
					n = "-";
				else
					n = "";
				Sign.pop();
			}
		}
		// add all the operator remaining in stack to the PFE except if '(' was found
		// then there's an runtime exception
		while (!oPSt.isEmpty()) {
			if (((String) oPSt.peek()).equals("("))
				throw new RuntimeException("Invalid Input : Redundant \"(\" ");
			PFE.append(" ");
			PFE.append(oPSt.pop());
		}
		// replace any two consecutive spaces with only one
		int i = 0;
		while (PFE.charAt(i) == ' ' && i < PFE.length() - 1) {
			PFE.deleteCharAt(i);
		}
		for (i = 0; i < PFE.length() - 1; i++) {
			if (PFE.charAt(i) == ' ' && PFE.charAt(i + 1) == ' ') {
				PFE.deleteCharAt(i);
				i--;
			}
		}
		return PFE.toString();

	}

	/**
	 * Evaluate a postfix numeric expression, with a single space separator
	 *
	 * @param expression postfix expression
	 * @return the expression evaluated value
	 */

	public int evaluate(String expression) {
		Stack oPSt = new Stack();
		for (int i = 0; i < expression.length(); i++) {
			String x = expression.substring(i, i + 1);
			StringBuilder longIntegers = new StringBuilder();
			if (x.equals(" "))
				continue;
			else {
				int counter = 0;
				while (counter + i < expression.length()
						&& !expression.substring(i + counter, i + counter + 1).equals(" ")) {
					longIntegers.append(expression.substring(i + counter, i + 1 + counter));
					counter++;
				}
				i = i + counter;
			}
			x = longIntegers.toString();
			if (isNum(x)) {
				oPSt.push(Float.parseFloat(x));
			} else if (x.equals("*") || x.equals("+") || x.equals("/") || x.equals("-")) {
				Float num1 = (Float) oPSt.pop(), num2 = (Float) oPSt.pop();
				if (x.equals("+"))
					oPSt.push(num1 + num2);
				else if (x.equals("*"))
					oPSt.push(num1 * num2);
				else if (x.equals("/"))
					oPSt.push(num2 / num1);
				else
					oPSt.push(num2 - num1);
			} else
				throw new RuntimeException("Invalid Input");

		}
		if (oPSt.size() == 0)
			return 0;
		int x = (int) Math.round((Float) oPSt.pop());
		return x;
	}
}
