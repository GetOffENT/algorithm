package hot150;

import java.util.Arrays;

/**
 * <p>
 *     <a href="https://leetcode.cn/problems/remove-duplicates-from-sorted-array/?envType=study-plan-v2&envId=top-interview-150">...</a>
 * </p>
 *
 * @author Yuxian Wu
 * @version 1.0
 * @since 2025-04-07 14:32
 */
public class HOT150_3_LeetCode26_RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[count - 1]) {
                nums[count++] = nums[i];
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0,0,1,1,1,2,2,3,3,4};
        System.out.println(new HOT150_3_LeetCode26_RemoveDuplicates().removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));
    }
}
