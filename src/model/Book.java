package model;

public class Book extends Document{
    private String author;
    private int pageNumber;

    public Book() {
    }

    public Book(String name, String publishName, int releaseNumber, String author, int pageNumber){
        super(name, publishName, releaseNumber);
        this.author = author;
        this.pageNumber = pageNumber;
    }

    public Book(int id, String name, String publishName, int releaseNumber, String author, int pageNumber) {
        super(id, name, publishName, releaseNumber);
        this.author = author;
        this.pageNumber = pageNumber;
    }

    public Book(String author, int pageNumber) {
        this.author = author;
        this.pageNumber = pageNumber;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public String toString() {
        return "=====Sách=====" + "\n" +
                super.toString() +
                "\nTên tác giả: " + author +
                "\nSố trang: " + pageNumber;
    }
}
