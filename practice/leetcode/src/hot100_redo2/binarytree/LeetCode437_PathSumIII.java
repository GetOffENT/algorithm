package hot100_redo2.binarytree;

import java.util.HashMap;
import java.util.Map;

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

        if (root == null) {
            return 0;
        }

        Map<Long, Integer> map = new HashMap<>();
        map.put(0L, 1);
        dfs(root, targetSum, 0L, map);
        return ans;
    }

    int ans;

    private void dfs(TreeNode node, int targetSum, Long currSum, Map<Long, Integer> map) {
        if (node == null) {
            return;
        }

        currSum += node.val;
        ans += map.getOrDefault(currSum - targetSum, 0);
        map.put(currSum, map.getOrDefault(currSum, 0) + 1);

        dfs(node.left, targetSum, currSum, map);
        dfs(node.right, targetSum, currSum, map);

        map.put(currSum, map.getOrDefault(currSum, 0) - 1);
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

        System.out.println(new LeetCode437_PathSumIII()
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
                                                new TreeNode(5, null, null),
                                                new TreeNode(1, null, null))

                                )
                        ),
                        22
                ));
    }
}
