package hot100_redo3.substring;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Will
 * @version 1.0
 * @Description: TODO
 * @Create: 2024-09-11 8:37
 */
public class LeetCode560_subarraySum {

    /**
     * 用滑动窗口无法解决有复数的情况
     *
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum_wrong(int[] nums, int k) {
        int n = nums.length;
        int sum = 0;
        int ans = 0;
        int l = 0;
        for (int r = 0; r < n; r++) {
            sum += nums[r];
            if (sum == k) {
                ans++;
            }
            while (sum >= k && l < r) {
                sum -= nums[l];
                l++;
                if (sum == k) {
                    ans++;
                }
            }
        }
        return ans;
    }

    public int subarraySum(int[] nums, int k) {
        int ans = 0, pre = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            pre+=nums[i];
            ans += map.getOrDefault(pre - k, 0);
            map.put(pre, map.getOrDefault(pre, 0) + 1);
        }
        return ans;
    }


    public static void main(String[] args) {
        System.out.println(new LeetCode560_subarraySum().subarraySum(new int[]{1, -1, 3}, 0));
    }
}
