package hot100_redo2.list;


/**
 * @author Will
 * @version 1.0
 * @Description: TODO
 * @Create: 2024-09-11 15:24
 */
public class LeetCode160_getIntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p1 = headA;
        ListNode p2 = headB;
        while (p1 != p2) {
            p1 = p1 == null ? headB : p1.next;
            p2 = p2 == null ? headA : p2.next;
        }
        return p1;
    }
}
