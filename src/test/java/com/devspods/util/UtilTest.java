package com.devspods.util;

import org.junit.jupiter.api.Test;

import static com.devspods.util.Util.isNull;
import static com.devspods.util.Util.notNulls;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UtilTest {

    @Test
    public void validatingNulls(){
        // isNull method
        assertTrue(isNull(null));
        assertTrue(isNull(null, new Object()));
        assertFalse(isNull(new Object()));
        assertFalse(isNull(new Object(), new Object()));
        assertTrue(isNull(new Object(), new Object(), null));

        // notNulls method
        assertFalse(notNulls(null));
        assertFalse(notNulls(null, new Object()));
        assertTrue(notNulls(new Object()));
        assertTrue(notNulls(new Object(), new Object()));
        assertFalse(notNulls(new Object(), new Object(), null));
    }
}
