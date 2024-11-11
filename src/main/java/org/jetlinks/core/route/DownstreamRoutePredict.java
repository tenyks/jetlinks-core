package org.jetlinks.core.route;

import com.fasterxml.jackson.databind.JsonNode;
import org.jetlinks.core.message.DeviceMessage;

import javax.annotation.Nonnull;

/**
 * 消息路由判别器
 * @param <R>       路由类
 * @param <M>       消息类
 * @author v-lizy81
 * @version 1.0
 * @since 1.2
 */
public interface DownstreamRoutePredict<R extends Route, M extends DeviceMessage> {

    boolean isAcceptable(@Nonnull R route, @Nonnull M message, @Nonnull JsonNode encodedMsg);

    boolean isAcceptable(@Nonnull R route, @Nonnull M message);

}
