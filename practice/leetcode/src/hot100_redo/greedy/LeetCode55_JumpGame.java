package hot100_redo.greedy;

/**
 * <p>
 *     <a href="https://leetcode.cn/problems/jump-game/description/?envType=study-plan-v2&envId=top-100-liked">...</a>
 * </p>
 *
 * @author Yuxian Wu
 * @version 1.0
 * @since 2025-03-06 19:58
 */
public class LeetCode55_JumpGame {

    public boolean canJump(int[] nums) {

        int farthest = 0;

        for (int i = 0; i < nums.length; i++) {
            if (farthest < i) {
                return false;
            }

            farthest = Math.max(farthest, i + nums[i]);
        }

        return farthest >= nums.length - 1;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode55_JumpGame().canJump(
                new int[]{2, 3, 1, 1, 4}
        ));
    }

}
