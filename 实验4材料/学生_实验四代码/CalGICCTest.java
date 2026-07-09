import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class CalGICCTest {

    @Test
    public void TC1_c1TrueInactive() {
        assertGiccCase(3, 10, 3, 20, 0, true, "c1");
    }

    @Test
    public void TC2_c1FalseInactive() {
        assertGiccCase(0, 10, 3, 20, 0, false, "c1");
    }

    @Test
    public void TC3_c2TrueInactive() {
        assertGiccCase(3, 10, 3, 20, 0, true, "c2");
    }

    @Test
    public void TC4_c2FalseInactive() {
        assertGiccCase(3, 10, 13, 20, 0, false, "c2");
    }

    @Test
    public void TC5_c3TrueInactive() {
        assertGiccCase(3, 10, 3, 20, 0, true, "c3");
    }

    @Test
    public void TC6_c3FalseInactive() {
        assertGiccCase(4, 10, 3, 20, 0, false, "c3");
    }

    @Test
    public void TC7_c4TrueInactive() {
        assertGiccCase(3, 10, 3, 20, 0, true, "c4");
    }

    @Test
    public void TC8_c4FalseInactive() {
        assertGiccCase(3, 0, 4, 20, 0, false, "c4");
    }

    @Test
    public void TC9_c5TrueInactive() {
        assertGiccCase(3, 10, 3, 20, 0, true, "c5");
    }

    @Test
    public void TC10_c5FalseInactive() {
        assertGiccCase(3, 10, 4, 0, 0, false, "c5");
    }

    @Test
    public void TC11_c6TrueInactive() {
        assertGiccCase(3, 10, 3, 20, 0, true, "c6");
    }

    @Test
    public void TC12_c6FalseInactive() {
        assertGiccCase(3, 20, 3, 10, 0, false, "c6");
    }

    @Test
    public void TC13_c7TrueInactive() {
        assertGiccCase(3, 20, 3, 10, 2024, true, "c7");
    }

    @Test
    public void TC14_c7FalseInactive() {
        assertGiccCase(3, 20, 3, 10, 0, false, "c7");
    }

    private void assertGiccCase(int month1, int day1, int month2, int day2, int year,
            boolean expectedMajorValue, String majorClause) {
        assertFalse("P", predicate(month1, day1, month2, day2, year));

        boolean actualMajorValue;
        if ("c1".equals(majorClause)) {
            actualMajorValue = c1(month1);
        } else if ("c2".equals(majorClause)) {
            actualMajorValue = c2(month2);
        } else if ("c3".equals(majorClause)) {
            actualMajorValue = c3(month1, month2);
        } else if ("c4".equals(majorClause)) {
            actualMajorValue = c4(day1);
        } else if ("c5".equals(majorClause)) {
            actualMajorValue = c5(day2);
        } else if ("c6".equals(majorClause)) {
            actualMajorValue = c6(month1, month2, day1, day2);
        } else if ("c7".equals(majorClause)) {
            actualMajorValue = c7(year);
        } else {
            throw new IllegalArgumentException("Unknown clause: " + majorClause);
        }

        if (expectedMajorValue) {
            assertTrue(majorClause, actualMajorValue);
        } else {
            assertFalse(majorClause, actualMajorValue);
        }
    }

    private boolean predicate(int month1, int day1, int month2, int day2, int year) {
        return c1(month1)
                && c2(month2)
                && c3(month1, month2)
                && c4(day1)
                && c5(day2)
                && c6(month1, month2, day1, day2)
                && c7(year);
    }

    private boolean c1(int month1) {
        return month1 >= 1 && month1 <= 12;
    }

    private boolean c2(int month2) {
        return month2 >= 1 && month2 <= 12;
    }

    private boolean c3(int month1, int month2) {
        return month1 <= month2;
    }

    private boolean c4(int day1) {
        return day1 >= 1 && day1 <= 31;
    }

    private boolean c5(int day2) {
        return day2 >= 1 && day2 <= 31;
    }

    private boolean c6(int month1, int month2, int day1, int day2) {
        return month1 != month2 || day1 <= day2;
    }

    private boolean c7(int year) {
        return year >= 1 && year <= 10000;
    }
}