package estornoProject.util;

public class DateFormatter {
    public static String formatDate(String date) {
        if(date.length() == 8 && date.matches("\\d{8}")) {
            String year = date.substring(0, 4);
            String month = date.substring(4, 6);
            String day = date.substring(6, 8);

            return year + "-" + month + "-" + day;
        } else {
            throw new IllegalArgumentException("Date is not in the expected format.");
        }
    }
}
