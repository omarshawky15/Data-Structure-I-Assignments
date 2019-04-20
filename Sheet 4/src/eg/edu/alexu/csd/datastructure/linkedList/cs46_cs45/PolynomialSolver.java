package eg.edu.alexu.csd.datastructure.linkedList.cs46_cs45;

public class PolynomialSolver implements IPolynomialSolver {
	DoubleLinkedList A = new DoubleLinkedList();
	DoubleLinkedList B = new DoubleLinkedList();
	DoubleLinkedList C = new DoubleLinkedList();
	DoubleLinkedList R = new DoubleLinkedList();
	int[] visited = { 0, 0, 0 };

	public int[][] add(char poly1, char poly2) {
		DoubleLinkedList t = null;
		DoubleLinkedList t2 = null;
		DoubleLinkedList r = R;
		R.clear();

		t = checker(poly1);
		t2 = checker(poly2);
		int[] visited = new int[t2.size];

		for (int i = 0; i < t.size; i++) {
			int j = 0;
			while (((String) t.get(i)).charAt(j) != '+') {
				j++;
			}
			int coef1 = Integer.parseInt(((String) t.get(i)).substring(0, j));
			int exp1 = Integer.parseInt(((String) t.get(i)).substring(j + 1));

			int l = 0;
			int k = 0;
			while (((String) t.get(k)).charAt(l) != '+') {
				l++;
			}
			int coef2 = Integer.parseInt(((String) t2.get(k)).substring(0, l));
			int exp2 = Integer.parseInt(((String) t2.get(k)).substring(l + 1));
			while (exp1 < exp2) {
				if (visited[k] == 0) {
					r.add(Integer.toString((coef2)) + "+" + Integer.toString(exp2));
					visited[k] = 1;
				}
				l = 0;
				k++;
				while (((String) t2.get(k)).charAt(l) != '+') {
					l++;
				}
				coef2 = Integer.parseInt(((String) t2.get(k)).substring(0, l));
				exp2 = Integer.parseInt(((String) t2.get(k)).substring(l + 1));
			}
			coef2 = 0;
			for (k = 0; k < t2.size; k++) {
				if (visited[k] == 1)
					continue;
				l = 0;
				while (((String) t2.get(k)).charAt(l) != '+') {
					l++;
				}
				if (((String) t.get(i)).substring(j + 1).equals(((String) t2.get(k)).substring(l + 1))) {
					visited[k] = 1;
					coef2 = Integer.parseInt(((String) t2.get(k)).substring(0, l));
					break;
				}
			}
			r.add(Integer.toString((coef1 + coef2)) + "+" + Integer.toString(exp1));
		}
		for (int i = 0; i < t2.size; i++) {
			if (visited[i] == 0)
				r.add(t2.get(i));
		}
		int[][] arradd = new int[r.size][2];
		for (int i = 0; i < r.size; i++) {
			int h = 0;
			while (((String) r.get(i)).charAt(h) != '+') {
				h++;
			}
			arradd[i][0] = Integer.parseInt(((String) r.get(i)).substring(0, h));
			arradd[i][1] = Integer.parseInt(((String) r.get(i)).substring(h + 1));
		}

		return arradd;
	}

	public DoubleLinkedList checker(char c) {
		if (c == 'A')
			return A;
		else if (c == 'B')
			return B;
		else if (c == 'C')
			return C;
		else if (c == 'R')
			return R;
		else
			return null;
	}

	public void clearPolynomial(char poly) {
		DoubleLinkedList t = null;
		t = checker(poly);
		t.clear();
		if (t != R)
			t.add(Integer.toString(0) + "+" + Integer.toString(0));
		else
			t = null;
	}

	public int[] convert(LinkedListNode t) {
		int[] ans = new int[2];
		int j = 0;
		while (((String) t.getData()).charAt(j) != '+') {
			j++;
		}
		ans[0] = Integer.parseInt(((String) t.getData()).substring(0, j));
		ans[1] = Integer.parseInt(((String) t.getData()).substring(j + 1));

		return ans;
	}

	public float evaluatePolynomial(char poly, float value) {
		DoubleLinkedList t = null;
		t = checker(poly);
		if(t==null)return 0;
		float sum = 0;
		for (int i = 0; i < t.size; i++) {
			int j = 0;
			while (((String) t.get(i)).charAt(j) != '+') {
				j++;
			}
			int coff = Integer.parseInt(((String) t.get(i)).substring(0, j));
			int exp = Integer.parseInt(((String) t.get(i)).substring(j + 1));

			sum += coff * Math.pow(value, exp);
		}

		return sum;
	}

	public void initialize() {
		A.add(Integer.toString(0) + "+" + Integer.toString(0));
		B.add(Integer.toString(0) + "+" + Integer.toString(0));
		C.add(Integer.toString(0) + "+" + Integer.toString(0));
	}

	public int[][] multiply(char poly1, char poly2) {
		DoubleLinkedList t = null;
		DoubleLinkedList t2 = null;
		DoubleLinkedList r = R;
		R.clear();

		t = checker(poly1);
		t2 = checker(poly2);

		int[] coefexp1 = new int[2];
		int[] coefexp2 = new int[2];
		int[] coefexp3 = new int[2];
		LinkedListNode tn = t.head;
		LinkedListNode tn2 = t2.head;
		LinkedListNode tn3 = r.head;

		for (int i = 0; i < t.size; i++) {
			coefexp1 = convert(tn);
			for (int j = 0; j < t2.size; j++) {
				coefexp2 = convert(tn2);
				int multcoef = coefexp1[0] * coefexp2[0];
				int multexp = coefexp1[1] + coefexp2[1];
				int k;
				boolean flag = true;
				for (k = 0; k < r.size; k++) {
					coefexp3 = convert(tn3);
					if (multexp == coefexp3[1]) {
						r.set(k, Integer.toString(multcoef + coefexp3[0]) + "+" + Integer.toString(multexp));
						flag = false;
						break;
					}
					if (coefexp3[1] < multexp) {
						break;
					}
					tn3 = tn3.next;
				}
				if (flag) {
					r.add(k, Integer.toString(multcoef) + "+" + Integer.toString(multexp));
				}
				tn3 = r.head;
				tn2 = tn2.next;
			}
			tn2 = t2.head;
			tn = tn.next;
		}
		int[][] arrmulti = new int[r.size][2];
		for (int i = 0; i < r.size; i++) {
			int h = 0;
			while (((String) r.get(i)).charAt(h) != '+') {
				h++;
			}
			arrmulti[i][0] = Integer.parseInt(((String) r.get(i)).substring(0, h));
			arrmulti[i][1] = Integer.parseInt(((String) r.get(i)).substring(h + 1));
		}
		return arrmulti;
	}

	public String print(char poly) {
		DoubleLinkedList t = null;
		t = checker(poly);
		StringBuilder s1 = new StringBuilder();
		for (int i = 0; i < t.size; i++) {
			int j = 0;
			while (((String) t.get(i)).charAt(j) != '+') {
				j++;
			}
			int coef = Integer.parseInt(((String) t.get(i)).substring(0, j));
			int exp = Integer.parseInt(((String) t.get(i)).substring(j + 1));
			if (coef == 0)
				continue;
			else {
				if (coef > 0 && i != 0)
					s1.append("+");
				if (exp == 0) {
					s1.append(coef);
				} else {
					if (Math.abs(coef) != 1)
						s1.append(coef);
					else if(coef < 0 ) {
						s1.append('-');
					}
					s1.append("x");
					if (exp != 1)
						s1.append("^" + exp);
				}
			}
		}
		if (s1.length() == 0)
			return "0";
		return s1.toString();
	}

	public void setPolynomial(char poly, int[][] terms) {
		DoubleLinkedList t = new DoubleLinkedList();
		t = checker(poly);
		t.clear();
		for (int i = 0; i < terms.length; i++) {
			t.add(Integer.toString(terms[i][0]) + "+" + Integer.toString(terms[i][1]));
		}
		visited[(int) (poly - 'A')] = 1;
	}

	public int[][] subtract(char poly1, char poly2) {
		DoubleLinkedList t = null;
		DoubleLinkedList t2 = null;
		DoubleLinkedList r = R;
		R.clear();

		t = checker(poly1);
		t2 = checker(poly2);
		int[] visited = new int[t2.size];

		for (int i = 0; i < t.size; i++) {
			int j = 0;
			while (((String) t.get(i)).charAt(j) != '+') {
				j++;
			}
			int coef1 = Integer.parseInt(((String) t.get(i)).substring(0, j));
			int exp1 = Integer.parseInt(((String) t.get(i)).substring(j + 1));

			int l = 0;
			int k = 0;
			while (((String) t.get(k)).charAt(l) != '+') {
				l++;
			}
			int coef2 = Integer.parseInt(((String) t2.get(k)).substring(0, l));
			int exp2 = Integer.parseInt(((String) t2.get(k)).substring(l + 1));
			while (exp1 < exp2) {
				if (visited[k] == 0) {
					r.add(Integer.toString((-coef2)) + "+" + Integer.toString(exp2));
					visited[k] = 1;
				}
				l = 0;
				k++;
				while (((String) t2.get(k)).charAt(l) != '+') {
					l++;
				}
				coef2 = Integer.parseInt(((String) t2.get(k)).substring(0, l));
				exp2 = Integer.parseInt(((String) t2.get(k)).substring(l + 1));
			}
			coef2 = 0;
			for (k = 0; k < t2.size; k++) {
				if (visited[k] == 1)
					continue;
				l = 0;
				while (((String) t2.get(k)).charAt(l) != '+') {
					l++;
				}
				if (((String) t.get(i)).substring(j + 1).equals(((String) t2.get(k)).substring(l + 1))) {
					visited[k] = 1;
					coef2 = Integer.parseInt(((String) t2.get(k)).substring(0, l));
					break;
				}
			}
			r.add(Integer.toString((coef1 - coef2)) + "+" + Integer.toString(exp1));
		}
		for (int i = 0; i < t2.size; i++) {
			if (visited[i] == 0) {
				int l = 0;
				while (((String) t2.get(i)).charAt(l) != '+') {
					l++;
				}
				int coef2 = Integer.parseInt(((String) t2.get(i)).substring(0, l));
				int exp2 = Integer.parseInt(((String) t2.get(i)).substring(l + 1));
				r.add(Integer.toString((-coef2)) + "+" + Integer.toString(exp2));
			}
		}
		int[][] arrsub = new int[r.size][2];
		for (int i = 0; i < r.size; i++) {
			int h = 0;
			while (((String) r.get(i)).charAt(h) != '+') {
				h++;
			}
			arrsub[i][0] = Integer.parseInt(((String) r.get(i)).substring(0, h));
			arrsub[i][1] = Integer.parseInt(((String) r.get(i)).substring(h + 1));
		}

		return arrsub;
	}

}
