package hot100.binarytree;

import java.util.Stack;

/**
 * <p>
 * </p>
 *
 * @author Yuxian Wu
 * @version 1.0
 * @since 2025-03-11 19:23
 */
public class LeetCode230_KthSmallestElementInABst {
    public int kthSmallest(TreeNode root, int k) {
        if (root == null) {
            return 0;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        while (current != null || !stack.isEmpty()) {
            if (current != null) {
                stack.push(current);
                current = current.left;
            } else {
                k--;
                if (k == 0) {
                    return stack.pop().val;
                }
                current = stack.pop().right;
            }
        }
        return root.val;
    }
}
