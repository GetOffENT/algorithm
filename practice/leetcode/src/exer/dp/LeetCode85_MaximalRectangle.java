package exer.dp;

import java.util.Stack;

/**
 * <p>
 * </p>
 *
 * @author Yuxian Wu
 * @version 1.0
 * @since 2025-03-15 21:36
 */
public class LeetCode85_MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        int[] height = new int[matrix[0].length];
        int ans = 0;
        for (int i = 0; i < matrix.length; i++) {
            int[] left = new int[matrix[0].length], right = new int[matrix[0].length];

            Stack<Integer> stack = new Stack<>();

            for (int j = 0; j < matrix[0].length; j++) {
                height[j] = matrix[i][j] == '0' ? 0 : height[j] + 1;

                while (!stack.isEmpty() && height[stack.peek()] >= height[j]) {
                    stack.pop();
                }
                left[j] = stack.isEmpty() ? -1 : stack.peek();
                stack.push(j);
            }

            stack = new Stack<>();
            for (int j = matrix[0].length - 1; j >= 0; j--) {
                while (!stack.isEmpty() && height[stack.peek()] >= height[j]) {
                    stack.pop();
                }
                right[j] = stack.isEmpty() ? height.length : stack.peek();
                stack.push(j);
            }

            for (int j = 0; j < height.length; j++) {
                ans = Math.max(ans, height[j] * (right[j] - left[j] - 1));
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode85_MaximalRectangle().maximalRectangle(
                new char[][]{
                        {'1', '0', '1', '0', '0'},
                        {'1', '0', '1', '1', '1'},
                        {'1', '1', '1', '1', '1'},
                        {'1', '0', '0', '1', '0'}
                }
        ));
    }
}
