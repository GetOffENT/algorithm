package hot100_redo.list;

/**
 * <p>
 * </p>
 *
 * @author Yuxian Wu
 * @version 1.0
 * @since 2025-03-12 12:39
 */
public class LeetCode148_SortList {
    public ListNode sortList(ListNode head) {
        return split(head);
    }


    private ListNode split(ListNode node) {
        ListNode slow = node, fast = node;
        ListNode prev = null;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        if (prev == null) {
            return node;
        }

        prev.next = null;

        ListNode left = split(node);
        ListNode right = split(slow);
        return merge(left, right);
    }


    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode sentinel = new ListNode(0);
        ListNode curr = sentinel;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }

        if (l1 != null) {
            curr.next = l1;
        }

        if (l2 != null) {
            curr.next = l2;
        }

        return sentinel.next;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode148_SortList().sortList(
                ListNode.of(4, 1, 2, 3)
        ));
    }
}
