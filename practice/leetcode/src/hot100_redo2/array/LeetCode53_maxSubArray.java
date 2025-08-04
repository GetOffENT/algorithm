package hot100_redo2.array;

/**
 * <a href="https://leetcode.cn/problems/maximum-subarray/description/?envType=study-plan-v2&envId=top-100-liked">...</a>
 * @author Will
 * @version 1.0
 * @Description: TODO
 * @Create: 2024-09-11 14:30
 */
public class LeetCode53_maxSubArray {
    public int maxSubArray(int[] nums) {
        int dp = 0;
        int ans = nums[0];
        for (int i = 0; i < nums.length; i++) {
            dp = Math.max(nums[i], nums[i] + dp);
            ans = Math.max(ans, dp);
        }

        return ans;
    }


    public static void main(String[] args) {
        System.out.println(new LeetCode53_maxSubArray().maxSubArray(new int[]{-2, 1}));
        System.out.println(new LeetCode53_maxSubArray().maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }
}
