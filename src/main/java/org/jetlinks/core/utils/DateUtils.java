package org.jetlinks.core.utils;

import org.springframework.util.StringUtils;

import java.text.ParseException;
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
    public static final SimpleDateFormat DF_YYYYMMDDHHmmss19 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static String    toYYMMDD12(Date at) {
        return DF_YYMMDD12.format(at);
    }

    public static Date fromYYYYMMDDHHmmss19(String dateStr) {
        if (StringUtils.isEmpty(dateStr)) return null;

        try {
            return DF_YYYYMMDDHHmmss19.parse(dateStr);
        } catch (ParseException e) {
            throw new IllegalArgumentException(e);
        }
    }

}
