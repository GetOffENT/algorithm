package hot100.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * <p>
 *     <a href="https://leetcode.cn/problems/permutations/?envType=study-plan-v2&envId=top-100-liked">...</a>
 * </p>
 *
 * @author Yuxian Wu
 * @version 1.0
 * @since 2025-03-05 21:26
 */
public class LeetCode46_Permute {

    public List<List<Integer>> permute(int[] nums) {

        boolean[] isVisited = new boolean[nums.length];

        List<List<Integer>> ans = new ArrayList<>();
        LinkedList<Integer> temp = new LinkedList<>();

        backtrace(isVisited, nums, temp, ans);

        return ans;
    }

    private void backtrace(boolean[] isVisited, int[] nums, LinkedList<Integer> temp,List<List<Integer>> ans) {
        for (int i = 0; i < nums.length; i++) {
            if (!isVisited[i]) {
                isVisited[i] = true;
                temp.add(nums[i]);

                if (temp.size() == nums.length) {
                    ans.add(new ArrayList<>(temp));
                }

                backtrace(isVisited, nums, temp, ans);

                isVisited[i] = false;
                temp.removeLast();
            }

        }
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode46_Permute().permute(
                new int[]{1, 2, 3}
        ));
    }
}
