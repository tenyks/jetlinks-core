package org.jetlinks.core.message.extend;

import org.jetlinks.core.message.ThingMessage;

/**
 * 物模型消息赋能
 */
public class ThingMessageEnabler<T extends ThingMessage> {

    private ThingMessage    originalMsg;

    protected ThingMessageEnabler(T thingMessage) {
        this.originalMsg = thingMessage;
    }

    public static <T extends ThingMessage> ThingMessageEnabler<T> of(T thingMsg) {
        return new ThingMessageEnabler<>(thingMsg);
    }

}
