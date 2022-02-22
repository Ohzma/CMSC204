/**
 * QueueOverflowException class
 * @author Daniel Cortes Gratacos
 *
 */
public class QueueOverflowException extends Exception{
	/**
	 * Occurs when a enqueue method is called on a full queue.
	 */
	QueueOverflowException(){
		super("Queue is full");
	}
}