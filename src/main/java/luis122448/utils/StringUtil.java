package luis122448.utils;

public class StringUtil {

    public static String repeat(String str, int times) {
        if(times< 0) {
            throw new IllegalArgumentException("negative times not allowed");
        }
        String result = "";
        // fori
        for (int i = 0; i < times; i++) {
            result += str;
        }
        return result;
    }

}
