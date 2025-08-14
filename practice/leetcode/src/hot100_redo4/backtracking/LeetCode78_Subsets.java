package hot100_redo4.backtracking;

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
        return List.of();
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
