import java.util.Scanner;

public class Tracker{
    private int trackerID;
    private int numberOfPoints;
    private int earnPoints;
    private int currDay;
    private int currPages;
    private int pagePerDay;
    private Book book;

    public Tracker(Book book, int currDay, int currPages, int earnPoints, int numberOfPoints, int pagePerDay, int trackerID) {
        this.book = book;
        this.currDay = currDay;
        this.currPages = currPages;
        this.earnPoints = earnPoints;
        this.numberOfPoints = numberOfPoints;
        this.pagePerDay = pagePerDay;
        this.trackerID = trackerID;
    }

    public int getTrackerID() {
        return trackerID;
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

    public int getPagePerDay() {
        return pagePerDay;
    }

    public Book getBook() {
        return book;
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

    public void setPagePerDay(int pagePerDay) {
        this.pagePerDay = pagePerDay;
    }

    public void setBook(Book book) {
        this.book = book;
    }

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
        System.out.println("Day " + getCurrDay());
        System.out.println("Do you want to change your goal? (type yes or no, type anything else and I will find you...)");
        String temp = scanner.nextLine();
        if(temp.equals("yes")){
            System.out.println("Enter new goal: ");
            setPagePerDay(Integer.parseInt(scanner.nextLine()));
        }
        System.out.println("Enter how many pages you read for " + book.getBookName());
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
        this.currDay = currDay++;

    }
}