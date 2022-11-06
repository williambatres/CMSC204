import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class CourseDBManager implements CourseDBManagerInterface{

	private CourseDBStructure hashtableStructure;
	
	public CourseDBManager()
	{
		hashtableStructure = new CourseDBStructure(11);
	}
	
	
	@Override
	public void add(String id, int crn, int credits, String roomNum, String instructor) {
		CourseDBElement element = new CourseDBElement(id, crn, credits, roomNum, instructor);
		hashtableStructure.add(element);
		
	}

	@Override
	public CourseDBElement get(int crn) {
		try {
			return hashtableStructure.get(crn);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void readFile(File input) throws FileNotFoundException {
//		File file = new File("courses.txt");
		Scanner scan = new Scanner(input);
		

		String[] outputArray = new String[10];

		String instructor = " ";
		String course = " ";
		String print = "";
		int t = 0;
		
		while(scan.hasNext())
		{
			print = "";
			print = scan.nextLine();

			outputArray = print.split(" ");
			String[] finalArray = new String[outputArray.length];

			for(String x : outputArray)
				{
					if(x != null)
					{
						finalArray[t] = x;
						t++;
					}
				}
			
			if(t > 7)
			{
				instructor = finalArray[5] + " " + finalArray[6] + " "+ finalArray[7];
				course = finalArray[3] + " " + finalArray[4];
				hashtableStructure.add(new CourseDBElement(finalArray[0],Integer.valueOf(finalArray[1]),
						Integer.valueOf(finalArray[2]), course, instructor ));
			}
			else if(t > 6)
			{
				instructor = finalArray[4] + " " + finalArray[5] + " "+ finalArray[6];
				hashtableStructure.add(new CourseDBElement(finalArray[0],Integer.valueOf(finalArray[1]),
						Integer.valueOf(finalArray[2]), finalArray[3],instructor));
			}
			else 
			{
				instructor = finalArray[4] + " " + finalArray[5];
				hashtableStructure.add(new CourseDBElement(finalArray[0],Integer.valueOf(finalArray[1]),
						Integer.valueOf(finalArray[2]), finalArray[3],instructor));
			}
			
			
			instructor = " ";
			
			outputArray = null;
			t = 0;
		}
		scan.close();
		
	}

	@Override
	public ArrayList<String> showAll() {
		ArrayList<String> stringArrays = new ArrayList<String>();
		for(int i = 0; i < hashtableStructure.getTableSize(); i++)
		{
			if(hashtableStructure.Hashtable[i] != null)
			{
				LinkedList<CourseDBElement> linkedListWithinHashtable = hashtableStructure.Hashtable[i];
				for(CourseDBElement x : linkedListWithinHashtable)
				{
					String CourseDBElement_info = "\n" + x.toString() ;
					stringArrays.add(CourseDBElement_info);
				}
				
			}
		}
		
		return stringArrays;
	}

}
