package spring.core.beans;

import lombok.Data;

import java.util.Date;
import java.util.Random;

@Data
public class Event {
    public int id;
    public String msg;
    public Date date;

    public Event(String msg) {
        this.id = new Random().nextInt();
        this.msg = msg;
        this.date = new Date();
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
