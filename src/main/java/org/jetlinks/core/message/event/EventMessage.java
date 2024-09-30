package org.jetlinks.core.message.event;

import lombok.Getter;
import lombok.Setter;
import org.jetlinks.core.message.CommonDeviceMessage;
import org.jetlinks.core.message.MessageType;

/**
 * 设备事件消息
 *
 * @author zhouhao
 * @since 1.0.0
 */
@Getter
@Setter
public class EventMessage extends CommonDeviceMessage<EventMessage> implements ThingEventMessage {

    private static final long serialVersionUID = 4765209086341790135L;

    private String event;

    private Object data;

    public MessageType getMessageType() {
        return MessageType.EVENT;
    }

    @Override
    public EventMessage event(String event) {
        this.event = event;
        return this;
    }

    @Override
    public EventMessage data(Object data) {
        this.data = data;
        return this;
    }
}
