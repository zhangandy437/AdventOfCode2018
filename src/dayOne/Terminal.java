package dayOne;

import java.io.File;

public class Terminal {

	public static void main(String[] args) {
		File file = new File("src/dayOne/FrequencyInput.txt");
		System.out.println(PartOne.main(file));
		System.out.println(PartTwo.firstRepeatedFrequency(file));
	}

}
