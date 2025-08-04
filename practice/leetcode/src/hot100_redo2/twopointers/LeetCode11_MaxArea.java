package hot100_redo2.twopointers;

/**
 * <p>
 * <a href="https://leetcode.cn/problems/container-with-most-water/?envType=study-plan-v2&envId=top-100-liked">...</a>
 * </p>
 *
 * @author Yuxian Wu
 * @version 1.0
 * @since 2025-02-21 11:32
 */
public class LeetCode11_MaxArea {
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int ans = 0;

        while (left < right) {
            int area;
            if (height[left] < height[right]) {
                area = height[left] * (right - left);
                left++;
            } else {
                area = height[right] * (right - left);
                right--;
            }
            ans = Math.max(ans, area);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode11_MaxArea().maxArea(
                new int[]{1,8,6,2,5,4,8,3,7}
        ));
    }
}
