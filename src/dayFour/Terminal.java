package dayFour;

import java.io.File;
import java.io.FileNotFoundException;

public class Terminal {

	public static void main(String[] args) throws FileNotFoundException {

		System.out.println(PartOne.findSleepyBoi(new File("src/dayFour/GuardSchedule.txt")));

	}

}