import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class SolutionTest {
    @Test
    public void doTest() {
        int[][] matrix = new int[1][2];
        matrix[0][0] = -1;
        matrix[0][1] = 3;

        var s = new Solution();
        assertTrue(s.searchMatrix(matrix, 3));
    }

    @Test
    public void doTest2() {
        int[][] matrix = new int[2][1];
        matrix[0][0] = -1;
        matrix[1][0] = 3;

        var s = new Solution();
        assertTrue(s.searchMatrix(matrix, 3));
    }

}
