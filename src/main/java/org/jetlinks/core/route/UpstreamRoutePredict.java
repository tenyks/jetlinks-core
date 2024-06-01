package org.jetlinks.core.route;

import com.alibaba.fastjson.JSONObject;
import org.jetlinks.core.message.codec.EncodedMessage;

import javax.annotation.Nullable;
import javax.validation.constraints.NotNull;

/**
 * 消息路由判别器
 * @param <R>       路由类
 * @param <M>       消息类
 * @author v-lizy81
 * @version 1.0
 * @since 1.2
 */
public interface UpstreamRoutePredict<R extends Route, M extends EncodedMessage> {

    boolean isAcceptable(@NotNull R route, @NotNull M message, @Nullable JSONObject parsedMsg);

}
