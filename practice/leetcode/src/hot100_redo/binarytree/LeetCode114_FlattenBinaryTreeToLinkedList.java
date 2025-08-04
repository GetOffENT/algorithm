package hot100_redo.binarytree;

/**
 * <p>
 * </p>
 *
 * @author Yuxian Wu
 * @version 1.0
 * @since 2025-03-11 19:50
 */
public class LeetCode114_FlattenBinaryTreeToLinkedList {
    public void flatten(TreeNode node) {
        while (node != null) {
            TreeNode left = node.left;
            if (left != null) {
                TreeNode curr = left;
                while (curr.right != null) {
                    curr = curr.right;
                }
                curr.right = node.right;
                node.right = left;
                node.left = null;
            }
            node = node.right;
        }
    }
}
