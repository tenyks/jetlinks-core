package org.jetlinks.core.message.request;

import com.alibaba.fastjson.JSONObject;
import org.jetlinks.core.message.Message;
import org.jetlinks.core.message.MessageType;

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

    DeviceRequestMessage<R> functionId(String functionId);

    JSONObject  getInputs();

    void        setInputs(JSONObject inputs);

    Object      getInput(String paramKey);

    String      getInputStr(String paramKey);

    Integer     getInputInt(String paramKey);

    Number      getInputNum(String paramKey);

    DeviceRequestMessage<R> addInput(String paramKey, Object paramVal);

    R           newResponse();

    default MessageType getMessageType() {
        return MessageType.DEVICE_REQUEST;
    }

}
