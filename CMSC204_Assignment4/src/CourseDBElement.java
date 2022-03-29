/**
 * This is the Data Element class of the database of courses
 * @author Daniel Cortes Gratacos
 *
 */
public class CourseDBElement implements Comparable{
	private String id;
	private int crn, credits;
	private String roomNum, instructor;
	
	/**
	 * No-Arg Constructor, initializes String vars to null and int vars to -1
	 */
	public CourseDBElement() {
		this.id = this.roomNum = this.instructor = "null";
		this.crn = this.credits = -1;
	}
	
	/**
	 * Compares two course database elements and returns an int
	 * Negative int if current CRN is smaller than parameter CRN
	 * Positive int if current CRN is bigger than parameter CRN
	 * 0 if both CRN codes are equal
	 * @param element the element to be compared with
	 * @return an integer representing the comparison
	 */
	@Override
	public int compareTo(CourseDBElement element) {
		return this.compareTo(element);
	}
	
	/**
	 * Parameterized constructor
	 * @param id
	 * @param crn
	 * @param credits
	 * @param roomNum
	 * @param instructor
	 */
	
	public CourseDBElement(String id, int crn, int credits, String roomNum, String instructor) {
		this.id = id;
		this.crn = crn;
		this.credits = credits;
		this.roomNum = roomNum;
		this.instructor = instructor;
	}
	
	/**
	 * Returns the hashCode of the data element
	 * Based on the hashCode of the CRN code as a string
	 * @return the hashCode of the data element
	 */
	public int hashCode() {
		String code = Integer.toString(crn);
		return code.hashCode();
	}
	
	public String getRoomNum() {
		return roomNum;
	}
	
	/**
	 * Sets the CRN code of the class to the given code number
	 * @param input the CRN code that the class should be set to
	 */
	public void setCRN(int input) {
		crn = input;
	}
	
	public String getID() {
		return id;
	}
	
	/**
	 * Returns the CRN code of the class 
	 * @return the unique CRN code
	 */
	public int getCRN() {
		return crn;
	}
	
	/**
	 * Converts the data element to a String object
	 * @return the element as a string
	 */
	public String toString() {
		return "\nCourse:"+id+" CRN:"+crn+" Credits:"+credits+" Instructor:"+instructor+" Room:"+roomNum;
	}

}