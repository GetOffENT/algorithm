package hot100_redo.dp;

/**
 * <p>
 * </p>
 *
 * @author Yuxian Wu
 * @version 1.0
 * @since 2025-03-14 9:13
 */
public class LeetCode300_LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];

        dp[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            int max = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    max = Math.max(max, dp[j] + 1);
                }
            }
            dp[i] = max;
        }

        int max = 1;
        for (int j : dp) {
            max = Math.max(max, j);
        }
        return max;
    }

    public int lengthOfLIS1(int[] nums) {
        int[] d = new int[nums.length + 1];
        int len = 1;
        d[1] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > d[len]) {
                d[++len] = nums[i];
            } else {
                int low = 1, high = len;
                while (low <= high) {
                    int mid = (low + high) >>> 1;
                    if (d[mid] < nums[i]) {
                        low = mid + 1;
                    } else {
                        high = mid - 1;
                    }
                }
                d[high + 1] = nums[i];
            }
        }
        return len;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode300_LongestIncreasingSubsequence().lengthOfLIS(
                new int[]{1, 3, 6, 7, 9, 4, 10, 5, 6}
        ));
    }
}
