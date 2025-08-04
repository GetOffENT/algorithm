package hot100_redo2.list;

/**
 * <p>
 *     <a href="https://leetcode.cn/problems/swap-nodes-in-pairs/description/?envType=study-plan-v2&envId=top-100-liked">...</a>
 * </p>
 *
 * @author Yuxian Wu
 * @version 1.0
 * @since 2025-03-11 16:17
 */
public class LeetCode24_SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        ListNode sentinel = new ListNode(0, head);

        return recursion(sentinel);
    }

    private ListNode recursion(ListNode node) {
        if (node.next == null || node.next.next == null) {
            return node.next;
        }

        ListNode nextHead = recursion(node.next.next);
        ListNode n1 = node.next;
        ListNode n2 = node.next.next;
        node.next = n2;
        n2.next = n1;
        n1.next = nextHead;

        return n2;
    }
}
