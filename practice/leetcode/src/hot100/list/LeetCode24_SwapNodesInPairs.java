package hot100.list;

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
        if (head == null || head.next == null) {
            return head;
        }

        ListNode sentinel = new ListNode(0);
        sentinel.next = head;

        recursion(sentinel);
        return sentinel.next;
    }


    private void recursion(ListNode node){
        if (node.next == null || node.next.next == null) {
            return;
        }
        ListNode next = node.next;

        node.next = node.next.next;
        next.next = node.next.next;
        node.next.next = next;

        recursion(node.next.next);
    }
}
