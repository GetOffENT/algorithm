package hot100_redo.graph;

import java.util.*;

/**
 * <p>
 * <a href="https://leetcode.cn/problems/implement-trie-prefix-tree/description/?envType=study-plan-v2&envId=top-100-liked">...</a>
 * </p>
 *
 * @author Yuxian Wu
 * @version 1.0
 * @since 2025-03-15 9:27
 */
public class LeetCode208_ImplementTriePrefixTree {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("ab");
        trie.search("abc");
        trie.search("ab");
        trie.startsWith("abc");
        trie.startsWith("ab");
        trie.insert("ab");
        trie.search("abc");
        trie.startsWith("abc");
        trie.insert("abc");
        trie.search("abc");
        System.out.println(trie.startsWith("abc"));
    }
}

class Trie {
    Set<String> set;

    Node root;

    private static class Node {
        char c;
        Map<Character, Node> children;

        public Node(char c) {
            this.c = c;
            children = new HashMap<>();
        }
    }

    public Trie() {
        set = new HashSet<>();
        root = new Node(' ');
    }

    public void insert(String word) {
        if (set.contains(word)) {
            return;
        }
        set.add(word);

        Node curr = root;
        for (char c : word.toCharArray()) {
            if (!curr.children.containsKey(c)) {
                Node node = new Node(c);
                curr.children.put(c, node);
                curr = node;
            } else {
                curr = curr.children.get(c);
            }
        }
    }

    public boolean search(String word) {
        return set.contains(word);
    }

    public boolean startsWith(String prefix) {
        Node curr = root;
        for (char c : prefix.toCharArray()) {
            if (!curr.children.containsKey(c)) {
                return false;
            }
            curr = curr.children.get(c);
        }
        return true;
    }
}
