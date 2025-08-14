package hot100_redo4.binarytree;

/**
 * <p>
 * <a href="https://leetcode.cn/problems/path-sum-iii/description/?envType=study-plan-v2&envId=top-100-liked">...</a>
 * </p>
 *
 * @author Yuxian Wu
 * @version 1.0
 * @since 2025-03-12 14:58
 */
public class LeetCode437_PathSumIII {
    public int pathSum(TreeNode root, int targetSum) {
      return 0;
    }


    public static void main(String[] args) {
        new LeetCode437_PathSumIII()
                .pathSum(
                        new TreeNode(
                                1,
                                new TreeNode(-2, null, null),
                                new TreeNode(-3, null, null)
                        ),
                        -1
                );

        new LeetCode437_PathSumIII()
                .pathSum(
                        new TreeNode(
                                5,
                                new TreeNode(
                                        4,
                                        new TreeNode(
                                                11,
                                                new TreeNode(7, null, null),
                                                new TreeNode(2, null, null)
                                        ),
                                        null
                                ),
                                new TreeNode(
                                        8,
                                        new TreeNode(13, null, null),
                                        new TreeNode(4,
                                                new TreeNode(5,null,null),
                                                new TreeNode(1, null,null))

                                )
                        ),
                        22
                );
    }
}
