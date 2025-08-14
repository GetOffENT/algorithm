package hot100_redo3.substring;

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
        int[] ans = new int[nums.length - k + 1];
        for (int i = 0; i < k; i++) {
            while (!queue.isEmpty() && nums[queue.getFirst()] <= nums[i]) {
                queue.removeFirst();
            }
            queue.addFirst(i);
        }
        ans[0] = nums[queue.getLast()];

        for (int i = k, j = 1; i < nums.length; i++, j++) {
            while (!queue.isEmpty() && nums[queue.getFirst()] <= nums[i]) {
                queue.removeFirst();
            }
            queue.addFirst(i);
            while (!queue.isEmpty() && queue.getLast() < j) {
                queue.removeLast();
            }
            ans[j] = nums[queue.getLast()];
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new LeetCode239_MaxSlidingWindow().maxSlidingWindow(
                new int[]{1,3,-1,-3,5,3,6,7}, 3
        )));
    }
}
