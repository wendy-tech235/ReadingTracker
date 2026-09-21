public class Book {
    private String bookName;
    private int bookID;
    private int totalPages;

    public Book() {
        bookName = "";
        bookID = 0;
        totalPages = 0;
    }

    public Book(String bookName, int bookID, int totalPages){
        this.bookName = bookName;
        this.bookID = bookID;
        this.totalPages = totalPages;
    }

    public String getBookName() {
        return bookName;
    }

    public int getBookID() {
        return bookID;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public void setBookID(int bookID) {
        this.bookID = bookID;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }
}