import java.util.ArrayList;
import java.util.List;

/**
 * Represents an town as a node of a graph. The Town class holds the name of the town 
 * and a list of adjacent towns, and other fields as desired, and the traditional 
 * methods (constructors, getters/setters, toString, etc.). It will implement the Comparable
 *  interface These are the minimum methods that are needed.
 * @author William Batres
 *
 */
public class Town implements Comparable<Town>{

	private String name;
	private ArrayList<Town> adjacentTowns;
	
	
	/**
	 * Parameterized Constructor that takes the name for a town
	 * @param name - Towns names
	 */
	public Town(String name)
	{
		this.name = name;
	}
	
	/**
	 * Copy constructor that takes the name of another town
	 * @param templateTown - copy town name
	 */
	public Town(Town templateTown)
	{
		this.name = templateTown.name;
	}
	
	/**
	 * Returns the towns name
	 * @return - town's name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name of the town
	 * @param name - Town's name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * To String method returning the name of the town as a string
	 */
	@Override
	public String toString() {
		return "Town: " + name;
	}


	/**
	 * Compares two town objects by comparing the names 
	 * 0 if names are equal, a positive or negative number if the names are not equal
	 */
	@Override
	public int compareTo(Town town) {
		
		return this.name.compareTo(town.getName());
	}

	/**
	 * Compares two towns using their names
	 * @param town - town being compared
	 * @return - true if the town names are equal, false if not
	 */
	public boolean equals(Town town){
		
		if(this.name.equals(town.getName()))
			return true;
		else 
			return false;
	}
	
	public int hashCode(){
		
		return this.name.hashCode();
	}
}
