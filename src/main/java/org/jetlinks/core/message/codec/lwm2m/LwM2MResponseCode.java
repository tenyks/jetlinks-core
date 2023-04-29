package org.jetlinks.core.message.codec.lwm2m;

/**
 * LwM2M协议的响应编码
 */
public enum LwM2MResponseCode {
    CREATED(201, "CREATED"),
    DELETED_CODE(202, "DELETED_CODE"),
    CHANGED_CODE(201, "CREATED")
    ;

    private int     code;

    private String  name;

    LwM2MResponseCode(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
}
