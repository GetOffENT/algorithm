package hot100_redo2.hashing;

import java.util.HashSet;
import java.util.Set;

/**
 * <p>
 *     <a href="https://leetcode.cn/problems/longest-consecutive-sequence/?envType=study-plan-v2&envId=top-100-liked">...</a>
 * </p>
 *
 * @author Yuxian Wu
 * @version 1.0
 * @since 2025-02-21 10:10
 */
public class LeetCode128_LongestConsecutive {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int ans = 0;
        for (int num : nums) {
            if (!set.contains(num - 1)) {
                int curr = num;
                int longest = 1;

                while (set.contains(curr + 1)) {
                    curr++;
                    longest++;
                }
                ans = Math.max(ans, longest);
            }
        }
        return ans;
    }
}
