import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * 
 * @author William Batres
 *
 */
public class MorseCodeConverter {

	private static MorseCodeTree morseCode = new MorseCodeTree();
	
//	public MorseCodeConverter()
//	{
//		morseCode = new MorseCodeTree();
//	}
	
	/**
	 *  returns a string with all the data in the tree in LNR order with an space in between them.
	 *   Uses the toArrayList method in MorseCodeTree It should return the data in this order:
	 *   "h s v i f u e l r a p w j b d x n c k y t z g q m o"
	 *   Note the extra space between j and b - that is because there is an empty string that is the root, 
	 *   and in the LNR traversal, the root would come between the right most child of the left tree (j) and 
	 *   the left most child of the right tree (b). This is used for testing purposes to make sure the MorseCodeTree has been built properly
	 *   
	 * @return the data in the tree in LNR order separated by a space.
	 */
	public static String printTree()
	{
		
		ArrayList<String> morseCodeTree = morseCode.toArrayList();
		String temp = "";
		for(String letter : morseCodeTree)
		{
			temp += letter + " ";
		}
		StringBuilder sb = new StringBuilder(temp);
		sb.deleteCharAt(temp.length() -1 );
		return sb.toString();
	}
	
	/**
	 * 
	 * Converts Morse code into English. Each letter is delimited by a space (‘ ‘). Each word is 
	 * delimited by a ‘/’.Example:code = ".... . .-.. .-.. --- / .-- --- .-. .-.. -.."
	 * string returned = "Hello World"
	 * 
	 * @param code - the morse code
	 * @return the English translation
	 */
	public static String convertToEnglish(String code)
	{
		String finalConvString = "";
		String temp = "";
		code += " ";
		
		int originalLength = code.length();
		
		
		for(int i = 0; i < originalLength; i++)
		{
			if(code.charAt(i) == '/')
			{
				finalConvString += " ";
				i++;
			}
			else
			{
				while(code.charAt(i) != ' ')
				{
					temp += code.charAt(i);
					i++;
				}
				if(temp != "")
				{
					finalConvString += morseCode.fetch(temp);
					temp = "";
				}
				
			}
		}

		return finalConvString;
	}
	
	/**
	 * 
	 * Converts a file of Morse code into English Each letter is delimited by a space (‘ ‘). 
	 * Each word is delimited by a ‘/’. Example: a file that contains ".... . .-.. .-.. --- / .-- --- .-. .-.. -.."
	 * string returned = "Hello World"
	 * 
	 * @param codeFile- name of the File that contains Morse Code
	 * @return the English translation of the file
	 * @throws FileNotFoundException
	 */
	public static String convertToEnglish(File codeFile) throws FileNotFoundException
	{
		String finalConvString = "";
		String temp = "";

		InputStream input = new FileInputStream(codeFile);
		Scanner scan = new Scanner(input);
		String code = scan.nextLine();
		int originalLength = code.length();
		code += " ";
		
		
		
		for(int i = 0; i < originalLength ; i++)
		{
			if(code.charAt(i) == '/')
			{
				finalConvString += " ";
				i++;
			}
			else
			{
				while(code.charAt(i) != ' ')
				{
					temp += code.charAt(i);
					i++;

				}
				
				finalConvString += morseCode.fetch(temp);
				temp = "";
				
			}
		}

		return finalConvString;
		
	}
	
}
