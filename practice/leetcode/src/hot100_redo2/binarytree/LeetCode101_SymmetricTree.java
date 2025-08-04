package hot100_redo2.binarytree;

/**
 * <p><a href="https://leetcode.cn/problems/symmetric-tree/description/?envType=study-plan-v2&envId=top-100-liked">...</a>
 * </p>
 *
 * @author Yuxian Wu
 * @version 1.0
 * @since 2025-03-10 14:18
 */
public class LeetCode101_SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        return check(root.left, root.right);
    }

    private boolean check(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }

        return left.val == right.val && check(left.left, right.right) && check(right.left, left.right);
    }
}
