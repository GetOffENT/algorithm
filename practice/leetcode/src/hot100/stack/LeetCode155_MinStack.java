package hot100.stack;

import java.util.Stack;

/**
 * <p>
 * <a href="https://leetcode.cn/problems/min-stack/description/?envType=study-plan-v2&envId=top-100-liked">...</a>
 * </p>
 *
 * @author Yuxian Wu
 * @version 1.0
 * @since 2025-03-05 23:10
 */
public class LeetCode155_MinStack {

    Stack<Integer> stack;
    Stack<Integer> minStack;

    public LeetCode155_MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
        minStack.push(Integer.MAX_VALUE);
    }

    public void push(int val) {
        stack.push(val);
        minStack.push(Math.min(minStack.peek(), val));
    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}

/**
 * O(1)额外空间维护最小值
 */
class MinStack {

    int min;  // 栈中最小值
    Stack<Long> stack;

    public MinStack() {
        stack = new Stack<>();
    }

    public void push(int val) {
        if (stack.isEmpty()) {
            stack.push(0L);
            min = val;
            return;
        }

        stack.push((long) min - val);
        min = Math.min(min, val);
    }

    public void pop() {
        if (stack.isEmpty()) return;

        Long pop = stack.pop();

        if (pop > 0) {
            min = (int) (min + pop);
        }
    }

    public int top() {
        Long peek = stack.peek();
        if (peek > 0) return min;

        return (int) (min - peek);
    }

    public int getMin() {
        return min;
    }
}
