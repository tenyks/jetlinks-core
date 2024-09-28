package org.jetlinks.core.message.request;

import org.jetlinks.core.message.Message;
import org.jetlinks.core.message.MessageType;

import javax.annotation.Nullable;

/**
 * @author v-lizy81
 * @version 1.0.0
 * @date 2024/9/28
 * @since V3.1.0
 */
public interface DeviceRequestMessageReply extends Message {

    String getDeviceId();

    long getTimestamp();

    //是否成功
    boolean isSuccess();

    //业务码,具体由设备定义
    @Nullable
    String getCode();

    /**
     * 功能调用响应结果.
     *
     * @return 响应结果
     */
    Object getOutput();

    default MessageType getMessageType() {
        return MessageType.DEVICE_REQUEST_REPLY;
    }

}
