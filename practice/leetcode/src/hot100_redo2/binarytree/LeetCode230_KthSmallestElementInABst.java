package hot100_redo2.binarytree;

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
        TreeNode curr =  root;
        while (!stack.isEmpty() || curr != null) {
            if (curr != null) {
                stack.push(curr);
                curr = curr.left;
            } else {
                TreeNode pop = stack.pop();
                if (--k == 0) {
                    return pop.val;
                }
                curr = pop.right;
            }
        }
        return 0;
    }
}
