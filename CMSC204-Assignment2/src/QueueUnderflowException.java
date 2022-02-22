/**
 * QueueUnderflowException class
 * @author Daniel Cortes Gratacos
 *
 */
public class QueueUnderflowException extends Exception{
	/**
	 * Occurs when a  dequeue method is called on an empty queue.
	 */
	QueueUnderflowException(){
		super("Queue is empty");
	}

}