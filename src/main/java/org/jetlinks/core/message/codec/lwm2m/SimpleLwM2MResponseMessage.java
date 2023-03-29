package org.jetlinks.core.message.codec.lwm2m;

import io.netty.buffer.ByteBuf;

import javax.annotation.Nonnull;

/**
 * @author v-lizy8
 * @date 2023/3/27
 */
public class SimpleLwM2MResponseMessage implements LwM2MResponseMessage {
    @Nonnull
    @Override
    public ByteBuf getPayload() {
        return null;
    }

}
