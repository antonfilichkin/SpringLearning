package spring.core;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.core.beans.Client;
import spring.core.beans.Event;
import spring.core.loggers.EventLogger;

import java.util.Map;

import static spring.core.EventType.ERROR;
import static spring.core.EventType.INFO;

public class App {
    private Client client;
    private EventLogger defaultEventLogger;
    private Map<EventType, EventLogger> loggers;

    private static ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");

    public App(Client client, EventLogger eventLogger, Map<EventType, EventLogger> loggers) {
        this.client = client;
        this.defaultEventLogger = eventLogger;
        this.loggers = loggers;
    }

    public static void main(String[] args) {
        App app = (App) ctx.getBean("app");
        app.logEvent(INFO, "Some event for user 1");
        app.logEvent(INFO, "Some event for user 2");
        app.logEvent(ERROR, "Some event for user 3");
        app.logEvent(ERROR, "Some event for user 4");
        app.logEvent(ERROR, "Some event for user 5");
        ctx.close();

//        BeanFactory beanFactory = new ClassPathXmlApplicationContext("spring.xml");
//        App app2 = beanFactory.getBean(App.class);
//        app2.logEvent("Some event for user 2");
    }

//    //Cached Event Logger
//    private static void logEvent(String msg) {
//        String message = msg.replaceAll(client.getId(), client.getFullName());
//        Event event = ctx.getBean(Event.class);
//        event.setMsg(message);
//        defaultEventLogger.logEvent(event);
//    }

    //INFO - Console Event Logger, ERROR - console & File Event Logger
    private void logEvent(EventType eventType, String msg) {
        String message = msg.replaceAll(client.getId(), client.getFullName());
        Event event = ctx.getBean(Event.class);
        event.setMsg(eventType.toString() + " " + message);

        EventLogger logger = loggers.get(eventType);
        if (logger == null) {
            logger = defaultEventLogger;
        }

        logger.logEvent(event);
    }
}