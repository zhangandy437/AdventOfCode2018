package dayThree;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PartTwo {
	static int[][] fabric = new int[1000][1000];
	
	public static int findUnclaimedID(File file) throws FileNotFoundException {
		Scanner sc = new Scanner(file);
		
		List<List<Integer>> intArray = new ArrayList<List<Integer>>();
		
		while(sc.hasNextLine()) {
			List<Integer> ints = stringToArray(sc.nextLine());
			intArray.add(ints);
			for(int i = ints.get(1); i < ints.get(1) + ints.get(3); i++) {
				for(int j = ints.get(2); j < ints.get(2) + ints.get(4); j++) {
					fabric[i][j]++;
				}
			}
		}
		sc.close();
		
		for(int i = 0; i < intArray.size(); i++) {
			if(testSquare(intArray.get(i))) {
				return i+1;
			}
		}
		return 0;
	}
	
	private static List<Integer> stringToArray(String input) {
		List<Integer> ints = new ArrayList<Integer>();
		Scanner sc = new Scanner(input);
		String myString = sc.next();
		
		StringBuilder build = new StringBuilder();
		for(int i = 1; i < myString.length(); i++) {
			build.append(myString.charAt(i));
		}
		
		ints.add(Integer.parseInt(build.toString()));
		sc.next();
		
		myString = sc.next();
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
	
	private static boolean testSquare(List<Integer> ints) {
		for(int i = ints.get(1); i < ints.get(1) + ints.get(3); i++) {
			for(int j = ints.get(2); j < ints.get(2) + ints.get(4); j++) {
				if(fabric[i][j] > 1) {
					return false;
				}
			}
		}
		
		return true;
	}

}
