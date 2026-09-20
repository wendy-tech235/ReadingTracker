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


    




}