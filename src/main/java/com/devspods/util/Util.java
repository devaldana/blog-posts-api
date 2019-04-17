package com.devspods.util;

import java.util.Objects;

public final class Util {

    public static boolean isNull(Object... objects) {
        if(Objects.isNull(objects)) return true;
        for(Object object: objects) if(Objects.isNull(object)) return true;
        return false;
    }

    public static boolean notNulls(Object... objects) {
        return !isNull(objects);
    }
}
