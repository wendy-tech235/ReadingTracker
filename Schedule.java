
<<<<<<< HEAD
public class Schedule {
    private int scheduleID;
    private int totalDays;
    private int pagesPerDay;
    private Book book;
    public Schedule(int scheduleID, int totalDays, Book book) {
=======
    public Schedule(int scheduleID, int bookID, int pagePerDay, int totalDays, Book book, Tracker tracker){
>>>>>>> parent of 5b925b8 (main functions and others)
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

<<<<<<< HEAD
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

=======
>>>>>>> parent of 5b925b8 (main functions and others)
    public void setScheduleID(int scheduleID) {
        this.scheduleID = scheduleID;
    }

    public void setTotalDays(int totalDays) {
        this.totalDays = totalDays;
    }
<<<<<<< HEAD
    public static void main(String[] args) {

    }

=======

    public void suggestedSchedule(){
        System.out.println("Recommended page per day: " + book.getTotalPages()/totalDays);
    }

    public void printSchedule(int totalDays){
        Map<Integer, Integer> pagesTrack = new HashMap<>();
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
    }

    public static void main(String[] args) {

    }
>>>>>>> parent of 5b925b8 (main functions and others)
}
