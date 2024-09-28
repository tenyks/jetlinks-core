package org.jetlinks.core.message.request;

import org.jetlinks.core.message.Message;
import org.jetlinks.core.message.MessageType;
import org.jetlinks.core.message.function.FunctionParameter;

import java.util.List;

/**
 * @author v-lizy81
 * @version 1.0.0
 * @date 2024/9/28
 * @since V3.1.0
 */
public interface DeviceRequestMessage<R extends DeviceRequestMessageReply> extends Message {

    String      getDeviceId();

    long        getTimestamp();

    String      getFunctionId();

    List<FunctionParameter> getInputs();

    R           newResponse();

    default MessageType getMessageType() {
        return MessageType.DEVICE_REQUEST;
    }

}
