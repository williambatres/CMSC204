/**
 * The class Road that can represent the edges of a Graph of Towns. The 
 * class must implement Comparable. The class stores references to the two 
 * vertices(Town endpoints), the distance between vertices, and a name, and the traditional 
 * methods (constructors, getters/setters, toString, etc.), and a compareTo, which 
 * compares two Road objects. Since this is a undirected graph, an edge from A to B is
 * equal to an edge from B to A.
 * @author William Batres
 *
 */
public class Road implements Comparable<Road> {

	private int distance; // represents the weight of the edge
	private String name;
	private Town sourceTown, destinationTown;
	
	/**
	 * Parameterized Constructor
	 * @param source - originating town
	 * @param destination - destination town
	 * @param degrees - distance between towns
	 * @param name - name of the road
	 */
	public Road(Town source, Town destination, int degrees, String name)
	{
		this.sourceTown = source;
		this.destinationTown = destination;
		this.distance = degrees;
		this.name = name;
	}
	/**
	 * Constructor with distance between towns or weight as 1
	 * @param source - originating town
	 * @param destination - destination town
	 * @param name - name of the road 
	 */
	public Road(Town source, Town destination, String name)
	{
		this.sourceTown = source;
		this.destinationTown = destination;
		this.name = name;
		this.distance = 1;
	}
	
	public Road(Road road)
	{
		this.sourceTown = road.getDestinationTown();
		this.destinationTown = road.getSourceTown();
		this.distance = road.getDistance();
		this.name = road.getName();
	}
	/**
	 * Returns the distance of the road
	 * @return distance of the town or weight of edge
	 */
	public int getDistance() {
		return distance;
	}

	/**
	 * sets the distance of the town
	 * @param distance - distance between towns or weight of edge
	 */
	public void setDistance(int distance) {
		this.distance = distance;
	}

	/**
	 * Retrive's the name of the road
	 * @return - road's name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name of the road
	 * @param roadName - name of the road
	 */
	public void setName(String roadName) {
		this.name = roadName;
	}

	/**
	 * Retrive's the originating town of the road
	 * @return originating town 
	 */
	public Town getSourceTown() {
		return sourceTown;
	}

	/**
	 * Sets the originating town of the road
	 * @param sourceTown
	 */
	public void setSourceTown(Town sourceTown) {
		this.sourceTown = sourceTown;
	}

	/**
	 * Retive's the destination town of the road
	 * @return - destination town of the road
	 */
	public Town getDestinationTown() {
		return destinationTown;
	}

	/**
	 * Sets the destination town of the road
	 * @param destinationTown - town object being set as the destination town
	 */
	public void setDestinationTown(Town destinationTown) {
		this.destinationTown = destinationTown;
	}

	/**
	 * Returns a string in the format as sourceTown via road name to destination town 
	 * distance ml;
	 */
	public String toString()
	{
		return this.sourceTown.getName() + " via " + this.name + " to " +
				this.destinationTown + " " + this.distance + " ml";
	}
	
	/**
	 * Compares tow roads and returns 0 if the road names are the same, a positive or 
	 * negative number if the road names are not the same
	 */
	@Override
	public int compareTo(Road road) {
		
		return this.name.compareTo(road.getName());
	}
	
	/**
	 * Returns true if each of the ends of the road r is the same as the ends of this road. 
	 * Remember that a road that goes from point A to point B is the same as a road that 
	 * goes from point B to point A.
	 * @param road - road object to compare to 
	 * @return - returns true if each end of the roads are the same, false otherwise 
	 */
	public boolean equals(Road road)
	{
		return (this.sourceTown.equals(road.sourceTown) && this.destinationTown.equals(road.destinationTown) ||
				this.destinationTown.equals(road.destinationTown) && this.sourceTown.equals(road.sourceTown));
		
	}
	
	/**
	 * Returns true only if one of the two towns connected via road are the same
	 * @param town - a vertex of the graph
	 * @return - true if the edge contains the given town 
	 */
	public boolean contains(Town town)
	{
		return (this.sourceTown.equals(town) || this.destinationTown.equals(town));
	}
	
}
