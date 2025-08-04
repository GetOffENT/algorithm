package hot100_redo2.list;


/**
 * <p>
 * <a href="https://leetcode.cn/problems/reverse-linked-list/description/?envType=study-plan-v2&envId=top-100-liked">...</a>
 * </p>
 *
 * @author Yuxian Wu
 * @version 1.0
 * @since 2025-03-18 11:18
 */
public class LeetCode206_ReverseList {
    public ListNode reverseList(ListNode node) {
        if (node == null || node.next == null) {
            return node;
        }
        ListNode last = reverseList(node.next);
        node.next.next = node;
        node.next = null;

        return last;
    }
}
