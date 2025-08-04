package hot100_redo2.binarytree;

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
        return Math.max(maxDepth(node.left), maxDepth(node.right)) + 1;
    }

    /**
     * 迭代
     *
     * @param root 根节点
     * @return 最大深度
     */
    public int maxDepth1(TreeNode root) {
        return 0;
    }

    /**
     * BFS
     *
     * @param root 根节点
     * @return 最大深度
     */
    public int maxDepth2(TreeNode root) {
        return 0;
    }
}
