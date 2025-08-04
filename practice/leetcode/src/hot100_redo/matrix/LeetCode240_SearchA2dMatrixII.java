package hot100_redo.matrix;

/**
 * <p><a href="https://leetcode.cn/problems/search-a-2d-matrix-ii/?envType=study-plan-v2&envId=top-100-liked">...</a>
 * </p>
 *
 * @author Yuxian Wu
 * @version 1.0
 * @since 2025-03-11 13:52
 */
public class LeetCode240_SearchA2dMatrixII {
    public boolean searchMatrix(int[][] matrix, int target) {
        int x = 0, y = matrix[0].length - 1;

        while (inArea(x, y, matrix.length, matrix[0].length)) {
            if (matrix[x][y] == target) {
                return true;
            } else if (matrix[x][y] < target) {
                x++;
            } else y--;
        }
        return false;
    }

    private boolean inArea(int x, int y, int row, int col) {
        return y >= 0 && x < row ;
    }
}
