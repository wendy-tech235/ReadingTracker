
public class Tracker {
    private int trackerID;
    private int currDay;
    private int currPages;
    private Schedule schedule;
    
    public Tracker() {
        trackerID = 0;
        currDay = 0;
        currPages = 0;
        schedule = new Schedule();
    }

    public Tracker(Schedule schedule, int currDay, int currPages, int trackerID) {
        this.schedule = schedule;
        this.currDay = currDay;
        this.currPages = currPages;
        this.trackerID = trackerID;
    }

    public int getTrackerID() {
        return trackerID;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }


    public int getCurrDay() {
        return currDay;
    }

    public int getCurrPages() {
        return currPages;
    }

    public void setTrackerID(int trackerID) {
        this.trackerID = trackerID;
    }


    public void setCurrDay(int currDay) {
        this.currDay = currDay;
    }

    public void setCurrPages(int currPages) {
        this.currPages = currPages;
    }
}
