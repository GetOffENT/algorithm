package hot100_redo3.array;

import java.util.Arrays;

/**
 * <p>
 *     <a href="https://leetcode.cn/problems/merge-intervals/description/?envType=study-plan-v2&envId=top-100-liked">...</a>
 * </p>
 *
 * @author Yuxian Wu
 * @version 1.0
 * @since 2025-03-04 13:29
 */
public class LeetCode56_Merge {
    public int[][] merge(int[][] intervals) {
        return new int[0][0];
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(new LeetCode56_Merge().merge(
                new int[][]{
                        {1, 3},
                        {2, 6},
                        {8, 10},
                        {15, 18}
                }
        )));
    }
}
