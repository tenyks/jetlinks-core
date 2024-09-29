package org.jetlinks.core.message.request;

import org.jetlinks.core.message.CommonDeviceMessageReply;

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
        extends CommonDeviceMessageReply<DefaultDeviceRequestMessageReply>
        implements DeviceRequestMessageReply {
    private static final long serialVersionUID = -217528289118813065L;

    private String  functionId;

    private Object  output;

    public DefaultDeviceRequestMessageReply from(DefaultDeviceRequestMessage message) {
        messageId(message.getMessageId());
        setDeviceId(message.getDeviceId());
        this.functionId = message.getFunctionId();

        return this;
    }

    public String getFunctionId() {
        return functionId;
    }

    public void setOutput(Object output) {
        this.output = output;
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
