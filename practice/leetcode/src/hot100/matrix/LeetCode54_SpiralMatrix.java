package hot100.matrix;

import java.util.ArrayList;
import java.util.HashMap;
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
    public List<Integer> spiralOrder(int[][] matrix) {
        int x = 0, y = -1;
        List<Integer> ans = new ArrayList<>();

        int row = matrix.length, col = matrix[0].length;
        int size = row * col;

        int dx = 0, dy = 1;
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];

        Map<Integer, int[]> map = Map.of(
                2, new int[]{0, -1},
                -1, new int[]{-1, 0},
                -2, new int[]{0, 1},
                1, new int[]{1, 0}
        );

        while (ans.size() != size) {
            int nextRow = x + dx, nextCol = y + dy;
            if (nextCol >= col || nextCol < 0 || nextRow >= row || nextRow < 0 || visited[nextRow][nextCol]) {
                int[] direction = map.get(dx * 2 + dy);
                dx = direction[0];
                dy = direction[1];
                continue;
            }

            x += dx;
            y += dy;
            visited[x][y] = true;
            ans.add(matrix[x][y]);
        }
        return ans;
    }
}
