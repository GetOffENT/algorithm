package hot100.binarytree;

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
        if (preorder == null || preorder.length == 0) return null;

        return build(
                preorder, 0, preorder.length - 1,
                inorder, 0, inorder.length - 1
        );
    }

    private TreeNode build(int[] preorder, int low1, int high1,
                           int[] inorder, int low2, int high2) {
        if (high1 < low1) {
            return null;
        }

        int index = low2;
        while (index < inorder.length) {
            if (preorder[low1] == inorder[index]) {
                break;
            }

            index++;
        }

        return new TreeNode(
                inorder[index],
                build(
                        preorder, low1 + 1, low1 + index - low2,
                        inorder, low2, index - 1
                ),

                build(
                        preorder, low1 + index - low2 + 1, high1,
                        inorder, index + 1, high2
                )
        );
    }


    public static void main(String[] args) {
        new LeetCode105_ConstructBinaryTreeFromPreorderAndInorderTraversal()
                .buildTree(
                        new int[]{3, 9, 20, 15, 7},
                        new int[]{9, 3, 15, 20, 7}
                );
    }
}
