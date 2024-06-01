package org.jetlinks.core.message.codec.lwm2m;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;
import org.eclipse.californium.core.coap.Option;
import org.jetlinks.core.message.codec.MessagePayloadType;
import org.jetlinks.core.utils.BytesUtils;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;

public abstract class AbstractLwM2MMessage implements LwM2MMessage {

    private String registrationId;

    private Integer messageId;

    private List<Option>    options;

    private String deviceId;

    private ByteBuf payload;

    private MessagePayloadType payloadType;

    private String path;

    private Integer responseCode;

    private LwM2MOperation  requestOperation;

    private Map<String, String> additionalAttributes;

    /**
     * @return  获取负载的原始字符串，如果是TLV只返回第一个字段的
     */
    public ByteBuf  getOriginalBytesOfPayloadFirstTLV() throws DecoderException {
        if (MessagePayloadType.BINARY.equals(payloadType)) return payload;
        if (MessagePayloadType.STRING.equals(payloadType)) return payload;
        if (MessagePayloadType.JSON.equals(payloadType)) return payload;

        if (MessagePayloadType.HEX.equals(payloadType)) {
            payload.resetReaderIndex();
            return BytesUtils.decodeHex(payload, 0, payload.readableBytes());
        }
        if (MessagePayloadType.TLV.equals(payloadType)) {
            payload.readerIndex(1);
            byte length = payload.readByte();
            return BytesUtils.decodeHex(payload, 1, length);
        }

        return payload;
    }

    @Nonnull
    @Override
    public String getRegistrationId() {
        return registrationId;
    }

    public void setRegistrationId(String registrationId) {
        this.registrationId = registrationId;
    }

    @Override
    public Integer getMessageId() {
        return messageId;
    }

    public void setMessageId(Integer messageId) {
        this.messageId = messageId;
    }

    @Override
    public List<Option> getOptions() {
        return options;
    }

    public void setOptions(List<Option> options) {
        this.options = options;
    }

    @Override
    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    @Nonnull
    @Override
    public ByteBuf getPayload() {
        return payload;
    }

    public void setPayload(ByteBuf payload) {
        this.payload = payload;
    }

    @Nullable
    @Override
    public MessagePayloadType getPayloadType() {
        return payloadType;
    }

    public void setPayloadType(MessagePayloadType payloadType) {
        this.payloadType = payloadType;
    }

    @Override
    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public Integer getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(Integer responseCode) {
        this.responseCode = responseCode;
    }

    @Override
    public LwM2MOperation getRequestOperation() {
        return requestOperation;
    }

    public void setRequestOperation(LwM2MOperation requestOperation) {
        this.requestOperation = requestOperation;
    }

    @Override
    public Map<String, String> getAdditionalAttributes() {
        return additionalAttributes;
    }

    public void setAdditionalAttributes(Map<String, String> additionalAttributes) {
        this.additionalAttributes = additionalAttributes;
    }

    @Override
    public String toString() {
        return "AbstractLwM2MMessage{" +
                "registrationId='" + registrationId + '\'' +
                ", messageId=" + messageId +
                ", options=" + options +
                ", deviceId='" + deviceId + '\'' +
                ", payload=" + payload +
                ", payloadType=" + payloadType +
                ", path='" + path + '\'' +
                ", responseCode=" + responseCode +
                ", requestOperation=" + requestOperation +
                ", additionalAttributes=" + additionalAttributes +
                '}';
    }
}
