package hot100.slidingwindow;

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
        int n = s.length();
        int r = -1;

        int ans = 0;
        char[] chars = s.toCharArray();
        Set<Character> occurred = new HashSet<>();
        for (int l = 0; l < n; l++) {

            while (r + 1 < n && !occurred.contains(chars[r + 1])) {
                r++;
                occurred.add(chars[r]);
            }
            ans = Integer.max(ans, r - l + 1);


            occurred.remove(chars[l]);
        }

        return ans;
    }

    public int lengthOfLongestSubstring1(String s) {
        int n = s.length();
        int l = 0;
        char[] charArray = s.toCharArray();
        int ans = 0;
        for (int r = 0; r < n; r++) {

            for (int i = l; i < r; i++) {
                if (charArray[i] == charArray[r]) {
                    l = i + 1;
                    break;
                }

            }
            ans = Integer.max(ans, r - l + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode3_lengthOfLongestSubstring().lengthOfLongestSubstring1("pwwkew"));
    }
}
