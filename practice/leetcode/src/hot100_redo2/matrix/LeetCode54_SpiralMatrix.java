package hot100_redo2.matrix;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * <a href="https://leetcode.cn/problems/spiral-matrix/description/?envType=study-plan-v2&envId=top-100-liked">...</a>
 * </p>
 *
 * @author Yuxian Wu
 * @version 1.0
 * @since 2025-03-11 11:57
 */
public class LeetCode54_SpiralMatrix {
    final int[][] directions = new int[][]{
            {0, 1},
            {1, 0},
            {0, -1},
            {-1, 0}
    };
    public List<Integer> spiralOrder(int[][] matrix) {
        int num = matrix.length * matrix[0].length;
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        List<Integer> ans = new ArrayList<>();
        int row = 0, col = -1;
        int curr = 0;
        int[] direction = directions[curr];
        while (ans.size() < num) {
            int nextRow = row + direction[0], nextCol = col + direction[1];
            if (inArea(nextRow, nextCol, matrix.length, matrix[0].length) && !visited[nextRow][nextCol]) {
                visited[nextRow][nextCol] = true;
                row = nextRow;
                col = nextCol;
                ans.add(matrix[row][col]);
            } else {
                curr = (curr + 1) % directions.length;
                direction = directions[curr];
            }
        }
        return ans;
    }

    public boolean inArea(int x, int y, int row, int col) {
        return x >= 0 && y >= 0 && x < row && y < col;
    }

}
