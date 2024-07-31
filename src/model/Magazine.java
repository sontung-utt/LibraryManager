package model;

public class Magazine extends Document{
    private int issueNumber;
    private int releaseMonth;

    public Magazine(){
    }

    public Magazine(String name, String publishName, int releaseNumber, int issueNumber, int releaseMonth){
        super(name, publishName, releaseNumber);
        this.issueNumber = issueNumber;
        this.releaseMonth = releaseMonth;
    }

    public Magazine (int id, String name, String publishName, int releaseNumber, int issueNumber, int releaseMonth) {
        super(id, name, publishName, releaseNumber);
        this.issueNumber = issueNumber;
        this.releaseMonth = releaseMonth;
    }

    public Magazine(int issueNumber, int releaseMonth) {
        this.issueNumber = issueNumber;
        this.releaseMonth = releaseMonth;
    }

    public int getIssueNumber() {
        return issueNumber;
    }

    public void setIssueNumber(int issueNumber) {
        this.issueNumber = issueNumber;
    }

    public int getReleaseMonth() {
        return releaseMonth;
    }

    public void setReleaseMonth(int releaseMonth) {
        this.releaseMonth = releaseMonth;
    }

    public String toString(){
        return "=====Tạp chí=====" + "\n"
                + super.toString() +
                "\nSố phát hành: " + issueNumber +
                "\nTháng phát hành: " + releaseMonth;
    }
}
