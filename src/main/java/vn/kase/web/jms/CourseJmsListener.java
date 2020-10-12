package vn.kase.web.jms;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

import vn.kase.jee.jms.pojo.CourseMessage;

public class CourseJmsListener implements MessageListener {
    private static final Logger LOGGER = Logger.getLogger(CourseJmsListener.class.getName());

    @Override
    public void onMessage(Message message) {
        try {
            ObjectMessage objectMessage = (ObjectMessage) message;
            CourseMessage course = (CourseMessage) objectMessage.getObject();
            LOGGER.info(course.getTitle());
        } catch (JMSException e) {
            LOGGER.log(Level.SEVERE, "Can't receive message", e);
        }
    }
    
}
