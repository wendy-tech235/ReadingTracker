import java.util.*;

public class ReadingTracker {
    private List<Book> books;
    private List<Schedule> schedules;
    private int trackerID = 0;
    private List<List<Tracker>> trackers;
    private static int DAYS_PER_ROW = 5;
    private Scanner scanner = new Scanner(System.in);

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
    
    public void setUpBooks() {
        try {
            System.out.println("How many books are you reading?");
            int numBooks = Integer.parseInt(scanner.nextLine());
            for (int i = 0; i < numBooks; i++) {
                System.out.println("-------------------");
                System.out.println("Book " + (i + 1));

                System.out.println("Enter book name:");
                String bookName = scanner.nextLine();

                System.out.println("Enter total book pages:");
                int totalPages = Integer.parseInt(scanner.nextLine());

                Book book = new Book(bookName, i, totalPages);
                books.add(book);
            }
            System.out.println();
            System.out.println("Good choices!");
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

    public void setUpSchedules(){
        try {
            for (int i = 0; i < books.size(); i++) {
                System.out.println("--------------------");
                System.out.println("Book " + (i + 1) + ", book name: " + books.get(i).getBookName());
                System.out.println("Enter how many days you want to finish " + books.get(i).getBookName());
                int totalDays = Integer.parseInt(scanner.nextLine());
                Schedule schedule = new Schedule(i, totalDays, this.books.get(i));
                schedules.add(schedule);
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

    public void printSchedule() {
        System.out.println("--------------------");
        System.out.printf("%-10s %-30s %12s %12s %12s%n","Book ID", "Book Name", "Total Pages", "Total Days", "Pages/Day");
        for (Schedule schedule : schedules) {
            Book book = schedule.getBook();
            System.out.printf("%-10d %-30s %12d %12d %12d%n", book.getBookID(), book.getBookName(), 
                book.getTotalPages(), schedule.getTotalDays(), schedule.getPagesPerDay());
        }
    }

    private int caculateMaxDays() {
        int maxDays = 0;
        for (Schedule schedule : schedules)
            maxDays = Math.max(maxDays, schedule.getTotalDays());
        return maxDays;
    }

    public void printBooksInfo() {
        System.out.println("--------------------");
        System.out.printf("%-10s %-30s %12s%n","Book ID", "Book Name", "Total Pages");
        for (Book book : books) {
            System.out.printf("%-10d %-30s %12d%n", book.getBookID(), book.getBookName(), book.getTotalPages());
        }
    }

    public void printCalendar(Schedule schedule, int scheduleIndex) {
        int rows = schedule.getTotalDays() / DAYS_PER_ROW;
        int day = 0;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < DAYS_PER_ROW; col++) {
                Book book = schedule.getBook();
                if (trackers.get(scheduleIndex).get(day).getCurrPages() != 0){
                    System.out.print(trackers.get(scheduleIndex).get(day).getCurrPages() + "/" + schedule.getPagesPerDay() + "    ");
                    System.out.print(schedule.getPagesPerDay() + "    ");
                }    
                else{
                    System.out.print("_" + "/" + schedule.getPagesPerDay());
                }
                    
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

    public static void main(String[] args) {
        ReadingTracker readingTracker = new ReadingTracker();

        System.out.println("         Step 1: Setup Book Information");
        System.out.println("         ==============================");
        readingTracker.setUpBooks();
        System.out.println();
        readingTracker.printBooksInfo();
        System.out.println();
        System.out.println();

        System.out.println("         Step 2: Setup Schedules");
        System.out.println("         =======================");
        readingTracker.setUpSchedules();
        System.out.println();
        readingTracker.printSchedule();
        System.out.println();
        System.out.println();

        System.out.println("         Step 3: Track Reading");
        System.out.println("         =======================");
        /*
        readingTracker.initSchedules();

        readingTracker.track();
        readingTracker.report();
        */
    }
}