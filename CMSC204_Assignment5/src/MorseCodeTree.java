import java.util.ArrayList;
import java.util.Arrays;

/** Tree that holds Morse Code in a way that's easy to read
 * 
 * @author Daniel Cortes Gratacos
 *
 */
public class MorseCodeTree implements LinkedConverterTreeInterface<String>{
	private TreeNode<String> root;
	
	/** Default constructor that builds the tree and creates the root */
	public MorseCodeTree() {
		root = new TreeNode<>("");
		buildTree();
	}

	
	/** Inserts an item into the tree
	 * 
	 *  @param code The code for the letter in morse code
	 *  @param result The letter to add into the tree
	 *  @return A reference to this
	 */
	@Override
	public LinkedConverterTreeInterface<String> insert(String code, String result) {
		addNode(root, code, result);
		return this;
	}

	/** Sets the root of the tree
	 *  
	 *  @param newNode The new root
	 */
	@Override
	public void setRoot(TreeNode<String> newNode) {
		root = newNode;
	}

	/** Gets the root of the tree
	 * 
	 *  @return The tree's root
	 */
	@Override
	public TreeNode<String> getRoot() {
		return root;
	}

	/** Gets a letter from the tree
	 *
	 * @param code The code for the letter you want
	 * @return The english letter corresponding to the morse code
	 */
	@Override
	public String fetch(String code) {
		return fetchNode(root, code);
	}
	
	/** Adds a node into the tree
	 * 
	 *  @param root The node's root
	 *  @param code The path of the letter, in morse code
	 *  @param letter The letter to add
	 */
	@Override
	public void addNode(TreeNode<String> root, String code, String letter) {
		//System.out.println("Adding: " + code + " " + letter);
		TreeNode<String> nextNode = new TreeNode<>(letter);
		char[] codeArr = code.toCharArray();
		char firstCharacter = codeArr[0];
		
		if (codeArr.length == 1) {
			if('.' == firstCharacter) {
				if (root.left == null) {
					root.left = nextNode;
					//System.out.println("Addded " + letter);
				}
			} else if( '-' == firstCharacter) {
				if (root.right == null) {
					root.right = nextNode;
					//System.out.println("Added " + letter);
				}
			}
		}
			
		else {
			TreeNode<String> newRoot = root;
			char[] newCodeArr = Arrays.copyOfRange(codeArr, 1, codeArr.length);
			String newCode = String.valueOf(newCodeArr);
			
			if( '.' == firstCharacter)
				newRoot = root.left;
			else if ( '-' == firstCharacter)
				newRoot = root.right;
			
			addNode(newRoot, newCode, letter);
		}
	}


	/** Gets a node from the tree
	 * 
	 * @param root The node's root
	 * @param code The path to the letter in morse code
	 * @return The letter corresponding to the morse code
	 */
	@Override
	public String fetchNode(TreeNode<String> root, String code) {
		String toReturn = "";
		char[] codeArr = code.toCharArray();
		char firstCharacter = codeArr[0];
		
		if (1 == codeArr.length) {
			if( '.' == firstCharacter) {
				toReturn = root.left.getData();
			} else if('-' == firstCharacter) {
				toReturn = root.right.getData();
			}
			
		}else {
			TreeNode<String> newRoot = root;
			char[] newCodeArr = Arrays.copyOfRange(codeArr, 1, codeArr.length);
			String newCode = String.valueOf(newCodeArr);
			
			if('.' == firstCharacter)
				newRoot = root.left;
			else if ('-' == firstCharacter)
				newRoot = root.right;
			
			toReturn = fetchNode(newRoot, newCode);
		}
		
		return toReturn;
	}

	/** Delete not supported
	 * 
	 * @param data Nothing
	 * @return Nothing
	 */
	@Override
	public LinkedConverterTreeInterface<String> delete(String data) throws UnsupportedOperationException {
		throw new UnsupportedOperationException("Cannot delete nodes");
	}
	/** Builds the tree with all letters in the alphabet and the morse code */
	@Override
	public void buildTree() {
		insert(".", "e");
		insert("-", "t");
		insert("..", "i");
		insert(".-", "a");
		insert("-.", "n");
		insert("--", "m");
		insert("...", "s");
		insert("..-", "u");
		insert(".-.", "r");
		insert(".--", "w");
		insert("-..", "d");
		insert("-.-", "k");
		insert("--.", "g");
		insert("---", "o");
		insert("....", "h");
		insert("...-", "v");
		insert("..-.", "f");
		insert(".-..", "l");
		insert(".--.", "p");
		insert(".---", "j");
		insert("-...", "b");
		insert("-..-", "x");
		insert("-.-.", "c");
		insert("-.--", "y");
		insert("--..", "z");
		insert("--.-", "q");
	}

	/** Update not supported
	 * 
	 * @return Nothing
	 */
	@Override
	public LinkedConverterTreeInterface<String> update() throws UnsupportedOperationException {
		throw new UnsupportedOperationException("Cannot update nodes");
	}

	
	
	/** Goes through the tree and adds each item to the arrayList
	 * 
	 * @param root The current node's root
	 * @param list The arraylist to add items
	 */
	@Override
	public void LNRoutputTraversal(TreeNode<String> root, ArrayList<String> list) {
		while (root != null) {
			LNRoutputTraversal(root.left, list);
			list.add(root.getData());
			LNRoutputTraversal(root.right, list);
		}
	}

	/** Converts the tree to an ArrayList
	 * 
	 * @return ArrayList of the items in the tree, in order
	 */
	@Override
	public ArrayList<String> toArrayList() {
		ArrayList<String> toReturn = new ArrayList<>();
		LNRoutputTraversal(root, toReturn);
		return toReturn;
	}
	
}