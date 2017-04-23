package me.tony.practice.amq;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.jms.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by tony on 2017/4/18.
 */
public class MainTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(MainTest.class);

    protected static String getVirtualTopicName() {
        return "VirtualTopic.haha";
    }

    protected static String getVirtualTopicConsumerNameA() {
        return "Consumer.fuck1.VirtualTopic.haha";
    }

    protected static String getVirtualTopicConsumerNameB() {
        return "Consumer.fuck2.VirtualTopic.haha";
    }

    @Test
    public void test() {
        try {

            ActiveMQConnectionFactory factoryA = new ActiveMQConnectionFactory(
                    "tcp://127.0.0.1:61616");

            Queue queueA = new ActiveMQQueue(getVirtualTopicConsumerNameA());
            Queue queueB = new ActiveMQQueue(getVirtualTopicConsumerNameB());
            ActiveMQConnection conn = (ActiveMQConnection) factoryA.createConnection();
            conn.start();
            Session session = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);

            MessageConsumer consumer1 = session.createConsumer(queueA);
            MessageConsumer consumer2 = session.createConsumer(queueA);
            MessageConsumer consumer3 = session.createConsumer(queueB);
            MessageConsumer consumer4 = session.createConsumer(queueB);
            final AtomicInteger aint1 = new AtomicInteger(0);
            MessageListener listenerA = message -> {
                try {
                    LOGGER.info("{} => receive from {}: {}", aint1.incrementAndGet(), getVirtualTopicConsumerNameA(), message);
                } catch (Exception e) {
                    LOGGER.error("error", e);
                }
            };
            consumer1.setMessageListener(listenerA);
            consumer2.setMessageListener(listenerA);
            final AtomicInteger aint2 = new AtomicInteger(0);
            MessageListener listenerB = message -> {
                try {
                    LOGGER.info("{} => receive from {}: {}", aint2.incrementAndGet(), getVirtualTopicConsumerNameA(), message);
                } catch (Exception e) {
                    LOGGER.error("error", e);
                }
            };
            consumer3.setMessageListener(listenerB);
            consumer4.setMessageListener(listenerB);

            MessageProducer producer = session.createProducer(new ActiveMQTopic(getVirtualTopicName()));
            int index = 0;
            while (index++ < 100) {
                TextMessage message = session.createTextMessage(index + " message.");
                producer.send(message);
            }

        } catch (Exception e) {
            LOGGER.error("error", e);
        }
    }
}
