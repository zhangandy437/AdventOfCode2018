package dayOne;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class PartTwo {
	private static HashSet<Integer> numbers = new HashSet<Integer>();
	private static List<Integer> operators = new ArrayList<Integer>();

	public static int firstRepeatedFrequency(File file) {
		operators = txtToArray(file);
		return iterate(0);
	}

	private static int iterate(int total) {
		for (int i = 0; i < operators.size(); i++) {
			total += operators.get(i);
			if (numbers.contains(total)) {
				return total;
			} else {
				numbers.add(total);
			}
		}
		return iterate(total);
	}

	private static List<Integer> txtToArray(File file) {
		List<Integer> list = new ArrayList<Integer>();
		try {
			Scanner sc = new Scanner(file);
			while (sc.hasNextLine()) {
				list.add(sc.nextInt());

			}
			sc.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return list;
	}

}