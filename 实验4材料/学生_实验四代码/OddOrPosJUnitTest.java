import static org.junit.Assert.assertEquals;

import org.junit.Ignore;
import org.junit.Test;

public class OddOrPosJUnitTest {
    @Test
    public void TC1_gaccTT() {
        assertEquals(1, OddOrPos.oddOrPos(new int[] {1}));
    }

    @Test
    public void TC2_gaccFT() {
        assertEquals(1, OddOrPos.oddOrPos(new int[] {2}));
    }

    @Test
    public void TC3_gaccFF() {
        assertEquals(0, OddOrPos.oddOrPos(new int[] {0}));
    }


    @Test
    public void TC5_specBasedOddNegative() {
        assertEquals(1, OddOrPos.oddOrPos(new int[] {-3}));
    }
}