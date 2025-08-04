package hot100.hashing;

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

        int longest = 0;

        for (int num : set) {
            if (!set.contains(num - 1)) {
                int currentNum = num;
                int currentLongest = 0;

                while (set.contains(currentNum)) {
                    currentNum++;
                    currentLongest++;
                }

                longest = Integer.max(longest, currentLongest);
            }
        }

        return longest;
    }
}
