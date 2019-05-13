package spring.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.core.beans.Client;
import spring.core.beans.Event;
import spring.core.loggers.EventLogger;

public class App {
    private static Client client;
    private static EventLogger logger;

    private static ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");

    public App(Client client, EventLogger logger) {
        this.client = client;
        this.logger = logger;
    }

    public static void main(String[] args) {
        App app = (App) ctx.getBean("app");
        app.logEvent("Some event for user 1");
        app.logEvent("Some event for user 2");
        app.logEvent("Some event for user 3");
        app.logEvent("Some event for user 4");
        app.logEvent("Some event for user 5");
        ctx.close();

//        BeanFactory beanFactory = new ClassPathXmlApplicationContext("spring.xml");
//        App app2 = beanFactory.getBean(App.class);
//        app2.logEvent("Some event for user 2");
    }

    private static void logEvent(String msg) {
        String message = msg.replaceAll(client.getId(), client.getFullName());
        Event event = ctx.getBean(Event.class);
        event.setMsg(message);
        logger.logEvent(event);
    }
}