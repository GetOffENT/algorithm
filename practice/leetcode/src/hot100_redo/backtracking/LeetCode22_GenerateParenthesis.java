package hot100_redo.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * <a href="https://leetcode.cn/problems/generate-parentheses/?envType=study-plan-v2&envId=top-100-liked">...</a>
 * </p>
 *
 * @author Yuxian Wu
 * @version 1.0
 * @since 2025-03-10 19:18
 */
public class LeetCode22_GenerateParenthesis {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();

        backtrace(n, 0, 0, 0, new char[n * 2], ans);
        return ans;
    }

    private void backtrace(int max, int open, int close, int length, char[] temp, List<String> ans) {
        if (length == temp.length) {
            ans.add(new String(temp));
            return;
        }

        if (open < max) {
            temp[length] = '(';
            backtrace(max, open + 1, close, length + 1, temp, ans);
        }

        if (close < open) {
            temp[length] = ')';
            backtrace(max, open, close + 1, length + 1, temp, ans);
        }
    }
}
