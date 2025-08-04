package hot100.binarytree;

/**
 * <p>
 * <a href="https://leetcode.cn/problems/binary-tree-maximum-path-sum/?envType=study-plan-v2&envId=top-100-liked">...</a>
 * </p>
 *
 * @author Yuxian Wu
 * @version 1.0
 * @since 2025-03-12 17:17
 */
public class LeetCode124_MaxPathSum {

    private int ans = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        bfs(root);
        return ans;
    }

    private int bfs(TreeNode node) {
        if (node == null)
            return 0;

        int left = Math.max(bfs(node.left), 0);
        int right = Math.max(bfs(node.right), 0);

        ans = Math.max(ans, left + right + node.val);

        return node.val + Math.max(left, right);
    }
}
