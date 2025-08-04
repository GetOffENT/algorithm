package hot100_redo.matrix;

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

    int[][] directions = {
            {0, 1},
            {1, 0},
            {0, -1},
            {-1, 0}
    };

    public List<Integer> spiralOrder(int[][] matrix) {
        int curr = 0;
        int[] direction = directions[curr];
        int x = 0, y = -1;
        List<Integer> ans = new ArrayList<>();
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        while (ans.size() < matrix.length * matrix[0].length) {
            int nextX = x + direction[0], nextY = y + direction[1];
            if (inArea(nextX, nextY, matrix.length, matrix[0].length) && !visited[nextX][nextY]) {
                ans.add(matrix[nextX][nextY]);
                x = nextX;
                y = nextY;
                visited[x][y] = true;
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
