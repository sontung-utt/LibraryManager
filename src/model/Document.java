package model;

public class Document {
    private int id;
    private String name;
    private String publishName;
    private int releaseNumber;

    private static int idIncrement = 1;

    public Document() {
    }

    public Document(int id, String name, String publishName, int releaseNumber) {
        this.id = id;
        this.name = name;
        this.publishName = publishName;
        this.releaseNumber = releaseNumber;
    }

    public Document(String name, String publishName, int releaseNumber) {
        this.id = idIncrement;
        this.name = name;
        this.publishName = publishName;
        this.releaseNumber = releaseNumber;
        idIncrement++;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPublishName() {
        return publishName;
    }

    public void setPublishName(String publishName) {
        this.publishName = publishName;
    }

    public int getReleaseNumber() {
        return releaseNumber;
    }

    public void setReleaseNumber(int releaseNumber) {
        this.releaseNumber = releaseNumber;
    }

    public static int getIdIncrement() {
        return idIncrement;
    }

    public static void setIdIncrement(int idIncrement) {
        Document.idIncrement = idIncrement;
    }

    public String toString(){
        return "Mã tài liệu: " + id +
                "\nTên tài liệu: " + name +
                "\nTên nhà xuất bản: " + publishName +
                "\nSố bản phát hành: " + releaseNumber;
    }
}
