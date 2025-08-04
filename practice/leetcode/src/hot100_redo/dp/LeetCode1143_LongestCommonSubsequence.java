package hot100_redo.dp;

/**
 * <p>
 *     <a href="https://leetcode.cn/problems/longest-common-subsequence/description/?envType=study-plan-v2&envId=top-100-liked">...</a>
 * </p>
 *
 * @author Yuxian Wu
 * @version 1.0
 * @since 2025-03-15 6:11
 */
public class LeetCode1143_LongestCommonSubsequence {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length()][text2.length()];

        char[] chars1 = text1.toCharArray();
        char[] chars2 = text2.toCharArray();

        dp[0][0] = chars1[0] == chars2[0] ? 1 : 0;

        for (int i = 1; i < text1.length(); i++) {
            dp[i][0] = (dp[i - 1][0] == 1 || chars1[i] == chars2[0]) ? 1 : 0;
        }

        for (int i = 1; i < text2.length(); i++) {
            dp[0][i] = (dp[0][i - 1] == 1 || chars1[0] == chars2[i]) ? 1 : 0;
        }

        for (int i = 1; i < text1.length(); i++) {
            for (int j = 1; j < text2.length(); j++) {
                dp[i][j] = Math.max(dp[i - 1][j - 1] + (chars1[i] == chars2[j] ? 1 : 0),
                        Math.max(dp[i - 1][j], dp[i][j - 1]));
            }
        }

        return dp[text1.length() - 1][text2.length() - 1];
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode1143_LongestCommonSubsequence().longestCommonSubsequence(
                "abcde",
                "ace"
        ));

    }
}
