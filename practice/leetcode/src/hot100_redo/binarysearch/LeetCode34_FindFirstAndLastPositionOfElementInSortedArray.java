package hot100_redo.binarysearch;

/**
 * <p>
 * </p>
 *
 * @author Yuxian Wu
 * @version 1.0
 * @since 2025-03-14 3:58
 */
public class LeetCode34_FindFirstAndLastPositionOfElementInSortedArray {
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[]{-1,-1};
        }
        int[] ans = new int[2];

        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            if (target <= nums[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        ans[0] = low >= 0 && low < nums.length &&nums[low] == target ? low : -1;
        if (ans[0] == -1) {
            ans[1] = -1;
            return ans;
        }
        low = 0;
        high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            if (target < nums[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        ans[1] = high;
        return ans;
    }
}
