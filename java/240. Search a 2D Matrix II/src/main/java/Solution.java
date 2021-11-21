import java.util.Objects;

/**
 * Write an efficient algorithm that searches for a target value in an m x n integer matrix. The
 * matrix has the following properties:
 *
 * <p>Integers in each row are sorted in ascending from left to right. Integers in each column are
 * sorted in ascending from top to bottom.
 *
 * <p>Constraints:
 *
 * <p>m == matrix.length n == matrix[i].length 1 <= n, m <= 300 -109 <= matrix[i][j] <= 109 All the
 * integers in each row are sorted in ascending order. All the integers in each column are sorted in
 * ascending order. -109 <= target <= 109
 */
class Solution {

  private int numCols;
  private boolean[][] visited;
  private int numRows;

  public boolean searchMatrix(int[][] matrix, int target) {
    if (Objects.isNull(matrix)) return false;

    numCols = matrix.length;
    numRows = matrix[0].length;

    visited = new boolean[numCols][numRows];
    for (int i = 0; i < numCols; i++) {
      visited[i] = new boolean[numRows];
    }

    return searchMatrix(matrix, 0, 0, target);
  }

  @SuppressWarnings("checkstyle:NeedBraces")
  private boolean searchMatrix(int[][] matrix, int col, int row, int target) {
    if (col >= numCols || row >= numRows || col < 0 || row < 0) return false;

    var value = matrix[col][row];
    if (value == target) return true;

    if (visited[col][row]) return false;

    visited[col][row] = true;

    if (value < target) {
      if (searchMatrix(matrix, col + 1, row, target)) return true;
      if (searchMatrix(matrix, col, row + 1, target)) return true;
    } else {
      if (searchMatrix(matrix, col - 1, row, target)) return true;
      if (searchMatrix(matrix, col, row - 1, target)) return true;
    }

    return false;
  }
}
