package dayThree;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PartOne {

	public static int findOverlap(File file) throws FileNotFoundException {
		int overlaps = 0;
		int[][] fabric = new int[1001][10011];
		
		Scanner sc = new Scanner(file);
		
		while (sc.hasNextLine()) {
			List<Integer> ints = stringToArray(sc.nextLine());
			
			for(int i = ints.get(0); i < ints.get(0) + ints.get(2); i++) {
				for(int j = ints.get(1); j < ints.get(1) + ints.get(3); j++) {
					fabric[i][j]++;
				}
			}
		}
		sc.close();
		
		for(int i = 0; i< 999; i++) {
			for(int j = 0; j < 999; j++) {
				if(fabric[i][j] > 1) {
					overlaps++;
				}
			}
		}
		
		return overlaps;
	}

	private static List<Integer> stringToArray(String input) {
		List<Integer> ints = new ArrayList<Integer>();
		Scanner sc = new Scanner(input);
		
		sc.next();
		sc.next();
		String myString = sc.next();
		addNumbersToArray(myString, ints);
		
		myString = sc.next();
		addNumbersToArray(myString+ ":", ints);
		sc.close();
		
		return ints;
	}
	
	private static void addNumbersToArray(String nextString, List<Integer> ints) {
		StringBuilder build = new StringBuilder();
		boolean second = false;
		for(int i = 0; i < nextString.length(); i++) {
			if(!Character.isDigit(nextString.charAt(i))) {
				second = true;
			}
			if(!second && Character.isDigit(nextString.charAt(i))) {
				build.append(nextString.charAt(i));
			}else if(!build.toString().isEmpty()){
				ints.add(Integer.parseInt(build.toString()));
				build.delete(0, build.length());
				second = false;
			}
		}
		
		
		
	}
}
