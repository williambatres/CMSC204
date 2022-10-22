import java.util.Comparator;
import java.util.ListIterator;

public class SortedDoubleLinkedList<T> extends BasicDoubleLinkedList<T> {
	
	private Comparator<T> comparator;
	/**
	 * Creates an empty list that is associated with the specified comparator.
	 * @param comparableObject Comparator to compare data elements

	 */
	public SortedDoubleLinkedList(Comparator<T> comparableObject)
	{
		this.comparator =comparableObject;
	}
	
	/**
	 * Inserts the specified element at the correct position in the sorted list.
	 * Notice we can insert the same element several times.
	 * Your implementation must traverse the list only once in order to perform 
	 * the insertion.Do not implement this method using iterators. 
	 * Notice that you don't need to call any of the super class methods in order 
	 * to implement this method.
	 * @param data the data to be added to the list
	 */
	public void add(T data)
	{
		Node newData = new Node(data);
		Node currentNode = firstNode;
		Node prevNode = null;
		
		
		if(numberOfEntries == 0)
		{
			firstNode = newData;
			lastNode = firstNode;
		}
		else
		{
			while(currentNode != null)
			{
				if(comparator.compare(newData.data, currentNode.data) == 0)
				{
					if(currentNode.equals(firstNode))
					{
						newData.next = currentNode.next;
						currentNode.next = newData;
					}
				}
				else if(comparator.compare(newData.data, currentNode.data) < 0)
				{
					if(currentNode.equals(firstNode))
					{
						newData.next = currentNode;
						firstNode = newData;
					}

				}
				else if(comparator.compare(newData.data, currentNode.data) > 0)
				{
					if(comparator.compare(newData.data, lastNode.data) > 0)
					{
						lastNode.next = newData;
						lastNode = newData;
					}
	
			
				}
				prevNode = currentNode;
				currentNode = currentNode.next;
			}

		}
		numberOfEntries++;
		
		
		
	}
	/**
	 * This operation is invalid for a sorted list. An UnsupportedOperationException will be generated using the message 
	 * "Invalid operation for sorted list."
	 */
	public void addToEnd(T data) throws UnsupportedOperationException
	{
		throw new UnsupportedOperationException("Invalid operation for sorted list.");
		
	}
	
	/**
	 * This operation is invalid for a sorted list. An UnsupportedOperationException 
	 * will be generated using the message "Invalid operation for sorted list."
	 */
	public void addToFront(T data) throws UnsupportedOperationException
	{
		throw new UnsupportedOperationException("Invalid operation for sorted list.");
		
	}
	/**
	 * Implements the iterator by calling the super class iterator method.
	 */
	public ListIterator<T> iterator()
	{
		return super.iterator();
	}
	/**
	 * Implements the remove operation by calling the super class remove method.
	 * @param data the data element to be removed
	 * @param comparator the comparator to determine equality of data elements
	 * @return a node containing the data or null
	 */
	public Node remove(T data, Comparator<T> comparator)
	{
		return super.remove​(data, comparator);
	}

}
