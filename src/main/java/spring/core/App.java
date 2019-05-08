package spring.core;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.BeanFactory;
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

//        BeanFactory beanFactory = new ClassPathXmlApplicationContext("spring.xml");
//        App app2 = beanFactory.getBean(App.class);
//        app2.logEvent("Some event for user 2");
    }

    private void logEvent(String msg) {
        String message = msg.replaceAll(client.getId(), client.getFullName());
        logger.logEvent(message);
    }
}