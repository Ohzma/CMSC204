/** Node for a Tree, has a left and right child
 * 
 * @author Daniel Cortes Gratacos
 *
 * @param <T> The datatype for the data the TreeNode will hold
 */
public class TreeNode<T> {
	
	TreeNode<T> left;
	TreeNode<T> right;
	private T data;
	
	/** Generic Constructor for the TreeNode
	 * 
	 * @param dataNode The data to store in the node
	 */
	public TreeNode(T dataNode) {
		left = right = null;
		data = dataNode;
	}
	
	/** Copy constructor for the TreeNode
	 * 
	 * @param node The node to be copied
	 */
	public TreeNode(TreeNode<T> node) {
		this(node.getData());
		left = node.left;
		right = node.right;
	}
	
	/** Gets the data from the node
	 * 
	 * @return The data in the node
	 */
	public T getData() {
		return data;
	}
}