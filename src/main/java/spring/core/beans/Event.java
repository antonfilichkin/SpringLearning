package spring.core.beans;

import java.text.DateFormat;
import java.time.LocalTime;
import java.util.Date;
import java.util.Random;

public class Event {
    private int id = new Random().nextInt(101) + 100;
    private String msg;
    private Date date;
    private DateFormat df;

    public static boolean isDay() {
        LocalTime dayStart = LocalTime.parse("08:00");
        LocalTime dayEnd = LocalTime.parse("17:00");
        LocalTime now = LocalTime.now();

        return now.isAfter(dayStart) && now.isBefore(dayEnd);
    }

    public Event(Date date, DateFormat df) {
        this.date = date;
        this.df = df;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", msg='" + msg + '\'' +
                ", date=" + df.format(date) +
                '}';
    }
}
