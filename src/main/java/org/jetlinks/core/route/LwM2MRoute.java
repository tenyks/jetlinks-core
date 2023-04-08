package org.jetlinks.core.route;

public interface LwM2MRoute extends Route {

    /**
     * @return  LwM2M协议的URI
     */
    String  getPath();

    /**
     * @return  数据协议约定的消息类型
     */
    String getMessageType();

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

        LwM2MRoute.Builder group(String group);

        LwM2MRoute.Builder path(String path);

        LwM2MRoute.Builder messageType(String msgType);

        LwM2MRoute.Builder downstream(boolean downstream);

        LwM2MRoute.Builder upstream(boolean downstream);

        LwM2MRoute.Builder description(String description);

        LwM2MRoute.Builder example(String example);

        LwM2MRoute build();
    }

}
