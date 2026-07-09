import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import szu.csse.softwaretesting.ch8.Cal;

public class CalMUMCUTTest {

    @Test
    public void TC1_UTP() {
        assertClausePattern(3, 10, 3, 20, 2024, true, true, true, true, true, true, true);
        assertTrue(predicate(3, 10, 3, 20, 2024));
        assertEquals(10, Cal.cal(3, 10, 3, 20, 2024));
    }

    @Test
    public void TC2_NFP_c1() {
        assertClausePattern(0, 10, 3, 20, 2024, false, true, true, true, true, true, true);
        assertFalse(predicate(0, 10, 3, 20, 2024));
    }

    @Test
    public void TC3_NFP_c2() {
        assertClausePattern(3, 10, 13, 20, 2024, true, false, true, true, true, true, true);
        assertFalse(predicate(3, 10, 13, 20, 2024));
    }

    @Test
    public void TC4_NFP_c3() {
        assertClausePattern(4, 10, 3, 20, 2024, true, true, false, true, true, true, true);
        assertFalse(predicate(4, 10, 3, 20, 2024));
    }

    @Test
    public void TC5_NFP_c4() {
        assertClausePattern(3, 0, 4, 20, 2024, true, true, true, false, true, true, true);
        assertFalse(predicate(3, 0, 4, 20, 2024));
    }

    @Test
    public void TC6_NFP_c5() {
        assertClausePattern(3, 10, 4, 0, 2024, true, true, true, true, false, true, true);
        assertFalse(predicate(3, 10, 4, 0, 2024));
    }

    @Test
    public void TC7_NFP_c6() {
        assertClausePattern(3, 20, 3, 10, 2024, true, true, true, true, true, false, true);
        assertFalse(predicate(3, 20, 3, 10, 2024));
    }

    @Test
    public void TC8_NFP_c7() {
        assertClausePattern(3, 10, 3, 20, 0, true, true, true, true, true, true, false);
        assertFalse(predicate(3, 10, 3, 20, 0));
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