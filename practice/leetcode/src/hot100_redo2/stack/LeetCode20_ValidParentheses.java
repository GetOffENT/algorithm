package hot100_redo2.stack;

import java.util.Stack;

/**
 * <p>
 * <a href="https://leetcode.cn/problems/valid-parentheses/?envType=study-plan-v2&envId=top-100-liked">...</a>
 * </p>
 *
 * @author Yuxian Wu
 * @version 1.0
 * @since 2025-03-05 21:45
 */
public class LeetCode20_ValidParentheses {

    public boolean isValid(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char c : chars) {
            if (c == '(') {
                stack.push(')');
            } else if (c == '[') {
                stack.push(']');
            } else if (c == '{') {
                stack.push('}');
            } else if (stack.isEmpty() || stack.pop() != c) {
                return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode20_ValidParentheses().isValid(
                "()[]{[]}"
        ));
    }

}
