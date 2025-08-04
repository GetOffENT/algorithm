package hot100.binarytree;

/**
 * <p>
 * <a href="https://leetcode.cn/problems/convert-sorted-array-to-binary-search-tree/?envType=study-plan-v2&envId=top-100-liked">...</a>
 * </p>
 *
 * @author Yuxian Wu
 * @version 1.0
 * @since 2025-03-10 15:20
 */
public class LeetCode108_SortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        return build(nums, 0, nums.length - 1);
    }

    private TreeNode build(int[] nums, int low, int high) {
        if (low == high) {
            return new TreeNode(nums[low]);
        }

        int mid = (low + high) / 2;

        TreeNode left = low <= mid - 1 ? build(nums, low, mid - 1) : null;
        TreeNode right = mid + 1 <= high ? build(nums, mid + 1, high) : null;

        return new TreeNode(nums[mid], left, right);
    }
}
