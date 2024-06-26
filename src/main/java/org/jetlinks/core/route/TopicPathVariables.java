package org.jetlinks.core.route;

import java.io.Serializable;

/**
 * @author v-lizy81
 * @version 1.0.0
 * @date 2024/6/26
 * @since V3.1.0
 */
public class TopicPathVariables implements Serializable {

    private static final long serialVersionUID = -5002519572673384298L;

    /**
     * 设备厂家编码
     */
    private String  manufacturerCode;

    /**
     * 产品标识
     */
    private String    productId;

    /**
     * 设备标识
     */
    private String    deviceId;

    @Deprecated //仅用于反序列化
    public TopicPathVariables() {

    }

    public TopicPathVariables(String manufacturerCode, String productId, String deviceId) {
        this.manufacturerCode = manufacturerCode;
        this.productId = productId;
        this.deviceId = deviceId;
    }

    public String getManufacturerCode() {
        return manufacturerCode;
    }

    public String getProductId() {
        return productId;
    }

    public String getDeviceId() {
        return deviceId;
    }

    @Override
    public String toString() {
        return "TopicPathVariables{" +
                ", manufacturerCode='" + manufacturerCode + '\'' +
                ", productId='" + productId + '\'' +
                ", deviceId='" + deviceId + '\'' +
                '}';
    }
}
