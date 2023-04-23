package org.jetlinks.core;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * 一套或设备消息数据协议的全集
 *
 * @author zhouhao
 * @since 1.0.0
 */
public interface ProtocolSupports {

    /**
     * 是否支持支持指定的协议
     * @param protocol      协议编码或协议标识，（必要）；
     * @return  如果包含返回true
     */
    boolean isSupport(String protocol);

    /**
     *
     * @param protocol      协议编码或协议标识，（必要）；
     * @return  获取协议实例
     */
    Mono<ProtocolSupport> getProtocol(String protocol);

    /**
     * @return  遍历流
     */
    Flux<ProtocolSupport> getProtocols();
}
