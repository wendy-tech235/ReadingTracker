
public class Schedule {
    private int scheduleID;
    private int totalDays;
    private int pagesPerDay;
    private Book book;
    public Schedule(int scheduleID, int totalDays, Book book) {
        this.scheduleID = scheduleID;
        this.totalDays = totalDays;
        this.book = book;
        this.pagesPerDay = this.book.getTotalPages() / totalDays;
    }

    public int getScheduleID() {
        return scheduleID;
    }

    public int getTotalDays() {
        return totalDays;
    }

    public Book getBook() {
        return book;
    }

    public int getPagesPerDay() {
        return pagesPerDay;
    }

    public void setPagesPerDay(int pagesPerDay) {
        this.pagesPerDay = pagesPerDay;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public void setScheduleID(int scheduleID) {
        this.scheduleID = scheduleID;
    }

    public void setTotalDays(int totalDays) {
        this.totalDays = totalDays;
    }
    public static void main(String[] args) {

    }

}
