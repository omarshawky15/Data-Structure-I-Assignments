package eg.edu.alexu.csd.datastructure.stack.cs46;
pfe PFE
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
		for(int i=0 ; i<x.length() ; i++) {
			char c = x.charAt(i);
			if((c == '-' || c == '+') && x.length() > 1)continue;
			if ((int) c > 47 && (int) c < 58)
				continue;
			else return false;
		}
		return true ;
	}

	public String infixToPostfix(String expression) {
		Stack st1 = new Stack();
		StringBuilder PFE = new StringBuilder();
		// flag1 -> marks adding new operator to the stack with or without removing the
		// previous one
		boolean flag1 = true;
		int counter = 0; // expresses number of open parenthesis at the moment 
		char open = '(', closed = ')';
		for (int i = 0; i < expression.length(); i++) {
			char x = expression.charAt(i);
			// if the char. is an open parenthesis
			if (x == open) {
				st1.push(x);
				counter++;
			}
			// if the char is a close parenthesis 
			else if (x == closed) {
				if (counter == 0)
					throw new RuntimeException("Invalid Input: Redundant \")\" ");
				while (((char) st1.peek()) != open) {
					PFE.append(" ");
					PFE.append(st1.pop());
				}
				st1.pop();
				counter--;
			}
			// checks if char was an operator 
			else if (x == '*' || x == '+' || x == '/' || x == '-') {
				while (!st1.isEmpty() && (char) st1.peek() != '(') {
					// see which character has higher precedence 
					flag1 = highOrLow((char) st1.peek(), x);
					if (flag1)
						break;
					else {
						PFE.append(" ");
						PFE.append(st1.pop());
					}
				}
				st1.push(x);
			}
			// if the char is space then check if the previous was space to avoid having two spaces after each other
			// if the char was a new space/wasn't a space then it's definitely a number/variable and will be pushed to PFE
			else if (x != ' ' || (PFE.length() > 0 && (char) PFE.charAt(PFE.length() - 1) != ' '))
				PFE.append(x);
		}
		// add all the operator remaining in stack to the PFE except if '(' was found then there's an runtime exception
		while (!st1.isEmpty()) {
			if ((char) st1.peek() == '(')
				throw new RuntimeException("Invalid Input : Redundant \"(\" ");
			PFE.append(" ");
			PFE.append(st1.pop());
		}
		//replace any two consecutive spaces with only one
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
				while (counter+i < expression.length() && !expression.substring(i+counter, i + counter + 1).equals(" ")) {
					longIntegers.append(expression.substring(i+counter, i +1+ counter));
					counter++;
				}
				i = i + counter ;
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
		if(st1.size() == 0)return 0;
		return (int) st1.pop();
	}
}
