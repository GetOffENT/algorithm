package hot100_redo2.binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * <p>
 * </p>
 *
 * @author Yuxian Wu
 * @version 1.0
 * @since 2025-03-11 19:50
 */
public class LeetCode114_FlattenBinaryTreeToLinkedList {
    public void flatten(TreeNode root) {
        TreeNode node = root;
        while (node != null) {
            if (node.left != null) {
                TreeNode curr = node.left;
                while (curr.right != null) {
                    curr = curr.right;
                }
                curr.right = node.right;
                node.right = node.left;
                node.left = null;
            }
            node = node.right;
        }
    }
}
