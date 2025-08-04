package hot100_redo.binarytree;

/**
 * <p><a href="https://leetcode.cn/problems/diameter-of-binary-tree/description/?envType=study-plan-v2&envId=top-100-liked">...</a>
 * </p>
 *
 * @author Yuxian Wu
 * @version 1.0
 * @since 2025-03-10 14:39
 */
public class LeetCode543_DiameterOfBinaryTree {
    public int diameterOfBinaryTree(TreeNode root) {
        recursion(root);
        return max;
    }

    private int max = 0;

    private int recursion(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int left = recursion(node.left);
        int right = recursion(node.right);

        max = Math.max(max, left + right + 1);

        return Math.max(left, right) + 1;
    }
}
