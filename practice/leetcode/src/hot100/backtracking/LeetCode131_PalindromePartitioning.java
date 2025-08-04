package hot100.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>
 * <a href="https://leetcode.cn/problems/palindrome-partitioning/description/?envType=study-plan-v2&envId=top-100-liked">...</a>
 * </p>
 *
 * @author Yuxian Wu
 * @version 1.0
 * @since 2025-03-14 2:40
 */
public class LeetCode131_PalindromePartitioning {
    public List<List<String>> partition(String s) {

        boolean[][] dp = new boolean[s.length()][s.length()];


        for (int i = 0; i < s.length(); i++) {
            Arrays.fill(dp[i], true);
        }

        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i + 1; j < s.length(); j++) {
                dp[i][j] = dp[i + 1][j - 1] && s.charAt(i) == s.charAt(j);
            }
        }

        List<List<String>> ans = new ArrayList<>();
        List<String> temp = new ArrayList<>();

        backtrace(s, 0, dp, ans, temp);

        return ans;
    }

    private void backtrace(String s, int index,
                           boolean[][] dp, List<List<String>> ans, List<String> temp) {
        if (index == s.length()) {
            ans.add(new ArrayList<>(temp));
            return;
        }

        for (int i = index; i < s.length(); i++) {
            if (dp[index][i]) {
                temp.add(s.substring(index, i + 1));
                backtrace(s, i + 1, dp, ans, temp);
                temp.remove(temp.size() - 1);
            }
        }
    }


    public static void main(String[] args) {
        System.out.println(new LeetCode131_PalindromePartitioning().partition(
                "anca"
        ));
    }
}
