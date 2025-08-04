package hot100_redo.list;

/**
 * <p>
 * </p>
 *
 * @author Yuxian Wu
 * @version 1.0
 * @since 2025-03-09 16:22
 */
public class LeetCode19_RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        return recursive(head, n);
    }

    private int order = 0;

    private ListNode recursive(ListNode node, int n) {
        if (node == null) {
            order++;
            return node;
        }

        node.next = recursive(node.next, n);
        if (order == n) {
            order++;
            return node.next;
        }
        order++;
        return node;
    }
}
