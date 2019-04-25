package utility;

public class StringConvertUtil {
    public static String convertEmptyStringToNull(String text) {
        if (text == null)
            return null;
        return text.isEmpty() ? null : text;
    }

    public static Integer convertStringToInteger(String textNumber) {
        if (convertEmptyStringToNull(textNumber) != null)
            return Integer.parseInt(textNumber);
        return null;
    }
}
