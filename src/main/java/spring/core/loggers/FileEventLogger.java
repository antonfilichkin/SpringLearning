package spring.core.loggers;

import org.apache.commons.io.FileUtils;
import spring.core.beans.Event;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

public class FileEventLogger implements EventLogger {
    protected String filename;
    protected File file;

    private void init() throws IOException {
        this.file = new File(filename);
        if (!this.file.canWrite()) throw new IOException();
    }

    @Override
    public void logEvent(String msg) {

    }

    @Override
    public void logEvent(Event event) {
        final String newLine = System.getProperty("line.separator");
        try {
            FileUtils.writeStringToFile(file, event.toString() + newLine, Charset.forName("utf-8"), true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
