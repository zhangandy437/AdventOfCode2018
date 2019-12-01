package dayFour;

import java.util.Objects;

public class Day {
	
	private boolean[] minutes;

	private int ID;

	private int month;
	private int day;

	public Day(){
		this.ID = -1;
		minutes = new boolean[60];
	}

	public boolean hasID(){
		return ID > -1;
	}

	public boolean[] getMinutes() {
		return minutes;
	}

	public int getID() {
		return ID;
	}

	public void setID(int ID) {
		this.ID = ID;
	}

	public void fellAsleep(int min){
		minutes[min] = true;
	}

	public void woke(int min){
		minutes[min - 1] = true;
	}

	public void finish(){

		boolean asleep = false;
		for(int i = 0; i < minutes.length; i++){
			if(asleep){
				if(minutes[i]){
					asleep = false;
				} else{
					minutes[i] = true;
				}
			} else {
				if(minutes[i]){
					asleep = true;
				}
			}
		}
	}

	public String toString(){
		StringBuilder b = new StringBuilder();
		b.append(ID + ":  \t");
		for(boolean a : minutes){
			if(a){
				b.append("#");
			} else  {
				b.append(".");
			}
		}
		return b.toString();
	}
}


