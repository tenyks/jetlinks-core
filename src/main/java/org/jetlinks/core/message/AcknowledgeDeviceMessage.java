package org.jetlinks.core.message;

import com.alibaba.fastjson.JSONObject;
import org.jetlinks.core.message.request.DeviceRequestMessageReply;

/**
 * 应答消息,通常用于发送非可回复消息后的应答
 *
 * @author zhouhao
 * @since 1.1.5
 */
public class AcknowledgeDeviceMessage extends CommonDeviceMessageReply<AcknowledgeDeviceMessage> {

    private static final long serialVersionUID = 4294426604248260950L;

    private String   functionId;

    private JSONObject outputs;

    @Override
    public String getServiceId() {
        return functionId;
    }

    public String getFunctionId() {
        return functionId;
    }

    public void setFunctionId(String functionId) {
        this.functionId = functionId;
    }

    @Override
    public MessageType getMessageType() {
        return MessageType.ACKNOWLEDGE;
    }

    public JSONObject getOutputs() {
        return outputs;
    }

    public void setOutputs(JSONObject output) {
        this.outputs = output;
    }

    public Object getOutput(String paramKey) {
        return (outputs != null ? outputs.get(paramKey) : null);
    }

    public String getOutputStr(String paramKey) {
        return (outputs != null ? outputs.getString(paramKey) : null);
    }

    public Integer getOutputInt(String paramKey) {
        return (outputs != null ? outputs.getInteger(paramKey) : null);
    }

    public Number getOutputNum(String paramKey) {
        return (outputs != null ? (Number) outputs.get(paramKey) : null);
    }

    public AcknowledgeDeviceMessage addOutput(String paramKey, Object paramVal) {
        if (outputs == null) outputs = new JSONObject();
        outputs.put(paramKey, paramVal);
        return this;
    }
}
