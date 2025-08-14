package hot100_redo4.substring;

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
        return 0;
    }


    public static void main(String[] args) {
        System.out.println(new LeetCode560_subarraySum().subarraySum(new int[]{1, -1, 3}, 0));
    }
}
