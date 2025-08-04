package hot100.list;

/**
 * <p>
 * <a href="https://leetcode.cn/problems/add-two-numbers/description/?envType=study-plan-v2&envId=top-100-liked">...</a>
 * </p>
 *
 * @author Yuxian Wu
 * @version 1.0
 * @since 2025-03-09 14:26
 */
public class LeetCode2_AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = l1;

        int carry = 0;
        while (true) {
            l1.val += l2.val + carry;

            carry = l1.val / 10;
            l1.val %= 10;

            if (l1.next != null && l2.next != null){
                l1 = l1.next;
                l2 = l2.next;
            }else break;
        }

        if (l1.next == null) {
            l1.next = l2.next;
        }

        while (carry > 0) {
            if (l1.next == null) {
                l1.next = new ListNode(0);
            }

            l1 = l1.next;

            l1.val += carry;
            carry = l1.val / 10;
            l1.val %= 10;
        }
        return head;
    }
}
