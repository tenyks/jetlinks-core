package org.jetlinks.core.route;

import org.jetlinks.core.message.codec.MessagePayloadType;
import org.jetlinks.core.message.codec.lwm2m.LwM2MOperation;

import javax.annotation.Nullable;
import javax.validation.constraints.NotNull;

public interface LwM2MRoute extends Route {

    /**
     * @return  LwM2M协议的operation
     */
    @NotNull
    LwM2MOperation  getOperation();

    /**
     * @return  LwM2M协议的URI
     */
    @NotNull
    String  getPath();

    /**
     * @return  返回消息负载的类型
     */
    @Nullable
    MessagePayloadType getPayloadType();

    /**
     * @return  上行消息（设备/网关 -> 服务器）
     */
    boolean isUpstream();

    /**
     * @return  下行消息（服务器 -> 设备/网关）
     */
    boolean isDownstream();

    @Override
    default String getAddress() {
        return getPath();
    }

    static LwM2MRoute.Builder builder(String path) {
        return DefaultLwM2MRoute.builder().path(path);
    }

    interface Builder {

        LwM2MRoute.Builder operation(LwM2MOperation operation);

        LwM2MRoute.Builder group(String group);

        LwM2MRoute.Builder path(String path);

        LwM2MRoute.Builder payloadType(MessagePayloadType type);

        LwM2MRoute.Builder downstream(boolean downstream);

        LwM2MRoute.Builder upstream(boolean downstream);

        LwM2MRoute.Builder description(String description);

        LwM2MRoute.Builder example(String example);

        LwM2MRoute build();
    }

}
