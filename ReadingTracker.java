import java.util.*;
public class ReadingTracker{
    private List<Book> books;
    private List<Schedule> schedules;
    private List<Tracker> trackers;
    public ReadingTracker(List<Book> books, List<Schedule> schedules, List<Tracker> trackers) {
        this.books = books;
        this.schedules = schedules;
        this.trackers = trackers;
    }

    public List<Book> getBooks() {
        return books;
    }

    public List<Schedule> getSchedules() {
        return schedules;
    }

    public List<Tracker> getTrackers() {
        return trackers;
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

    public void setUpSchedule(){
        Scanner scanner = new Scanner(System.in);
        for(int i = 0; i < books.size(); i++){
            System.out.println("Enter how many days you want to finish " + books.get(i).getBookName());
            int totalDays = Integer.parseInt(scanner.nextLine());
            Schedule schedule = new Schedule(i, totalDays, books.get(i), null);
            schedules.add(schedule);

            System.out.println("Enter how many pages you want to read per day for " + books.get(i).getBookName());
            int pagePerDay = Integer.parseInt(scanner.nextLine());
            Tracker tracker = new Tracker(books.get(i), 0, schedules.get(i).getTotalDays(), 0, 0, 0, pagePerDay);
            schedules.get(i).setTracker(tracker);
            trackers.add(tracker);
        }
    }

    public void daily(){
        
    }

    public static void main(String[] args) {
        ReadingTracker readingTracker = new ReadingTracker(new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        readingTracker.setUpBooks();
        System.out.println();
        readingTracker.setUpSchedule();
        System.out.println();
    }

    
}