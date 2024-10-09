package org.jetlinks.core.utils;

import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * @author v-lizy81
 * @version 1.0.0
 * @date 2024/10/9
 * @since V3.1.0
 */
public class DebugHelper {

    public static String moreInfoOfJSON(String jsonStr) {
        if (StringUtils.isEmpty(jsonStr)) return null;

        JSONObject obj = JSONObject.parseObject(jsonStr);

        return null;
    }

}
