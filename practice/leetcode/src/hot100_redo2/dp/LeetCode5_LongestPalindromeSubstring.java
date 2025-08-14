package hot100_redo2.dp;

import java.util.Arrays;

/**
 * <p>
 * </p>
 *
 * @author Yuxian Wu
 * @version 1.0
 * @since 2025-03-15 5:57
 */
public class LeetCode5_LongestPalindromeSubstring {
    public String longestPalindrome(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            Arrays.fill(dp[i], true);
        }

        int begin = 0, end = 0, max = 1;

        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i + 1; j < s.length(); j++) {
                dp[i][j] = dp[i + 1][j - 1] && s.charAt(i) == s.charAt(j);
                if (dp[i][j]) {
                    if (j - i + 1 > max) {
                        max = j - i + 1;
                        begin = i;
                        end = j;
                    }
                }
            }
        }
        return s.substring(begin, end + 1);
    }
}
