package hot100.list;


import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *     <a href="https://leetcode.cn/problems/copy-list-with-random-pointer/?envType=study-plan-v2&envId=top-100-liked">...</a>
 * </p>
 *
 * @author Yuxian Wu
 * @version 1.0
 * @since 2025-03-12 12:27
 */
public class LeetCode138_CopyListWithRandomPointer {
    public Node copyRandomList(Node head) {
        Node sentinel = new Node(0);
        Node newCurr = sentinel;
        Node curr = head;

        Map<Node, Node> map = new HashMap<>();
        while (curr != null) {
            newCurr.next = new Node(curr.val);
            newCurr = newCurr.next;

            map.put(curr, newCurr);

            curr = curr.next;
        }

        curr = head;
        while (curr != null) {
            if (curr.random != null) {
                map.get(curr).random = map.get(curr.random);
            }
            curr = curr.next;
        }

        return sentinel.next;
    }


    private static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}

