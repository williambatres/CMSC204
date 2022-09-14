/**
 * 
 * @author william Batres
 * Length of password is less than 6 characters
 */
public class LengthException extends Exception{

	/**
	 * Constructor that displays the message if the exception is thrown
	 */
	public LengthException()
	{
		super("The password must be at least 6 characters long");
	}
	/**
	 * Single argument constructor
	 * @param message pulls the message that is printed when the exception is thrown
	 */
	public LengthException(String message)
	{
		super(message);
	}
}
