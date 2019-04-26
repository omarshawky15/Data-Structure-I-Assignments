package eg.edu.alexu.csd.datastructure.stack.cs46;

import java.util.EmptyStackException;
import java.util.Scanner;

public class StackUI {
	static Scanner s1 = new Scanner(System.in);

	public static void main(String[] args) throws EmptyStackException {
		Object n;
		Stack st = new Stack();
		st.pop();
		while (true) {
			System.out.println("Choose An Option :\n===============================" + "\n1: Push\n" + "2: Pop\n"
					+ "3: Peek\n" + "4: Get size\n" + "5: Check if empty");
			n = s1.nextLine();
			if (((String)n).equals("1")) {
				System.out.println("Enter Any Object/Primitive Type/NumberOrText");
				n = s1.nextLine();
				st.push(n);
			} else if (((String)n).equals("2")) {
				System.out.println(st.pop());
			} else if (((String)n).equals("3")) {
				System.out.println(st.peek());
			} else if (((String)n).equals("4")) {
				System.out.println(st.size());
			} else if (((String)n).equals("5")) {
				System.out.println(st.isEmpty());
			} else {
				throw new RuntimeException("Invalid Choice");
			}
			System.out.println("Press Enter Key To Continue....");
			s1.nextLine();
		}
	}
}
