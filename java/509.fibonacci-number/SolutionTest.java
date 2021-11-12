import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SolutionTest {
    @Test
    void simpleTest() {
        var sol = new Solution();
        assertEquals(1, sol.fib(1));
        assertEquals(1, sol.fib(2));
        assertEquals(2, sol.fib(3));
        assertEquals(3, sol.fib(4));
        assertEquals(5, sol.fib(5));
        assertEquals(8, sol.fib(6));
        assertEquals(13, sol.fib(7));
        assertEquals(21, sol.fib(8));
    }
}