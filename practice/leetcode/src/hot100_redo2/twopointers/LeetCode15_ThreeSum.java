package hot100_redo2.twopointers;

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

        int first = 0;
        while (first < nums.length - 2) {
            int twoSum = -nums[first];

            int second = first + 1, third = nums.length - 1;
            while (second < third) {
                int temp = nums[second] + nums[third];
                if (temp == twoSum) {
                    ans.add(List.of(nums[first], nums[second], nums[third]));
                    do {
                        second++;
                    } while (second < third && nums[second] == nums[second - 1]);
                } else if (temp < twoSum) {
                    second++;
                } else {
                    third--;
                }
            }
            do {
                first++;
            } while (first < nums.length - 2 && nums[first] == nums[first - 1]);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode15_ThreeSum().threeSum(
                new int[]{-1, 0, 1, 2, -1, -4}
        ));
        System.out.println(new LeetCode15_ThreeSum().threeSum(
                new int[]{0, 0, 0}
        ));
    }
}
