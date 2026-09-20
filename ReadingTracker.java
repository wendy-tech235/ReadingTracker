import java.util.*;
public class ReadingTracker{
    private List<Book> books;
    private List<Schedule> schedules;
    public ReadingTracker(List<Book> books, List<Schedule> schedules) {
        this.books = books;
        this.schedules = schedules;
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
    }

    public static void main(String[] args) {
        ReadingTracker readingTracker = new ReadingTracker(new ArrayList<>(), new ArrayList<>());
        readingTracker.setUpBooks();
    }
}