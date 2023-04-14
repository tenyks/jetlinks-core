package org.jetlinks.core.device;

import org.jetlinks.core.message.codec.DefaultTransport;
import org.jetlinks.core.message.codec.Transport;

import java.security.PublicKey;
import java.util.Arrays;

/**
 * LwM2M协议的设备认证请求
 * @author v-lizy8
 * @date 2023/3/28
 */
public abstract class LwM2MAuthenticationRequest implements AuthenticationRequest {

    private String      endpoint;

    /**
     * PSK
     */
    private String identity;
    private byte[] preSharedKey;

    /**
     * RPK
     */
    private PublicKey rawPublicKey;

    /**
     * X.509
     */
    private final boolean useX509Cert;

    public LwM2MAuthenticationRequest(String endpoint) {
        this(endpoint, false);
    }

    public LwM2MAuthenticationRequest(String endpoint, String identity, byte[] preSharedKey) {
        this(endpoint, false);

        if (identity == null || preSharedKey == null) {
            throw new IllegalArgumentException("参数不全。[0x30LMAR4465]");
        }

        this.endpoint = endpoint;
        this.identity = identity;
        this.preSharedKey = preSharedKey;
    }

    public LwM2MAuthenticationRequest(String endpoint, PublicKey rawPublicKey) {
        this(endpoint, false);

        if (rawPublicKey == null) {
            throw new IllegalArgumentException("参数不全。[0x30LMAR4465]");
        }

        this.endpoint = endpoint;
        this.rawPublicKey = rawPublicKey;
    }

    public LwM2MAuthenticationRequest(String endpoint, boolean useX509Cert) {
        if (endpoint == null) {
            throw new IllegalArgumentException("参数不全。[0x30LMAR4465]");
        }

        this.endpoint = endpoint;
        this.useX509Cert = useX509Cert;
    }

    @Override
    public Transport getTransport() {
        return DefaultTransport.LwM2M;
    }

    public String getEndpoint() {
        return endpoint;
    }

    public String getIdentity() {
        return identity;
    }

    public byte[] getPreSharedKey() {
        return preSharedKey;
    }

    public PublicKey getRawPublicKey() {
        return rawPublicKey;
    }

    public boolean isUseX509Cert() {
        return useX509Cert;
    }

    @Override
    public String toString() {
        return "LwM2MAuthenticationRequest{" +
                "endpoint='" + endpoint + '\'' +
                ", identity='" + identity + '\'' +
                ", preSharedKey=" + Arrays.toString(preSharedKey) +
                ", rawPublicKey=" + rawPublicKey +
                ", useX509Cert=" + useX509Cert +
                '}';
    }
}
