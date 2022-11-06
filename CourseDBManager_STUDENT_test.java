import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Student made test file for the CourseDBManager
 * which is implemented from the CourseDBManagerInterface
 * @author William Batres
 *
 */

class CourseDBManager_STUDENT_test {

	private CourseDBManager dataManager = new CourseDBManager();
	
	@BeforeEach
	void setUp() throws Exception {
		dataManager = new CourseDBManager();
	}

	@AfterEach
	void tearDown() throws Exception {
		dataManager = null;
	}

	@Test
	void testAdd() {
		try
		{
			dataManager.add("CMSC 204", 32214, 4, "SCW213", "Random Teacher");
			assertEquals(1,dataManager.showAll().size());
			dataManager.add("CMSC 207", 36714, 2, "SCW200", "Random Teacher");
			assertEquals(1,dataManager.showAll().size());
		}
		catch(Exception e)
		{
			fail("This should not have caused an exception");
		}
		
	}

	@Test
	void testGet() {
		dataManager.add("CMSC 204", 32214, 4, "SCW213", "Random Teacher");
		dataManager.add("CMSC 207", 35226, 2, "SCW200", "Random Teacher");
		ArrayList<String> list = dataManager.showAll();
		
		assertEquals(list.get(0), "\n" + dataManager.get(32214).toString());
		assertEquals(list.get(1), "\n" + dataManager.get(35226).toString());
	}

	@Test
	void testShowAll() {
		dataManager.add("CMSC 204", 32214, 4, "SCW213", "Random Teacher");
		dataManager.add("CMSC 207", 35226, 2, "SCW200", "Jim Lanes");
		dataManager.add("CMSC205", 39457, 4, "SCW215", "William Knox");
		ArrayList<String> list = dataManager.showAll();
		
		assertEquals(list.get(0), "\n" + dataManager.get(39457).toString());
		assertEquals(list.get(2), "\n" + dataManager.get(35226).toString());
		assertEquals(list.get(1), "\n" + dataManager.get(32214).toString());
		
		
		
	}
	
	@Test
	void testReadFile() {
		try
		{
			File inputFile = new File("Test2.txt");
			PrintWriter inFile = new PrintWriter(inputFile);
			inFile.println("CMSC205 39457 4 SCW215 William Knox");
			inFile.print("CMSC207 30503 4 SC012 Jimmy Lions");
			
			inFile.close();
			dataManager.readFile(inputFile);
			assertEquals("CMSC205",dataManager.get(39457).getID());
			assertEquals("CMSC207",dataManager.get(30503).getID());
			assertEquals("SCW215",dataManager.get(39457).getRoomNum());
		}
		catch(Exception e)
		{
			fail("Should not have thrown an exception");
		}
	}



}
