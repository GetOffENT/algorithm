package hot100_redo2.stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * <p>
 * </p>
 *
 * @author Yuxian Wu
 * @version 1.0
 * @since 2025-03-14 6:41
 */
public class LeetCode739_DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[temperatures.length];
        for (int i = temperatures.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && temperatures[stack.peek()] <= temperatures[i]) {
                stack.pop();
            }
            ans[i] = stack.isEmpty() ? 0 : (stack.peek() - i);
            stack.push(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new LeetCode739_DailyTemperatures().dailyTemperatures(
                new int[]{89, 62, 70, 58, 47, 47, 46, 76, 100, 70}
        )));
    }
}
