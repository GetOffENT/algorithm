package hot100_redo.binarysearch;

/**
 * <p>
 * </p>
 *
 * @author Yuxian Wu
 * @version 1.0
 * @since 2025-03-14 4:15
 */
public class LeetCode33_SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            if (nums[mid] == target) {
                return mid;
            }

            // 左边是有序的
            if (nums[low] <= nums[mid]) {
                if (target < nums[mid] && target >= nums[low]) {
                    high = mid;
                    while (low <= high) {
                        mid = (low + high) >>> 1;
                        if (target < nums[mid]) {
                            high = mid - 1;
                        } else if (nums[mid] < target) {
                            low = mid + 1;
                        } else {
                            return mid;
                        }
                    }
                } else {
                    low = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[high]) {
                    low = mid +1;
                    while (low <= high) {
                        mid = (low + high) >>> 1;
                        if (target < nums[mid]) {
                            high = mid - 1;
                        } else if (nums[mid] < target) {
                            low = mid + 1;
                        } else {
                            return mid;
                        }
                    }
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode33_SearchInRotatedSortedArray().search(
                new int[]{5,1,3}, 3
        ));
    }
}
