package hot100_redo3.binarytree;

/**
 * <p>
 * </p>
 *
 * @author Yuxian Wu
 * @version 1.0
 * @since 2025-03-12 16:09
 */
public class LeetCode236_LowestCommonAncestor {
    // 加上RMQ可做到O(nlogn)查询 k组p、q最近公共祖先
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return null;
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
        return null;
    }
}
