package org.jetlinks.core.message;

import com.alibaba.fastjson.JSONObject;

/**
 * 应答消息,通常用于发送非可回复消息后的应答
 *
 * @author zhouhao
 * @since 1.1.5
 */
public class AcknowledgeDeviceMessage extends CommonDeviceMessageReply<AcknowledgeDeviceMessage> {

    private static final long serialVersionUID = 4294426604248260950L;

    private JSONObject  extraParams;

    @Override
    public MessageType getMessageType() {
        return MessageType.ACKNOWLEDGE;
    }

    public JSONObject getExtraParams() {
        return extraParams;
    }

    public void setExtraParams(JSONObject extraParams) {
        this.extraParams = extraParams;
    }
}
