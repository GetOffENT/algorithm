package hot100_redo2.array;

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
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
        reverse(nums, 0, nums.length - 1);
    }

    public void reverse(int[] array, int left, int right){
        while (left < right) {
            int temp = array[left];
            array[left] = array[right];
            array[right] = temp;
            left++;
            right--;
        }
    }


    public static void main(String[] args) {
        System.out.println(-1 / 2);
    }
}
