package hot100_redo2.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

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
        Arrays.sort(intervals, Comparator.comparingInt(o-> o[0]));

        int[] current = intervals[0];
        List<int[]> ans = new ArrayList<>();

        for (int i = 1; i < intervals.length; i++) {
            if (current[1] >= intervals[i][0]) {
                current[1] = Math.max(intervals[i][1], current[1]);
            } else  {
                ans.add(current);
                current = intervals[i];
            }
        }
        ans.add(current);

        return ans.toArray(new int[ans.size()][]);
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
