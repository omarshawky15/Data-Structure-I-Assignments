package eg.edu.alexu.csd.datastructure.linkedList.cs46_cs45;

import java.util.Scanner;

public class Application {
	static Scanner s1 = new Scanner(System.in);
	static PolynomialSolver tester = new PolynomialSolver();
	static DoubleLinkedList check = new DoubleLinkedList();
	static String[] order = { "First", "Second" };

	static char variable(char c, int n) {
		System.out.println("Insert the" + order[n] + "operand variable name: A, B or C");
		c = s1.next().charAt(0);
		if (c == 'A' || c == 'B' || c == 'C') {
			check = tester.checker(c);
			while (tester.visited[(int) (c - 'A')] == 0) {
				System.out.println("Variable not set");
				System.out.println("Insert the" + order[n] + "operand variable name: A, B or C");
				c = s1.next().charAt(0);
				if (c == 'A' || c == 'B' || c == 'C')
					check = tester.checker(c);
				else
					throw new RuntimeException("Invalid Entry");

			}
		} else
			throw new RuntimeException("Invalid Entry");
		return c;
	}

	static void sort(int arr[][]) {
		int n = arr.length;
		for (int i = 1; i < n; ++i) {
			int[] key = arr[i];
			int j = i - 1;

			while (j >= 0 && arr[j][1] < key[1]) {
				arr[j + 1] = arr[j];
				j = j - 1;
			}
			arr[j + 1] = key;
		}
	}

	public static int[][] inputs(String str) {
		int[][] arr = new int[100][2];
		int count = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '(') {
				int j, k;
				for (j = i + 1; str.charAt(j) != ','; j++) {
					if (j > str.length())
						throw new RuntimeException("Invalid Entry");
				}
				arr[count][0] = Integer.parseInt(str.substring(i + 1, j));
				for (k = j + 1; str.charAt(k) != ')'; k++) {
					if (k > str.length())
						throw new RuntimeException("Invalid Entry");

				}
				arr[count++][1] = Integer.parseInt(str.substring(j + 2, k));
				i = k;
			}

		}
		int[][] arr2 = new int[count][2];
		for (int i = 0; i < count; i++) {
			arr2[i] = arr[i];
		}
		return arr2;
	}

	public static void main(String[] args) {
		tester.initialize();
		String list = "Please choose an action\n-----------------------\n" + "1- Set a polynomial variable\n"
				+ "2- Print the value of a polynomial variable\n" + "3- Add two polynomials\n"
				+ "4- Subtract two polynomials\n" + "5- Multiply two polynomials\n"
				+ "6- Evaluate a polynomial at some point\n" + "7- Clear a polynomial variable\n"
				+ "====================================================================\n";
		outer: while (true) {
			System.out.println(list);
			char c1 = 0;
			char c2 = 0;
			String term = new String();
			int n = s1.nextInt();
			if (n > 7 || n < 1) {
				break outer;
			} else if (n == 1) {
				System.out.println("Insert the variable name: A, B or C \n");
				c1 = s1.next().charAt(0);
				if (c1 == 'A' || c1 == 'B' || c1 == 'C') {
					s1.nextLine();
					System.out.print("Insert the polynomial terms in the form:\r\n"
							+ "(coeff1, exponent1), (coeff2, exponent2), ..");
					term = s1.nextLine();
					int[][] arr = inputs(term);
					sort(arr);
					tester.setPolynomial(c1, arr);

				} else
					break outer;
				System.out.println();
			} else if (n == 2) {
				System.out.println("Insert the variable name: A, B, C or R");
				c1 = s1.next().charAt(0);
				if (c1 == 'A' || c1 == 'B' || c1 == 'C' || c1 == 'R') {
					check = tester.checker(c1);
					while (check.size == 0) {
						System.out.println("Variable not set");
						System.out.println("Insert the variable name: A, B, C or R");
						c1 = s1.next().charAt(0);
						if (c1 == 'A' || c1 == 'B' || c1 == 'C' || c1 == 'R')
							check = tester.checker(c1);
						else
							break outer;

					}
					term = tester.print(c1);
					System.out.println(term);
				} else
					break outer;
				System.out.println();
			} else if (n == 3) {
				c1 = variable(c1, 0);
				c2 = variable(c2, 1);
				int[][] arr = tester.add(c1, c2);
				System.out.println("Result set in R:");
				for (int i = 0; i < arr.length; i++) {
					System.out.print("(" + arr[i][0] + "," + arr[i][1] + ")");
					if (i != arr.length - 1)
						System.out.print(", ");
				}
				System.out.println();
			} else if (n == 4) {
				c1 = variable(c1, 0);
				c2 = variable(c2, 1);
				int[][] arr = tester.subtract(c1, c2);
				System.out.println("Result set in R:");
				for (int i = 0; i < arr.length; i++) {
					System.out.print("(" + arr[i][0] + "," + arr[i][1] + ")");
					if (i != arr.length - 1)
						System.out.print(", ");
				}
				System.out.println();
			} else if (n == 5) {
				c1 = variable(c1, 0);
				c2 = variable(c2, 1);
				int[][] arr = tester.multiply(c1, c2);
				System.out.println("Result set in R:");
				for (int i = 0; i < arr.length; i++) {
					System.out.print("(" + arr[i][0] + "," + arr[i][1] + ")");
					if (i != arr.length - 1)
						System.out.print(", ");

				}
				System.out.println();
			} else if (n == 6) {
				System.out.println("Insert the variable name: A, B, C or R");
				c1 = s1.next().charAt(0);
				if (c1 == 'A' || c1 == 'B' || c1 == 'C' || c1 == 'R') {
					check = tester.checker(c1);
					while (check.size == 0) {
						System.out.println("Variable not set");
						System.out.println("Insert the variable name: A, B, C or R");
						c1 = s1.next().charAt(0);
						if (c1 == 'A' || c1 == 'B' || c1 == 'C' || c1 == 'R')
							check = tester.checker(c1);
						else
							break outer;

					}
					System.out.println("Enter Value of x : ");
					float x = s1.nextInt();
					System.out.println(tester.evaluatePolynomial(c1, x));
				}
				System.out.println();
			} else if (n == 7) {
				System.out.println("Insert the variable name: A, B, C or R");
				c1 = s1.next().charAt(0);
				if (c1 == 'A' || c1 == 'B' || c1 == 'C' || c1 == 'R') {
					check = tester.checker(c1);
					while (check.size == 0) {
						System.out.println("Variable not set");
						System.out.println("Insert the variable name: A, B, C or R");
						c1 = s1.next().charAt(0);
						if (c1 == 'A' || c1 == 'B' || c1 == 'C' || c1 == 'R')
							check = tester.checker(c1);
						else
							break outer;

					}
					tester.clearPolynomial(c1);
				}
				System.out.println();

			}
		}
		throw new RuntimeException("Invalid Entry");
	}
}
//(5,6), (4,3), (35,90)
//(2, 2), (1, 4), (4, 0)
//(3, 5), (4, 2), (6, 0), (2, 4)
