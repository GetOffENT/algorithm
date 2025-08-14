package hot100_redo4.binarytree;

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
       return new TreeNode();
    }


    public static void main(String[] args) {
        new LeetCode105_ConstructBinaryTreeFromPreorderAndInorderTraversal()
                .buildTree(
                        new int[]{3, 9, 20, 15, 7},
                        new int[]{9, 3, 15, 20, 7}
                );
    }
}
