package hot100_redo2.dp;

/**
 * <p>
 * <a href="https://leetcode.cn/problems/maximum-product-subarray/description/?envType=study-plan-v2&envId=top-100-liked">...</a>
 * </p>
 *
 * @author Yuxian Wu
 * @version 1.0
 * @since 2025-03-14 10:07
 */
public class LeetCode152_MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        int max = nums[0], min = nums[0];
        int ans = max;
        for (int i = 1; i < nums.length; i++) {
            int tempMax = max;
            max = Math.max(Math.max(max * nums[i], min * nums[i]), nums[i]);
            min = Math.min(Math.min(tempMax * nums[i], min * nums[i]), nums[i]);
            ans = Math.max(max, ans);
        }
        return ans;
    }
}
