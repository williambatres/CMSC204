import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;


public class BasicDoubleLinkedList<T> implements Iterable<T>{
	protected Node firstNode;
	protected Node lastNode;
	protected int numberOfEntries;
	
	
	
	public BasicDoubleLinkedList()
	{
		this.firstNode = null;
		this.lastNode = null;
		this.numberOfEntries = 0;
	}
	
	public BasicDoubleLinkedList(int setSize)
	{
		this.firstNode = null;
		this.lastNode = null;
		this.numberOfEntries = setSize;
	}
	
	public int getSize()
	{
		return this.numberOfEntries;
	}
	
	public void addToEnd(T data)
	{
		Node temp = new Node(data);
		if(this.numberOfEntries == 0)
		{
			firstNode = temp;
			lastNode = temp;
			
		}
		else 
		{
			lastNode.next = temp;
			temp.prev = lastNode;
			lastNode = temp;
		}
		numberOfEntries++;
	}
	
	public void addToFront(T data)
	{
		Node temp = new Node(data);
		if(this.numberOfEntries == 0)
		{
			firstNode = temp;
			lastNode = temp;
			
		}
		else 
		{
			firstNode.prev = temp;
			temp.next = firstNode;
			firstNode = temp;
		}
		numberOfEntries++;
	}
	
	public T getFirst()
	{
		if(this.numberOfEntries == 0)
			return null;
		else 
			return firstNode.data;
	}
	
	public T getLast()
	{
		if(this.numberOfEntries == 0)
			return null;
		else 
			return lastNode.data;
	}
	
	public ListIterator<T> iterator()  {
		return new DoubleLinkedListIterator();
	}

	public  BasicDoubleLinkedList.Node remove​(T targetData, Comparator<T> comparator)
	{
		Node currentNode = firstNode;
		Node prevNode = null;
		
		while(currentNode != null)
		{
			if(comparator.compare(targetData, currentNode.data) == 0)
			{
				if(currentNode.equals(firstNode))
					firstNode = firstNode.next;
				else if(currentNode.equals(lastNode))
					lastNode = prevNode;
				else
					prevNode.next = currentNode.next;
				numberOfEntries--;
				return currentNode;
			}
			prevNode = currentNode;
			currentNode = currentNode.next;
		}
		return null;
		
	}

	public T retrieveFirstElement()
	{
		if(numberOfEntries != 0)
		{
			Node temp = firstNode;
			firstNode = firstNode.next;
			numberOfEntries--;
			return temp.getData();
		}
		else 
			return null;
	}
	
	public T retrieveLastElement()
	{
		if(numberOfEntries != 0)
		{
			Node currentNode = firstNode;
			Node prevNode = null;
			
			while(currentNode != null)
			{
				if(currentNode.equals(lastNode))
				{
					lastNode = prevNode;
				}
				prevNode = currentNode;
				currentNode = currentNode.next;
			}
			
			numberOfEntries--;
			return prevNode.data;
			
			
//			if(numberOfEntries == 1)
//			{
//				firstNode = null;
//				lastNode = null;
//				numberOfEntries--;
//				return temp.data;
//			}
//			else
//			{
//				lastNode = temp.prev;
//				numberOfEntries--;
//				return temp.data;
//			}
//		}
//		else 
//			return null;
		}
		else 
			return null;
	}
	
	public ArrayList<T> toArrayList()
	{
		ArrayList<T> list = new ArrayList<T>();
		Node currentNode = firstNode;
		
		while(currentNode != null)
		{
			list.add(currentNode.data);
			currentNode = currentNode.next;
		}
		return list;
	}
	
	protected class DoubleLinkedListIterator<T> implements ListIterator<T>{

		protected Node head = firstNode;
		protected Node tail;
		int size;
		
		public DoubleLinkedListIterator(){
			this.head =  firstNode;
			this.tail = null;

		}

		@Override
		public boolean hasNext() {
			return head != null;
		}

		@Override
		public T next() throws NoSuchElementException{
			T result;
			if(hasNext())
			{
				result = (T) head.getData();
				tail = head;
				head = head.next;
				if(head != null)
					head.prev = tail;

			}
			else 
				throw new NoSuchElementException();
				
			return result;
		}

		@Override
		public boolean hasPrevious() {
			
			return tail != null;
		}

		@Override
		public T previous() {
			T result;
			if(tail != null)
			{
				
				head = tail;
				tail = head.prev;
				result = (T) tail.getData();
			}
			else 
				throw new NoSuchElementException();
				
			return result;
		}

		@Override
		public int nextIndex() throws UnsupportedOperationException{
			throw new  UnsupportedOperationException();
		}

		@Override
		public int previousIndex() throws UnsupportedOperationException {
			throw new  UnsupportedOperationException();
		}

		@Override
		public void remove() throws  UnsupportedOperationException{
			throw new  UnsupportedOperationException();
			
		}

		@Override
		public void set(T e) throws  UnsupportedOperationException{
			throw new  UnsupportedOperationException();
			
		}

		@Override
		public void add(T e) throws  UnsupportedOperationException{
			throw new  UnsupportedOperationException();
			
		}

		
	}
	
	
	
	/**
	 * Inner class that creates a linked list 
	 * @author William Batres
	 */
	protected class Node
	{
		protected T data;
		protected Node prev;
		protected Node next;
		
		/**
		 * Constructor that creates a default node that hold the data and has a null pointer
		 * @param dataPortion - data that is passed into the node
		 */
	
		protected Node(T dataPortion)
		{
			this.data = dataPortion;
		}
		
		protected T getData()
		{
			return data;
		}
		
		public void setData(T data) {
			this.data = data;
		}

		public Node getPrev() {
			return prev;
		}

		public void setPrev(Node prev) {
			this.prev = prev;
		}

		public Node getNext() {
			return next;
		}

		public void setNext(Node next) {
			this.next = next;
		}

	
		
	}
}
