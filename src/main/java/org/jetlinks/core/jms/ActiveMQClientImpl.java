package org.jetlinks.core.jms;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQTextMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import javax.jms.*;

/**
 * @author Maxwell.Lee
 * @date 2018-12-11 19:10
 * @since 1.0.0
 */
public class ActiveMQClientImpl implements JMSClient {

    private static final Logger log = LoggerFactory.getLogger(ActiveMQClientImpl.class);

    private String name;

    private Connection connection;

    private Session session;

    private MessageConsumer consumer;

    private MessageProducer producer;

    private MessageProducer producer2;

    public ActiveMQClientImpl(String name, String url) throws JMSException {
        this.name = name;

        ActiveMQConnectionFactory cf = new ActiveMQConnectionFactory(url);
        cf.setAlwaysSessionAsync(false);
        cf.setAlwaysSyncSend(true);

        Connection connection = cf.createConnection();
        connection.start();

        this.connection = connection;
        this.session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);
    }

    public ActiveMQClientImpl(String name, String url, String username, String password) throws JMSException {
        this.name = name;

        ActiveMQConnectionFactory cf = new ActiveMQConnectionFactory(url);
        cf.setAlwaysSessionAsync(false);
        cf.setAlwaysSyncSend(true);
        if (!StringUtils.isEmpty(username)) {
            cf.setUserName(username);
            if (!StringUtils.isEmpty(password)) {
                cf.setPassword(password);
            }
        }

        Connection connection = cf.createConnection();
        connection.start();

        this.connection = connection;
        this.session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void commitTransaction() throws JMSException {
        this.session.commit();
    }

    @Override
    public void rollbackTransaction() throws JMSException {
        this.session.rollback();
    }

    @Override
    public Message receive(String queue, long waitTime) throws JMSException {
        if (consumer == null) {
            Destination destination = session.createQueue(queue);
            consumer = session.createConsumer(destination);
        }

        Message msg = consumer.receive(waitTime);
//        consumer.close();

        return msg;
    }

    @Override
    public void send(String queue, String payload) throws JMSException {
        TextMessage msg = new ActiveMQTextMessage();
        msg.setText(payload);

        send(queue, msg);
    }

    @Override
    public void send(String queue, Message msg) throws JMSException {
        if (msg == null) return ;

        if (producer == null) {
            Destination destination = session.createQueue(queue);
            producer = session.createProducer(destination);
        }

        producer.send(msg);
//        producer.close();
    }

    @Override
    public void send(String queue, String queue2, Message msg) throws JMSException {
        if (msg == null) return ;

        if (producer == null) {
            Destination destination = session.createQueue(queue);
            producer = session.createProducer(destination);
        }
        producer.send(msg);

        if (producer2 == null) {
            Destination destination = session.createQueue(queue2);
            producer2 = session.createProducer(destination);
        }
        producer2.send(msg);
    }

    @Override
    public void close() {
        if (session != null) {
            try {
                session.close();
            } catch (JMSException e) {
                log.error("[0x09AMQCI10337]关闭Session时异常失败：", e);
            }
            session = null;
        }

        if (this.connection != null) {
            try {
                this.connection.close();
            } catch (JMSException e) {
                log.error("[0x09AMQCI11137]关闭Connection时异常失败：", e);
            }
            this.connection = null;
        }
    }

    @Override
    public String toString() {
        return "ActiveMQClientImpl{" +
                "name='" + name + '\'' +
                ", connection=" + connection +
                '}';
    }
}
