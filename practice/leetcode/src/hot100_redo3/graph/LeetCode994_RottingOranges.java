package hot100_redo3.graph;

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

    public int orangesRotting(int[][] grid) {
        return 0;
    }


    private boolean inGrid(int x, int y, int row, int col) {
        return x >= 0 && y >= 0 && x < row && y < col;
    }
}
