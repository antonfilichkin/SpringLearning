package spring.core.loggers;

public class ConsoleEventLogger implements ConsoleEventLoggerInterface {
    @Override
    public void logEvent(String msg) {
        System.out.println(msg);
    }
}
