import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/** Converter Utility class to convert morse code into readable text
 * 
 * @author Daniel Cortes Gratacos
 *
 */
public class MorseCodeConverter {
	
	
	/** Prints the tree, for debugging purposes
	 * 
	 * @return A string with the tree's data in-order.
	 */
	public static String printTree() {
		StringBuilder toReturn = new StringBuilder();
		for (String item : morseCodeTree.toArrayList())
			toReturn.append(item).append(" ");
		
		return toReturn.toString();
	}
	
static MorseCodeTree morseCodeTree = new MorseCodeTree();
	
	/** Gets a file, reads it, and gives you the english text from what was in the file
	 * 
	 * @param codeFile The file to read
	 * @return The english text of the morse code
	 * @throws FileNotFoundException If the file does not exist
	 */
	public static String convertToEnglish(File codeFile) throws FileNotFoundException {
		while (!codeFile.exists())
			throw new FileNotFoundException("An unwanted exception was caught");
		
		Scanner fileReader = new Scanner(codeFile);
		StringBuilder fileRead = new StringBuilder();
		
		while(fileReader.hasNextLine()) {
			fileRead.append(fileReader.nextLine()).append(" ");
		}
		
		fileReader.close();
		
		return convertToEnglish(fileRead.toString());
	}
	
	/** Converts from morse code to english text
	 * 
	 * @param code The code to be decoded, or turned into english
	 * @return The english text from the code
	 */
	public static String convertToEnglish(String code) {
		StringBuilder english = new StringBuilder();
		String[] codeArr = code.split(" ");
		
		for (String englishCode : codeArr) {
			if (englishCode.equals("/")) {
				english.append(" ");
				continue;
			}
			
			english.append(morseCodeTree.fetch(englishCode));
		}
		
		return english.toString();
	}
	
}