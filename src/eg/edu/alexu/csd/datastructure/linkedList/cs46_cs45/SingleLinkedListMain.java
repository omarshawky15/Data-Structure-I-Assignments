package eg.edu.alexu.csd.datastructure.linkedList.cs46_cs45;

import java.util.ArrayList;
public class SingleLinkedListMain {

	public static void main(String[] args) {
		DoubleLinkedList test = new DoubleLinkedList();
		/*test.add(5, 1);
		test.add(1, 2);*/
		test.add(0, 3);
		test.add(1, 4);
		test.add(2, 5);
		test.add(3, 6);
		test.add(4, 7);
		ArrayList<Object> testArr = new ArrayList<Object>();
		testArr.add(0, 3);
		testArr.add(1, 4);
		testArr.add(2, 5);
		testArr.add(3, 6);
		/*for (int i = 0; i < testArr.size(); i++) {
			System.out.println(test.get(i)== testArr.get(i));
	}*/
		//test.clear() ; 
		//System.out.println(test.get(4)); 
		/*test.remove(1);
		testArr.remove(1);
		System.out.println(test.get(2) == testArr.get(2)); 
		*/
	/*	for (int i = 0; i < test.size; i++) {
			System.out.println(test.get(i));
		}
//		System.out.println(test.get(0));
		/*System.out.println(test.contains(05));*/
		DoubleLinkedList t ;
		DoubleLinkedList A = new DoubleLinkedList();
		t = A ;
		t.add(5);
		t.add(4);
		System.out.println(A.head.data);
		System.out.println(A.head.next.data);
		System.out.println(t.head.data);
		System.out.println(t.head.next.data);

		String myString ;
		
	
	PolynomialSolver tester = new PolynomialSolver();
	
	int [][] poly = new int [3][2];
	
	poly[0][0]=1;
	poly[0][1]=3;
	
	poly[1][0]=1;poly[1][1]=2;

	poly[2][0]=3;poly[2][1]=0;
	
	tester.setPolynomial('A', poly);
	poly[0][0]=0;
	poly[0][1]=0;
	
	poly[1][0]=0;poly[1][1]=0;

	poly[2][0]=0;poly[2][1]=0;
	tester.setPolynomial('B', poly);
	myString = tester.print('A');
	System.out.println(myString);
	myString = tester.print('B');
	System.out.println(myString);
	tester.add('A', 'B');
	myString = tester.print('R');
	System.out.println(myString);
	/*float z = tester.evaluatePolynomial('A', 5);
	System.out.println(z);*/
	int[][] z = tester.multiply('A','B');
	myString = tester.print('R');
	System.out.println(myString);
	
	
	
	
	
	}
}
