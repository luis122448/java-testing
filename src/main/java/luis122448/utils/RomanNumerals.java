package luis122448.utils;

public class RomanNumerals {

    public enum RomanNumeral {
        M(1000), CM(900), D(500), CD(400),
        C(100), XC(90), L(50), XL(40),
        X(10), IX(9), V(5), IV(4),
        I(1);

        private final int value;

        RomanNumeral(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    public static String arabicToRoman(int number) {
        if (number < 1 || number > 3999) {
            throw new IllegalArgumentException("number must be between 1 and 3999");
        }
        StringBuilder result = new StringBuilder();
        int remaining = number;
        for (RomanNumeral romanNumeral : RomanNumeral.values()) {
            remaining = appendRomanNumeral(remaining, romanNumeral, result );
            if (remaining == 0) {
                break;
            }
        }
        return result.toString();
    }

    public static int romanToArabic(String roman) {
        int result = 0;
        int i = 0;
        for (RomanNumeral romanNumeral : RomanNumeral.values()) {
            while (startsWith(roman, i, romanNumeral)) {
                result += romanNumeral.getValue();
                i += romanNumeral.name().length();
            }
        }
        return result;
    }

    private static boolean startsWith(String roman, int i, RomanNumeral romanNumeral) {
        return roman.startsWith(romanNumeral.name(), i);
    }

    private static int appendRomanNumeral(int remaining, RomanNumeral romanNumeral, StringBuilder result) {
        while (remaining >= romanNumeral.getValue()) {
            result.append(romanNumeral.name());
            remaining -= romanNumeral.getValue();
        }
        return remaining;
    }
}
