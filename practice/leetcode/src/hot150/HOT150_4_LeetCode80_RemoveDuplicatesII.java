package hot150;


/**
 * <p>
 * <a href="https://leetcode.cn/problems/remove-duplicates-from-sorted-array-ii/description/?envType=study-plan-v2&envId=top-interview-150">...</a>
 * </p>
 *
 * @author Yuxian Wu
 * @version 1.0
 * @since 2025-04-07 14:32
 */
public class HOT150_4_LeetCode80_RemoveDuplicatesII {
    public int removeDuplicates(int[] nums) {
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (count == 1 || nums[i] != nums[count - 2]) {
                nums[count++] = nums[i];
            }
        }
        return count;
    }

    public static void main(String[] args) {
    }
}
