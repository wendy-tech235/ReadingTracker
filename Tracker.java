<<<<<<< HEAD
public class Tracker {
=======
public class Tracker{
>>>>>>> parent of 5b925b8 (main functions and others)
    private int trackerID;
    private int numberOfPoints;
    private int earnPoints;
    private int currDay;
    private int currPages;
    private Schedule schedule;

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

    public int getNumberOfPoints() {
        return numberOfPoints;
    }

    public int getEarnPoints() {
        return earnPoints;
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

    public void setNumberOfPoints(int numberOfPoints) {
        this.numberOfPoints = numberOfPoints;
    }

    public void setEarnPoints(int earnPoints) {
        this.earnPoints = earnPoints;
    }

    public void setCurrDay(int currDay) {
        this.currDay = currDay;
    }

    public void setCurrPages(int currPages) {
        this.currPages = currPages;
    }

<<<<<<< HEAD
    public void calander(){
        int remainDays = schedule.getTotalDays() % 5;
        for(int row = 1; row <= schedule.getTotalDays()/ 5; row++){
            for(int col = 1; col <= 5; col++){
                
            }
        }
    }
}
=======
    public void setPagePerDay(int pagePerDay) {
        this.pagePerDay = pagePerDay;
    }

    public void setBook(Book book) {
        this.book = book;
    }


    




}
>>>>>>> parent of 5b925b8 (main functions and others)
