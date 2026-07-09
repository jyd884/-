public class OddOrPosGACCTest {
    private static final class TestCase {
        final String id;
        final String requirement;
        final int[] input;
        final int expected;
        final boolean executable;
        final String note;

        TestCase(String id, String requirement, int[] input, int expected, boolean executable, String note) {
            this.id = id;
            this.requirement = requirement;
            this.input = input;
            this.expected = expected;
            this.executable = executable;
            this.note = note;
        }
    }

    public static void main(String[] args) {
        TestCase[] cases = new TestCase[] {
            new TestCase("TC1", "GACC-TT", new int[] {1}, 1, true, "c1=T, c2=T"),
            new TestCase("TC2", "GACC-FT", new int[] {2}, 1, true, "c1=F, c2=T"),
            new TestCase("TC3", "GACC-FF", new int[] {0}, 0, true, "c1=F, c2=F"),
            new TestCase("TC4", "GACC-TF", null, -1, false, "Requirement is infeasible in this implementation"),
            new TestCase("TC5", "Spec-based odd negative", new int[] {-3}, 1, true,
                "Fault-revealing case: odd negative should be counted by the specification")
        };

        System.out.println("ID | Requirement | Input | Expected | Actual | Pass | Note");
        System.out.println("---|---|---|---|---|---|---");

        for (TestCase testCase : cases) {
            runCase(testCase);
        }
    }

    private static void runCase(TestCase testCase) {
        if (!testCase.executable) {
            System.out.println(testCase.id + " | " + testCase.requirement + " | N/A | N/A | N/A | N/A | "
                + testCase.note);
            return;
        }

        int actual = OddOrPos.oddOrPos(testCase.input);
        boolean passed = actual == testCase.expected;

        System.out.println(testCase.id + " | " + testCase.requirement + " | " + formatArray(testCase.input)
            + " | " + testCase.expected + " | " + actual + " | " + (passed ? "Success" : "Fail")
            + " | " + testCase.note);
    }

    private static String formatArray(int[] values) {
        StringBuilder builder = new StringBuilder("[");
        for (int index = 0; index < values.length; index++) {
            if (index > 0) {
                builder.append(", ");
            }
            builder.append(values[index]);
        }
        builder.append(']');
        return builder.toString();
    }
}