package spring.core;

import lombok.AllArgsConstructor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.core.beans.Client;
import spring.core.loggers.ConsoleEventLogger;

@AllArgsConstructor
public class App {
    private Client client;
    private ConsoleEventLogger logger;

    public static void main(String[] args) {
        ApplicationContext appCtx = new ClassPathXmlApplicationContext("spring.xml");
        App app = (App) appCtx.getBean("app");
        app.logEvent("Some event for user 1");
    }

    private void logEvent(String msg) {
        String message = msg.replaceAll(client.getId(), client.getFullName());
        logger.logEvent(message);
    }
}