package hot100.graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <p>
 * <a href="https://leetcode.cn/problems/rotting-oranges/?envType=study-plan-v2&envId=top-100-liked">...</a>
 * </p>
 *
 * @author Yuxian Wu
 * @version 1.0
 * @since 2025-03-15 7:01
 */
public class LeetCode994_RottingOranges {

    private final int[][] directions = {
            {1, 0}, {0, 1}, {-1, 0}, {0, -1}
    };

    public int orangesRotting(int[][] grid) {
        Queue<Integer> queue = new LinkedList<>();
        int row = grid.length, col = grid[0].length;

        boolean hasOrange = false;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                hasOrange = hasOrange | grid[i][j] != 0;
                if (grid[i][j] == 2) {
                    queue.offer(i * col + j);
                    // 表示已访问
                    grid[i][j] = 3;
                }
            }
        }

        if (!hasOrange) {
            return 0;
        }

        int ans = 0;
        while (!queue.isEmpty()) {
            ans++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int poll = queue.poll();
                int x = poll / col, y = poll % col;

                for (int[] direction : directions) {
                    int nextX = x + direction[0], nextY = y + direction[1];
                    if (inGrid(nextX, nextY, row, col) && grid[nextX][nextY] != 0 && grid[nextX][nextY] != 3) {
                        queue.offer(nextX * col + nextY);
                        grid[nextX][nextY] = 3;
                    }
                }
            }
        }

        for (int[] ints : grid) {
            for (int j = 0; j < col; j++) {
                if (ints[j] == 1) {
                    return -1;
                }
            }
        }
        return ans - 1;
    }


    private boolean inGrid(int x, int y, int row, int col) {
        return x >= 0 && y >= 0 && x < row && y < col;
    }
}
