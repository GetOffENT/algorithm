package hot100.substring;

import java.util.HashMap;

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
        int pre = 0;
        int n = nums.length;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        hashMap.put(0, 1);

        int ans = 0;

        for (int r = 0; r < n; r++) {
            pre += nums[r];

            ans += hashMap.getOrDefault(pre - k, 0);

            hashMap.put(pre, hashMap.getOrDefault(pre, 0) + 1);
        }
        return ans;
    }


    public static void main(String[] args) {
        System.out.println(new LeetCode560_subarraySum().subarraySum(new int[]{1, -1, 3}, 0));
    }
}
