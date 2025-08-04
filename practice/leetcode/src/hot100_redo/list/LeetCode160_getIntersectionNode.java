package hot100_redo.list;

/**
 * @author Will
 * @version 1.0
 * @Description: TODO
 * @Create: 2024-09-11 15:24
 */
public class LeetCode160_getIntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        ListNode pA = headA, pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }
}
