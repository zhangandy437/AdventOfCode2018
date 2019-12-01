package dayTwo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;

public class PartOne {

	public static int checksumBoxIDs(File file) throws FileNotFoundException {
		int doubleCounter = 0;
		int tripleCounter = 0;

		Scanner sc = new Scanner(file);
		while (sc.hasNextLine()) {
			String test = sc.next();

			boolean repeatedDouble = false;
			boolean repeatedTriple = false;
			HashSet<Character> characters = new HashSet<Character>();

			for (int i = 0; i < test.length(); i++) {

				int counter = 1;

				for (int j = 1; j < test.length() - i; j++) {
					if (test.charAt(i) == test.charAt(i + j) && !characters.contains(test.charAt(i))) {
						counter++;

					}
				}
				characters.add(test.charAt(i));

				if (counter == 2 && !repeatedDouble) {
					doubleCounter++;
					repeatedDouble = true;
				}
				if (counter == 3 && !repeatedTriple) {
					tripleCounter++;
					repeatedTriple = true;
				}
			}

		}
		sc.close();

		return doubleCounter * tripleCounter;

	}
}
