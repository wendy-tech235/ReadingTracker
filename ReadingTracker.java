import java.util.*;
public class ReadingTracker{
    private List<Book> books;
    private List<Schedule> schedules;
    private int trackerID = 0;
    private List<List<Tracker>> trackers;
    private static int DAYS_PER_ROW = 3;

    public ReadingTracker() {
        this.books = new ArrayList<>();
        this.schedules = new ArrayList<>();
        this.trackers = new ArrayList<>();
    }

    public List<Book> getBooks() {
        return books;
    }

    public List<Schedule> getSchedules() {
        return schedules;
    }

 

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public void setSchedules(List<Schedule> schedules) {
        this.schedules = schedules;
    }
    

    public void setUpBooks(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many books are you reading?");
        int numBooks = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < numBooks; i++) {
            System.out.println("Enter book name:");
            String bookName = scanner.nextLine();

            System.out.println("Enter total book pages:");
            int totalPages = Integer.parseInt(scanner.nextLine());

            Book book = new Book(bookName, i, totalPages);
            books.add(book);
        }
        System.out.println("Good choices!");
    }

    public void setUpSchedules(){
        Scanner scanner = new Scanner(System.in);
        for(int i = 0; i < books.size(); i++){
            System.out.println("Enter how many days you want to finish " + books.get(i).getBookName());
            int totalDays = Integer.parseInt(scanner.nextLine());
            Schedule schedule = new Schedule(i, totalDays, this.books.get(i));
            schedules.add(schedule);

            // System.out.println("Enter how many pages you want to read per day for " + books.get(i).getBookName());
            // int pagePerDay = Integer.parseInt(scanner.nextLine());
            // Tracker tracker = new Tracker(books.get(i), 1, schedules.get(i).getTotalDays(), 0, 0, pagePerDay, i);
            // schedules.get(i).setTracker(tracker);
            // trackers.add(tracker);
        }
    }

    public void printSchedule() {
        for (Schedule schedule : schedules) {
            System.out.println("--------------------");
            System.out.println(schedule.getBook().getBookName());
            System.out.println("Days to finish " + schedule.getTotalDays());
            System.out.println();
        }
    }

    private int caculateMaxDays() {
        int maxDays = 0;
        for (Schedule schedule : schedules)
            maxDays = Math.max(maxDays, schedule.getTotalDays());
        return maxDays;
    }

    public void printCalendar(Schedule schedule, int scheduleIndex) {
        int rows = schedule.getTotalDays() / DAYS_PER_ROW;
        int day = 0;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < DAYS_PER_ROW; col++) {
                Book book = schedule.getBook();
                if (trackers.get(scheduleIndex).get(day).getCurrPages() != 0)
                    System.out.print(trackers.get(scheduleIndex).get(day).getCurrPages() + " / " + schedule.getPagesPerDay() + "    ");
                else
                    System.out.print("_" + "2/ " + schedule.getPagesPerDay());
            }
            System.out.println();
        }
    }
    
    public void track() {
        Scanner scanner = new Scanner(System.in);
        int maxDays = caculateMaxDays();
        for (int day = 0; day < maxDays; day++) {
            System.out.println("For Day of " + (day + 1));
            for (int scheduleIndex = 0; scheduleIndex < schedules.size(); scheduleIndex++) {
                System.out.println("Enter how many pages you read for book " + schedules.get(scheduleIndex).getBook().getBookName());
                int currPages = Integer.parseInt(scanner.nextLine());
                Tracker tracker = new Tracker(schedules.get(scheduleIndex), day, currPages, trackerID);
                trackerID++;
                this.trackers.get(scheduleIndex).add(tracker);
            }
        }        
    }

    public void initSchedules() {
        for (int i = 0; i < schedules.size(); i++) {
            trackers.add(new ArrayList<>());
        }
    }

    public void report(){
        for(int i = 0; i < schedules.size(); i++){
            Book book = schedules.get(i).getBook();
            System.out.println("Calender for " + book.getBookName());
            printCalendar(schedules.get(i), i);
        }
    }

    /*
    public void report(){
        for(int i = 0; i < books.size(); i++){
            System.out.println("Day " + trackers.get(i).getCurrDay() + " for " + books.get(i).getBookName());
            trackers.get(i).dailySummary();
            schedules.get(i).printSchedule(schedules.get(i).getTotalDays());
            System.out.println();
        }
 
    }
    */

    /*
    public void daily(ReadingTracker readingTracker){
        Scanner scanner = new Scanner(System.in);
        int max = -1;
        for(int i = 0; i < books.size(); i++){
            if (max < schedules.get(i).getTotalDays()) {
                max = schedules.get(i).getTotalDays();
            }
        }
        for(int i = 1; i <= max; i++){
            readingTracker.report();
            System.out.println("Type anthing and enter to go to the next day");
            String useless = scanner.nextLine();
            System.out.println();
            trackers.get(1).setCurrDay(trackers.get(1).getCurrDay() + 1);
        }
    }
        */

    public static void main(String[] args) {
        ReadingTracker readingTracker = new ReadingTracker();

        readingTracker.setUpBooks();
        System.out.println();

        readingTracker.setUpSchedules();
        System.out.println();
        readingTracker.printSchedule();

        readingTracker.initSchedules();

        

        // readingTracker.daily(readingTracker);
        readingTracker.track();
        readingTracker.report();
    }
    
}