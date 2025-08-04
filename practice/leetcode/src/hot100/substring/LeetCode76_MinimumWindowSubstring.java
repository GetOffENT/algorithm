package hot100.substring;

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
        Map<Character, Integer> tCount = new HashMap<>();
        for (char c : t.toCharArray()) {
            tCount.put(c, tCount.getOrDefault(c, 0) + 1);
        }

        Map<Character, Integer> sCount = new HashMap<>();
        int left = 0, right = 0;
        char[] chars = s.toCharArray();

        String ans = "";
        while (right < s.length()) {
            while (!check(sCount, tCount) && right < s.length()) {
                sCount.put(chars[right], sCount.getOrDefault(chars[right], 0) + 1);
                right++;
            }
            if (!check(sCount, tCount)) {
                break;
            }

            while (left < right) {
                sCount.put(chars[left], sCount.get(chars[left]) - 1);
                if (!check(sCount, tCount)) {
                    String temp = s.substring(left, right);
                    ans = ans.isEmpty() ? temp :
                            (ans.length() > temp.length() ? temp : ans);
                    left++;
                    break;
                }
                left++;
            }
        }
        return ans;
    }

    private boolean check(Map<Character, Integer> sCount, Map<Character, Integer> tCount) {
        for (Map.Entry<Character, Integer> entry : tCount.entrySet()) {
            Character key = entry.getKey();
            if (!sCount.containsKey(key) || sCount.get(key) < entry.getValue()) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode76_MinimumWindowSubstring().minWindow(
                "a", "aa"
        ));
    }
}
