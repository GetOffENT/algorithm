package hot100.array;

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
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));

        List<int[]> mergedIntervals = new ArrayList<>();

        int[] currentInterval = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            int[] nextInterval = intervals[i];
            if (currentInterval[1] >= nextInterval[0]) {
                currentInterval[1] = Math.max(currentInterval[1], nextInterval[1]);
            } else {
                mergedIntervals.add(currentInterval);
                currentInterval = nextInterval;
            }
        }
        mergedIntervals.add(currentInterval);

        return mergedIntervals.toArray(int[][]::new);
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
