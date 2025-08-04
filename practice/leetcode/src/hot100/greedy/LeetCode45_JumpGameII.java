package hot100.greedy;

/**
 * <p>
 *     <a href="https://leetcode.cn/problems/jump-game-ii/description/?envType=study-plan-v2&envId=top-100-liked">...</a>
 * </p>
 *
 * @author Yuxian Wu
 * @version 1.0
 * @since 2025-03-14 11:24
 */
public class LeetCode45_JumpGameII {
    public int jump(int[] nums) {
        int max = 0;
        int end = 0;
        int ans = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            max = Math.max(i + nums[i], max);
            if (i == end) {
                end = max;
                ans++;
            }
        }
        return ans;
    }
}
