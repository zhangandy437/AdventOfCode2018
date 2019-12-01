package dayFour;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class PartOne {
    public static String findSleepyBoi(File file) throws FileNotFoundException {

        Month[] year = new Month[12];
        for (int i = 0; i < year.length; i++) {
            year[i] = new Month();
        }

        Scanner sc = new Scanner(file);
        // ID, Guard

        int count = 0;
        while (sc.hasNextLine()) {
            String curr = sc.next() + " " + sc.next();
            int[] time = getDate(curr);
            curr = sc.next();

            count++;
            if (curr.equals("Guard")) {
                int id = Integer.parseInt(sc.next().substring(1));
                year[time[2]].setGuardID(time[3], id);
            } else if (curr.equals("falls")) {
                year[time[2]].sleep(time[3], time[5]);
            } else if (curr.equals("wakes")) {
                year[time[2]].wake(time[3], time[5]);
            }
            sc.nextLine();
        }
        sc.close();

        HashMap<Integer, Guard> guards = new HashMap<Integer, Guard>();
        int mostRecent = -1;
        for (Month m : year) {
            if (m != null) {
                m.finishDays();
                for (Day d : m.getDays()) {
                    int curr = d.getID();
                    if(curr == -1){
                        curr = mostRecent;
                    } else {
                        mostRecent = curr;
                    }
                    if (guards.containsKey(curr)) {
                        guards.get(curr).addDay(d);
                    } else {
                        Guard g = new Guard(curr);
                        g.addDay(d);
                        guards.put(curr, g);
                    }
                }
            }
        }
        guards.values().forEach(System.out::println);
        Guard g = guards.values().stream().max(Comparator.comparingInt(Guard::getBiggest)).get();


        return "Ya boi is " + g.getID() + " * " + g.getBiggestIndex() + " = " + (g.getID() * g.getBiggestIndex());
    }

    private static int[] getDate(String date) {
        date.replaceAll("[^0-9]", " ");
        String[] splittedDate = date.split("\\s|\\[|\\]|-|:");
        int[] time = new int[6];

        for (int i = 2; i < splittedDate.length; i++) {
            time[i] = Integer.parseInt(splittedDate[i]);
//			System.out.print(time[i]);
        }
//		System.out.println();
        return time;
    }
}
