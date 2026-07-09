import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import szu.csse.softwaretesting.ch8.Cal;

public class CalGACCTest {

    private static final int VALID_MONTH1 = 3;
    private static final int VALID_DAY1 = 10;
    private static final int VALID_MONTH2 = 3;
    private static final int VALID_DAY2 = 20;
    private static final int VALID_YEAR = 2024;

    @Test
    public void TR1_c1True() {
        assertAllClausesTrue(VALID_MONTH1, VALID_DAY1, VALID_MONTH2, VALID_DAY2, VALID_YEAR);
        assertEquals(10, Cal.cal(VALID_MONTH1, VALID_DAY1, VALID_MONTH2, VALID_DAY2, VALID_YEAR));
    }

    @Test
    public void TR2_c1False() {
        assertClausePattern(0, 10, 3, 20, 2024, false, true, true, true, true, true, true);
    }

    @Test
    public void TR3_c2True() {
        assertAllClausesTrue(VALID_MONTH1, VALID_DAY1, VALID_MONTH2, VALID_DAY2, VALID_YEAR);
        assertEquals(10, Cal.cal(VALID_MONTH1, VALID_DAY1, VALID_MONTH2, VALID_DAY2, VALID_YEAR));
    }

    @Test
    public void TR4_c2False() {
        assertClausePattern(3, 10, 13, 20, 2024, true, false, true, true, true, true, true);
    }

    @Test
    public void TR5_c3True() {
        assertAllClausesTrue(VALID_MONTH1, VALID_DAY1, VALID_MONTH2, VALID_DAY2, VALID_YEAR);
        assertEquals(10, Cal.cal(VALID_MONTH1, VALID_DAY1, VALID_MONTH2, VALID_DAY2, VALID_YEAR));
    }

    @Test
    public void TR6_c3False() {
        assertClausePattern(4, 10, 3, 20, 2024, true, true, false, true, true, true, true);
    }

    @Test
    public void TR7_c4True() {
        assertAllClausesTrue(VALID_MONTH1, VALID_DAY1, VALID_MONTH2, VALID_DAY2, VALID_YEAR);
        assertEquals(10, Cal.cal(VALID_MONTH1, VALID_DAY1, VALID_MONTH2, VALID_DAY2, VALID_YEAR));
    }

    @Test
    public void TR8_c4False() {
        assertClausePattern(3, 0, 4, 20, 2024, true, true, true, false, true, true, true);
    }

    @Test
    public void TR9_c5True() {
        assertAllClausesTrue(VALID_MONTH1, VALID_DAY1, VALID_MONTH2, VALID_DAY2, VALID_YEAR);
        assertEquals(10, Cal.cal(VALID_MONTH1, VALID_DAY1, VALID_MONTH2, VALID_DAY2, VALID_YEAR));
    }

    @Test
    public void TR10_c5False() {
        assertClausePattern(3, 10, 4, 0, 2024, true, true, true, true, false, true, true);
    }

    @Test
    public void TR11_c6True() {
        assertAllClausesTrue(VALID_MONTH1, VALID_DAY1, VALID_MONTH2, VALID_DAY2, VALID_YEAR);
        assertEquals(10, Cal.cal(VALID_MONTH1, VALID_DAY1, VALID_MONTH2, VALID_DAY2, VALID_YEAR));
    }

    @Test
    public void TR12_c6False() {
        assertClausePattern(3, 20, 3, 10, 2024, true, true, true, true, true, false, true);
    }

    @Test
    public void TR13_c7True() {
        assertAllClausesTrue(VALID_MONTH1, VALID_DAY1, VALID_MONTH2, VALID_DAY2, VALID_YEAR);
        assertEquals(10, Cal.cal(VALID_MONTH1, VALID_DAY1, VALID_MONTH2, VALID_DAY2, VALID_YEAR));
    }

    @Test
    public void TR14_c7False() {
        assertClausePattern(3, 10, 3, 20, 0, true, true, true, true, true, true, false);
    }

    private void assertAllClausesTrue(int month1, int day1, int month2, int day2, int year) {
        assertClausePattern(month1, day1, month2, day2, year, true, true, true, true, true, true, true);
    }

    private void assertClausePattern(int month1, int day1, int month2, int day2, int year,
            boolean c1Expected, boolean c2Expected, boolean c3Expected,
            boolean c4Expected, boolean c5Expected, boolean c6Expected, boolean c7Expected) {
        assertClauseValue(c1(month1), c1Expected, "c1");
        assertClauseValue(c2(month2), c2Expected, "c2");
        assertClauseValue(c3(month1, month2), c3Expected, "c3");
        assertClauseValue(c4(day1), c4Expected, "c4");
        assertClauseValue(c5(day2), c5Expected, "c5");
        assertClauseValue(c6(month1, month2, day1, day2), c6Expected, "c6");
        assertClauseValue(c7(year), c7Expected, "c7");
    }

    private void assertClauseValue(boolean actual, boolean expected, String clauseName) {
        if (expected) {
            assertTrue(clauseName, actual);
        } else {
            assertFalse(clauseName, actual);
        }
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