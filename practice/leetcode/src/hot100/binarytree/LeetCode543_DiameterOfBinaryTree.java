package hot100.binarytree;

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
        depth(root);
        return max;
    }

    private int max = 0;

    private int depth(TreeNode node){
        if (node == null) {
            return 0;
        }

        int left = depth(node.left);
        int right = depth(node.right);

        max = Integer.max(max, left+ right);
        return Integer.max(left, right) + 1;
    }
}
