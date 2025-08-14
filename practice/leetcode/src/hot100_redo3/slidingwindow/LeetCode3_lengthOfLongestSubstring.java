package hot100_redo3.slidingwindow;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Will
 * @version 1.0
 * @Description: TODO
 * @Create: 2024-09-11 7:54
 */
public class LeetCode3_lengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();

        int ans = 0;
        int l = 0, r = 0;
        while (r < s.length()) {
            while (r < s.length() && !set.contains(s.charAt(r))) {
                set.add(s.charAt(r));
                r++;
            }
            ans = Math.max(set.size(), ans);

            set.remove(s.charAt(l));
            l++;
        }
        return ans;
    }

    public int lengthOfLongestSubstring1(String s) {
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode3_lengthOfLongestSubstring().lengthOfLongestSubstring("dvdf"));
    }
}
