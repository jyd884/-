import static org.junit.Assert.assertEquals;

import org.junit.Ignore;
import org.junit.Test;

public class OddOrPosRACCTest {
    @Ignore("TR4 is infeasible: if x[i] % 2 == 1 is true, then x[i] > 0 must also be true")
    @Test
    public void TR4_racc_trueFalse() {
        assertEquals("This test documents an infeasible RACC requirement.", -1, -1);
    }

    @Test
    public void TR5_racc_falseTrue() {
        assertEquals(1, OddOrPos.oddOrPos(new int[] {2}));
    }

    @Test
    public void TR6_racc_falseFalse() {
        assertEquals(0, OddOrPos.oddOrPos(new int[] {0}));
    }
}