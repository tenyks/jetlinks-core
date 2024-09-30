package org.jetlinks.core.message.request;

import com.alibaba.fastjson.JSONObject;
import lombok.Getter;
import lombok.Setter;
import org.hswebframework.web.bean.FastBeanCopier;
import org.jetlinks.core.message.CommonDeviceMessage;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * @author v-lizy81
 * @version 1.0.0
 * @date 2024/9/28
 * @since V3.1.0
 */
@Getter
@Setter
public class DefaultDeviceRequestMessage
         extends CommonDeviceMessage<DefaultDeviceRequestMessage>
            implements DeviceRequestMessage<DefaultDeviceRequestMessageReply> {

    private static final long   serialVersionUID = -3133405728058352463L;

    private String              functionId;

    private final JSONObject    inputs = new JSONObject();

    @Override
    public String   getFunctionId() {
        return functionId;
    }

    @Override
    public Object   getInput(String key) {
        return inputs.get(key);
    }

    @Override
    public String getInputStr(String paramKey) {
        return inputs.getString(paramKey);
    }

    @Override
    public Integer getInputInt(String paramKey) {
        return inputs.getInteger(paramKey);
    }

    @Override
    public Number getInputNum(String paramKey) {
        return (Number) inputs.get(paramKey);
    }

    public DefaultDeviceRequestMessage addInput(String paramKey, Object paramVal) {
        inputs.put(paramKey, paramVal);
        return this;
    }

    public DefaultDeviceRequestMessage functionId(String id) {
        this.functionId = id;
        return this;
    }

    @Override
    public DefaultDeviceRequestMessageReply newResponse() {
        return new DefaultDeviceRequestMessageReply().from(this);
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

        if (getTimestamp() == 0) {
            super.timestamp(System.currentTimeMillis());
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
