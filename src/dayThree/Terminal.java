package dayThree;

import java.io.File;
import java.io.FileNotFoundException;

public class Terminal {

	public static void main(String[] args) throws FileNotFoundException {
		System.out.println(PartOne.findOverlap(new File("src/dayThree/IDs.txt")));
		System.out.println(PartTwo.findUnclaimedID(new File("src/dayThree/IDs.txt")));

	}
}
