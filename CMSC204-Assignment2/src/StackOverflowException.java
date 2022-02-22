/**
 * StackOverflowException class
 * @author Daniel Cortes Gratacos
 *
 */
public class StackOverflowException extends Exception{
	/**
	 * Occurs when a push method is called on a full stack.
	 */
	StackOverflowException(){
		super("Stack is full");
	}

}