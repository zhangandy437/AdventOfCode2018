package dayOne;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PartOne {

	public static int main(File file) {
		int total = 0;

		try {
			Scanner sc = new Scanner(file);
			while (sc.hasNextLine()) {
				int place = sc.nextInt();
				total += place;

			}
			sc.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return total;
	}

}
