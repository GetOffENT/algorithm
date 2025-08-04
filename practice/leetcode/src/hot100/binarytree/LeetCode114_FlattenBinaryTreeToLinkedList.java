package hot100.binarytree;

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
        TreeNode current = root;
        Stack<TreeNode> stack  = new Stack<>();

        List<TreeNode> list = new ArrayList<>();

        while (current != null || !stack.isEmpty()) {
            if (current != null) {
                list.add(current);
                stack.push(current);
                current = current.left;
            } else {
                current = stack.pop().right;
            }
        }

        for (int i = 1; i < list.size(); i++) {
            TreeNode prev = list.get(i - 1), curr = list.get(i);
            prev.left = null;
            prev.right = curr;
        }
    }

    // 空间O(1) 找前驱
    public void flatten2(TreeNode node){
        while (node != null){
            TreeNode left = node.left, right = node.right;
            if (left == null) {
                node = node.right;
                continue;
            }

            TreeNode curr = left;
            while (curr.right != null) {
                curr = curr.right;
            }

            curr.right = right;
            node.right = left;
            node.left = null;

            node = node.right;
        }
    }
}
