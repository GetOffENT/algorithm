package hot100.dp;

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
            dp[i][i] = true;
        }

        char[] chars = s.toCharArray();

        int begin = 0, end = 0, max = 1;

        for (int i = s.length() - 1; i >= 0 ; i--) {
            for (int j = i + 1; j < s.length(); j++) {
                if (j == i + 1) {
                    dp[i][j] = chars[i] == chars[j];
                } else {
                    dp[i][j] = dp[i + 1][j - 1] && chars[i] == chars[j];
                }

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
