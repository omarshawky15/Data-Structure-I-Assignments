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

	public String infixToPostfix(String expression) {
		Stack st1 = new Stack();
		Stack Sign = new Stack();
		StringBuilder PFE = new StringBuilder();
		String n = "";
		// flag1 -> marks adding new operator to the stack with or without removing the
		// previous one
		boolean flag1 = true;
		int counter = 0; // expresses number of open parenthesis at the moment
		int countern = 0;
		String open = "(", closed = ")";
		for (int i = 0; i < expression.length(); i++) {
			// char x = expression.charAt(i);
			String x = expression.substring(i, i + 1);
			StringBuilder longIntegers = new StringBuilder();
			if (x.equals("-") && !expression.substring(i + 1, i + 2).equals(" ")) {
				if (n.equals(""))
					n = "-";
				else
					n = "";
				Sign.push(countern);
				continue;
			} else {
				int counter2 = 0;
				while (counter2 + i < expression.length()
						&& isNum(expression.substring(i + counter2, i + counter2 + 1))) {
					longIntegers.append(expression.substring(i + counter2, i + 1 + counter2));
					counter2++;
				}
				i = i + counter2;
				if (counter2 > 0) {
					i--;
					x = longIntegers.toString();
				}
			}

			// if the char. is an open parenthesis
			if (x.equals(open)) {
				st1.push(x);
				counter++;
				countern++;
				
			}
			// if the char is a close parenthesis
			else if (x.equals(closed)) {
				if (counter == 0)
					throw new RuntimeException("Invalid Input: Redundant \")\" ");
				while (!((String) st1.peek()).equals(open)) {
					PFE.append(" ");
					PFE.append(st1.pop());
				}
				st1.pop();
				counter--;
				if (countern > 0) {
					countern--;
				}
			}
			// checks if char was an operator
			else if (x.equals("*") || x.equals("+") || x.equals("/") || x.equals("-")) {
				while (!st1.isEmpty() && !((String) st1.peek()).equals("(")) {
					// see which character has higher precedence
					flag1 = highOrLow(((String) st1.peek()).charAt(0), x.charAt(0));
					if (flag1)
						break;
					else {
						PFE.append(" ");
						PFE.append(st1.pop());
					}
				}
				st1.push(x);
			}
			// if the char is space then check if the previous was space to avoid having two
			// spaces after each other
			// if the char was a new space/wasn't a space then it's definitely a
			// number/variable and will be pushed to PFE
			else if (!x.equals(" ") || (PFE.length() > 0 && (char) PFE.charAt(PFE.length() - 1) != ' ')) {
				if (!x.equals(" "))
					PFE.append(n + x);
				else
					PFE.append(x);	
			}
			if (!Sign.isEmpty() && countern == (int)Sign.peek()) {
				if (n.equals(""))
					n = "-";
				else
					n = "";
				Sign.pop();
			}
		}
		// add all the operator remaining in stack to the PFE except if '(' was found
		// then there's an runtime exception
		while (!st1.isEmpty()) {
			if (((String) st1.peek()).equals("("))
				throw new RuntimeException("Invalid Input : Redundant \"(\" ");
			PFE.append(" ");
			PFE.append(st1.pop());
		}
		// replace any two consecutive spaces with only one
		for (int i = 0; i < PFE.length() - 1; i++) {
			if (PFE.charAt(i) == ' ' && PFE.charAt(i + 1) == ' ') {
				PFE.deleteCharAt(i);
				i--;
			}
		}
		return PFE.toString();

	}

	public int evaluate(String expression) {
		Stack st1 = new Stack();
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
				st1.push(Integer.parseInt(x));
			} else if (x.equals("*") || x.equals("+") || x.equals("/") || x.equals("-")) {
				int num1 = (int) st1.pop(), num2 = (int) st1.pop();
				if (x.equals("+"))
					st1.push(num1 + num2);
				else if (x.equals("*"))
					st1.push(num1 * num2);
				else if (x.equals("/"))
					st1.push(num2 / num1);
				else
					st1.push(num2 - num1);
			} else
				throw new RuntimeException("Invalid Input");

		}
		if (st1.size() == 0)
			return 0;
		return (int) st1.pop();
	}
}
