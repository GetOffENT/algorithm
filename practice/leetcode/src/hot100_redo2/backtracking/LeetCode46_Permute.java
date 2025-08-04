package hot100_redo2.backtracking;

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
        boolean[] visited = new boolean[nums.length];
        LinkedList<Integer> temp = new LinkedList<>();
        traceback(nums, visited, temp);
        return ans;
    }
    List<List<Integer>> ans = new LinkedList<>();

    private void traceback(int[] nums, boolean[] visited, LinkedList<Integer> curr) {
        if (curr.size() == nums.length) {
            ans.add(new LinkedList<>(curr));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                curr.add(nums[i]);
                traceback(nums, visited, curr);
                visited[i] = false;
                curr.removeLast();
            }
        }

    }

    public static void main(String[] args) {
        System.out.println(new LeetCode46_Permute().permute(
                new int[]{1, 2, 3}
        ));
    }
}
