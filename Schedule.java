public class Schedule{
    private int scheduleID;
    private int bookID; 
    private int pagePerDay;
    private int totalDays; 
    
    public Schedule(){
        scheduleID = 000000;
        bookID = 000000;
        pagePerDay = 0;
    }

    public Schedule(int scheduleID, int bookID, int pagePerDay, int totalDays){
        this.scheduleID = scheduleID;
        this.bookID = bookID;
        this.pagePerDay = pagePerDay;
        this.totalDays = totalDays;
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

    public int getTotalDays() {
        return totalDays;
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

    public void setTotalDays(int totalDays) {
        this.totalDays = totalDays;
    }

    public void suggestedSchedule(int totalPages, int totalDays){
        System.out.println("Recommended page per day: " + totalPages/totalDays);
    }

}