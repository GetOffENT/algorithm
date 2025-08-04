package hot100_redo.dp;

/**
 * <p>
 *     <a href="https://leetcode.cn/problems/maximum-product-subarray/description/?envType=study-plan-v2&envId=top-100-liked">...</a>
 * </p>
 *
 * @author Yuxian Wu
 * @version 1.0
 * @since 2025-03-14 10:07
 */
public class LeetCode152_MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        int max = nums[0];
        int min = nums[0];

        int ans = max;

        for (int i = 1; i < nums.length; i++) {
            int tempMax = max;
            max = Math.max(max * nums[i], Math.max(min * nums[i], nums[i]));
            ans = Math.max(max, ans);
            min = Math.min(min * nums[i], Math.min(tempMax * nums[i], nums[i]));
        }
        return ans;
    }
}
