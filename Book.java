public class Book {
    private String bookName;
    private int bookID;
    private int totalPages;
    private double price;

    public Book() {
        bookName = "";
        bookID = 0;
        totalPages = 0;
        price = 0.0;
    }

    public Book(String bookName, int bookID, int totalPages, double price) {
        this.bookName = bookName;
        this.bookID = bookID;
        this.totalPages = totalPages;
        this.price = price;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

