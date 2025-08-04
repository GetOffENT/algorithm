package hot100_redo2.graph;

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
    private final int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public int orangesRotting(int[][] grid) {
        int row = grid.length, col = grid[0].length;
        boolean[][] visited = new boolean[row][col];

        LinkedList<Integer> queue = new LinkedList<>();
        boolean hasOrange = false;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                hasOrange = hasOrange | grid[i][j] != 0;
                if (grid[i][j] == 2) {
                    visited[i][j] = true;
                    queue.offer(i * col + j);
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

                for (int j = 0; j < directions.length; j++) {
                    int nextX = x + directions[j][0], nextY = y + directions[j][1];
                    if (inGrid(nextX, nextY, row, col) && !visited[nextX][nextY]) {

                        visited[x][y] = true;
                        if (grid[nextX][nextY] == 1) {
                            grid[nextX][nextY] = 2;
                            queue.offer(nextX * col + nextY);
                        }
                    }
                }
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }
        return ans - 1;
    }


    private boolean inGrid(int x, int y, int row, int col) {
        return x >= 0 && y >= 0 && x < row && y < col;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode994_RottingOranges().orangesRotting(
                new int[][]{
                        {2, 1, 1},
                        {1, 1, 0},
                        {0, 1, 1}
                }
        ));
        System.out.println(new LeetCode994_RottingOranges().orangesRotting(
                new int[][]{
                        {2, 1, 1},
                        {1, 1, 0},
                        {1, 0, 1}
                }
        ));
    }
}
