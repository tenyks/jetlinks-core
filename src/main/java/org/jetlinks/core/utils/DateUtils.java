package org.jetlinks.core.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author v-lizy81
 * @version 1.0.0
 * @date 2024/9/30
 * @since V3.1.0
 */
public class DateUtils {

    public static final SimpleDateFormat DF_YYMMDD12 = new SimpleDateFormat("yyMMddHHmmss");

    public static String    toYYMMDD12(Date at) {
        return DF_YYMMDD12.format(at);
    }

}
