package models;

public class TweetInfoModel {
    private String text;
    private long date;
    private int retweetCount;

    public TweetInfoModel(String text, long date, int retweetCount) {
        this.text = text;
        this.date = date;
        this.retweetCount = retweetCount;
    }

    public String getText() {
        return text;
    }

    public long getDate() {
        return date;
    }

    public int retweetCount() {
        return retweetCount;
    }
}
