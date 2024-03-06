package luis122448.utils;

public class StringUtil {

    public static String repeat(String str, int times) {
        String result = "";
        // fori
        for (int i = 0; i < times; i++) {
            result += str;
        }
        return result;
    }

}
