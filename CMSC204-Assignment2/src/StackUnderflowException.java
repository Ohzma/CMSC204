/**
 * StackUnderflowException class
 * @author Daniel Cortes Gratacos
 *
 */
public class StackUnderflowException extends Exception{
	/**
	 * Occurs when a top or pop method is called on an empty stack.
	 */
	StackUnderflowException(){
		super("Stack is empty");
	}
}