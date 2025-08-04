package hot100_redo.slidingwindow;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * </p>
 *
 * @author Yuxian Wu
 * @version 1.0
 * @since 2025-03-11 7:37
 */
public class LeetCode438_FindAllAnagramsInAString {
    public List<Integer> findAnagrams(String s, String p) {
        int[] count = new int[26];
        for (char c : p.toCharArray()) {
            count[c - 'a']++;
        }

        int[] temp = new int[26];
        char[] chars = s.toCharArray();

        List<Integer> ans = new ArrayList<>();
        for (int l = 0, r = p.length() - 1; r < s.length(); l++, r++) {
            if (l == 0) {
                for (int i = 0; i < p.length(); i++) {
                    temp[chars[i] - 'a']++;
                }
            } else {
                temp[chars[l - 1] - 'a']--;
                temp[chars[r] - 'a']++;
            }

            if (compare(temp, count)) {
                ans.add(l);
            }
        }
        return ans;
    }

    private boolean compare(int[] a, int[] b) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) return false;
        }
        return true;
    }
}
