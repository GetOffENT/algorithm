package hot100_redo.backtracking;

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
        List<List<Integer>> ans = new ArrayList<>();
        LinkedList<Integer> temp = new LinkedList<>();
        ans.add(temp);
        backtrace(nums, 0 , temp, ans);
        return ans;
    }

    private void backtrace(int[] nums, int begin,
                           LinkedList<Integer> temp, List<List<Integer>> ans){
        for (int i = begin; i < nums.length; i++) {
            temp.add(nums[i]);
            ans.add(new ArrayList<>(temp));
            backtrace(nums, i + 1, temp, ans);

            temp.removeLast();
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
