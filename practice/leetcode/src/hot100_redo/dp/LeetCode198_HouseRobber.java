package hot100_redo.dp;

/**
 * <p>
 * </p>
 *
 * @author Yuxian Wu
 * @version 1.0
 * @since 2025-03-10 19:33
 */
public class LeetCode198_HouseRobber {
    public int rob(int[] nums) {
        if (nums.length == 1 ) return nums[0];

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Integer.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Integer.max(dp[i-2]+ nums[i], dp[i-1]);
        }

        return dp[nums.length - 1];
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode198_HouseRobber()
                .rob(
                        new int[]{2,7,9,3,1}
                ));
    }
}
