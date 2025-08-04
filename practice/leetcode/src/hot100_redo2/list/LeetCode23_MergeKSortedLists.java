package hot100_redo2.list;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * <p>
 * <a href="https://leetcode.cn/problems/merge-k-sorted-lists/description/?envType=study-plan-v2&envId=top-100-liked">...</a>
 * </p>
 *
 * @author Yuxian Wu
 * @version 1.0
 * @since 2025-03-11 20:32
 */
public class LeetCode23_MergeKSortedLists {

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));
        for (ListNode list : lists) {
            if (list != null) {
                minHeap.offer(list);
            }
        }
        ListNode head = new ListNode(0);
        ListNode curr = head;
        while (!minHeap.isEmpty()) {
            ListNode poll = minHeap.poll();
            curr.next = poll;
            curr = curr.next;
            if (poll.next != null) {
                minHeap.offer(poll.next);
            }
        }
        return head.next;
    }


}
