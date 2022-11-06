import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CourseDBStructure implements CourseDBStructureInterface{

	LinkedList<CourseDBElement>[] Hashtable;
	
	public CourseDBStructure(int n)
	{
		int numberOfElements = n;
		numberOfElements = calcHashIndexForSize(numberOfElements);
		Hashtable = new LinkedList[numberOfElements];
	}
	
	public CourseDBStructure(String x, int n)
	{
		int numberOfElements = n;
		calcHashIndexForSize(numberOfElements);
		Hashtable = new LinkedList[numberOfElements];
	}
	
	public static int calcHashIndexForSize(int n)
	{

		int[] primeNumbers = new int[n];
		int numberOfElements = (int) (n/1.5);
		for(int i = 1; i < n; i++)
		{
			primeNumbers[i] = (4 * i) + 3;
		}
		
		for(int i = 1; i < primeNumbers.length ; i++)
		{
			if(primeNumbers[i] > numberOfElements && isPrime(primeNumbers[i]) == true)
			{
				numberOfElements = primeNumbers[i];
				break;
			}
		}
		
		return numberOfElements;
		
	}
	
	public static boolean isPrime(int x)
	{
		if(x <= 1)
		{
			return false;
		}
		for(int i = 2; i <= x/2; i++ )
		{
			if((x % i)==0)
				return false;
		}
		return true;
	}
	/** 
	* Adds a CourseDBElement object to the CourseDBStructure using the hashcode
	* of the CourseDatabaseElemen object's crn value.
	* If the CourseDatabaseElement already exists, exit quietly
	*  
	* @param element the CourseDBElement to be added to CourseDBStructure
	*/
	public void add(CourseDBElement element) {
		int index = calcRefinedHashcode(element);
		
		if(Hashtable[index] == null)
		{
			Hashtable[index] = new LinkedList<CourseDBElement>();
			Hashtable[index].add(element);
		}
		else if(Hashtable[index] != null && Hashtable[index].size() >0)
		{

			LinkedList<CourseDBElement> linkedListWithinHashtable = Hashtable[index];
				for(CourseDBElement x : linkedListWithinHashtable)
				{
					if(x.getCRN() == element.getCRN())
					{
						x.copyInformantion(element);
					}
				}

		}
		else
		{
			Hashtable[index].add(element);
		}
		
	}

	public int calcRefinedHashcode(CourseDBElement element)
	{
		int refinedHashcode = element.hashCode() % Hashtable.length;
		return refinedHashcode;
	}
	/**
	 * Find a courseDatabaseElement based on the key (crn) of the
	 * courseDatabaseElement If the CourseDatabaseElement is found return it If not,
	 * throw an IOException
	 * 
	 * @param crn crn (key) whose associated courseDatabaseElement is to be returned
	 * @return a CourseDBElement whose crn is mapped to the key
	 * @throws IOException if key is not found
	 */
	@Override
	public CourseDBElement get(int crn) throws IOException {
		
		LinkedList<CourseDBElement> tempLinkedList;
		CourseDBElement temp = new CourseDBElement();
		temp.setCRN(crn);
		int index = calcRefinedHashcode(temp);
		if(Hashtable[index] != null)
		{
			 tempLinkedList = Hashtable[index];
		}
		else 
			throw new IOException();
		
		List<CourseDBElement> tempLinkedListToArray = new ArrayList<CourseDBElement>(tempLinkedList);
		

		for(CourseDBElement x : tempLinkedListToArray)
		{
			if(temp.getCRN() == x.getCRN())
				return x;
		}
		throw new IOException();
	}

	/**
	 * @return an array list of string representation of each course in 
	 * the data structure separated by a new line. 
	 * Refer to the following example:
	 * Course:CMSC500 CRN:39999 Credits:4 Instructor:Nobody InParticular Room:SC100
	 * Course:CMSC600 CRN:4000 Credits:4 Instructor:Somebody Room:SC200
	 */
	@Override
	public ArrayList<String> showAll() {
		
		ArrayList<String> stringArrays = new ArrayList<String>();
		for(int i = 0; i < getTableSize(); i++)
		{
			if(Hashtable[i] != null)
			{
				LinkedList<CourseDBElement> linkedListWithinHashtable = Hashtable[i];
				for(CourseDBElement x : linkedListWithinHashtable)
				{
					String CourseDBElement_info = x.toString() + "\n";
					stringArrays.add(CourseDBElement_info);
				}
				
			}
		}
		
		return stringArrays;
		
		
	}

	/**
	* Returns the size of the ConcordanceDataStructure (number of indexes in the array)
	*/
	@Override
	public int getTableSize() {

		return Hashtable.length;
	}
}
