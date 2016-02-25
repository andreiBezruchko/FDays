package com.webacademy.fdays.Event;


import android.os.Parcel;
import android.os.Parcelable;

public class Event implements Parcelable {
    private long id;
    private long date;
    private String title;
    private String text;
    private int check;

    public Event(long date, String title, String text, int check) {
        this.date = date;
        this.title = title;
        this.text = text;
        this.check = check;
    }

    public Event() {};

    protected Event(Parcel in) {
        id = in.readLong();
        date = in.readLong();
        title = in.readString();
        text = in.readString();
        check = in.readInt();
    }

    public static final Creator<Event> CREATOR = new Creator<Event>() {
        @Override
        public Event createFromParcel(Parcel in) {
            return new Event(in);
        }

        @Override
        public Event[] newArray(int size) {
            return new Event[size];
        }
    };

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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

    public int isCheck() {
        return check;
    }

    public int getCheck() {
        return check;
    }

    public void setCheck(int check) {
        this.check = check;
    }

    @Override
    public String toString() {
        return "Event{" +
                ", date=" + date +
                ", title='" + title + '\'' +
                ", text='" + text + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(id);
        dest.writeLong(date);
        dest.writeString(title);
        dest.writeString(text);
        dest.writeInt(check);
    }
}
