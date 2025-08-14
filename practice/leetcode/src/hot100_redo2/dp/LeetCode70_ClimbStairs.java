package hot100_redo2.dp;

/**
 * <p>
 * <a href="https://leetcode.cn/problems/climbing-stairs/?envType=study-plan-v2&envId=top-100-liked">...</a>
 * </p>
 *
 * @author Yuxian Wu
 * @version 1.0
 * @since 2025-03-06 19:12
 */
public class LeetCode70_ClimbStairs {


    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        if (n >= 1) dp[1] = 1;
        if (n >= 2) dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

    public int climbStairs2(int n) {
        return 0;
    }
}
