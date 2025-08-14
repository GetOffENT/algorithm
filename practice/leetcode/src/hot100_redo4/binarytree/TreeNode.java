package hot100_redo4.binarytree;

/**
 * @author Will
 * @version 1.0
 * @Description: TODO
 * @Create: 2024-09-13 11:43
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
