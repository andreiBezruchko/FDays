package com.webacademy.fdays.Event;


public class Event {

    public long Date;
    public long Id;
    public String Title;
    public String Text;

    public Event(long date, String title, String text) {
        this.Date = date;
        this.Title = title;
        this.Text = text;
    }

    public Event() {};


    @Override
    public String toString() {
        return "Event{" +
                ", date=" + Date +
                ", title='" + Title + '\'' +
                ", text='" + Text + '\'' +
                '}';
    }
}
