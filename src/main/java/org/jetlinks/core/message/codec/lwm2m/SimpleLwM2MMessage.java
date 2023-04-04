package org.jetlinks.core.message.codec.lwm2m;

import io.netty.buffer.ByteBuf;
import org.eclipse.californium.core.coap.Option;

import javax.annotation.Nonnull;
import java.util.List;

/**
 * @author v-lizy8
 * @date 2023/3/27
 */
public class SimpleLwM2MMessage implements LwM2MMessage {
    @Nonnull
    @Override
    public ByteBuf getPayload() {
        return null;
    }

    @Nonnull
    @Override
    public String getPath() {
        return null;
    }

    @Nonnull
    @Override
    public List<Option> getOptions() {
        return null;
    }
}
