public class Schedule {
    private int scheduleID;
    private int totalDays;
    private int pagesPerDay;
    private Book book;
    private int pagesNotRead;

    public Schedule(int scheduleID, int totalDays, Book book) {
        this.scheduleID = scheduleID;
        this.totalDays = totalDays;
        this.book = book;
        this.pagesPerDay = this.book.getTotalPages()/totalDays;
        if (this.pagesPerDay == 0)
            this.pagesPerDay = 1;
        this.pagesNotRead = book.getTotalPages();
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

    public int getPagesNotRead() {
        return pagesNotRead;
    }

    public void setPagesNotRead(int pagesNotRead) {
        this.pagesNotRead = pagesNotRead;
    }
}
