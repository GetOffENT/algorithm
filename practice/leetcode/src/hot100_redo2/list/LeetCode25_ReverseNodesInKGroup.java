package hot100_redo2.list;

/**
 * <p>
 * <a href="https://leetcode.cn/problems/reverse-nodes-in-k-group/description/?envType=study-plan-v2&envId=top-100-liked">...</a>
 * </p>
 *
 * @author Yuxian Wu
 * @version 1.0
 * @since 2025-03-12 9:27
 */
public class LeetCode25_ReverseNodesInKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode sentinel = new ListNode(0, head);
        ListNode curr = sentinel;

        ListNode node;
        while ((node = reverse(head, 1, k)) != null) {
            curr.next = node;
            head.next = next;
            curr = head;
            head = next;
        }

        return sentinel.next;
    }

    ListNode next;

    private ListNode reverse(ListNode node, int num, int k) {
        if (node == null) {
            return null;
        }

        if (num == k) {
            next = node.next;
            return node;
        }

        ListNode last = reverse(node.next, num + 1, k);

        if (last != null) {
            node.next.next = node;
            node.next = null;
        }
        return last;
    }


    public static void main(String[] args) {
        System.out.println(new LeetCode25_ReverseNodesInKGroup()
                .reverseKGroup(
                        ListNode.of(1, 2, 3, 4, 5, 6), 2
                ));
    }
}
