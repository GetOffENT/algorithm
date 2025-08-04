package hot100_redo.twopointers;

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

        for (int first = 0; first < nums.length - 2; first++) {
            if (first != 0 && nums[first] == nums[first - 1]) {
                continue;
            }

            int second = first + 1;
            int third = nums.length - 1;

            int twoSum = -nums[first];

            while (second < third) {
                if (nums[second] + nums[third] < twoSum) {
                    second++;
                } else if (nums[second] + nums[third] > twoSum) {
                    third--;
                } else {
                    ans.add(List.of(nums[first], nums[second], nums[third]));
                    do {
                        second++;
                    } while (second < third && nums[second - 1] == nums[second]);
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
