package hot100_redo3.twopointers;

/**
 * <p>
 *     <a href="https://leetcode.cn/problems/container-with-most-water/?envType=study-plan-v2&envId=top-100-liked">...</a>
 * </p>
 *
 * @author Yuxian Wu
 * @version 1.0
 * @since 2025-02-21 11:32
 */
public class LeetCode11_MaxArea {
    public int maxArea(int[] height) {
        int l = 0, r = height.length - 1;
        int ans = 0;
        while (l < r) {
            ans = Math.max(ans, Math.min(height[r], height[l]) * (r - l));
            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new hot100_redo2.twopointers.LeetCode11_MaxArea().maxArea(
                new int[]{1,8,6,2,5,4,8,3,7}
        ));
    }
}
