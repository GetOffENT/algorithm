package hot100_redo3.twopointers;

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
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int l = i + 1, r = nums.length - 1, target = -nums[i];
            while (l < r) {
                if (nums[l] + nums[r] == target) {
                    ans.add(List.of(nums[i], nums[l], nums[r]));
                    do {
                        l++;
                    } while (l < r && nums[l] == nums[l - 1]);
                } else if (nums[l] + nums[r] < target) {
                    l++;
                } else {
                    r--;
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
