package pl.edu.ug.inf.pojo;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Tweet {

    private long id;
    private String text;
    private String author;
    private String authorNickname;
    private String date;
    private boolean positive;

    public Tweet() {
    }

    public Tweet(long id, String text, String author, String authorNickname, String date) {
        this.text = text;
        this.author = author;
        this.authorNickname = authorNickname;
        this.date = date;
        this.id = id;
    }

    public Tweet(long id, String text, String author, String authorNickname, String date, boolean positive) {
        this.text = text;
        this.author = author;
        this.authorNickname = authorNickname;
        this.date = date;
        this.positive = positive;
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthorNickname() {
        return authorNickname;
    }

    public void setAuthorNickname(String authorNickname) {
        this.authorNickname = authorNickname;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public boolean isPositive() {
        return positive;
    }

    public void setPositive(boolean positive) {
        this.positive = positive;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
