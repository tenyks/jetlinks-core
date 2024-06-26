package org.jetlinks.core.route;

import java.util.ArrayList;
import java.util.List;

/**
 * MQTT主题的模板，表示具体主题的合集
 *
 * @author v-lizy81
 * @version 1.0.0
 * @date 2024/6/26
 * @since V3.1.0
 */
public class TemplateTopic {
    private final String    templateUri;

    /**
     * 当pattern=1时，prefix/.../{manufacturerCode}/.../{productId}/.../{deviceId}/.../postfix
     */
    private final int       pattern;

    private final String[]  templateParts;

    /**
     * +或{}占位符的偏移量
     */
    private final List<Integer> placeHolderOffsets;

    /**
     * @param templateUri      支持MQTT V3.1的格式，（必要）
     * @param pattern          参数相应属性的定义
     */
    public TemplateTopic(String templateUri, int pattern) {
        this.templateUri = templateUri;
        this.pattern = pattern;
        this.templateParts = templateUri.split("/");
        this.placeHolderOffsets = new ArrayList<>();
        for (int i = 0; i < templateParts.length; i++) {
            String tmp = templateParts[i];

            //TODO 优化实现
            if (tmp.equals("+")) {
                placeHolderOffsets.add(i);
            }
        }
    }

    public String   concreteTopic(String manufacturerCode, String productId, String deviceId) {
        if (pattern != 1) return templateUri;

        String rst = templateUri;

        if (manufacturerCode != null) {
            rst = rst.replaceFirst("/\\+", "/" + manufacturerCode);
        }
        if (productId != null) {
            rst = rst.replaceFirst("/\\+", "/" + productId);
        }
        if (deviceId != null) {
            rst = rst.replaceFirst("/\\+", "/" + deviceId);
        }

        return rst;
    }

    public TopicPathVariables parse(String topicUri) {
        String[] parts = topicUri.split("/");

        int alignIdx = -1;
        String alignFor = parts[0];

        for (int i = 0; i < templateParts.length; i++) {
            if (alignFor.equals(templateParts[i])) {
                alignIdx = i;
            }
        }
        if (alignIdx < 0) return null;
        if (alignIdx + parts.length != templateParts.length) return null;

        if (pattern == 1) {
            return new TopicPathVariables(
                    parts[placeHolderOffsets.get(0) - alignIdx],
                    parts[placeHolderOffsets.get(1) - alignIdx],
                    parts[placeHolderOffsets.get(2) - alignIdx]
            );
        }

        return null;
    }
}
