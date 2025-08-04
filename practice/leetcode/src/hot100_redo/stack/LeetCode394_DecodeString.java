package hot100_redo.stack;

import java.util.Stack;

/**
 * <p>
 *     <a href="https://leetcode.cn/problems/decode-string/description/?envType=study-plan-v2&envId=top-100-liked">...</a>
 * </p>
 *
 * @author Yuxian Wu
 * @version 1.0
 * @since 2025-03-12 18:12
 */
public class LeetCode394_DecodeString {
    public String decodeString(String s) {
        Stack<Character> stack = new Stack<>();
        Stack<Integer> counts = new Stack<>();

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (c >= '0' && c <= '9') {
                StringBuilder temp = new StringBuilder();
                temp.append(c);
                while (chars[++i] != '[') {
                    temp.append(chars[i]);
                }
                stack.push('[');
                counts.push(Integer.parseInt(temp.toString()));
            } else if (c >= 'a' && c <= 'z') {
                stack.push(c);
            } else if (c == ']') {
                char top;
                StringBuilder word = new StringBuilder();
                while ((top = stack.pop()) != '[') {
                    word.append(top);
                }
                word.reverse();

                int count = counts.pop();
                char[] tempWord =  word.toString().toCharArray();
                while (count-- > 0) {
                    for (char c1 : tempWord) {
                        stack.push(c1);
                    }
                }
            }
        }

        StringBuilder word = new StringBuilder();
        while (!stack.isEmpty()) {
            word.append(stack.pop());
        }
        return word.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode394_DecodeString().decodeString(
                "2[abc]3[cd]ef"
        ));
    }
}
