package hot100_redo2.graph;

import org.w3c.dom.Node;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * <p>
 *     <a href="https://leetcode.cn/problems/implement-trie-prefix-tree/description/?envType=study-plan-v2&envId=top-100-liked">...</a>
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
    public Trie() {
    }

    public void insert(String word) {
    }

    public boolean search(String word) {
        return true;
    }

    public boolean startsWith(String prefix) {
        return true;
    }
}
