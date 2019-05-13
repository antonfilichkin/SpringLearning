package spring.core.loggers;

import spring.core.beans.Event;

public class ConsoleEventLogger implements EventLogger {
    @Override
    public void logEvent(String msg) {
        System.out.println(msg);
    }

    @Override
    public void logEvent(Event event) {
        System.out.println(event.toString());
    }
}
