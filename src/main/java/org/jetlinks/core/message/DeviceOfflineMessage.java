package org.jetlinks.core.message;

import java.io.IOException;
import java.io.ObjectOutput;

public class DeviceOfflineMessage extends CommonDeviceMessage<DeviceOfflineMessage>{
    public MessageType getMessageType() {
        return MessageType.OFFLINE;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {

    }
}
