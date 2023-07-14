package com.tutor.tutorbe.util;

import cn.hutool.core.lang.Snowflake;

import java.util.Objects;

public class IDUtil {

    private static Snowflake snowflake;

    public static String generateId() {
        if (Objects.isNull(snowflake)) {
            snowflake = SpringContext.getBean(Snowflake.class);
        }
        return snowflake.nextIdStr();
    }
}
