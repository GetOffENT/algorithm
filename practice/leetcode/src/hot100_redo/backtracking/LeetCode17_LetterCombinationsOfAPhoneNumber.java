package hot100_redo.backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
        char[] temp = new char[digits.length()];
        List<String> ans = new ArrayList<>();
        backtrace(digits.toCharArray(), 0, temp, ans);
        return ans;
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

    private void backtrace(char[] digits, int index, char[] temp, List<String> ans) {
        if (index == digits.length) return;
        char[] charSet = map.get(digits[index]);
        for (char c : charSet) {
            temp[index] = c;
            backtrace(digits, index + 1, temp, ans);
            if (index == digits.length - 1) {
                ans.add(new String(temp));
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode17_LetterCombinationsOfAPhoneNumber()
                .letterCombinations(
                        "23"
                ));
    }
}
