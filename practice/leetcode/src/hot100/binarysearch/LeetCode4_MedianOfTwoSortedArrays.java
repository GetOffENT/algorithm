package hot100.binarysearch;

/**
 * <p>
 * </p>
 *
 * @author Yuxian Wu
 * @version 1.0
 * @since 2025-03-14 4:43
 */
public class LeetCode4_MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int left = 0, right = nums1.length;

        int median1 = 0, median2 = 0;

        while (left <= right) {
            int i = (left + right) >>> 1;
            int j = ((nums1.length + nums2.length + 1) >>> 1) - i;

            int nums_im1 = (i == 0 ? Integer.MIN_VALUE : nums1[i - 1]);
            int nums_i = (i == nums1.length ? Integer.MAX_VALUE : nums1[i]);
            int nums_jm1 = (j == 0 ? Integer.MIN_VALUE : nums2[j - 1]);
            int nums_j = (j == nums2.length ? Integer.MAX_VALUE : nums2[j]);

            if (nums_im1 <= nums_j) {
                left = i + 1;
                median1 = Math.max(nums_im1, nums_jm1);
                median2 = Math.min(nums_i, nums_j);
            } else {
                right = i -1;
            }
        }

        if ((nums1.length + nums2.length) % 2 == 0) {
            return (median1 + median2) / 2.0;
        } else {
            return median1;
        }
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode4_MedianOfTwoSortedArrays().findMedianSortedArrays(
                new int[]{1,3},
                new int[]{2}
        ));
    }
}
