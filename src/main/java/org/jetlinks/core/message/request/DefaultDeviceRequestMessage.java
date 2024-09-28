package org.jetlinks.core.message.request;

import com.alibaba.fastjson.JSONObject;
import lombok.Getter;
import lombok.Setter;
import org.hswebframework.web.bean.FastBeanCopier;
import org.jetlinks.core.GenericHeaderSupport;
import org.jetlinks.core.message.function.FunctionParameter;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.ArrayList;
import java.util.List;

/**
 * @author v-lizy81
 * @version 1.0.0
 * @date 2024/9/28
 * @since V3.1.0
 */
@Getter
@Setter
public class DefaultDeviceRequestMessage
         extends GenericHeaderSupport<DefaultDeviceRequestMessage>
            implements DeviceRequestMessage<DefaultDeviceRequestMessageReply> {

    private static final long serialVersionUID = -3133405728058352463L;

    private String  messageId;

    private String  deviceId;

    private String  functionId;

    private long    timestamp = System.currentTimeMillis();

    private final List<FunctionParameter> inputs = new ArrayList<>();

    @Override
    public String getMessageId() {
        return messageId;
    }

    @Override
    public String getDeviceId() {
        return deviceId;
    }

    @Override
    public long getTimestamp() {
        return timestamp;
    }

    @Override
    public String getFunctionId() {
        return functionId;
    }

    @Override
    public List<FunctionParameter> getInputs() {
        return inputs;
    }

    public DefaultDeviceRequestMessage addInput(FunctionParameter parameter) {
        inputs.add(parameter);
        return this;
    }

    public DefaultDeviceRequestMessage functionId(String id) {
        this.functionId=id;
        return this;
    }

    @Override
    public DefaultDeviceRequestMessageReply newResponse() {
        return new DefaultDeviceRequestMessageReply().from(this);
    }

    public DefaultDeviceRequestMessage timestamp(long timestamp) {
        this.timestamp = timestamp;
        return castSelf();
    }


    public DefaultDeviceRequestMessage messageId(String messageId) {
        this.setMessageId(messageId);
        return castSelf();
    }

    @Override
    public JSONObject toJson() {
        JSONObject json = FastBeanCopier.copy(this, new JSONObject());
        json.put("messageType", getMessageType().name());
        return json;
    }

    @Override
    public void fromJson(JSONObject jsonObject) {
        FastBeanCopier.copy(jsonObject, this, "headers");
        if (timestamp == 0) {
            timestamp = System.currentTimeMillis();
        }
        JSONObject headers = jsonObject.getJSONObject("headers");
        if (null != headers) {
            headers.forEach(this::addHeader);
        }
    }

    @Override
    public String toString() {
        return toJson().toJSONString();
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {

    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {

    }
}
