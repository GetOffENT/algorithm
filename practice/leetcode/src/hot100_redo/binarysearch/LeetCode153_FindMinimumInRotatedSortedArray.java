package hot100_redo.binarysearch;

/**
 * <p>
 * </p>
 *
 * @author Yuxian Wu
 * @version 1.0
 * @since 2025-03-14 4:31
 */
public class LeetCode153_FindMinimumInRotatedSortedArray {
    public int findMin(int[] nums) {
        if (nums[0] <= nums[nums.length - 1]) return nums[0];
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            // 左边有序
            if (nums[low] <= nums[mid] && nums[mid + 1] <= nums[high]) {
                return nums[mid + 1];
            } else if (nums[low] <= nums[mid]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode153_FindMinimumInRotatedSortedArray().findMin(
                new int[]{4,5,1,2,3}
        ));
    }
}
