package org.jetlinks.core.message;

public class DeviceOnlineMessage extends CommonDeviceMessage<DeviceOnlineMessage> {

    private static final long serialVersionUID = 424512074237766506L;

    public MessageType getMessageType() {
        return MessageType.ONLINE;
    }
}
