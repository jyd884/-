import org.junit.Test;
import static org.junit.Assert.*;

public class LastZeroTest {
    @Test
    public void testTC1_emptyArray() {
        int[] x = {};
        assertEquals(-1, LastZero.lastZero(x));
    }
    @Test
    public void testTC2_firstElementZero() {
        int[] x = {0};
        assertEquals(0, LastZero.lastZero(x));
    }
    @Test
    public void testTC3_secondElementZero() {
        int[] x = {1, 0};
        assertEquals(1, LastZero.lastZero(x));
    }
    @Test
    public void testTC4_noZero() {
        int[] x = {1, 2};
        assertEquals(-1, LastZero.lastZero(x));
    }
    @Test
    public void testTC5_multipleZeros() {
        int[] x = {0, 1, 0};
        assertEquals(2, LastZero.lastZero(x));  // 预期最后一个零的索引为2
    }
}