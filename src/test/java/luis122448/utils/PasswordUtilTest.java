package luis122448.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PasswordUtilTest {

    @Test
    public void weak_when_has_less_than_8_letters() {
        PasswordUtil passwordUtil = new PasswordUtil();
        assertEquals(PasswordUtil.SecurityLevel.WEAK, passwordUtil.assessPassword("123"));
    }

    @Test
    public void weak_when_has_only_letters() {
        PasswordUtil passwordUtil = new PasswordUtil();
        assertEquals(PasswordUtil.SecurityLevel.WEAK, passwordUtil.assessPassword("abcdefgh"));
    }

    @Test void strong_when_has_letters_and_numbers_and_symbols() {
        PasswordUtil passwordUtil = new PasswordUtil();
        assertEquals(PasswordUtil.SecurityLevel.MEDIUM, passwordUtil.assessPassword("abcd1234#%%$"));
    }
}