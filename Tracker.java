import java.util.*;
public class Tracker {
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

        // calculate earnPoints, numberOfPoints
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

    public void calander(){
        int remainDays = schedule.getTotalDays() % 5;
        for(int row = 1; row <= schedule.getTotalDays()/ 5; row++){
            for(int col = 1; col <= 5; col++){
                
            }
        }
    }


    /*
    public int pointsAdded(){
        int diff = getCurrPages() - getPagePerDay();
        int ret = 0;
        if (diff > 0){
            ret += diff / 3;
        }else if(diff == 0){
            ret++;
        }else{
            ret--;
        }
        return ret;
    }

    public void dailySummary(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Do you want to change your goal? (type yes or no)");
        String temp = scanner.nextLine();
        if(temp.equals("yes")){
            System.out.println("Enter new goal: ");
            setPagePerDay(Integer.parseInt(scanner.nextLine()));
        }

        System.out.println("Enter how many pages you read for " + book.getBookName() + " (your goal is " + pagePerDay + ")");
        setCurrPages(Integer.parseInt(scanner.nextLine())); 
        setEarnPoints(pointsAdded());
        setNumberOfPoints(getNumberOfPoints() + pointsAdded());
        System.out.println(book.getBookName()+ ":");
        System.out.println("Earn points: " + getEarnPoints());
        System.out.println("Total points: " + getNumberOfPoints());
        System.out.println("Total pages read: " + getCurrPages());
        if(pointsAdded() >= 0){
            System.out.println("Congrats! Goal met!" );
        }else{
            System.out.println("Goal not met" );
        }

    }
     */
}
