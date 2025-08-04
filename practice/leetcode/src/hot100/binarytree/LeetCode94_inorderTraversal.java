package hot100.binarytree;

import java.sql.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * <a href="https://leetcode.cn/problems/binary-tree-inorder-traversal/description/?envType=study-plan-v2&envId=top-100-liked">...</a>
 * @author Will
 * @version 1.0
 * @Description: TODO
 * @Create: 2024-09-13 11:35
 */
public class LeetCode94_inorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        inorder(root, res);
        return res;
    }

    public void inorder(TreeNode node, List<Integer> res){
        if (node == null) {
            return;
        }
        inorder(node.left, res);
        res.add(node.val);
        inorder(node.right, res);
    }


    // 迭代
    public List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> res = new LinkedList<>();

        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        while (current != null || !stack.isEmpty()) {
            if (current != null) {
                stack.push(current);
                current = current.left;
            } else {
                TreeNode pop = stack.pop();
                res.add(pop.val);
                current = pop.right;
            }
        }

        return res;
    }

    public List<Integer> inorderTest(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;

        while (current != null || !stack.isEmpty()) {
            if (current != null) {
                stack.push(current);
                current = current.left;
            } else {
                TreeNode pop = stack.pop();
                res.add(pop.val);
                current = pop.right;
            }
        }
        return res;
    }
}
