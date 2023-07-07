package org.jetlinks.core.jms;

import org.junit.Before;
import org.junit.Test;

import javax.jms.JMSException;

public class ActiveMQClientImplTest {

    private JMSClient client;

    @Before
    public void init() {
        client = new ActiveMQClientImpl("iot-client", "tcp://MyDevS1:61616");
    }

    @Test
    public void send() throws JMSException {
        String payload = "{\"key1\":1234}";
        client.send("/demo/device1", payload);
        client.commitTransaction();
    }
}