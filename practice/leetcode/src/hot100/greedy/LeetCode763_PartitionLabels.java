package hot100.greedy;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * </p>
 *
 * @author Yuxian Wu
 * @version 1.0
 * @since 2025-03-14 11:40
 */
public class LeetCode763_PartitionLabels {
    public List<Integer> partitionLabels(String s) {

        int[] max = new int[26];

        for (int i = 0; i < s.length(); i++) {
            max[s.charAt(i) - 'a'] = i;
        }

        List<Integer> ans = new ArrayList<>();

        int left = 0, right;
        while (left < s.length()) {
            right = max[s.charAt(left) - 'a'];
            for (int i = left; i <= right; i++) {
                right = Math.max(right, max[s.charAt(i) - 'a']);
            }

            ans.add(right - left + 1);
            left = right + 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode763_PartitionLabels().partitionLabels(
                "ababcbacadefegdehijhklij"
        ));
    }
}
