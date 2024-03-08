package luis122448.utils;

public class DateUtil {

    public static boolean isLeapYear(int year) {
//        return true;
        if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
            return true;
        }
        return false;
    }
}
