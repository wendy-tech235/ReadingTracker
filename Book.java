public class Book{
    private String bookName;
    private int bookID;
    private int totalPages;

    public Book(){
        bookName = "book";
        bookID = 000000;
        totalPages = 0;
    }

    public Book(String bookName, int bookID, int totalPage){
        this.bookName = bookName;
        this.bookID = bookID;
        this.bookName = bookName;
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