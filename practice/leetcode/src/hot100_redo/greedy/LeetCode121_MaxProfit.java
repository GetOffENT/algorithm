package hot100_redo.greedy;

/**
 * <p>
 * <a href="https://leetcode.cn/problems/best-time-to-buy-and-sell-stock/description/?envType=study-plan-v2&envId=top-100-liked">...</a>
 * </p>
 *
 * @author Yuxian Wu
 * @version 1.0
 * @since 2025-03-06 19:09
 */
public class LeetCode121_MaxProfit {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = Integer.MIN_VALUE;

        for (int price : prices) {
            minPrice = Math.min(price, minPrice);

            maxProfit = Math.max(maxProfit, price - minPrice);
        }
        return maxProfit;
    }
}
