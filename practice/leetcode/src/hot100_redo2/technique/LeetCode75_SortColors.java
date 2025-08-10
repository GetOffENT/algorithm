package hot100_redo2.technique;

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
        int low = 0, high= 0;
        while (high < nums.length) {
            if (nums[high] == 0) {
                int temp = nums[high];
                nums[high] = nums[low];
                nums[low] = temp;
                low++;
            }
            high++;
        }

        high = low;
        while (high < nums.length) {
            if (nums[high] == 1) {
                int temp = nums[high];
                nums[high] = nums[low];
                nums[low] = temp;
                low++;
            }
            high++;
        }
    }

    public static void main(String[] args) {
        new LeetCode75_SortColors().sortColors(
                new int[]{0, 0, 0, 1, 2, 3, 4, 5}
        );
    }
}
