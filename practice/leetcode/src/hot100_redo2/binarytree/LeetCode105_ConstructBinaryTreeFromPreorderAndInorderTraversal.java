package hot100_redo2.binarytree;

/**
 * <p>
 * </p>
 *
 * @author Yuxian Wu
 * @version 1.0
 * @since 2025-03-10 16:50
 */
public class LeetCode105_ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        return build(preorder, 0, preorder.length - 1,
                inorder, 0, inorder.length - 1);
    }

    private TreeNode build(int[] preorder, int low1, int high1,
                           int[] inorder, int low2, int high2) {
        if (low1 == high1) {
            return new TreeNode(preorder[low1]);
        }

        int index = low1;
        for (int i = low2; i <= high2; i++) {
            if (inorder[i] == preorder[low1]) {
                index = i;
                break;
            }
        }
        int left = index - low2, right = high2 - index;
        return new TreeNode(
                preorder[low1],
                left == 0 ? null : build(preorder, low1 + 1, low1 + left,
                        inorder, low2, index - 1),
                right == 0 ? null : build(preorder, low1 + left + 1, high1,
                        inorder, index + 1, high2)
        );
    }


    public static void main(String[] args) {
        new LeetCode105_ConstructBinaryTreeFromPreorderAndInorderTraversal()
                .buildTree(
                        new int[]{3, 9, 20, 15, 7},
                        new int[]{9, 3, 15, 20, 7}
                );
        new LeetCode105_ConstructBinaryTreeFromPreorderAndInorderTraversal()
                .buildTree(
                        new int[]{1,2},
                        new int[]{2,1}
                );
    }
}
