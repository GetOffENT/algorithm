package hot100_redo2.dp;

/**
 * <p>
 * <a href="https://leetcode.cn/problems/edit-distance/description/?envType=study-plan-v2&envId=top-100-liked">...</a>
 * </p>
 *
 * @author Yuxian Wu
 * @version 1.0
 * @since 2025-03-15 6:31
 */
public class LeetCode72_EditDistance {
    public int minDistance(String word1, String word2) {
        if (word1.isEmpty()) {
            return word2.length();
        }
        if (word2.isEmpty()) {
            return word1.length();
        }
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];

        char[] chars1 = word1.toCharArray();
        char[] chars2 = word2.toCharArray();

        dp[0][0] = 0;

        for (int i = 1; i < dp.length; i++) {
            dp[i][0] = i;
        }

        for (int i = 1; i < dp[0].length; i++) {
            dp[0][i] = i;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                dp[i][j] = Math.min(dp[i - 1][j - 1] + (chars1[i - 1] == chars2[j - 1] ? 0 : 1), Math.min(dp[i - 1][j], dp[i][j - 1]) + 1);
            }
        }
        return dp[word1.length()][word2.length()];
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode72_EditDistance().minDistance(
                "horse",
                "ros"
        ));
    }
}
