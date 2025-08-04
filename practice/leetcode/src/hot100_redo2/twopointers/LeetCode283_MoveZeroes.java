package hot100_redo2.twopointers;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/move-zeroes/description/?envType=study-plan-v2&envId=top-100-liked">...</a>
 * @author Will
 * @version 1.0
 * @Description: TODO
 * @Create: 2024-09-10 20:05
 */
public class LeetCode283_MoveZeroes {
    public void moveZeroes(int[] nums) {

        int left = 0, right =0;
        while (right < nums.length) {
            if (nums[right] != 0) {
                int temp = nums[right];
                nums[right] = nums[left];
                nums[left] = temp;
                left++;
            }
            right++;
        }

    }

    public void moveZeroes1(int[] nums) {

    }


    public static void main(String[] args) {
        int[] nums = new int[]{0,1,0,3,12};
        new LeetCode283_MoveZeroes().moveZeroes1(nums);
        System.out.println(Arrays.toString(nums));
    }
}
