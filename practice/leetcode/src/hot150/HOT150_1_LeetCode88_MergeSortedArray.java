package hot150;

/**
 * <p>
 *     <a href="https://leetcode.cn/problems/merge-sorted-array/?envType=study-plan-v2&envId=top-interview-150">...</a>
 * </p>
 *
 * @author Yuxian Wu
 * @version 1.0
 * @since 2025-04-07 14:32
 */
public class HOT150_1_LeetCode88_MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums1, 0, nums1, n, m);

        int i = n, j = 0, k = 0;
        while (i < m + n && j < n) {
            if (nums1[i] < nums2[j]) {
                nums1[k] = nums1[i];
                i++;
            } else {
                nums1[k] = nums2[j];
                j++;
            }
            k++;
        }

        if (j < n) {
            System.arraycopy(nums2, j, nums1, k, n - j);
        }
    }
}
