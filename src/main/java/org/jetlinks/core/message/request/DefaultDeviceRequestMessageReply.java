package org.jetlinks.core.message.request;

import com.alibaba.fastjson.JSONObject;
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

    private JSONObject outputs = new JSONObject();

    public DefaultDeviceRequestMessageReply from(DefaultDeviceRequestMessage message) {
        messageId(message.getMessageId());
        setDeviceId(message.getDeviceId());
        this.functionId = message.getFunctionId();

        return this;
    }

    public String getFunctionId() {
        return functionId;
    }

    @Override
    public DeviceRequestMessageReply functionId(String functionId) {
        this.functionId = functionId;
        return this;
    }

    public void setOutputs(JSONObject outputs) {
        this.outputs = outputs;
    }

    @Override
    public JSONObject getOutputs() {
        return outputs;
    }

    @Override
    public Object getOutput(String paramKey) {
        return (outputs != null ? outputs.get(paramKey) : null);
    }

    @Override
    public String getOutputStr(String paramKey) {
        return (outputs != null ? outputs.getString(paramKey) : null);
    }

    @Override
    public Integer getOutputInt(String paramKey) {
        return (outputs != null ? outputs.getInteger(paramKey) : null);
    }

    @Override
    public Number getOutputNum(String paramKey) {
        return (outputs != null ? (Number) outputs.get(paramKey) : null);
    }

    @Override
    public DeviceRequestMessageReply addOutput(String paramKey, Object paramVal) {
        if (outputs == null) outputs = new JSONObject();
        outputs.put(paramKey, paramVal);
        return this;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {

    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {

    }
}
