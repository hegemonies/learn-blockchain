package Bravochain.Utils;

public class StringUtil {
    public static String difficaltyToString(int difficalty) {
        return String.valueOf(new char[difficalty]).replace("\0", "0");
    }

    public static double fromNanosecondToSecond(long nanosecond) {
        return nanosecond / (double) Math.pow(10, 9);
    }
}
