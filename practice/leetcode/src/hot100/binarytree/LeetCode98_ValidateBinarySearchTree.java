package hot100.binarytree;

/**
 * <p>
 * <a href="https://leetcode.cn/problems/validate-binary-search-tree/description/?envType=study-plan-v2&envId=top-100-liked">...</a>
 * </p>
 *
 * @author Yuxian Wu
 * @version 1.0
 * @since 2025-03-10 15:37
 */
public class LeetCode98_ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        return check(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean check(TreeNode node, long low, long high) {
        if (node == null) {
            return true;
        }

        if (node.val <= low || node.val >= high) {
            return false;
        }

        return check(node.left, low, node.val) && check(node.right, node.val, high);
    }
}
