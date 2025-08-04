package hot100_redo.list;

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
        lRUCache.get(1);    // 返回 1
        lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
        lRUCache.get(2);    // 返回 -1 (未找到)
        lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
        lRUCache.get(1);    // 返回 -1 (未找到)
        lRUCache.get(3);    // 返回 3
        lRUCache.get(4);    // 返回 4
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
        this.sentinel = new ListNode(0, 0, null, null);
        this.sentinel.next = sentinel;
        this.sentinel.prev = sentinel;
        this.size = 0;
    }

    public int get(int key) {
        if (this.map.containsKey(key)) {
            ListNode curr = this.map.get(key);
            curr.prev.next = curr.next;
            curr.next.prev = curr.prev;

            ListNode first = this.sentinel.next;

            this.sentinel.next = curr;
            first.prev = curr;
            curr.prev = sentinel;
            curr.next = first;
            return curr.val;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (this.map.containsKey(key)) {
            ListNode curr = this.map.get(key);
            curr.prev.next = curr.next;
            curr.next.prev = curr.prev;
        } else {
            if (size == capacity) {
                this.map.remove(this.sentinel.prev.key);
                this.sentinel.prev = this.sentinel.prev.prev;
                this.sentinel.prev.next = this.sentinel;
            } else {
                size++;
            }
        }
        ListNode first = this.sentinel.next;
        ListNode curr = new ListNode(key, value, this.sentinel, first);
        this.map.put(key, curr);
        this.sentinel.next = curr;
        first.prev = curr;
    }
}

class LRUCacheWithExpirationAlt {
    int capacity;
    int size;
    Map<Integer, ListNode> map;
    ListNode sentinel;
    long expirationTime; // 过期时间，单位为毫秒

    private static class ListNode {
        int key;
        int val;
        ListNode prev;
        ListNode next;
        long insertTime;

        public ListNode(int key, int val, ListNode prev, ListNode next, long insertTime) {
            this.key = key;
            this.val = val;
            this.prev = prev;
            this.next = next;
            this.insertTime = insertTime;
        }
    }

    public LRUCacheWithExpirationAlt(int capacity, long expirationTime) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.sentinel = new ListNode(0, 0, null, null, 0);
        this.sentinel.next = sentinel;
        this.sentinel.prev = sentinel;
        this.size = 0;
        this.expirationTime = expirationTime;
    }

    private ListNode addFirst(int key, int val) {
        ListNode second = this.sentinel.next;
        long currentTime = System.currentTimeMillis();
        ListNode first = new ListNode(key, val, sentinel, second, currentTime);
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
            long currentTime = System.currentTimeMillis();
            if (currentTime - node.insertTime > expirationTime) {
                // 缓存项已过期，移除该缓存项
                removeNode(node);
                map.remove(key);
                size--;
                return -1;
            }
            removeNode(node);
            ListNode first = addFirst(node.key, node.val);
            map.put(key, first);
            return node.val;
        }
        return -1;
    }

    public static void main(String[] args) {
        LRUCacheWithExpirationAlt cache = new LRUCacheWithExpirationAlt(2, 1000); // 容量为 2，过期时间为 1 秒
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));
        cache.put(3, 3);
        System.out.println(cache.get(2));
        cache.put(4, 4);
        System.out.println(cache.get(1));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));
    }
}
