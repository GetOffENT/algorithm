package hot100_redo2.technique;

/**
 * <p>
 *     <a href="https://leetcode.cn/problems/find-the-duplicate-number/description/?envType=study-plan-v2&envId=top-100-liked">...</a>
 * </p>
 *
 * @author Yuxian Wu
 * @version 1.0
 * @since 2025-03-15 8:55
 */
public class LeetCode287_FindDuplicate {

    // 修改原数组
    public int findDuplicate(int[] nums) {
        return 0;
    }


    // 快慢指针
    public int findDuplicate1(int[] nums) {
        int slow = 0, fast = 0;
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);
        slow = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}
