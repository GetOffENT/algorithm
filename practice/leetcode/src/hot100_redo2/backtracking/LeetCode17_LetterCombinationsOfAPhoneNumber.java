package hot100_redo2.backtracking;

import java.util.*;

/**
 * <p>
 *     <a href="https://leetcode.cn/problems/letter-combinations-of-a-phone-number/description/?envType=study-plan-v2&envId=top-100-liked">...</a>
 * </p>
 *
 * @author Yuxian Wu
 * @version 1.0
 * @since 2025-03-10 18:37
 */
public class LeetCode17_LetterCombinationsOfAPhoneNumber {
    public List<String> letterCombinations(String digits) {
        temp = new char[digits.length()];
        backtrace(digits.toCharArray(), 0);
        return ans;
    }

    List<String> ans = new LinkedList<>();
    char[] temp;

    private void backtrace(char[] digits, int curr) {
        if (curr == digits.length) {
            return;
        }
        char[] chars = map.get(digits[curr]);
        for (int i = 0; i < chars.length; i++) {
            temp[curr] = chars[i];
            if (curr + 1 == digits.length) {
                ans.add(new String(temp));
            }
            backtrace(digits, curr + 1);
        }
    }

    private final Map<Character, char[]> map =
            Map.of(
                    '2', new char[]{'a', 'b', 'c'},
                    '3', new char[]{'d', 'e', 'f'},
                    '4', new char[]{'g', 'h', 'i'},
                    '5', new char[]{'j', 'k', 'l'},
                    '6', new char[]{'m', 'n', 'o'},
                    '7', new char[]{'p', 'q', 'r', 's'},
                    '8', new char[]{'t', 'u', 'v'},
                    '9', new char[]{'w', 'x', 'y', 'z'}
            );

    public static void main(String[] args) {
        System.out.println(new LeetCode17_LetterCombinationsOfAPhoneNumber()
                .letterCombinations(
                        "23"
                ));
    }
}
