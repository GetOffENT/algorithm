package hot100_redo.list;

/**
 * <p>
 * <a href="https://leetcode.cn/problems/palindrome-linked-list/description/?envType=study-plan-v2&envId=top-100-liked">...</a>
 * </p>
 *
 * @author Yuxian Wu
 * @version 1.0
 * @since 2025-03-07 7:35
 */
public class LeetCode234_PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        ListNode p1 = head;
        ListNode p2 = head;

        ListNode n1 = null;
        ListNode o1 = head;

        while (p2 != null && p2.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;

            o1.next = n1;
            n1 = o1;
            o1 = p1;
        }

        if (p2 != null) {
            p1 = p1.next;
        }

        while (n1 != null) {
            if (n1.val != p1.val) {
                return false;
            }

            p1 = p1.next;
            n1 = n1.next;
        }
        return true;
    }
}
