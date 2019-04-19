package eg.edu.alexu.csd.datastructure.linkedList.cs46_cs45;

public interface IPolynomialSolver {
	int[][] add(char poly1, char poly2);

	void clearPolynomial(char poly);

	float evaluatePolynomial(char poly, float value);

	int[][] multiply(char poly1, char poly2);

	String print(char poly);

	void setPolynomial(char poly, int[][] terms);

	int[][] subtract(char poly1, char poly2);

}
