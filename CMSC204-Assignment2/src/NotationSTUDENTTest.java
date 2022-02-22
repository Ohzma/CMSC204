import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class NotationSTUDENTTest {
	public String complexInfix = "(((4/2)*(5+(6-3)))+((5/1)-(8-4)))";
	public String complexPostfix =  "42/563-+*51/84--+";
	public String easyInfix = "(6/3)";
	public String easyPostfix = "63/";
	public String intermediateInfix = "((4/(9-7))+(3*6))";
	public String intermediatePostfix = "497-/36*+";
	
	public double complexPostfixRes=17;
	public double intermediatePostfixRes=20;
	public double easyPostfixRes=2;
	
	public double complexInfixRes=17;
	public double intermediateInfixRes=20;
	public double easyInfixRes=2;
			
	public String invalidPostfix = "897-+/";
	public String invalidInfix = "(9-7)+8)";
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testComplexConvertInfixToPostfix() throws InvalidNotationFormatException {
		String postfix=Notation.convertInfixToPostfix(complexInfix);
		assertEquals(postfix,complexPostfix);
	}
	
	@Test
	public void testIntermediateConvertInfixToPostfix() throws InvalidNotationFormatException {
		String postfix=Notation.convertInfixToPostfix(intermediateInfix);
		assertEquals(postfix,intermediatePostfix);
		
	}
	
	@Test
	public void testEasyConvertInfixToPostfix() throws InvalidNotationFormatException {
		String postfix=Notation.convertInfixToPostfix(easyInfix);
		assertEquals(postfix,easyPostfix);

		
	}
	
	@Test
	public void testInvalidInfixExpression() {
		try{
			Notation.convertInfixToPostfix(invalidInfix);
			assertTrue("This should throw an InvalidNotationFormatException",false);
		}
		catch (InvalidNotationFormatException e)
		{
			assertTrue("Threw an InvalidNotationFormatException",true);
		}
	}
	
	@Test
	public void testComplexConvertPostfixToInfix() throws InvalidNotationFormatException {
		String infix=Notation.convertPostfixToInfix(complexPostfix);
		assertEquals(infix,complexInfix);
	}
	
	@Test
	public void testIntermediateConvertPostfixToInfix() throws InvalidNotationFormatException {
		String infix=Notation.convertPostfixToInfix(intermediatePostfix);
		assertEquals(infix,intermediateInfix);
	}
	
	@Test
	public void testEasyConvertPostfixToInfix() throws InvalidNotationFormatException {
		String infix=Notation.convertPostfixToInfix(easyPostfix);
		assertEquals(infix,easyInfix);
	}

	@Test
	public void testInvalidPostfixExpression() {
		try{
			Notation.convertPostfixToInfix(invalidPostfix);
			assertTrue("This should throw an InvalidNotationFormatException",false);
		}
		catch (InvalidNotationFormatException e)
		{
			assertTrue("Threw an InvalidNotationFormatException",true);
		}
	}
	
	@Test
	public void testComplexEvaluatePostfixExpression() throws InvalidNotationFormatException {
		double postfixResult = Notation.evaluatePostfixExpression(complexPostfix);
		assertEquals(complexPostfixRes, postfixResult, .001);
	}
	
	@Test
	public void testIntermediateEvaluatePostfixExpression() throws InvalidNotationFormatException {
		double postfixResult = Notation.evaluatePostfixExpression(intermediatePostfix);
		assertEquals(intermediatePostfixRes, postfixResult, .001);
	}
	
	@Test
	public void testEasyEvaluatePostfixExpression() throws InvalidNotationFormatException {
		double postfixResult = Notation.evaluatePostfixExpression(easyPostfix);
		assertEquals(easyPostfixRes, postfixResult, .001);
	}
	
	@Test
	public void testComplexEvaluateInfixExpression() throws InvalidNotationFormatException {
		double infixResult = Notation.evaluateInfixExpression(complexInfix);
		assertEquals(complexInfixRes, infixResult, .001);
	}
	
	@Test
	public void testIntermediateEvaluateInfixExpression() throws InvalidNotationFormatException {
		double infixResult = Notation.evaluateInfixExpression(intermediateInfix);
		assertEquals(intermediateInfixRes, infixResult, .001);
	}
	
	@Test
	public void testEasyEvaluateInfixExpression() throws InvalidNotationFormatException {
		double infixResult = Notation.evaluateInfixExpression(easyInfix);
		assertEquals(easyInfixRes, infixResult, .001);
	}
	
	@Test
	public void testEvaluateInvalidPostfixExpression() {
		try{
			Notation.evaluatePostfixExpression(invalidPostfix);
			assertTrue("This should throw an InvalidNotationFormatException",false);
		}
		catch (InvalidNotationFormatException e)
		{
			assertTrue("Threw an InvalidNotationFormatException",true);
		}
	}
	
	@Test
	public void testEvaluateInvalidInfixExpression() {
		try{
			Notation.evaluateInfixExpression(invalidInfix);
			assertTrue("This should throw an InvalidNotationFormatException",false);
		}
		catch (InvalidNotationFormatException e)
		{
			assertTrue("Threw an InvalidNotationFormatException",true);
		}
	}
}