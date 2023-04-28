package org.jetlinks.core.message.codec.lwm2m;

/**
 * 对应LwM2M协议的operation概念
 */
public enum LwM2MOperation {
    Read("GET"),
    Discover("GET"),
    Write("PUT"),
    WriteAttributes("PUT"),
    Execute("POST"),
    Create("POST"),
    Delete("DELETE");

    /**
     * 对应的CoAP协议的method属性
     */
    private String coapMethod;

    LwM2MOperation(String coapMethod) {
        this.coapMethod = coapMethod;
    }

    public String getCoapMethod() {
        return coapMethod;
    }
}
