package luis122448.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RomanNumeralsTest {

    @Test
    public void return_I_when_1() {
        assertEquals("I", RomanNumerals.arabicToRoman(1));
    }
    @Test
    public void return_XI_when_11() {
        assertEquals("XI", RomanNumerals.arabicToRoman(11));
    }
    @Test
    public void return_XL_when_40() {
        assertEquals("XL", RomanNumerals.arabicToRoman(40));
    }
    @Test
    public void return_C_when_100() {
        assertEquals("C", RomanNumerals.arabicToRoman(100));
    }
    @Test
    public void return_CXL_when_140() {
        assertEquals("CXL", RomanNumerals.arabicToRoman(140));
    }
    @Test
    public void return_D_when_500() {
        assertEquals("D", RomanNumerals.arabicToRoman(500));
    }
    @Test
    public void return_M_when_1000() {
        assertEquals("M", RomanNumerals.arabicToRoman(1000));
    }
    @Test
    public void return_1_when_I() {
        assertEquals(1, RomanNumerals.romanToArabic("I"));
    }
    @Test
    public void return_11_when_XI() {
        assertEquals(11, RomanNumerals.romanToArabic("XI"));
    }
    @Test
    public void return_40_when_XL() {
        assertEquals(40, RomanNumerals.romanToArabic("XL"));
    }
    @Test
    public void return_100_when_C() {
        assertEquals(100, RomanNumerals.romanToArabic("C"));
    }
    @Test
    public void return_140_when_CXL() {
        assertEquals(140, RomanNumerals.romanToArabic("CXL"));
    }
    @Test
    public void return_500_when_D() {
        assertEquals(500, RomanNumerals.romanToArabic("D"));
    }
    @Test
    public void return_1000_when_M() {
        assertEquals(1000, RomanNumerals.romanToArabic("M"));
    }
    @Test
    public void throw_exception_when_number_is_less_than_1() {
        assertThrows(IllegalArgumentException.class, () -> {
            RomanNumerals.arabicToRoman(0);
        });
    }

}