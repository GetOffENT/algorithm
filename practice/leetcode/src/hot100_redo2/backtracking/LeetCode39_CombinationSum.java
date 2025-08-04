package hot100_redo2.backtracking;

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
        backtrace(candidates, 0, target);
        return ans;
    }

    List<List<Integer>> ans = new LinkedList<>();
    LinkedList<Integer> temp = new LinkedList<>();

    private void backtrace(int[] candidates, int curr, int sum) {
        if (sum < 0) {
            return;
        }
        if (sum == 0) {
            ans.add(new LinkedList<>(temp));
        }

        for (int i = curr; i < candidates.length; i++) {
            temp.add(candidates[i]);
            backtrace(candidates, i, sum - candidates[i]);
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
