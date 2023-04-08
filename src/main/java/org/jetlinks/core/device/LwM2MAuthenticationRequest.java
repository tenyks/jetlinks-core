package org.jetlinks.core.device;

import org.jetlinks.core.message.codec.DefaultTransport;
import org.jetlinks.core.message.codec.Transport;

/**
 * LwM2M协议的设备认证请求
 * @author v-lizy8
 * @date 2023/3/28
 */
public abstract class LwM2MAuthenticationRequest implements AuthenticationRequest {

    private String      endpoint;

    public LwM2MAuthenticationRequest(String endpoint) {
        this.endpoint = endpoint;
    }

    @Override
    public Transport getTransport() {
        return DefaultTransport.LwM2M;
    }

    public String getEndpoint() {
        return endpoint;
    }

    public void complete(boolean accepted) {

    }

    @Override
    public String toString() {
        return "LwM2MAuthenticationRequest{" +
                "endpoint='" + endpoint + '\'' +
                '}';
    }
}
