
/**
 * The external Tree Node for Linked Trees
 * @author William Batres
 * @param <T> -data type of TreeNode
 */
public class TreeNode<T> {

	protected T data;
	protected TreeNode<T> leftChild, rightChild;
	
	
/**
 * Create a new TreeNode with left and right child 
 * set to null and data set to the dataNode
 * @param dataNode - the data to be stored in the TreeNode
 */
	public TreeNode(T dataNode)
	{
		this.data = dataNode;
		this.leftChild = null;
		this.rightChild = null;
		
	}
	
/**
 * used for making deep copies
 * @param node - node to make copy of
 */
	public TreeNode(TreeNode<T> node)
	{
		this.data = node.data;
		this.leftChild = node.leftChild;
		this.rightChild = node.rightChild;
	}

/**
 * Return the data within this TreeNode
 * @return the data within the TreeNode
 */
	public T getData() {
		return data;
	}

	
	
}
