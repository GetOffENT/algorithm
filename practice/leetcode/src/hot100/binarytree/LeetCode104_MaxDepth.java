package hot100.binarytree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * <p>
 * <a href="https://leetcode.cn/problems/maximum-depth-of-binary-tree/?envType=study-plan-v2&envId=top-100-liked">...</a>
 * </p>
 *
 * @author Yuxian Wu
 * @version 1.0
 * @since 2025-03-04 19:42
 */
public class LeetCode104_MaxDepth {

    /**
     * 递归
     *
     * @param node 当前根节点
     * @return 以当前节点为根的字数最大深度
     */
    public int maxDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }

        return 1 + Math.max(maxDepth(node.left), maxDepth(node.right));
    }

    /**
     * 迭代
     *
     * @param root 根节点
     * @return 最大深度
     */
    public int maxDepth1(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();

        TreeNode current = root;
        TreeNode pop = null;

        int ans = 0;

        while (current != null || !stack.isEmpty()) {
            if (current != null) {
                stack.push(current);
                ans = Math.max(ans, stack.size());
                current = current.left;
            } else {
                TreeNode peek = stack.peek();
                if (peek.right == null || peek.right == pop) {
                    pop = stack.pop();
                } else{
                    current = peek.right;
                }
            }
        }

        return ans;
    }

    /**
     * BFS
     *
     * @param root 根节点
     * @return 最大深度
     */
    public int maxDepth2(TreeNode root) {

        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);

        int depth = 0;

        while (!queue.isEmpty()) {
            depth++;

            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();

                if (current.left != null) {
                    queue.offer(current.left);
                }

                if (current.right != null) {
                    queue.offer(current.right);
                }
            }
        }
        return depth;
    }
}
