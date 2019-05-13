package spring.core.loggers;

import spring.core.beans.Event;

public interface EventLogger {
    @Deprecated
    void logEvent(String msg);
    void logEvent(Event event);
}
