import java.util.ArrayList;

/**
 * @author William Batres
 *This is a MorseCodeTree which is specifically used for the conversion of morse code to english
 *It relies on a root (reference to root of the tree)
 *The root is set to null when the tree is empty.
 *The class uses an external generic TreeNode class which consists of a reference to the data and a
 *reference to the left and right child. The TreeNode is parameterized as a String, TreeNode This class uses
 *a private member root (reference to a TreeNode)
 */
public class MorseCodeTree implements LinkedConverterTreeInterface<String>{

	private TreeNode<String> root;
	
	public MorseCodeTree()
	{
		buildTree();
	}
	
	/**
	 * Returns a reference to the root
	 * @return reference to root
	 */
	@Override
	public TreeNode getRoot() {
		return root;
	}

	/**
	 * sets the root of the Tree
	 * @param newNode a TreeNode<T> that will be the new root
	 */
	@Override
	public void setRoot(TreeNode newNode) {
		this.root = new TreeNode<String>(newNode);
		
	}

	/**
	 * Adds result to the correct position in the tree based on the code
	 * This method will call the recursive method addNode
	 * 
	 * @param code the code for the new node to be added
	 * 
	 */
	@Override
	public void insert(String code, String result) {
		addNode(root,code,result);
	}
	/**
	 * This is a recursive method that adds element to the correct position 
	 * in the tree based on the code.
	 * Unless it is one letter within the string indicating the final position of the letter
	 * the recursive method will cut the string in the front by one letter using the string builder
	 * object then passes the new string into the recursive method repeating the process
	 * until the final '.' or '-' is indicated
	 * @param root the root of the tree for this particular recursive instance of addNode
	 * @param code the code for this particular recursive instance of addNode
	 * @param letter the data of the new TreeNode to be added
	 */
	@Override
	public void addNode(TreeNode<String> root, String code, String letter) {
		
		if(code.length() == 1)
		{
			if(code.charAt(0) == '-')
			{
				
				root.rightChild = new TreeNode<String>(letter);
			}
			else
			{
				root.leftChild = new TreeNode<String>(letter);
			}
		}
		else
		{
			
			if(code.charAt(0)== '-')
			{
				StringBuilder sb = new StringBuilder(code); // String builder object created
				code = sb.deleteCharAt(0).toString(); // string builder removes first letter in String
				addNode(root.rightChild,code,letter);
			}
			else if(code.charAt(0)== '.')
			{
				StringBuilder sb = new StringBuilder(code); // String builder object created
				code = sb.deleteCharAt(0).toString(); // string builder removes first letter in String
				addNode(root.leftChild,code,letter);
			}
		}
		
		
	}

	/**
	 * Fetch the data in the tree based on the code
	 * This method will call the recursive method fetchNode
	 * 
	 * @param code the code that describes the traversals within the tree
	 * @return the result that corresponds to the code
	 */
	@Override
	public String fetch(String code) {
		return fetchNode(root, code);
	}

	/**
	 * This is the recursive method that fetches the data of the TreeNode
	 * that corresponds with the code
	 * 
	 * @param root the root of the tree for this particular recursive instance of addNode
	 * @param code the code for this particular recursive instance of fetchNode
	 * @return the data corresponding to the code
	 */
	@Override
	public String fetchNode(TreeNode<String> root, String code) {

		
		
		if(code.length() == 1)
		{
			if(code.charAt(0) == '-')
			{
				return root.rightChild.data;
			}
			else
			{
				return root.leftChild.data;
			}
		}
		else
		{

			if(code.charAt(0)== '-')
			{
				StringBuilder sb = new StringBuilder(code); // String builder object created
				code = sb.deleteCharAt(0).toString(); // string builder removes first letter in String
				return fetchNode(root.rightChild,code);
			}
			else if(code.charAt(0)== '.')
			{
				StringBuilder sb = new StringBuilder(code); // String builder object created
				code = sb.deleteCharAt(0).toString(); // string builder removes first letter in String
				return fetchNode(root.leftChild,code);
			}
		}
		return null;
	}

	/**
	 * This operation is not supported for a LinkedConverterTree
	 * @param data data of node to be deleted
	 * @return reference to the current tree
	 * @throws UnsupportedOperationException
	 */
	@Override
	public LinkedConverterTreeInterface<String> delete(String data) throws UnsupportedOperationException {
		throw new UnsupportedOperationException();
	}

	/**
	 * This operation is not supported for a LinkedConverterTree
	 * @return reference to the current tree
	 * @throws UnsupportedOperationException
	 */
	@Override
	public LinkedConverterTreeInterface<String> update() throws UnsupportedOperationException {
		throw new UnsupportedOperationException();
	}

	/**
	 * This method builds the LinkedConverterTree by inserting TreeNodes<T>
	 * into their proper locations
	 * 
	 */
	@Override
	public void buildTree() {
		
		//All the following levels are created in level order and the left and 
		//right side refer only to the corresponding side based on the root
		//not the left or right subtree of the side refereed
		
		//level 1 - root
		root = new TreeNode<String>("");
		
		//level 2
		insert(".", "e");
		insert("-", "t");
		
		//level 3
		insert("..", "i");
		insert(".-", "a");
		insert("--", "m");
		insert("-.", "n");
		
		//level 4 - right side
		insert("...", "s");
		insert("..-", "u");
		insert(".-.", "r");
		insert(".--", "w");
		
		//level 4 - left side
		insert("-..", "d");
		insert("-.-", "k");
		insert("--.", "g");
		insert("---", "o");
		
		//level 5 - right side
		insert("....", "h");
		insert("...-", "v");
		insert("..-.", "f");
		insert(".-..", "l");
		insert(".--.", "p");
		insert(".---", "j");

		//level 5 - left side
		insert("-...", "b");
		insert("-..-", "x");
		insert("-.-.", "c");
		insert("-.--", "y");
		insert("--..", "z");
		insert("--.-", "q");

		
	}

	/**
	 * Returns an ArrayList of the items in the linked converter Tree in LNR (Inorder) Traversal order
	 * Used for testing to make sure tree is built correctly
	 * @return an ArrayList of the items in the linked Tree
	 */
	@Override
	public ArrayList<String> toArrayList() {
		ArrayList<String> returnList = new ArrayList<>();
		LNRoutputTraversal(root,returnList);
		return returnList;
	}

	/**
	 * The recursive method to put the contents of the linked converter tree in an ArrayList<T> 
	 * LNR (Inorder)
	 * @param root the root of the tree for this particular recursive instance
	 * @param list the ArrayList that will hold the contents of the tree in LNR order
	 */
	@Override
	public void LNRoutputTraversal(TreeNode<String> root, ArrayList<String> list) {
		
		//base case for recursion
//		if(root == null)
//			return;
//		else 
//		{
//			if (root.leftChild != null)
//			{
//				LNRoutputTraversal(root.leftChild, list);
//			}
//			
//			list.add(root.data);
//			if(root.rightChild != null)
//			{
//				LNRoutputTraversal(root.leftChild, list);
//			}
//		}
		
		if(root == null)
			return;
		
		LNRoutputTraversal(root.leftChild, list);
		list.add(root.data);
		LNRoutputTraversal(root.rightChild,list);
		
		
	}


		


	
	

}
