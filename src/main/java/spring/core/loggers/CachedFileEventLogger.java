package spring.core.loggers;

import spring.core.beans.Event;

import java.util.ArrayList;
import java.util.List;

public class CachedFileEventLogger extends FileEventLogger {
    private int cacheSize;
    private List<Event> cache = new ArrayList<>();

    private void destroy() {
        if (!cache.isEmpty()) {
            writeEventsFromCache();
        }
    }

    public CachedFileEventLogger(String filename, int cacheSize) {
        super.filename = filename;
        this.cacheSize = cacheSize;
    }

    @Override
    public void logEvent(String msg) {

    }

    @Override
    public void logEvent(Event event) {
        cache.add(event);

        if (cache.size() == cacheSize) {
            writeEventsFromCache();
            cache.clear();
        }
    }

    private void writeEventsFromCache() {
        System.out.println("Writing from cache...");
        for (Event event : cache) {
            super.logEvent(event);
        }
    }
}
