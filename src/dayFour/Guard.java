package dayFour;

import java.util.*;

public class Guard {

    private int[] minutes;
    private HashMap<Integer, Day> days;

    private int ID;

    public Guard(){
        minutes = new int[60];
        days = new HashMap<Integer, Day>();
    }

    public Guard(int ID){
        this();
        this.ID = ID;
    }

    public void setID(int ID){
        this.ID = ID;
    }

    public int getID(){
        return ID;
    }

    public void addDay(Day d){
        add(d.getMinutes());
    }

    private void add(boolean[] day) {
        for(int i = 0; i < day.length; i++){
            if(day[i]){
                minutes[i]++;
            }
        }
    }

    public int getBiggest(){
        return Arrays.stream(minutes).max().getAsInt();
    }

    public int getBiggestIndex(){
        int biggest = 0;
        for(int i = 1; i < minutes.length; i++){
            if(minutes[biggest] < minutes[i]) {
                biggest = i;
            }
        }
        return biggest;
    }

    public void finish(){
        for(Day d : days.values()){
            d.finish();
            add(d.getMinutes());
        }
    }

    public String toString(){
        StringBuilder b = new StringBuilder();
        b.append(ID).append(" (");
        for(int i = 0; i < minutes.length - 1; i++){
            b.append(minutes[i]).append(", ");
        }
        b.append(minutes[minutes.length - 1]).append(")");
        return b.toString();
    }

}
