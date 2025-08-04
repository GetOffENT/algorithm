package hot100_redo.dp;

/**
 * <p>
 * <a href="https://leetcode.cn/problems/coin-change/description/?envType=study-plan-v2&envId=top-100-liked">...</a>
 * </p>
 *
 * @author Yuxian Wu
 * @version 1.0
 * @since 2025-03-14 8:31
 */
public class LeetCode322_CoinChange {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        int[] dp = new int[amount + 1];

        for (int i = 1; i <= amount; i++) {
            int min = Integer.MAX_VALUE;
            for (int coin : coins) {
                if (i - coin == 0) {
                    min = 1;
                } else if (i - coin > 0 && dp[i - coin] > 0) {
                    min = Math.min(dp[i - coin] + 1, min);
                }
            }
            dp[i] = min == Integer.MAX_VALUE ? 0 : min;
        }

        return dp[amount] == 0 ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode322_CoinChange().coinChange(
                new int[]{1,2,5},
                11
        ));
    }
}
