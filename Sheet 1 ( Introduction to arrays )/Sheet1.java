package Sheet1;

import java.math.BigInteger;
interface F1 {
	void term (int t) ;
	void nextTerm() ;
	void previousTerm () ;
}
class Fib implements F1 {
	BigInteger fib0 = new BigInteger ("0") ;
	BigInteger fib1 = new BigInteger ("1") ;
	BigInteger fib2 = new BigInteger ("0") ;
	public void term (int t) {
		if (t==0 || t== 1)System.out.println(fib0);
		else if (t==2)System.out.println(fib1);
		else {
			for (int i=3 ; i<=t ; i++) {
				fib2 = fib1.add(fib0);
				fib0 = fib1 ; 
				fib1 = fib2;
			}
			System.out.println(fib2);
		}
	}
	public void nextTerm () {
		fib2 = fib1.add(fib0);
		fib0 = fib1 ; 
		fib1 = fib2;
		System.out.println(fib2);
	}
	public void previousTerm () {
		if (fib2.equals(new BigInteger ("0")))System.out.println("error");
		else {
		fib0 = fib2.subtract(fib0);
		fib1 = fib2.subtract(fib0) ; 
		fib2 = fib1;
		System.out.println(fib2);
		}
	}
}
interface MySpecialArrayUtils {
	void reverse(int[] arr);
	int[] sumEvenOdd(int[] arr);
	double average(int[] arr);
	void moveValue(int[] arr, int val);
	void transpose(int[][] arr);
}
class newArrays implements MySpecialArrayUtils {
	public  void reverse(int[] arr) {
		for (int i=0 ; i< (arr.length)/2 ; i++) {
			int temp = arr[i] ;
			arr[i] = arr[arr.length -i-1];
			 arr[arr.length -i-1] = temp ; 
		}
	}
	public  int[] sumEvenOdd(int[] arr) {
		 int[] sideArr = {0,0};
		 if (arr.length == 0)return sideArr ;
		 for (int i=0 ; i< arr.length ;i++) {
			 if(arr[i] % 2 == 0) sideArr[0] +=arr[i] ;
			 else sideArr[1] +=arr[i] ;
		 }
		 return sideArr ;
	}
	public  double average(int[] arr) {
		double x = 0 ;
		for (int i= 0 ; i<arr.length ; i++) {
			x += (double)arr[i] / arr.length ; 
		}
		return x ;
	}
	public  void moveValue(int[] arr, int val) {
		for (int i=0 ; i<arr.length ; i++) {
			if(arr[i] == val) {
				for(int j =i+1 ; j < arr.length ; j++) {
					arr[j-1] = arr[j];
				}
				arr[arr.length-1] = val;
			}
		}
	}
	public  void transpose(int[][] arr) {
		/* if it might be empty i can make a flag in the main that at least one of the entries
		 * has a non-zero value should make the flag triggered and equal to 1 , so it will go inside the method 
		 * to transpose it , else it will never enter this method !
		 */
		for (int i= 0 ; i <arr.length ; i++) {
			for (int j=i+1 ; j<arr.length ; j++) {
				if (arr[i][j] != arr[j][i]){
					int temp = arr[i][j] ;
					arr[i][j] = arr[j][i] ;
					arr[j][i] = temp ;
				}
			}
		}
	}
}