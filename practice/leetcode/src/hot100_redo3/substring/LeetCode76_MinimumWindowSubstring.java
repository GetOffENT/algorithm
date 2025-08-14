package hot100_redo3.substring;

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

        int[] temp = new int[52];
        int l = 0, r = 0;
        String ans = "";
        while (l < s.length()) {
            while (r < s.length() && !check(count, temp)) {
                temp[index(s.charAt(r))]++;
                r++;
            }
            if (!check(count, temp)) {
                break;
            }
            ans = ans.isEmpty() ? s.substring(l, r) : (
                    ans.length() > r - l ? s.substring(l, r) : ans
            );
            temp[index(s.charAt(l))]--;
            l++;
        }

        return ans;
    }

    private int index(char c) {
        if (c >= 'a' && c <= 'z') {
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
        System.out.println(new hot100_redo3.substring.LeetCode76_MinimumWindowSubstring().minWindow(
                "ADOBECODEBANC", "ABC"
        ));
        System.out.println(new LeetCode76_MinimumWindowSubstring().minWindow(
                "a", "aa"
        ));
    }
}
