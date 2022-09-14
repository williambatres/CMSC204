/**
 * 
 * @author William Batres
 * Exception for a password contains more than 2 of the same character in sequence 
 */
public class InvalidSequenceException extends Exception{

	/**
	 * Constructor that displays the message if the exception is thrown
	 */
	public InvalidSequenceException() 
	{
		super("The password cannot contain more than two of the same"
				+ "character in sequence");
	}
	/**
	 * Single argument constructor
	 * @param message pulls the message that is printed when the exception is thrown
	 */
	public InvalidSequenceException(String message)
	{
		super(message);
	}
}