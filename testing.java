import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

public class testing {

	static int crn = 23435254;
	static int crn2 = 23455254;
	static int crn4 = 23455277;
	
	public static void main(String[] args) throws FileNotFoundException {
		
		String testing = "CMSC100 21556 2 Distance-Learning Janet E. Joy ";
		
		File file = new File("courses.txt");
		Scanner scan = new Scanner(file);
		
		String[] inputArray = new String[10];
		String[] outputArray = new String[10];
//		String[] finalArray = new String[10];
		String course = " ";
		String instructor = " ";
		String print = "";
		int i = 0;
		
		
		
		while(scan.hasNext())
		{
			print = "";
			print = scan.nextLine();
			System.out.println(print);

			outputArray = print.split(" ");
			System.out.println(outputArray.length);
			int t = 0;
			String[] finalArray = new String[outputArray.length];
			for(String x : outputArray)
				{
				
					if(x != null)
					{
						finalArray[t] = x;
						t++;
						System.out.println(x);
					}
				}
			System.out.println(t);
			
			if(t > 7)
			{
				instructor = finalArray[5] + " " + finalArray[6] + " "+ finalArray[7];
				course = finalArray[3] + " " + finalArray[4];
				System.out.println(finalArray[0] + " " + finalArray[1] + " "  +
						finalArray[2]  + " "  + course  + " " + instructor );
			}
			else if(t > 6)
			{
				System.out.println(finalArray[0] + " " + finalArray[1] + " "  +
						finalArray[2] + " |  "+ finalArray[3] + " " + finalArray[4] + " " +
						finalArray[5] + " " + finalArray[6] );
			} 
			else
			{
			System.out.println(finalArray[0] + " " + finalArray[1] + " "  +
					finalArray[2] + " "+ finalArray[3] + " | " + finalArray[4] + " " +
					finalArray[5]);
			}

			instructor = " ";
//			outputArray = null;
			t =0;
			System.out.println("");
		}
		
		System.out.println(" ");
		String array[] = print.split(" ");
		
		for(String x : inputArray)
		{
			if(x != null)
			System.out.println(x);
		}
		
		String y= " ";
		
//		for(String x : inputArray)
//		{
//			if(x != null)
//			{
//			y = x.split(" ");
//			System.out.println(y);
//			
//			y = " ";
//			}
//		}
		
		
		
	

//		int n = 530;
//		int[] prime = new int[n];
//			int numberOfElements = (int) (n/1.5);
////			numberOfElements = calcHashIndexForSize(numberOfElements);
////			System.out.println(numberOfElements);
//			
//			for(int i = 1; i < n; i++)
//			{
//				prime[i] = (4 * i) + 3;
//			}
//			
//			System.out.println(toString(prime));
//
//			for(int i = 1; i < prime.length ; i++)
//			{
//				if(prime[i] > numberOfElements && isPrime(prime[i]) == true)
//				{
//					numberOfElements = prime[i];
//					break;
//				}
//			}
//			
//
//			System.out.println(numberOfElements);
//			System.out.println(crn);
//			System.out.println(hashCode(crn));
//			System.out.println(getHashIndex(crn));
//			System.out.println(getHashIndex(crn2));
//			System.out.println(getHashIndex(crn4));
	}
	
	
	
//	public static int hashCode(int n)
//	{
//		String stringRep = String.valueOf(n);
//		System.out.println(stringRep);
//		int hashcode = 0;
//		int offset = 11;
//		for(int i = 1; i < stringRep.length(); i++)
//		{
//			hashcode = hashcode * offset + stringRep.charAt(i);
//		}
//		
//		return hashcode;
//	}
//	
//	public static boolean isPrime(int x)
//	{
//		if(x <= 1)
//		{
//			return false;
//		}
//		for(int i = 2; i <= x/2; i++ )
//		{
//			if((x%i)==0)
//				return false;
//		}
//		return true;
//	}
//	
//	public static String toString(int[] x)
//	{
//		String y = "";
//		for(int i = 1; i < x.length ; i++)
//		{
//			y += x[i] + " ";
//		}
//		return y;
//	}
//
//	  private static int getHashIndex(int x) {
//		    int hashIndex = hashCode(x) % 23435254;
//		    if (hashIndex < 0) {
//		      hashIndex += 347;
//		    }
//		    return hashIndex;
//		  }
}
