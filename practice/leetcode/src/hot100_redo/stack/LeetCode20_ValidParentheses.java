package hot100_redo.stack;

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

        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (stack.isEmpty() || !judge(stack, c)) {
                stack.push(c);
            } else {
                stack.pop();
            }
        }

        return stack.isEmpty();
    }

    private boolean judge(Stack<Character> stack, Character character) {
        return switch (character) {
            case ')' -> stack.peek() == '(';
            case ']' -> stack.peek() == '[';
            case '}' -> stack.peek() == '{';
            default -> false;
        };
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode20_ValidParentheses().isValid(
                "()[]{[]}"
        ));
    }

}
