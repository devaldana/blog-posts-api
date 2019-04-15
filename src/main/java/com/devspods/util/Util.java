package com.devspods.util;

public final class Util {

    public static boolean isNull(Object... objects) {
        if(isNull(objects)) return true;
        for(Object object: objects) if(isNull(object)) return true;
        return false;
    }

    public static boolean notNulls(Object... objects) {
        return !isNull(objects);
    }

    public static boolean isNull(Object object){
        return object == null;
    }
}
