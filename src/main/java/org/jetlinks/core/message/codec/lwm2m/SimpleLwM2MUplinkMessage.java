package org.jetlinks.core.message.codec.lwm2m;

import io.netty.buffer.ByteBuf;
import org.eclipse.californium.core.coap.Option;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;
import java.util.Map;

/**
 * @author v-lizy8
 * @date 2023/3/27
 */
public class SimpleLwM2MUplinkMessage implements LwM2MUplinkMessage {

    private LwM2MResource   resource;

    private ByteBuf     payload;

    private String      registrationId;

    private int         messageId;

    @Override
    public LwM2MResource getObjectAndResource() {
        return resource;
    }

    @Nonnull
    @Override
    public ByteBuf getPayload() {
        return payload;
    }

    @Override
    public int getCode() {
        return 0;
    }

    @Nullable
    @Override
    public String getPath() {
        return null;
    }

    @Nonnull
    @Override
    public String getRegistrationId() {
        return registrationId;
    }

    @Nonnull
    @Override
    public int getMessageId() {
        return messageId;
    }

    @Nonnull
    @Override
    public Map<String, String> getAdditionalAttributes() {
        return null;
    }

    @Nonnull
    @Override
    public List<Option> getOptions() {
        return null;
    }

    public void setResource(LwM2MResource resource) {
        this.resource = resource;
    }

    public void setPayload(ByteBuf payload) {
        this.payload = payload;
    }

    public void setRegistrationId(String registrationId) {
        this.registrationId = registrationId;
    }

    public void setMessageId(int messageId) {
        this.messageId = messageId;
    }

    @Override
    public String toString() {
        return "SimpleLwM2MUplinkMessage{" +
                "resource=" + resource +
                ", payload=" + payload +
                ", registrationId='" + registrationId + '\'' +
                ", messageId=" + messageId +
                '}';
    }
}
