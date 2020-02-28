package domain;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class TimeStamp {

    int year;
    int month;
    int day;
    int hour;
    int minute;
    int second;

    public TimeStamp(String y, String mO, String d, String h, String mI, String s) {
        this.year = Integer.parseInt(y);
        this.month = Integer.parseInt(mO);
        this.day = Integer.parseInt(d);
        this.hour = Integer.parseInt(h);
        this.minute = Integer.parseInt(mI);
        this.second = Integer.parseInt(s);
    }

    public String printTimeStamp() {
        String monthString = findMonthFromNumber(month);
        String meridiam = AMorPM(hour);
        return String.format("%2s:%2s:%2s %s, %-8s %d, %d", makeDoubleDigits(hour), makeDoubleDigits(minute), makeDoubleDigits(second), meridiam, monthString, day, year);
    }

    private String findMonthFromNumber(int month) {
        String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        return months[month-1];
    }

    private String AMorPM(int hour) {
        String AmOrPm = "AM";
        if (hour > 12){
            AmOrPm = "PM";
            this.hour = this.hour - 12;
        }
        return AmOrPm;
    }

    private String makeDoubleDigits(int number) {
        if (number < 10){
            return "0"+number;
        }
        return Integer.toString(number);
    }

    public int getSecond() {
        return second;
    }

    public int getMinute() {
        return minute;
    }

    public int getHour() {
        return hour;
    }

    public int getDay() {
        return day;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getSum() {
        return (year*500) + (month*400) + (day*300) + (hour*3) + (minute*2) + (second);
    }
}
