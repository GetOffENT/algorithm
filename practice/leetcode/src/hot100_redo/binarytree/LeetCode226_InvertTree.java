package hot100_redo.binarytree;

/**
 * <p>
 *     <a href="https://leetcode.cn/problems/invert-binary-tree/?envType=study-plan-v2&envId=top-100-liked">...</a>
 * </p>
 *
 * @author Yuxian Wu
 * @version 1.0
 * @since 2025-03-10 14:10
 */
public class LeetCode226_InvertTree {

    public TreeNode invertTree(TreeNode root) {
        recursion(root);
        return root;
    }

    private void recursion(TreeNode node) {
        if (node == null) {
            return;
        }

        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;

        recursion(node.left);
        recursion(node.right);
    }

}
