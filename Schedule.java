public class Schedule{
    private int scheduleID;
    private int bookID; 
    private int pagePerDay;
    public Schedule(){
        scheduleID = 000000;
        bookID = 000000;
        pagePerDay = 0;
    }

    public Schedule(int scheduleID, int bookID, int pagePerDay){
        this.scheduleID = scheduleID;
        this.bookID = bookID;
        this.pagePerDay = pagePerDay;
    }

    public int getScheduleID() {
        return scheduleID;
    }

    public int getBookID() {
        return bookID;
    }

    public int getPagePerDay() {
        return pagePerDay;
    }

    public void setScheduleID(int scheduleID) {
        this.scheduleID = scheduleID;
    }

    public void setBookID(int bookID) {
        this.bookID = bookID;
    }

    public void setPagePerDay(int pagePerDay) {
        this.pagePerDay = pagePerDay;
    }


}