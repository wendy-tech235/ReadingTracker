import java.util.*;
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

    public void printSchedule(String bookName, int totalPages, int totalDays, int pagesPerDay, int currDay, int currPages){
        Map<Integer, Integer> pagesTrack = new HashMap<>();
        pagesTrack.put(currDay, currPages);
        int remainDays = totalDays % 5;
        int day = 1;
        System.out.println(bookName + " Schedule For Day " + currDay);
        for(int row = 1; row <= totalDays / 5; row++){
            for(int col = 1; col <= 5; col++){
                if(day <= 10){
                    if (pagesTrack.get(day) != null) {
                        System.out.print(day + " - " + pagesTrack.get(day)  + "/" + pagesPerDay + "     ");
                    }else{
                        System.out.print(day + " - _"  + "/" + pagesPerDay + "     ");
                    }      
                }
                else{
                    if (pagesTrack.get(day) != null) {
                        System.out.print(day + " - " + pagesTrack.get(day)  + "/" + pagesPerDay + "    ");
                    }else{
                        System.out.print(day + " - _"  + "/" + pagesPerDay + "    ");
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
                        System.out.print(day + " - " + pagesTrack.get(day)  + "/" + pagesPerDay + "     ");
                    }else{
                        System.out.print(day + " - _"  + "/" + pagesPerDay + "     ");
                    }  
                }else{
                    if (pagesTrack.get(day) != null) {
                        System.out.print(day + " - " + pagesTrack.get(day)  + "/" + pagesPerDay + "    ");
                    }else{
                        System.out.print(day + " - _"  + "/" + pagesPerDay + "    ");
                    }  
                }    
                day++;
            } 
        }  
    }

    public static void main(String[] args) {
        
    }
}

