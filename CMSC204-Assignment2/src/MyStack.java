import java.util.ArrayList;
import java.util.Collections;
/**
 * class implementing StackInterface
 * @author Daniel Cortes Gratacos
 *
 * @param <T> data type
 */
public class MyStack<T> implements StackInterface<T> {
	
	private int sizeOfStack;
	private ArrayList<T>stack;
	int items=0;
	
	public MyStack(){
		sizeOfStack=100;
		stack=new ArrayList<T> (sizeOfStack);
	}
	
	public MyStack(int size) {
		sizeOfStack=size;
		stack=new ArrayList<T> (sizeOfStack);
	}
	
	/**
	 * Deletes and returns the element at the top of the Stack
	 * @return the element at the top of the Stack
	 */
	@Override
	public T pop() throws StackUnderflowException {
		T poppedElement=null;
		if(0 == items) {
			throw new StackUnderflowException();
		}
		else {
			poppedElement=stack.get(items-1);
			stack.remove(items-1);
			items--;
			return poppedElement;
		}
	}

	/**
	 * Determines if Stack is empty
	 * @return true if Stack is empty, false if not
	 */
	@Override
	public boolean isEmpty() {
		if (0 == items)
			return true;
		else 
			return false;
	}

	/**
	 * Determines if Stack is full
	 * @return true if Stack is full, false if not
	 */
	@Override
	public boolean isFull() {
		if (sizeOfStack == items)
			return true;
		else 
			return false;
	}
	
	/**
	 * Adds an element to the top of the Stack
	 * @param e the element to add to the top of the Stack
	 * @return true if the add was successful, false if not
	 */
	@Override
	public boolean push(T e) throws StackOverflowException {
		if(sizeOfStack <= items) {
			throw new StackOverflowException();
			}
		else {
			stack.add(e);
			items++;
			return true;
		}

	}

	/**
	 * Returns the element at the top of the Stack, does not pop it off the Stack
	 * @return the element at the top of the Stack
	 */
	@Override
	public T top() throws StackUnderflowException {
		if(0 == items) {
			throw new StackUnderflowException();
		}
		else {
			return stack.get(items-1);
		}
	}

	/**
	 * Number of elements in the Stack
	 * @return the number of elements in the Stack
	 */
	@Override
	public int size() {
		return items;
	}
	
	/**
	  * Fills the Stack with the elements of the ArrayList, First element in the ArrayList
	  * is the first bottom element of the Stack
	  * @param list elements to be added to the Stack from bottom to top
	  */
	@Override
	public void fill(ArrayList<T> list) {
		ArrayList<T> listCopy=new ArrayList<T>(list);
		stack.addAll(listCopy);
		items=stack.size();
		
	}
	
	/**
	 * Returns the elements of the Stack in a string from bottom to top, the beginning 
	 * of the String is the bottom of the stack
	 * @return an string which represent the Objects in the Stack from bottom to top
	 */
	@Override
	public String toString() {
		String stackString="";
		for(T i:stack ) {
			stackString+=i;
		}
		return stackString;
	}
	
	/**
	 * Returns the string representation of the elements in the Stack, the beginning of the 
	 * string is the bottom of the stack
	 * Place the delimiter between all elements of the Stack
	 * @return string representation of the Stack from bottom to top with elements 
	 * separated with the delimiter
	 */
	@Override
	public String toString(String delimiter) {
		String stackString="";
		for(int i=0; stack.size() > i; i++ ) {
			if(stack.size()-1 != i) {
				stackString+=stack.get(i)+delimiter;
			}
			else {
				stackString+=stack.get(i);
			}
		}
		return stackString;
	}

}