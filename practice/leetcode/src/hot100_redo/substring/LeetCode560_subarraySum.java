package hot100_redo.substring;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Will
 * @version 1.0
 * @Description: TODO
 * @Create: 2024-09-11 8:37
 */
public class LeetCode560_subarraySum {

    public int subarraySum(int[] nums, int k) {
        int pre = 0;

        Map<Integer, Integer> map = new HashMap<>();

        int ans = 0;
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            pre += nums[i];

            ans += map.getOrDefault(pre - k, 0);

            map.put(pre, map.getOrDefault(pre, 0) + 1);
        }
        return ans;
    }


    public static void main(String[] args) {
        System.out.println(new LeetCode560_subarraySum().subarraySum(new int[]{1, -1, 3}, 0));
    }
}
