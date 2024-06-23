package estornoProject.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DateFormatterTest {
    @Test
    void formatDate() {
        String date = "20230622";
        String expected = "2023-06-22";
        String result = DateFormatter.formatDate(date);
        assertEquals(expected, result);
    }

    @Test
    public void testFormatDateInvalidLength() {
        String date = "2023062";
        assertThrows(IllegalArgumentException.class, () -> {
            DateFormatter.formatDate(date);
        });
    }

    @Test
    public void testFormatDateNonNumericDate() {
        String date = "2023abcd";
        assertThrows(IllegalArgumentException.class, () -> {
            DateFormatter.formatDate(date);
        });
    }
}