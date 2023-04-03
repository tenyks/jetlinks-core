package org.jetlinks.core.message.codec;

import org.jetlinks.core.metadata.ConfigMetadata;

import javax.annotation.Nullable;

/**
 * @see org.jetlinks.core.message.codec.mqtt.MqttMessageCodecDescription
 */
public interface MessageCodecDescription {

    String getDescription();

    @Nullable
    ConfigMetadata getConfigMetadata();

}
