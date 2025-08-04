package hot100_redo.binarytree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * </p>
 *
 * @author Yuxian Wu
 * @version 1.0
 * @since 2025-03-12 16:09
 */
public class LeetCode236_LowestCommonAncestor {


    Map<TreeNode, Integer> first = new HashMap<>();
    Map<TreeNode, Integer> depth = new HashMap<>();
    List<TreeNode> euler = new ArrayList<>();


    // 加上RMQ可做到O(nlogn)查询 k组p、q最近公共祖先
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        dfs(root, 0);

        int pFirst = first.get(p), qFirst = first.get(q);
        int min = Math.min(pFirst, qFirst), max = Math.max(pFirst, qFirst);

        TreeNode ans = null;
        int temp = Integer.MAX_VALUE;
        for (int i = min; i <= max; i++) {
            TreeNode node = euler.get(i);
            if (depth.get(node) < temp) {
                ans = node;
                temp = depth.get(node);
            }
        }
        return ans;
    }

    private void dfs(TreeNode node, int depth) {
        first.put(node, euler.size());
        this.depth.put(node, depth);
        euler.add(node);

        if (node.left != null) {
            dfs(node.left, depth + 1);
            euler.add(node);
        }
        if (node.right != null) {
            dfs(node.right, depth + 1);
            euler.add(node);
        }
    }

    public static void main(String[] args) {
        new LeetCode236_LowestCommonAncestor().lowestCommonAncestor(
                new TreeNode(
                        3,
                        new TreeNode(5, new TreeNode(6), new TreeNode(2, new TreeNode(7), new TreeNode(4))),
                        new TreeNode(1, new TreeNode(0), new TreeNode(8))
                ),
                new TreeNode(1),
                new TreeNode(1)
        );
    }




    // 递归，只能判断一组p、q
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if (root == p || root == q || root == null) {
            return root;
        }
        TreeNode left = lowestCommonAncestor2(root.left, p, q);
        TreeNode right = lowestCommonAncestor2(root.right, p, q);
        if (left != null && right != null) {
            return root;
        }
        if (left != null) {
            return left;
        }
        return right;
    }
}
