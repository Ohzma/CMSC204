/**
 * This utility class converts infix to postfix notation strings and vice-versa, and also evaluates
 * those strings.
 * 
 * @author Daniel Cortes Gratacos
 *
 */
public class Notation {

  private static MyQueue<String> mQueue;
  private static MyStack<String> mStack;
  private final static String OPS = "+-*/";

  // Helper methods to handle Exceptions

  /**
   * Returns the element at the top of the NotationStack<String> nStack but it doesn't remove it.
   * 
   * @return the element at the top of nStack
   */
  private static String stackTop() {
    try {
      return mStack.top();
    } catch (StackUnderflowException e) {
      e.getMessage();
    }
    return null;
  }
  
  /**
   * Add an element to the top of NotationStack<String> nStack.
   * 
   * @param c - - the element to add at the top of the stack
   * @return true if the add was successful, false if not
   */
  private static boolean stackPush(String c) {
    try {
      return mStack.push(c);
    } catch (StackOverflowException e) {
      e.getMessage();
    }
    return false;
  }

  /**
   * Returns element at the top of the NotationStack<String> nStack and removes it from the stack.
   * 
   * @return the element at the top of nStack
   */
  private static String stackPop() {
    try {
      return mStack.pop();
    } catch (StackUnderflowException e) {
      e.getMessage();
    }
    return null;
  }
  
  /**
   * Deletes and returns the element at the front of the NotationQueue<String> nQueue.
   * 
   * @return the element at the front of the queue
   */
  private static String dequeue() {
    try {
      return mQueue.dequeue();
    } catch (QueueUnderflowException e) {
      e.getMessage();
    }
    return null;
  }

  /**
   * Add an element to the end of the NotationQueue<String> nQueue.
   * 
   * @param c - - the element to add at the end of the queue
   * @return true if the add was successful, false if not
   */
  private static boolean enqueue(String c) {
    try {
      return mQueue.enqueue(c);
    } catch (QueueOverflowException e) {
      e.getMessage();
    }
    return false;
  }

  // HELPER METHODS
  
  /**
   * Evaluate the correspondent operation between two operands
   * 
   * @param first - - the first operand
   * @param second - - the second operand
   * @param operator - - the operator
   * @return the string representation of the result of the operation
   * @throws InvalidNotationFormatException
   */
  private static String applyOperator(String first, String second, char operator)
      throws InvalidNotationFormatException {
    double a = Double.parseDouble(first);
    double b = Double.parseDouble(second);
    switch (operator) {
      case '+':
        return Double.toString(a + b);
      case '-':
        return Double.toString(a - b);
      case '*':
        return Double.toString(a * b);
      case '/':
        if (b == 0)
          throw new InvalidNotationFormatException();
        return Double.toString(a / b);
    }
    return null;
  }
  
  /**
   * Calculates the precedence of the operator
   * 
   * @param c - - the operator to evaluate for precedence
   * @return 1 if the operator has high precedence and 0 if low precedence. -1 if not operator
   */
  private static int calculatePrec(char c) {
    if ('*' == c || '/' == c) {
      return 1;
    } else if ('+' == c || '-' == c) {
      return 0;
    }
    return -1;
  }

  // MAIN METHODS

  /**
   * Convert an infix expression into a postfix expression
   * 
   * @param infix - - the infix expression in string format
   * @return the postfix expression in string format
   * @throws InvalidNotationFormatException - if the infix expression format is invalid
   */
  public static String convertPostfixToInfix(String complexPostfix)
      throws InvalidNotationFormatException {
    mStack = new MyStack<String>();
    for (int i = 0;complexPostfix.length() > i; i++) {
      char cur = complexPostfix.charAt(i);
      if (' ' == cur) {
        continue;
      } else if (Character.isDigit(cur)) {
        stackPush(Character.toString(cur));
      } else if (OPS.indexOf(cur) >= 0) {
        String a = stackPop().toString(), b, tmp;
        if (mStack.isEmpty()) {
          throw new InvalidNotationFormatException();
        } else {
          b = stackPop().toString();
          tmp = '(' + b + cur + a + ')';
          stackPush(tmp);
        }
      }
    }
    if (1 != mStack.size()) {
      throw new InvalidNotationFormatException();
    }
    return stackPop();
  }
  
  /**
   * Convert an infix expression into a postfix expression
   * 
   * @param complexInfix - - the postfix expression in string format
   * @return the infix expression in string format
   * @throws InvalidNotationFormatException - if the postfix expression format is invalid
   */
  public static String convertInfixToPostfix(String complexInfix)
      throws InvalidNotationFormatException {
    mQueue = new MyQueue<String>();
    mStack = new MyStack<String>();

    for (int i = 0; complexInfix.length() > i; i++) {
      char cur = complexInfix.charAt(i);
      if (' ' == cur) {
        continue;
      } else if (Character.isDigit(cur)) {
        enqueue(Character.toString(cur));
      } else if ('(' == cur) {
        stackPush(Character.toString(cur));
      } else if (0 <= OPS.indexOf(cur)) {
        while (!mStack.isEmpty() && calculatePrec(cur) <= calculatePrec(stackTop().charAt(0))) {
          enqueue(stackPop());
        }
        stackPush(Character.toString(cur));
      } else if (')' == cur) {
        char top = stackPop().charAt(0);
        while ('(' != top) {
          enqueue(Character.toString(top));
          if (mStack.isEmpty()) {
            throw new InvalidNotationFormatException();
          } else {
            top = stackPop().charAt(0);
          }
        }
      }
    }
    while (!mStack.isEmpty()) {
      enqueue(stackPop());
    }
    return mQueue.toString();
  }
  
  /**
   * Evaluates an infix expression from a string to a double
   * 
   * @param infixExpr - the infix expression in String format
   * @return the evaluation of the infix expression as a double
   */
  public static double evaluateInfixExpression(String infixExpr) throws InvalidNotationFormatException {
		double result=0;
		result=evaluatePostfixExpression(convertInfixToPostfix(infixExpr));
		
		return result;
	}

  /**
   * Evaluates a postfix expression from a string to a double
   * 
   * @param complexPostfix - the postfix expression in String format
   * @return the evaluation of the postfix expression as a double
   * @throws InvalidNotationFormatException - if the postfix expression format is invalid
   */
  public static double evaluatePostfixExpression(String complexPostfix)
      throws InvalidNotationFormatException {
    mStack = new MyStack<String>();
    for (int i = 0; complexPostfix.length() > i; i++) {
      char cur = complexPostfix.charAt(i);
      if (cur == ' ') {
        continue;
      } else if (cur == '(' || Character.isDigit(cur)) {
        stackPush(Character.toString(cur));
      } else if (0 <= OPS.indexOf(cur)) {
        String a = stackPop().toString(), b;
        String result;
        if (mStack.isEmpty()) {
          throw new InvalidNotationFormatException();
        } else {
          b = stackPop().toString();
          result = applyOperator(b, a, cur);
          stackPush(result);
        }
      }
    }
    while (1 != mStack.size()) {
      throw new InvalidNotationFormatException();
    }
    return Double.parseDouble(stackPop());
  }

}