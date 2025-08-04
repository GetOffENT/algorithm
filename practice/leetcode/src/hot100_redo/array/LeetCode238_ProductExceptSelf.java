package hot100_redo.array;

/**
 * <p>
 * <a href="https://leetcode.cn/problems/product-of-array-except-self/?envType=study-plan-v2&envId=top-100-liked">...</a>
 * </p>
 *
 * @author Yuxian Wu
 * @version 1.0
 * @since 2025-03-07 7:06
 */
public class LeetCode238_ProductExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int[] ans = new int[nums.length];
        ans[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            ans[i] = ans[i - 1] * nums[i - 1];
        }

        int R = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            ans[i] *= R;
            R *= nums[i];
        }
        return ans;
    }
}
