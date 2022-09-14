/**
 * 
 * @author William Batres
 * Exception for a Password that doesn’t contain a special character 
 */
public class NoSpecialCharacterException extends Exception{
	/**
	 * Constructor that displays the message if the exception is thrown
	 */
	public NoSpecialCharacterException()
	{
		super("The password must contain at least one special character");
	}
	/**
	 * Single argument constructor
	 * @param message pulls the message that is printed when the exception is thrown
	 */
	public NoSpecialCharacterException(String message)
	{
		super(message);
	}
}
