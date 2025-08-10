package hot100_redo2.greedy;

/**
 * <p>
 * <a href="https://leetcode.cn/problems/jump-game/description/?envType=study-plan-v2&envId=top-100-liked">...</a>
 * </p>
 *
 * @author Yuxian Wu
 * @version 1.0
 * @since 2025-03-06 19:58
 */
public class LeetCode55_JumpGame {

    public boolean canJump(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (max < i) {
                return false;
            }

            max = Math.max(max, i + nums[i]);
            if (max >= nums.length - 1) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode55_JumpGame().canJump(
                new int[]{2, 3, 1, 1, 4}
        ));
        System.out.println(new LeetCode55_JumpGame().canJump(
                new int[]{3,2,1,0,4}
        ));
    }

}
