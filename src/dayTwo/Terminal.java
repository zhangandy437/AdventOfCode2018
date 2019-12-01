package dayTwo;

import java.io.File;
import java.io.FileNotFoundException;

public class Terminal {

	public static void main(String[] args) throws FileNotFoundException {
		System.out.println(PartOne.checksumBoxIDs(new File("src/dayTwo/BoxIDs.txt")));
		System.out.println(PartTwo.compareBoxes(new File("src/dayTwo/BoxIDs.txt")));
	}

}
