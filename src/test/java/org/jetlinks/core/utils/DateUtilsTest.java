package org.jetlinks.core.utils;

import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

public class DateUtilsTest {

    @Test
    public void toYYMMDD12() {
        String rst = DateUtils.toYYMMDD12(new Date());
        System.out.println(rst);
    }
}