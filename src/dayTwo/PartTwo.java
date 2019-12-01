package dayTwo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PartTwo {

	public static String compareBoxes(File file) throws FileNotFoundException {
		List<String> boxes = boxToArray(file);
		
		for(int i = 0; i < boxes.size(); i++) {
			for(int j = 1; j < boxes.size() - i; j++){
				
				if(foundBoxes(boxes.get(i), boxes.get(i + j))) {
					return compareStrings(boxes.get(i), boxes.get(i + j));
				}
			}
		}
		return "not found";
	}
	
	private static List<String> boxToArray(File file) throws FileNotFoundException {
		Scanner sc = new Scanner(file);
		List<String> boxes = new ArrayList<String>();
		
		while(sc.hasNextLine()) {
			boxes.add(sc.next());
		}
		sc.close();
		
		return boxes;
	}
	
	private static String compareStrings(String first, String second) {
		String similarCharacters = new String();
		
		for(int i = 0; i < first.length(); i++) {
			if(first.charAt(i) == second.charAt(i)) {
				similarCharacters = similarCharacters + first.charAt(i);
			}
		}
		return similarCharacters;
	}
	
	private static boolean foundBoxes(String first, String second) {
		int differences = 0;
		
		for(int i = 0; i < first.length(); i++) {
			if(first.charAt(i) != second.charAt(i)) {
				differences++;
			}
			if(differences > 1) {
				return false;
			}
		}
		return true;
	}

}
