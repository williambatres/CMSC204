
public class CourseDBElement implements Comparable{

	private String id, roomNum, instructor;
	private int crn, credits;
	
	/**
	 * No Arg constructor setting all five attributes to 0 or null 
	 */
	public CourseDBElement()
	{
	
		this.id = "";
		this.roomNum = "";
		this.instructor = "";
		this.crn = 0;
		this.credits = 0;
	}
	
	/**
	 * Parameterized constructor setting each attribute to the respective input
	 * @param id - id of course
	 * @param roomNum - the room number of the course
	 * @param instructor - name of the instructor for the course
	 * @param crn - the identifying number associated with the course
	 * @param credits - the number of credits earned for the course
	 */
	public CourseDBElement(String id, int crn , int credits ,String roomNum, String instructor)
	{
	
		this.id = id;
		this.roomNum = roomNum;
		this.instructor = instructor;
		this.crn = crn;
		this.credits = credits;
	}
	
	public void copyInformantion(CourseDBElement element)
	{
		this.id = element.getID();
		this.roomNum = element.getRoomNum();
		this.instructor = element.getInstructor();
		this.crn = element.getCRN();
		this.credits = element.getCredits();
	}

	
	
	/**
	 * Retrieves the id of the course
	 * @return string representing the course ID
	 */
	public String getID() {
		return id;
	}

	/**
	 * sets the id of the course
	 * @param id course ID
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Retrieves the room number for the course
	 * @return room number of the course
	 */
	public String getRoomNum() {
		return roomNum;
	}

	/**
	 * sets the course's room number
	 * @param roomNum
	 */
	public void setRoomNum(String roomNum) {
		this.roomNum = roomNum;
	}

	/**
	 * Retrieves the instructor for the course
	 * @return instructors name
	 */
	public String getInstructor() {
		return instructor;
	}

	/**
	 * sets the instructors name for the course
	 * @param instructor - name of the instructor
	 */
	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}

	/**
	 * Retrieves the crn of the course
	 * @return crn
	 */
	public int getCRN() {
		return crn;
	}

	/**
	 * sets the crn of the course
	 * @param crn - numerical representation of the course
	 */
	public void setCRN(int crn) {
		this.crn = crn;
	}

	/**
	 * Retrieves the credits of the course
	 * @return credits
	 */
	public int getCredits() {
		return credits;
	}

	/**
	 * sets the credits for a course
	 * @param credits - credits for the course
	 */
	public void setCredits(int credits) {
		this.credits = credits;
	}


	
	/**
	 * Returns a string representation of the data in the format---Course:CMSC500 CRN:39999 Credits:4 Instructor:Nobody InParticular Room:SC100
	 */
	@Override
	public String toString()
	{
		return("Course:" + id + " " + "CRN:" + crn + " " + "Credits:" + credits + " " + "Instructor:" + instructor + " " + "Room:" + roomNum);
	}
	
	/**
	 * converting a CRN to a string then off-setting that string and converting the new value into
	 * an int and returning that int as the hashcode
	 * 
	 */
	public int hashCode()
	{
		String stringRep = String.valueOf(getCRN());
		System.out.println(stringRep);
		int hashcode = 0;
		int offset = 11;
		for(int i = 0; i < stringRep.length(); i++)
		{
			hashcode = hashcode * offset + stringRep.charAt(i);
		}
		
		return hashcode;
	}


	@Override
	public int compareTo(Object o) {
		CourseDBElement element = (CourseDBElement) o;
		if(this.crn == element.crn)
			return 0;
		else if(this.crn > element.crn)
			return 1;
		else
			return -1;
	}
	
	public boolean equalTo(CourseDBElement element)
	{
		if(this.crn == element.getCRN() && this.credits == element.credits &&
				this.instructor.equals(element.instructor) && this.id.equals(element.id) &&
				this.roomNum.equals(element.roomNum))
		{
			return true;
		}
		return false;
				
	}
	
}
