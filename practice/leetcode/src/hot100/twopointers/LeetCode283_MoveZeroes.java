package hot100.twopointers;

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
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                count++;
            }
        }
        int[] newNums = new int[nums.length];
        int index = nums.length - 1 -count;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] != 0) {
                newNums[index--] = nums[i];
            }
        }

        System.arraycopy(newNums, 0, nums, 0, nums.length);
    }

    public void moveZeroes1(int[] nums) {
        int l = 0, r = 0, n = nums.length;
        while (r < n) {
            if (nums[r] != 0){
                int a = nums[r];
                nums[r] = nums[l];
                nums[l] = a;
                l++;
            }
            r++;
        }
    }


    public static void main(String[] args) {
        int[] nums = new int[]{0,1,0,3,12};
        new LeetCode283_MoveZeroes().moveZeroes1(nums);
        System.out.println(Arrays.toString(nums));
    }
}
