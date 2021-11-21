import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class SolutionTest {
    @Test
    public void doTest() {
        var s = new Solution();
        assertTrue(s.canReach("011010", 2, 3));
        assertFalse(s.canReach("01101110", 2, 3));
        assertFalse(s.canReach("01", 1, 1));
    }
}
