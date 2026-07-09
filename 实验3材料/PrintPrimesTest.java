import org.junit.Test;
import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;

public class PrintPrimesTest {
    private String captureOutput(int n) throws Exception {
        ByteArrayOutputStream outputBuffer = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        PrintStream captureStream = new PrintStream(outputBuffer, true, StandardCharsets.UTF_8.name());

        try {
            System.setOut(captureStream);

            Method printPrimesMethod = PrintPrimes.class.getDeclaredMethod("printPrimes", int.class);
            printPrimesMethod.setAccessible(true);
            printPrimesMethod.invoke(null, n);
        } finally {
            System.out.flush();
            System.setOut(originalOut);
            captureStream.close();
        }

        return outputBuffer.toString(StandardCharsets.UTF_8);
    }

    @Test
    public void testTC1_nEquals0() throws Exception {
        String output = captureOutput(0);
        assertEquals("", output.trim());
    }

    @Test
    public void testTC2_nEquals1() throws Exception {
        String output = captureOutput(1).replace("\r\n", "\n");
        assertEquals("Prime: 2\n", output);
    }

    @Test
    public void testTC3_nEquals2() throws Exception {
        String output = captureOutput(2).replace("\r\n", "\n");
        assertEquals("Prime: 2\nPrime: 3\n", output);
    }

    @Test
    public void testTC4_nEquals4() throws Exception {
        String output = captureOutput(4).replace("\r\n", "\n");
        assertEquals("Prime: 2\nPrime: 3\nPrime: 5\nPrime: 7\n", output);
    }
}