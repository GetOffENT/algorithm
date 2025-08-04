package hot100_redo2.list;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * </p>
 *
 * @author Yuxian Wu
 * @version 1.0
 * @since 2025-03-12 13:04
 */
public class LeetCode146_LRUCache {
    public static void main(String[] args) {
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(1, 1); // 缓存是 {1=1}
        lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
        System.out.println(lRUCache.get(1));    // 返回 1
        lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
        System.out.println(lRUCache.get(2));    // 返回 -1 (未找到)
        lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
        System.out.println(lRUCache.get(1));    // 返回 -1 (未找到)
        System.out.println(lRUCache.get(3));    // 返回 3
        System.out.println(lRUCache.get(4));    // 返回 4
    }
}

class LRUCache {

    int capacity;
    int size;

    Map<Integer, ListNode> map;
    ListNode sentinel;

    private static class ListNode {
        int key;
        int val;
        ListNode prev;
        ListNode next;

        public ListNode(int key, int val, ListNode prev, ListNode next) {
            this.key = key;
            this.val = val;
            this.prev = prev;
            this.next = next;
        }
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.sentinel = new ListNode(0,0, null, null);
        this.sentinel.next = sentinel;
        this.sentinel.prev = sentinel;
        this.size = 0;
    }

    private ListNode addFirst(int key, int val) {
        ListNode second = this.sentinel.next;
        ListNode first = new ListNode(key, val, sentinel, second);
        second.prev = first;
        sentinel.next = first;
        return first;
    }

    private int removeLast() {
        ListNode remove = sentinel.prev;
        ListNode node = sentinel.prev.prev;
        node.next = sentinel;
        sentinel.prev = node;
        return remove.key;
    }

    private void removeNode(ListNode node) {
        ListNode prev = node.prev;
        ListNode next = node.next;
        prev.next = next;
        next.prev = prev;
    }

    public void put(int key, int val) {
        if (map.containsKey(key)) {
            ListNode remove = map.remove(key);
            removeNode(remove);
        } else {
            if (size >= this.capacity) {
                int deleteKey = removeLast();
                map.remove(deleteKey);
            } else {
                size++;
            }
        }
        ListNode node = addFirst(key, val);
        map.put(key, node);
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            ListNode node = map.get(key);
            removeNode(node);
            ListNode first = addFirst(node.key, node.val);
            map.put(key, first);
            return node.val;
        }
        return -1;
    }
}
