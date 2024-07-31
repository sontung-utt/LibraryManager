package model;

import java.time.LocalDate;

public class News extends Document {
    private LocalDate releaseDate;

    public News(int id, String name, String publishName, int releaseNumber, LocalDate releaseDate) {
        super(id, name, publishName, releaseNumber);
        this.releaseDate = releaseDate;
    }

    public News() {
    }

    public News(String name, String publishName, int releaseNumber, LocalDate releaseDate){
        super(name, publishName, releaseNumber);
        this.releaseDate = releaseDate;
    }

    public News(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String toString() {
        return "=====Báo=====" + "\n" +
                super.toString() +
                "\nNgày phát hành: " + releaseDate;
    }
}
