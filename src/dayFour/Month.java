package dayFour;

public class Month {

    Day[] days;

    public Day[] getDays() {
        return days;
    }

    public Month() {
        days = new Day[32];
        for (int i = 0; i < days.length; i++) {
            days[i] = new Day();
        }
    }

    public void setGuardID(int day, int ID) {
        days[day].setID(ID);
    }

    public void sleep(int day, int min) {
        days[day].fellAsleep(min);
    }

    public void wake(int day, int min) {
        days[day].woke(min);
    }

    public void finishDays() {
        for (Day day : days) {
            if (day != null) {
                day.finish();
            }
        }
    }
}