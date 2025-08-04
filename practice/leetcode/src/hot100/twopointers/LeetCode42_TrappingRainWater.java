package hot100.twopointers;

/**
 * <p><a href="https://leetcode.cn/problems/trapping-rain-water/description/?envType=study-plan-v2&envId=top-100-liked">...</a>
 * </p>
 *
 * @author Yuxian Wu
 * @version 1.0
 * @since 2025-03-11 7:03
 */
public class LeetCode42_TrappingRainWater {
    public int trap(int[] height) {
        int[] preMax = new int[height.length];
        int[] postMax = new int[height.length];

        preMax[0] = 0;
        for (int i = 1; i < height.length; i++) {
            preMax[i] = Integer.max(preMax[i - 1], height[i - 1]);
        }

        postMax[height.length - 1] = 0;
        for (int i = height.length - 2; i >= 0; i--) {
            postMax[i] = Integer.max(postMax[i + 1], height[i + 1]);
        }

        int ans = 0;
        for (int i = 0; i < height.length; i++) {
            ans += Math.max(Integer.min(preMax[i], postMax[i]) - height[i], 0);
        }

        return ans;
    }

    // 双指针
    public int trap1(int[] height){
        int left = 0, right = height.length - 1;

        int leftMax = 0, rightMax = 0;

        int ans = 0;
        while (left < right) {
            leftMax = Integer.max(leftMax, height[left]);
            rightMax = Integer.max(rightMax, height[right]);
            if (height[left] < height[right]) {
                ans += leftMax - height[left];
                left++;
            } else {
                ans += rightMax - height[right];
                right--;
            }

        }
        return ans;
    }
}
