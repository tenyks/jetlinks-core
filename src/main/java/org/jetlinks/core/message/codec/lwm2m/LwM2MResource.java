package org.jetlinks.core.message.codec.lwm2m;

import org.springframework.util.StringUtils;

/**
 * 收录LwM2M协议的约定的资源
 */
public class LwM2MResource {

    public static final LwM2MResource BinaryAppDataContainerReport =
            new LwM2MResource(19, 0, 0, "上报设备数据/上报设备事件");
    public static final LwM2MResource BinaryAppDataContainerCommand =
            new LwM2MResource(19, 1, 0, "指令下发");

    private String  path;

    private String  name;

    private Integer     objectId;

    private Integer     objectInstanceId;

    private Integer     resourceId;

    private Integer     resourceInstanceId;

    private LwM2MResource(Integer objectId, Integer objectInstanceId, Integer resourceId, String name) {
        this.path = String.format("/%d/%d/%d", objectId, objectInstanceId, resourceId);
        this.objectId = objectId;
        this.objectInstanceId = objectInstanceId;
        this.resourceId = resourceId;
        this.name = name;
    }

    private LwM2MResource(Integer objectId, Integer objectInstanceId, Integer resourceId, Integer resourceInstanceId, String name) {
        this.path = String.format("/%d/%d/%d", objectId, objectInstanceId, resourceId);
        this.objectId = objectId;
        this.objectInstanceId = objectInstanceId;
        this.resourceId = resourceId;
        this.resourceInstanceId = resourceInstanceId;
        this.name = name;
    }

    public static LwM2MResource parse(String path) {
        String[] parts = path.split("/");

        if (parts.length == 0 || parts.length == 1) return null;
        if (parts.length == 2) {
            return new LwM2MResource(tryParseInt(parts[1]), null, null, null, path);
        }
        if (parts.length == 3) {
            return new LwM2MResource(tryParseInt(parts[1]), tryParseInt(parts[2]), null, null, path);
        }
        if(parts.length == 4){
            return new LwM2MResource(tryParseInt(parts[1]), tryParseInt(parts[2]), tryParseInt(parts[3]), null, path);
        }

        return new LwM2MResource(tryParseInt(parts[1]), tryParseInt(parts[2]), tryParseInt(parts[3]), tryParseInt(parts[4]), path);
    }

    private static Integer tryParseInt(String val) {
        return StringUtils.isEmpty(val) ? null : Integer.valueOf(val);
    }

    public String getName() {
        return name;
    }

    public String getPath() {
        return path;
    }

    public Integer getObjectId() {
        return objectId;
    }

    public Integer getObjectInstanceId() {
        return objectInstanceId;
    }

    public Integer getResourceId() {
        return resourceId;
    }

    public Integer getResourceInstanceId() {
        return resourceInstanceId;
    }

}
