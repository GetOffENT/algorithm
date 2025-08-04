package hot100.array;

/**
 * <p>
 * <a href="https://leetcode.cn/problems/rotate-array/?envType=study-plan-v2&envId=top-100-liked">...</a>
 * </p>
 *
 * @author Yuxian Wu
 * @version 1.0
 * @since 2025-03-07 6:32
 */
public class LeetCode189_RotateArray {
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    private void reverse(int[] nums, int low, int high) {
        if (high <= low) return;

        int mid = (low + high) / 2;

        for (int i = low; i <= mid; i++) {
            int temp = nums[i];
            nums[i] = nums[low + high - i];
            nums[low + high - i] = temp;
        }
    }

    public static void main(String[] args) {
        System.out.println(-1 / 2);
    }
}
