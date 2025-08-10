package hot100_redo2.heap;

import java.util.PriorityQueue;

/**
 * <p>
 * </p>
 *
 * @author Yuxian Wu
 * @version 1.0
 * @since 2025-03-06 18:31
 */
public class LeetCode215_FindKthLargest {
    public int findKthLargest(int[] numbers, int k) {
        return quickSelect1(numbers, 0, numbers.length - 1, numbers.length - k);
    }

    private int quickSelect1(int[] nums, int low, int high, int k) {
        if (low == high) return nums[low];
        int l = low - 1, r = high + 1;
        int pivot = nums[low];
        while (l < r) {
            do l++; while (nums[l] < pivot);
            do r--; while (nums[r] > pivot);
            if (l < r) {
                int temp = nums[l];
                nums[l] = nums[r];
                nums[r] = temp;
            }
        }
        if (k <= r) {
            return quickSelect1(nums, low, r, k);
        } else {
            return quickSelect1(nums, r + 1, high, k);
        }
    }

    // 快速选择
    public int findKthLargest1(int[] numbers, int k) {
        return quickSelect(numbers, 0, numbers.length - 1, numbers.length - k);
    }

    int quickSelect(int[] nums, int low, int high, int k) {
        if (low == high) return nums[low];

        int pivot = nums[low];
        int left = low, right = high;
        while (left < right) {
            while (left < right && nums[right] >= pivot) {
                right--;
            }
            nums[left] = nums[right];
            while (left < right && nums[left] <= pivot) {
                left++;
            }
            nums[right] = nums[left];
        }
        nums[left] = pivot;
        if (left < k) {
            return quickSelect(nums, left + 1, high, k);
        } else {
            return quickSelect(nums, low, left, k);
        }
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode215_FindKthLargest().findKthLargest(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4));
        System.out.println(new LeetCode215_FindKthLargest().findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));
    }
}
