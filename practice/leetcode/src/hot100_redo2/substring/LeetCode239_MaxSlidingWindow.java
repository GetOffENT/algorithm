package hot100_redo2.substring;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * <p>
 * <a href="https://leetcode.cn/problems/sliding-window-maximum/description/?envType=study-plan-v2&envId=top-100-liked">...</a>
 * </p>
 *
 * @author Yuxian Wu
 * @version 1.0
 * @since 2025-03-04 12:53
 */
public class LeetCode239_MaxSlidingWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {
        LinkedList<Integer> queue = new LinkedList<>();

        for (int i = 0; i < k; i++) {
            while (!queue.isEmpty() && nums[queue.getLast()] < nums[i]) {
                queue.removeLast();
            }
            queue.addLast(i);
        }

        int[] ans = new int[nums.length - (k - 1)];
        ans[0] = nums[queue.getFirst()];

        for (int i = 1, j = k; j < nums.length; i++, j++) {
            while (!queue.isEmpty() && nums[queue.getLast()] < nums[j]) {
                queue.removeLast();
            }
            queue.addLast(j);
            while (queue.getFirst() < i) {
                queue.removeFirst();
            }

            ans[i] = nums[queue.getFirst()];
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new LeetCode239_MaxSlidingWindow().maxSlidingWindow(
                new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3
        )));
    }
}
