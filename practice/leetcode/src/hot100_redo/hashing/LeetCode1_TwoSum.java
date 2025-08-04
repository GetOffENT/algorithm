package hot100_redo.hashing;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Will
 * @version 1.0
 * @Description: TODO
 * @Create: 2024-09-10 18:43
 */
public class LeetCode1_TwoSum {

    public static void main(String[] args) {
        int[] ans = new int[2];
        ans = new LeetCode1_TwoSum().twoSum(new int[]{3,3}, 6);
        System.out.println(Arrays.toString(ans));
    }




    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }

            map.put(nums[i], i);
        }
        return null;
    }
}
