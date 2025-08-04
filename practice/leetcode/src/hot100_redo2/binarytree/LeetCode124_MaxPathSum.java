package hot100_redo2.binarytree;

/**
 * <p>
 * <a href="https://leetcode.cn/problems/binary-tree-maximum-path-sum/?envType=study-plan-v2&envId=top-100-liked">...</a>
 * </p>
 *
 * @author Yuxian Wu
 * @version 1.0
 * @since 2025-03-12 17:17
 */
public class LeetCode124_MaxPathSum {
    public int maxPathSum(TreeNode root) {
        recursion(root);
        return ans;
    }

    int ans = Integer.MIN_VALUE;

    private int recursion(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int left = Math.max(recursion(node.left), 0);
        int right = Math.max(recursion(node.right), 0);
        int path = left + right + node.val;
        ans = Math.max(path, ans);

        return node.val + Math.max(left, right);
    }
}
