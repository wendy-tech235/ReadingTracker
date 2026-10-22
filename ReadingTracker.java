import java.util.*;

public class ReadingTracker {
    private static int MAX_BOOKS = 10;
    private Book[] books; 
    private List<Schedule> schedules;
    private int trackerID = 0;
    private List<List<Tracker>> trackers;
    private static int DAYS_PER_ROW = 5;
    private Scanner scanner = new Scanner(System.in);
    public static int numBooks = 0;

    public ReadingTracker() {
        this.books = new Book[MAX_BOOKS];  
        this.schedules = new ArrayList<>();
        this.trackers = new ArrayList<>();
    }

    public Book[] getBooks() {
        return books;
    }

    public List<Schedule> getSchedules() {
        return schedules;
    }

    public void setBooks(Book[] books) {
        this.books = books;
    }

    public void setSchedules(List<Schedule> schedules) {
        this.schedules = schedules;
    }

    //precondition: prompt needs to be a string
    //postcondition: checks if the input is a positive integer, if not it will reprompt until it is
    public int inputVaildPosInt(String prompt) {
        int haha = 0;
        System.out.println(prompt);
        while (true) {
            boolean isValid = true;
            int value = 0;
            String textValue = scanner.nextLine();
            try {
                value = Integer.parseInt(textValue); 
                if(value <= 0 || value > 1000)
                    isValid = false;
            } catch (Exception e) {
                isValid = false;
            }
            if (isValid) {
                if(haha > 0)
                    System.out.println("See that wasn't so hard :D");

                return value;
            }else if(value > 1000){ 
                System.out.println("There is no way your reading that much, it seems to me you are an alien and I'm calling Area 51...please enter lower than 1000");
                haha += 1;
            }else{
                System.out.println("ENTER A POSITIVE INTEGER!!!!!");
                haha++;
            }
        }
    }
    
    public double inputVaildPosDouble(String prompt) {
        int haha = 0;
        System.out.println(prompt);
        while (true) {
            boolean isValid = true;
            double value = 0;
            String textValue = scanner.nextLine();
            try {
                value = Double.parseDouble(textValue);
                if(value <= 0 || value > 1000)
                    isValid = false;
            } catch (Exception e) {
                isValid = false;
            }
            if (isValid) {
                if(haha > 0)
                    System.out.println("See that wasn't so hard :D");

                return value;
            }else if(value > 1000){ 
                System.out.println("Inflation is not that high, please enter a double less than 1000");
                haha += 1;
            }else{
                System.out.println("ENTER A POSITIVE DOUBLE!!!!!");
                haha++;
            }
        }
    }

    //precondition: NA
    //postcondition: adds the books to the list of books based on user input
    public void setUpBooks() {
        numBooks = inputVaildPosInt("How many books are you reading? (Enter less than or equal to 10, if you don't then I will find you)");
        for (int i = 0; i < numBooks; i++) {
            System.out.println("-------------------");
            System.out.println("Book " + (i + 1));

            System.out.println("Enter book name:");
            String bookName = scanner.nextLine();
            int totalPages = inputVaildPosInt("Enter total book pages:");
            double price = inputVaildPosDouble("Enter book price:");
            
            Book book = new Book(bookName, i, totalPages, price);
            books[i] = book;
        }
        System.out.println();
        System.out.println("Good choices!");
    }

    //precondition: NA
    //postcondition: makes a schedule for each book and adds it to the list of schedules
    public void setUpSchedules(){
        for (int i = 0; i < numBooks; i++) {
            if (books[i] == null) break;
            System.out.println("--------------------");
            System.out.println("Book " + (i + 1) + ", book name: " + books[i].getBookName());
            int totalDays = inputVaildPosInt("Enter how many days you want to finish " + books[i].getBookName());
            Schedule schedule = new Schedule(i, totalDays, books[i]);
            schedules.add(schedule);
        }
    }

    //precondition: NA
    //postcondition: prints out the schedules and their information in a table
    public void printSchedule() {
        System.out.println("--------------------");
        System.out.printf("%-10s %-30s %12s %12s %12s%n","Book ID", "Book Name", "Total Pages", "Total Days", "Pages/Day");
        for (Schedule schedule : schedules) {
            Book book = schedule.getBook();
            System.out.printf("%-10d %-30s %12d %12d %12d%n", book.getBookID(), book.getBookName(), 
                book.getTotalPages(), schedule.getTotalDays(), schedule.getPagesPerDay());
        }
    }

    //precondition: NA
    //postcondition: prints out the books and their information in a table
    public void printBooksInfo() {
        System.out.println("--------------------");
        System.out.printf("%-10s %-30s %12s %12s%n","Book ID", "Book Name", "Total Pages", "Price");
        for (int i = 0; i < numBooks; i++) {
            System.out.printf("%-10d %-30s %12d %12.2f%n", books[i].getBookID(), books[i].getBookName(), books[i].getTotalPages(), books[i].getPrice());
        }
    }

    //precondition: scheduleIndex is a valid index in the list
    //postcondition: prints out the calendar for the day which is the index
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
    

    //precondition: a valid Score
    //postcondition: tracks the reading for each book in one day and adds it to the list of trackers
    public void trackReading(Score score) {
        int day = 0;
        while (true) {
            System.out.println("--------------------");
            System.out.println("For Day of " + (day + 1));
            boolean hasLeftPage = false;
            for (int scheduleIndex = 0; scheduleIndex < schedules.size(); scheduleIndex++) {
                Schedule schedule = schedules.get(scheduleIndex);
                if (schedule.getPagesNotRead() == 0)
                    continue;
                int currPages = inputVaildPosInt("Enter how many pages you read for book " + 
                    schedules.get(scheduleIndex).getBook().getBookName() + ", pages not read: " + schedule.getPagesNotRead());
                if (currPages >= schedule.getPagesNotRead()) {
                    System.out.println("Only " + schedule.getPagesNotRead() + 
                        " pages left, so todays count " + schedule.getPagesNotRead() + " pages read.");
                    currPages = schedule.getPagesNotRead();
                } 
                score.calculatePointsInDay();
                score.addTotalPoints();
                int leftPages = schedule.getPagesNotRead() - currPages;
                if (leftPages > 0)
                    hasLeftPage = true;
                
                schedule.setPagesNotRead(leftPages);
                Tracker tracker = new Tracker(schedule, day, currPages, trackerID);
                trackerID++;
                this.trackers.get(scheduleIndex).add(tracker);
                
                System.out.println("Total points: " + score.getTotalPoints() + ", total earned in a day: " + score.getEarnInDay());
                score.resetEarnInDay();
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

    //precondition: NA
    //postcondition: prints out the reading schedule for the days in the calender for each book
    public void report(){
        for(int i = 0; i < schedules.size(); i++) {
            System.out.println("--------------------");
            Book book = schedules.get(i).getBook();
            System.out.println("Calender for " + book.getBookName());
            printCalendar(schedules.get(i), i);
        }
    }

    public static void main(String[] args) {
        Score score = new Score();
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
        readingTracker.trackReading(score);
        System.out.println();
        System.out.println();

        System.out.println("Step 4: Report Reading");
        System.out.println("=======================");
        readingTracker.report();

        // test
        // test2
    }
}
//Neev
//Good: the code checked for all the wrong answeres and kept reprompting until the right type was inputted.
//Improvement: Maybe make restrict unreasonable amounts of pages read in a day.
//The wording on the calender is a bit confusing
//When saying I read more pages than the book is long it doesn't flag
//You can't read partial pages
//Lucas Vanasse only breaks if you read a billion pages a day
