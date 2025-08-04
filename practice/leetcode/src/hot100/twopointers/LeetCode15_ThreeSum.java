package hot100.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>
 * <a href="https://leetcode.cn/problems/3sum/?envType=study-plan-v2&envId=top-100-liked">...</a>
 * </p>
 *
 * @author Yuxian Wu
 * @version 1.0
 * @since 2025-03-07 5:43
 */
public class LeetCode15_ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int twoSum = -nums[i];

            int right = nums.length - 1;

            for (int left = i + 1; left < nums.length - 1; left++) {
                if (left > i + 1 && nums[left] == nums[left - 1]) {
                    continue;
                }

                while (nums[left] + nums[right] > twoSum && left < right) {
                    right--;
                }

                if (left == right) {
                    break;
                }

                if (nums[left] + nums[right] == twoSum) {
                    ans.add(List.of(nums[i], nums[left], nums[right]));
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode15_ThreeSum().threeSum(
                new int[]{-1, 0, 1, 2, -1, -4}
        ));
    }
}
