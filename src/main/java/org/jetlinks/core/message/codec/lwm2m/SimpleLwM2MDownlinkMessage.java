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
public class SimpleLwM2MDownlinkMessage implements LwM2MDownlinkMessage {
    @Nonnull
    @Override
    public ByteBuf getPayload() {
        return null;
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
        return null;
    }

    @Nonnull
    @Override
    public int getMessageId() {
        return 0;
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
}
