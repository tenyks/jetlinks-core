package org.jetlinks.core.metadata;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 管理相关特性
 *
 * @author zhouhao
 * @since 1.1.8
 */
@AllArgsConstructor
@Getter
public enum ManagementFeature implements Feature {
    
    autoGenerateDeviceId("自动生成设备ID");

    private final String name;

    @Override
    public String getId() {
        return name();
    }

}
