package hot100.dp;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * </p>
 *
 * @author Yuxian Wu
 * @version 1.0
 * @since 2025-03-14 9:02
 */
public class LeetCode139_WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];

        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (String word : wordDict) {
                if (i >= word.length()) {
                    dp[i] = dp[i - word.length()] && s.startsWith(word, i - word.length());
                    if (dp[i]) break;
                }
            }
        }

        return dp[s.length()];
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode139_WordBreak().wordBreak(
                "leetcode",
                List.of("leet", "code")
        ));
    }
}
