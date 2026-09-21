
public class Schedule {

    private int scheduleID;
    private int totalDays;
    private int pagesPerDay;
    private Book book;

    /*
    private Tracker tracker;
    private Map<Integer, Integer> pagesTrack = new HashMap<>();
     */
    public Schedule(int scheduleID, int totalDays, Book book) {
        this.scheduleID = scheduleID;
        this.totalDays = totalDays;
        this.book = book;
        // this.tracker = tracker; 
        // calcuate pages per day based on totalDays
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

    /*
    public Tracker getTracker() {
        return tracker;
    }
     */
    public void setBook(Book book) {
        this.book = book;
    }

    /*
    public void setTracker(Tracker tracker) {
        this.tracker = tracker;
    }
     */
    public void setScheduleID(int scheduleID) {
        this.scheduleID = scheduleID;
    }

    public void setTotalDays(int totalDays) {
        this.totalDays = totalDays;
    }

    /*
    public void printSchedule(int totalDays){
        
        pagesTrack.put(tracker.getCurrDay(), tracker.getCurrPages()); 
        int remainDays = totalDays % 5;
        int day = 1;
        System.out.println(book.getBookName() + " Schedule For Day " + tracker.getCurrDay());
        for(int row = 1; row <= totalDays / 5; row++){
            for(int col = 1; col <= 5; col++){
                if(day <= 10){
                    if (pagesTrack.get(day) != null) {
                        System.out.print(day + " - " + pagesTrack.get(day)  + "/" + tracker.getPagePerDay() + "     ");
                    }else{
                        System.out.print(day + " - _"  + "/" + tracker.getPagePerDay() + "     ");
                    }      
                }
                else{
                    if (pagesTrack.get(day) != null) {
                        System.out.print(day + " - " + pagesTrack.get(day)  + "/" + tracker.getPagePerDay() + "    ");
                    }else{
                        System.out.print(day + " - _"  + "/" + tracker.getPagePerDay() + "    ");
                    }  
                }      
                day++;
            }
            System.out.println(); 
        }
        
        if (remainDays != 0) {
           for(int remainDay = 0; remainDay < remainDays; remainDay++){
                if(day <= 10){
                    if (pagesTrack.get(day) != null) {
                        System.out.print(day + " - " + pagesTrack.get(day)  + "/" + tracker.getPagePerDay() + "     ");
                    }else{
                        System.out.print(day + " - _"  + "/" + tracker.getPagePerDay() + "     ");
                    }  
                }else{
                    if (pagesTrack.get(day) != null) {
                        System.out.print(day + " - " + pagesTrack.get(day)  + "/" + tracker.getPagePerDay() + "    ");
                    }else{
                        System.out.print(day + " - _"  + "/" + tracker.getPagePerDay() + "    ");
                    }  
                }    
                day++;
            } 
        }  
        System.out.println(); 
    }
     */
    public static void main(String[] args) {

    }

}
