package hot100_redo2.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
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
        temp = new char[n * 2];
        backtrace(0, 0, 0, n);
        return ans;
    }

    List<String> ans = new LinkedList<>();
    char[] temp;

    private void backtrace(int left, int right, int index, int max) {
        if (index == temp.length) {
            ans.add(new String(temp));
            return;
        }

        if (left < max) {
            temp[index] = '(';
            backtrace(left + 1, right, index + 1, max);
        }

        if (right < left) {
            temp[index] = ')';
            backtrace(left, right + 1, index + 1, max);
        }
    }

    public static void main(String[] args) {
        System.out.println(
                new LeetCode22_GenerateParenthesis().generateParenthesis(3)
        );

    }
}
