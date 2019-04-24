package eg.edu.alexu.csd.datastructure.stack.cs46;

import org.junit.Assert;
import org.junit.Test;

public class ExpressionEvaluatorTester {
    ExpressionEvaluator tester= new ExpressionEvaluator();;
	@Test
	public void firsTest() throws Exception{
		// Example on negative integers and more than one decimal integer number , Please Consider the shape of This Sample !
		
		Assert.assertEquals("2 3 + -4 *",tester.infixToPostfix("-(-(2 + 3) * 4)"));
		Assert.assertEquals("-32 -23 4 * +",tester.infixToPostfix("-(32 + 23 * -4)"));
		Assert.assertEquals("32 23 * -4444 /",tester.infixToPostfix("32 * 23 / -4444"));

		
		// Please !!
		
		// The Assignment Test Cases 
		Assert.assertEquals("a b * c /",tester.infixToPostfix("a * b / c"));
		Assert.assertEquals("1 2 + 7 *",tester.infixToPostfix("(1 + 2) * 7"));
		Assert.assertEquals("a b * 5 +",tester.infixToPostfix("a * b + 5"));
		Assert.assertEquals("a b c - d + / e a - * c *",tester.infixToPostfix("(a / (b - c + d)) * (e - a) * c"));
		Assert.assertEquals("a b / c - d e * + a c * -",tester.infixToPostfix("a / b - c + d * e - a * c"));
	}
	@Test
	public void secondTest() throws Exception{
		
		//Assignment Test Case
		Assert.assertEquals(8,tester.evaluate("6 2 / 3 - 4 2 * +"));
		Assert.assertEquals((2+3) * 4,tester.evaluate("2 3 + 4 *"));
		Assert.assertEquals((1 + 2) * 7,tester.evaluate("1 2 + 7 *"));

		// Some negative/multiple integer numbers Test Cases 
		Assert.assertEquals(6/2 - -3 + (4*2),tester.evaluate("6 2 / -3 - 4 2 * +"));
		Assert.assertEquals(6/-2 - 3 + (4*-2),tester.evaluate("6 -2 / 3 - 4 -2 * +"));

	}
}
