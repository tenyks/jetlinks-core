package org.jetlinks.core.message.codec.lwm2m;

import org.eclipse.californium.core.coap.Option;
import org.jetlinks.core.message.codec.EncodedMessage;

import javax.annotation.Nonnull;
import java.util.List;

/**
 * LwM2M协议的请求消息
 *
 * @author v-lizy8
 * @date 2023/3/27
 * @since 1.2
 */
public interface LwM2MRequestMessage extends EncodedMessage {

    @Nonnull
    String getPath();

    @Nonnull
    List<Option> getOptions();



}
