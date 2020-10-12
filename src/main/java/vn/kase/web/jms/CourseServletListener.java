package vn.kase.web.jms;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Logger;

import javax.jms.Connection;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.Topic;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.apache.activemq.ActiveMQConnectionFactory;

@WebListener
public class CourseServletListener implements ServletContextListener {
    private static final Logger LOGGER = Logger.getLogger(CourseServletListener.class.getName());
    private static final String DESTINATION_KEY = "course-jms-listner";

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        String value = (String) sce.getServletContext().getAttribute(DESTINATION_KEY);
        if (value != null && !"".equals(value.trim())) {
            return;
        }
        sce.getServletContext().setAttribute(DESTINATION_KEY, "INITIALIZED");

        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.execute(() -> {
            try {
                ActiveMQConnectionFactory cf = new ActiveMQConnectionFactory("tcp://localhost:61616");
                cf.setTrustAllPackages(true);

                Connection connection = cf.createConnection();
                Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

                Topic topic = session.createTopic("courseTopic");

                MessageConsumer consumer = session.createConsumer(topic);
                consumer.setMessageListener(new CourseJmsListener());

                connection.start();
                LOGGER.info("Initalized JMS");
            } catch (JMSException e) {
                throw new RuntimeException("Can't init messaging", e);
            }
        });
    }
}
