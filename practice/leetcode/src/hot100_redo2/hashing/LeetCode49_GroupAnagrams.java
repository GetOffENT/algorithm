package hot100_redo2.hashing;

import java.util.*;

/**
 * <p>
 *     <a href="https://leetcode.cn/problems/group-anagrams/submissions/601540157/?envType=study-plan-v2&envId=top-100-liked">...</a>
 * </p>
 *
 * @author Yuxian Wu
 * @version 1.0
 * @since 2025-02-21 9:57
 */
public class LeetCode49_GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String newStr = Arrays.toString(chars);
            List<String> orDefault = map.getOrDefault(newStr, new ArrayList<>());
            orDefault.add(str);
            map.put(newStr, orDefault);
        }
        return new ArrayList<>(map.values());
    }

    public List<List<String>> groupAnagrams1(String[] strs) {
        return null;
    }
}
