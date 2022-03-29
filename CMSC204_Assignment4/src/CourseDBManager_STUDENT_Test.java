import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
/**
 * This is the student tests for the CourseDBManager class
 * @author Daniel Cortes Gratacos
 *
 */
class CourseDBManager_STUDENT_Test {
	private CourseDBManagerInterface database = new CourseDBManager();
	
	/**
	 * Sets up a CourseDBManager
	 * @throws Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		database = new CourseDBManager();
	}

	/**
	 * Tears down the CourseDBManager after end of test
	 * @throws Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
		database = null;
	}

	/**
	 * Tests if class is able to add a course to the database according to the parameters
	 */
	@Test
	void testAdd() {
		try {
			database.add("CMSC420",30985,4,"SC445","Monica Lewinski");
			database.add("CMSC204",30635,4,"SC245","Peter File");
		}
		catch(Exception e) {
			fail("This should not have caused an Exception");
		}
	}

	/**
	 * Tests if class is able to accurately retrieve the correct course based on the CRN
	 */
	@Test
	void testGet() {
		try {
			database.add("CMSC420",30504,4,"SC450","Monica Lewinski");
			CourseDBElement testElement = new CourseDBElement("CMSC203", 30504, 4, "SC450", "Monica Lewinski");
			assertEquals(testElement.getCRN(), database.get(30504).getCRN());
		}
		catch(Exception e) {
			fail("This should not have caused an Exception");
		}
	}

	/**
	 * Tests if class is able to read a text file of courses and add them to a database
	 */
	@Test
	void testReadFile() {
		try {
			File inputFile = new File("test.txt");
			PrintWriter inFile = new PrintWriter(inputFile);
			inFile.println("CMSC240 30504 4 SC350 Monica Lewinski");
			inFile.print("CMSC207 30503 4 SC400 Peter File");
			
			inFile.close();
			database.readFile(inputFile);
		} catch (Exception e) {
			fail("Should not have thrown an exception");
		}
	}

	/**
	 * Tests if class can return an ArrayList of strings of all the courses in the database
	 */
	@Test
	void testShowAll() {
		database.add("CMSC420",30504,4,"SC245","Monica Lewinski");
		database.add("CMSC203",30503,4,"SC450","Nobody Knows");
		database.add("CMSC207",30559,4,"SC350","Peter File");
		ArrayList<String> list = database.showAll();
		
		assertEquals(list.get(0),"\nCourse:CMSC203 CRN:30503 Credits:4 Instructor:Nobody Knows Room:SC450");
		assertEquals(list.get(1),"\nCourse:CMSC420 CRN:30504 Credits:4 Instructor:Monica Lewinski Room:SC245");
		assertEquals(list.get(2),"\nCourse:CMSC207 CRN:30559 Credits:4 Instructor:Peter File Room:SC350");
	}

}