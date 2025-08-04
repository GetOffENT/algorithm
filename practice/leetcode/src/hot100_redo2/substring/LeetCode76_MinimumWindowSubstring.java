package hot100_redo2.substring;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * </p>
 *
 * @author Yuxian Wu
 * @version 1.0
 * @since 2025-03-12 13:40
 */
public class LeetCode76_MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        int[] count = new int[52];
        for (char c : t.toCharArray()) {
            count[index(c)]++;
        }

        char[] chars = s.toCharArray();
        int[] temp = new int[52];
        int l = 0, r = 0;
        String ans = "";
        while (r < s.length()) {
            while (r < s.length() && !check(count, temp)) {
                temp[index(chars[r])]++;
                r++;
            }

            if (!check(count, temp)) {
                break;
            }

            while (l< r) {
                int index = index(chars[l]);
                if (temp[index] > count[index]) {
                    temp[index]--;
                    l++;
                } else {
                    String sub = s.substring(l, r);
                    ans = ans.isEmpty() ? sub : (ans.length() < sub.length() ? ans : sub);

                    temp[index]--;
                    l++;
                    break;
                }
            }
        }
        return ans;
    }

    private int index(char c) {
        if ('a' <= c && c <= 'z') {
            return c - 'a';
        }

        return c - 'A' + 26;
    }

    private boolean check(int[] a, int[] b) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] > b[i]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode76_MinimumWindowSubstring().minWindow(
                "ADOBECODEBANC", "ABC"
        ));
        System.out.println(new LeetCode76_MinimumWindowSubstring().minWindow(
                "a", "aa"
        ));
    }
}
