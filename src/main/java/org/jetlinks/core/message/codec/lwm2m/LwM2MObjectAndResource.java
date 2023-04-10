package org.jetlinks.core.message.codec.lwm2m;

public enum LwM2MObjectAndResource {

    Register("设备注册"),
    RegisterUpdate("设备注册更新"),
    UnRegister("设备注销"),
    BinaryAppDataContainerReport("上报设备数据/上报设备事件"),
    BinaryAppDataContainerCommand("指令下发"),
    ;

    private String  name;

    LwM2MObjectAndResource(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
