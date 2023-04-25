package org.jetlinks.core.message.codec.lwm2m;

public enum LwM2MResource {

    Register("/register", "设备注册", 0),
    RegisterUpdate("/register", "设备注册更新", 0),
    UnRegister("/deregister", "设备注销", 0),
    BinaryAppDataContainerReport("/19/0/0", "上报设备数据/上报设备事件", 1),
    BinaryAppDataContainerReportRoot("/19/0", "上报设备数据/上报设备事件", 1),
    BinaryAppDataContainerCommand("/19/1/0", "指令下发", 2),
    ;

    private String  path;

    private String  name;

    private int     code;

    LwM2MResource(String path, String name, int code) {
        this.path = path;
        this.name = name;
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public String getPath() {
        return path;
    }

    public int getCode() {
        return code;
    }

    public boolean codeOfObservation() {
        return code == 1;
    }

    public boolean codeOfExecute() {
        return code == 2;
    }
}
