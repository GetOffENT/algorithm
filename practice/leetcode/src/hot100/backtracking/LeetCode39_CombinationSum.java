package hot100.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * <p>
 * <a href="https://leetcode.cn/problems/combination-sum/description/?envType=study-plan-v2&envId=top-100-liked">...</a>
 * </p>
 *
 * @author Yuxian Wu
 * @version 1.0
 * @since 2025-03-10 18:53
 */
public class LeetCode39_CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);

        List<List<Integer>> ans = new ArrayList<>();

        backtrace(candidates, target, 0, 0, ans, new LinkedList<>());
        return ans;
    }

    private void backtrace(int[] candidates, int target, int index, int sum,
                           List<List<Integer>> ans, LinkedList<Integer> temp) {

        for (int i = index; i < candidates.length; i++) {

            sum += candidates[i];
            if (sum > target) {
                return;
            }
            temp.add(candidates[i]);

            if (sum == target) {
                ans.add(new LinkedList<>(temp));
            }

            backtrace(candidates, target, i, sum, ans, temp);

            sum -= candidates[i];
            temp.removeLast();
        }
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode39_CombinationSum()
                .combinationSum(
                        new int[]{2,3,6,7},7
                ));
    }
}
