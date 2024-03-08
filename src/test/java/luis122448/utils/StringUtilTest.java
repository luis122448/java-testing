package luis122448.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringUtilTest {

    @Test
    public void testRepeat_string_once() {
        Assertions.assertEquals("hola", StringUtil.repeat("hola", 1));
    }

    @Test
    public void testRepeat_string_multiple_times() {
        assertEquals("holaholahola", StringUtil.repeat("hola", 3));
    }

    @Test
    public void testRepeat_string_negative_times() {
        assertThrows(IllegalArgumentException.class, () -> {
            StringUtil.repeat("hola", -1);
        });
    }

    @Test
    public void testIsEmpty_string_true() {
        assertFalse(StringUtil.isEmpty("Hola"));
    }

    @Test
    public void testIsEmpty_string_null() {
        assertTrue(StringUtil.isEmpty(null));
    }

    @Test
    public void testIsEmpty_string_empty() {
        assertTrue(StringUtil.isEmpty(""));
    }

    @Test
    public void testIsEmpty_string_spaces() {
        assertTrue(StringUtil.isEmpty("   "));
    }

}