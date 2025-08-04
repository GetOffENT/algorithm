package hot100.substring;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * <p>
 *     <a href="https://leetcode.cn/problems/sliding-window-maximum/description/?envType=study-plan-v2&envId=top-100-liked">...</a>
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
            while (!queue.isEmpty() && nums[i] > nums[queue.getLast()]) {
                queue.removeLast();
            }

            queue.addLast(i);
        }

        int[] ans = new int[nums.length - k + 1];
        ans[0] = nums[queue.getFirst()];

        for (int i = k; i < nums.length; i++) {
            while (!queue.isEmpty() && nums[i] > nums[queue.getLast()]) {
                queue.removeLast();
            }

            queue.addLast(i);

            while (queue.getFirst() <= i - k) {
                queue.removeFirst();
            }

            ans[i - k + 1] = nums[queue.getFirst()];
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new LeetCode239_MaxSlidingWindow().maxSlidingWindow(
                new int[]{1,3,-1,-3,5,3,6,7}, 3
        )));
    }
}
