package hot100_redo3.twopointers;

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
        int l = 0, r= 0;
        while (r < nums.length) {
            if (nums[r] != 0) {
                int temp = nums[r];
                nums[r] = nums[l];
                nums[l] = temp;
                l++;
            }
            r++;
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
