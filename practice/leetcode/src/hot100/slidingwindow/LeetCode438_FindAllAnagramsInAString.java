package hot100.slidingwindow;

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
        if (s.length() < p.length()) return List.of();

        int[] count = new int[26];

        int[] temp = new int[26];

        for (char c : p.toCharArray()) {
            count[c - 'a']++;
        }

        char[] chars = s.toCharArray();
        for (int i = 0; i < p.length(); i++) {
            temp[chars[i] - 'a']++;
        }

        List<Integer> ans = new ArrayList<>();
        if (compare(count, temp)) ans.add(0);

        for (int i = 1; i <= s.length() - p.length(); i++) {
            temp[chars[i - 1] - 'a']--;
            temp[chars[i + p.length() - 1] - 'a']++;
            if (compare(temp, count)) ans.add(i);
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
