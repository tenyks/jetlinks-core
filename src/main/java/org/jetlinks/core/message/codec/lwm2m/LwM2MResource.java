package org.jetlinks.core.message.codec.lwm2m;

public enum LwM2MResource {

    Register("/register", "设备注册"),
    RegisterUpdate("/register", "设备注册更新"),
    UnRegister("/register", "设备注销"),
    BinaryAppDataContainerReport("/19/0/0", "上报设备数据/上报设备事件"),
    BinaryAppDataContainerCommand("/19/1/1", "指令下发"),
    ;

    private String  path;

    private String  name;

    LwM2MResource(String path, String name) {
        this.path = path;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getPath() {
        return path;
    }
}
