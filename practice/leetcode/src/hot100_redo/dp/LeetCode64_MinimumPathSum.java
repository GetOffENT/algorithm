package hot100_redo.dp;

/**
 * <p>
 *     <a href="https://leetcode.cn/problems/minimum-path-sum/description/?envType=study-plan-v2&envId=top-100-liked">...</a>
 * </p>
 *
 * @author Yuxian Wu
 * @version 1.0
 * @since 2025-03-15 5:46
 */
public class LeetCode64_MinimumPathSum {
    public int minPathSum(int[][] grid) {
        int[][] pathSum = new int[grid.length][grid[0].length];

        pathSum[0][0] = grid[0][0];

        for (int i = 1; i < grid.length; i++) {
            pathSum[i][0] = pathSum[i - 1][0] + grid[i][0];
        }

        for (int i = 1; i < grid[0].length; i++) {
            pathSum[0][i] = pathSum[0][i - 1] + grid[0][i];
        }

        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[0].length; j++) {
                pathSum[i][j] = Math.min(pathSum[i - 1][j], pathSum[i][j - 1]) + grid[i][j];
            }
        }

        return pathSum[grid.length - 1][grid[0].length - 1];
    }


    // O(n)空间复杂度
    public int minPathSum2(int[][] grid) {
        int[] pathSum = new int[grid[0].length];

        pathSum[0] = grid[0][0];

        for (int i = 1; i < grid[0].length; i++) {
            pathSum[i] = pathSum[i - 1] + grid[0][i];
        }

        for (int i = 1; i < grid.length; i++) {
            pathSum[0] += grid[i][0];
            for (int j = 1; j < grid[0].length; j++) {
                pathSum[j] = Math.min(pathSum[j - 1], pathSum[j]) + grid[i][j];
            }
        }

        return pathSum[grid[0].length - 1];
    }
}
