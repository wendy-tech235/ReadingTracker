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

    public int inputVaildPosInt(String prompt) {
        int haha = 0;
        System.out.println(prompt);
        while (true) {
            boolean isValid = true;
            int value = 0;
            String textValue = scanner.nextLine();
            try {
                value = Integer.parseInt(textValue); 
                if(value <= 0)
                    isValid = false;
            } catch (Exception e) {
                isValid = false;
            }
            if (isValid) {
                if(haha > 0)
                    System.out.println("See that wasn't so hard :D");
                return value;
            } else {
                System.out.println("ENTER A POSITIVE INTEGER!!!!!");
                haha++;
            }
        }
    }
    
    public void setUpBooks() {
        //System.out.println("How many books are you reading?");
        //int numBooks = Integer.parseInt(scanner.nextLine());
        int numBooks = inputVaildPosInt("How many books are you reading?");
        for (int i = 0; i < numBooks; i++) {
            System.out.println("-------------------");
            System.out.println("Book " + (i + 1));

            System.out.println("Enter book name:");
            String bookName = scanner.nextLine();

            //System.out.println("Enter total book pages:");
            //int totalPages = Integer.parseInt(scanner.nextLine());
            int totalPages = inputVaildPosInt("Enter total book pages:");

            Book book = new Book(bookName, i, totalPages);
            books.add(book);
        }
        System.out.println();
        System.out.println("Good choices!");
    }

    public void setUpSchedules(){
        for (int i = 0; i < books.size(); i++) {
            System.out.println("--------------------");
            System.out.println("Book " + (i + 1) + ", book name: " + books.get(i).getBookName());
            //System.out.println("Enter how many days you want to finish " + books.get(i).getBookName());
            //int totalDays = Integer.parseInt(scanner.nextLine());
            int totalDays = inputVaildPosInt("Enter how many days you want to finish " + books.get(i).getBookName());
            Schedule schedule = new Schedule(i, totalDays, books.get(i));
            schedules.add(schedule);
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
        int totalDays = trackers.get(scheduleIndex).size();
        int pagesPerDay = schedule.getPagesPerDay();
        int day = 0;

        while (day < totalDays) {
            int rowStartDay = day;

            // Day-number row
            for (int col = 0; col < DAYS_PER_ROW && day < totalDays; col++) {
                System.out.printf("%-14s", "Day " + (day + 1));
                day++;
            }
            System.out.println();

            // Reading-result row
            day = rowStartDay;

            for (int col = 0; col < DAYS_PER_ROW && day < totalDays; col++) {
                String result = "_/" + pagesPerDay;

                if (day < trackers.get(scheduleIndex).size()) {
                    int pagesRead = trackers.get(scheduleIndex).get(day).getCurrPages();

                    if (pagesRead > 0) {
                        result = pagesRead + "/" + pagesPerDay;
                    }
                }

                System.out.printf("%-14s", result);
                day++;
            }

            System.out.println();
            System.out.println();
        }
    }
    
    public void trackReading() {
        int day = 0;
        while (true) {
            System.out.println("--------------------");
            System.out.println("For Day of " + (day + 1));
            boolean hasLeftPage = false;
            for (int scheduleIndex = 0; scheduleIndex < schedules.size(); scheduleIndex++) {
                Schedule schedule = schedules.get(scheduleIndex);
                if (schedule.getPagesNotRead() == 0)
                    continue;
                
                //System.out.println("Enter how many pages you read for book " + 
                    //schedules.get(scheduleIndex).getBook().getBookName() + ", pages not read: " + schedule.getPagesNotRead());
                //int currPages = Integer.parseInt(scanner.nextLine());
                int currPages = inputVaildPosInt("Enter how many pages you read for book " + 
                    schedules.get(scheduleIndex).getBook().getBookName() + ", pages not read: " + schedule.getPagesNotRead());
                if (currPages >= schedule.getPagesNotRead()) {
                    System.out.println("Only " + schedule.getPagesNotRead() + 
                        " pages left, so today count " + schedule.getPagesNotRead() + " pages read.");
                    currPages = schedule.getPagesNotRead();
                }
                int leftPages = schedule.getPagesNotRead() - currPages;
                if (leftPages > 0)
                    hasLeftPage = true;
                
                schedule.setPagesNotRead(leftPages);
                
                Tracker tracker = new Tracker(schedule, day, currPages, trackerID);
                trackerID++;
                this.trackers.get(scheduleIndex).add(tracker);
            }
            if (!hasLeftPage)
                break;
            day++;
        }        
    }

    public void initTrackers() {
        for (Schedule schedule : schedules) {
            trackers.add(new ArrayList<>());
        }
    }

    public void report(){
        for(int i = 0; i < schedules.size(); i++) {
            System.out.println("--------------------");
            Book book = schedules.get(i).getBook();
            System.out.println("Calender for " + book.getBookName());
            printCalendar(schedules.get(i), i);
        }
    }

    public static void main(String[] args) {
        ReadingTracker readingTracker = new ReadingTracker();

        System.out.println("Step 1: Setup Book Information");
        System.out.println("==============================");
        readingTracker.setUpBooks();
        System.out.println();
        readingTracker.printBooksInfo();
        System.out.println();
        System.out.println();

        System.out.println("Step 2: Setup Schedules");
        System.out.println("=======================");
        readingTracker.setUpSchedules();
        System.out.println();
        readingTracker.printSchedule();
        System.out.println();
        System.out.println();

        System.out.println("Step 3: Track Reading");
        System.out.println("=======================");
        readingTracker.initTrackers();
        readingTracker.trackReading();
        System.out.println();
        System.out.println();

        System.out.println("Step 4: Report Reading");
        System.out.println("=======================");
        readingTracker.report();
    }
}
//Neev
//Good: the code checked for all the wrong answeres and kept reprompting until the right type was inputted.
//Improvement: Maybe make restrict unreasonable amounts of pages read in a day.
//The wording on the calender is a bit confusing
//When saying I read more pages than the book is long it doesn't flag
//You can't read partial pages
//Lucas Vanasse only breaks if you read a billion pages a day