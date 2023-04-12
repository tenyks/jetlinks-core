package org.jetlinks.core.route;

import org.jetlinks.core.message.codec.lwm2m.LwM2MResource;

/**
 * @see HttpRoute
 * @see MqttRoute
 * @see LwM2MRoute
 */
public interface Route {
    /**
     * @return 分组
     */
    String getGroup();

    /**
     * @return 地址
     */
    String getAddress();

    /**
     * @return 说明
     */
    String getDescription();

    /**
     * @return 示例
     */
    String getExample();

    static MqttRoute.Builder mqtt(String topic) {
        return MqttRoute.builder(topic);
    }

    static HttpRoute.Builder http(String address) {
        return HttpRoute.builder().address(address);
    }

    static LwM2MRoute.Builder lwm2m(LwM2MResource resource) { return LwM2MRoute.builder(resource); }
}
