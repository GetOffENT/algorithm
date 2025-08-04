package hot100.technique;

/**
 * <p>
 * </p>
 *
 * @author Yuxian Wu
 * @version 1.0
 * @since 2025-03-14 12:33
 */
public class LeetCode75_SortColors {
    public void sortColors(int[] nums) {
        int left = 0, right = 0;
        while (right < nums.length) {
            if (nums[right] == 0) {
                nums[right] = nums[left];
                nums[left] = 0;
                left++;
            }
            right++;
        }

        right = left;
        while (right < nums.length) {
            if (nums[right] == 1) {
                nums[right] = nums[left];
                nums[left] = 1;
                left++;
            }
            right++;
        }
    }

    public static void main(String[] args) {
        new LeetCode75_SortColors().sortColors(
                new int[]{0, 0, 0, 1, 2, 3, 4, 5}
        );
    }
}
