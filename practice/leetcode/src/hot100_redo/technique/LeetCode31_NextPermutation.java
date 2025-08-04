package hot100_redo.technique;

/**
 * <p>
 * </p>
 *
 * @author Yuxian Wu
 * @version 1.0
 * @since 2025-03-15 8:39
 */
public class LeetCode31_NextPermutation {
    public void nextPermutation(int[] nums) {
        int left = -1;
        for (int i = nums.length - 1; i >= 1; i--) {
            if (nums[i - 1] < nums[i]) {
                left = i - 1;
                for (int j = nums.length - 1; j > left; j--) {
                    if (nums[j] > nums[left]) {
                        int temp = nums[j];
                        nums[j] = nums[left];
                        nums[left] = temp;
                        break;
                    }
                }
                break;
            }
        }

        left++;
        int right = nums.length - 1;
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        new LeetCode31_NextPermutation().nextPermutation(
                new int[]{1,2,3}
        );
    }
}
