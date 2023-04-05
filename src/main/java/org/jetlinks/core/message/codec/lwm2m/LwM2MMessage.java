package org.jetlinks.core.message.codec.lwm2m;

import org.eclipse.californium.core.coap.Option;
import org.jetlinks.core.message.codec.EncodedMessage;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;
import java.util.Map;

/**
 * LwM2M协议消息
 *
 * @author 李仲允
 * @date 2023/4/5 22:36
 */
public interface LwM2MMessage extends EncodedMessage {

    int         getCode();

    @Nullable
    String      getPath();

    @Nonnull
    String      getRegistrationId();

    @Nonnull
    int         getMessageId();

    @Nonnull
    Map<String, String> getAdditionalAttributes();

    @Nonnull
    List<Option> getOptions();

}
