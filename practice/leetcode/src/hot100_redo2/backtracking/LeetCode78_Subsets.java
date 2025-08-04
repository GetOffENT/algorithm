package hot100_redo2.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * <p>
 *     <a href="https://leetcode.cn/problems/subsets/?envType=study-plan-v2&envId=top-100-liked">...</a>
 * </p>
 *
 * @author Yuxian Wu
 * @version 1.0
 * @since 2025-03-10 17:31
 */
public class LeetCode78_Subsets {

    public List<List<Integer>> subsets(int[] nums) {
        visited = new boolean[nums.length];
        ans.add(List.of());
        backtrace(nums, 0);
        return ans;
    }
    List<List<Integer>> ans = new LinkedList<>();
    LinkedList<Integer> temp = new LinkedList<>();
    boolean[] visited;

    private void backtrace(int[] nums, int curr) {
        for (int i = curr; i < nums.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                temp.add(nums[i]);
                ans.add(new ArrayList<>(temp));
                backtrace(nums, i + 1);
                temp.removeLast();
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(1 << 2);
        System.out.println(7 & (1<<2));
        System.out.println(
                new LeetCode78_Subsets().subsets(
                        new int[]{1,2,3}
                )
        );
    }
}
