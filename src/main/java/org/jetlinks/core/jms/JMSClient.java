package org.jetlinks.core.jms;

import javax.jms.JMSException;
import javax.jms.Message;

/**
 * @author Maxwell.Lee
 * @date 2018-12-11 19:04
 * @since 1.0.0
 */
public interface JMSClient {

    String getName();

    void commitTransaction() throws JMSException;

    void rollbackTransaction() throws JMSException;

    Message receive(String queue, long waitTime) throws JMSException;

    void send(String queue, String payload) throws JMSException;

    void send(String queue, Message msg) throws JMSException;

    void send(String queue, String queue2, Message msg) throws JMSException;

    void close();
}
