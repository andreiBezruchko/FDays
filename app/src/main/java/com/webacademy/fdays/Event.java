package com.webacademy.fdays;

/**
 * Created by Андрей  Безручко on 18.02.2016.
 */
public class Event {
    private long date;
    private String title;
    private String text;

    public Event(long date, String title, String text) {
        this.date = date;
        this.title = title;
        this.text = text;
    }

    public Event() {};

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Event{" +
                ", date=" + date +
                ", title='" + title + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}
