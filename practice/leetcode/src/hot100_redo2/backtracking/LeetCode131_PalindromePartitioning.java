package hot100_redo2.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
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
        for (boolean[] booleans : dp) {
            Arrays.fill(booleans, true);
        }

        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i + 1; j < s.length(); j++) {
                dp[i][j] = dp[i + 1][j - 1] && s.charAt(i) == s.charAt(j);
            }
        }
        backtrace(s, 0, dp);

        return ans;
    }

    List<List<String>> ans = new ArrayList<>();
    LinkedList<String> temp = new LinkedList<>();

    private void backtrace(String s, int index, boolean[][] dp) {
        if (index == s.length()) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        for (int i = index; i < s.length(); i++) {
            if (dp[index][i]) {
                temp.add(s.substring(index, i + 1));
                backtrace(s, i + 1, dp);
                temp.removeLast();
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode131_PalindromePartitioning().partition(
                "anca"
        ));
        System.out.println(new LeetCode131_PalindromePartitioning().partition(
                "aab"
        ));
    }
}
