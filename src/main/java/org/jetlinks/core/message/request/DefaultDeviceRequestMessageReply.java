package org.jetlinks.core.message.request;

import org.jetlinks.core.GenericHeaderSupport;
import org.jetlinks.core.message.Message;
import org.jetlinks.core.message.ThingMessage;

import javax.annotation.Nullable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * @author v-lizy81
 * @version 1.0.0
 * @date 2024/9/28
 * @since V3.1.0
 */
public class DefaultDeviceRequestMessageReply
        extends GenericHeaderSupport<DefaultDeviceRequestMessage>
        implements DeviceRequestMessageReply {
    private static final long serialVersionUID = -217528289118813065L;

    private String  messageId;

    private String  deviceId;

    private String  functionId;

    private long    timestamp = System.currentTimeMillis();

    private String  code;

    private Object  output;

    @Override
    public String getMessageId() {
        return messageId;
    }

    @Override
    public String getDeviceId() {
        return deviceId;
    }

    @Override
    public long getTimestamp() {
        return timestamp;
    }

    public DefaultDeviceRequestMessageReply from(DefaultDeviceRequestMessage message) {
        this.messageId = message.getMessageId();
        this.deviceId = message.getDeviceId();
        this.functionId = message.getFunctionId();

        return this;
    }

    @Override
    public boolean isSuccess() {
        return (code != null && (code.equals("SUCCESS") || code.startsWith("SUCCESS")));
    }

    @Nullable
    @Override
    public String getCode() {
        return code;
    }

    @Override
    public Object getOutput() {
        return output;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {

    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {

    }
}
