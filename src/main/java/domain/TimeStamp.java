package domain;

public class TimeStamp {

    int year;
    int month;
    int day;
    int hour;
    int minute;
    int second;

    public TimeStamp(String y, String mO, String d, String h, String mI, String s){
        this.year = Integer.parseInt(y);
        this.month = Integer.parseInt(mO);
        this.day = Integer.parseInt(d);
        this.hour = Integer.parseInt(h);
        this.minute = Integer.parseInt(mI);
        this.second = Integer.parseInt(s);
    }

    public int getSum(){ return (year*365) + (month*30) + day + (hour/24) + (minute/1440) + (second/86400); }
}
