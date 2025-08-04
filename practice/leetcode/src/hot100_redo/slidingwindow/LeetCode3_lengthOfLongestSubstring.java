package hot100_redo.slidingwindow;

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
        int ans = 0;
        Set<Character> occurred = new HashSet<>();
        char[] chars = s.toCharArray();
        int l = 0, r = 0;
        while (r < s.length()){
            while (r < s.length() && !occurred.contains(chars[r])) {
                occurred.add(chars[r]);
                r++;
            }
            ans = Math.max(ans, occurred.size());
            occurred.remove(chars[l]);
            l++;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode3_lengthOfLongestSubstring().lengthOfLongestSubstring("dvdf"));
    }
}
