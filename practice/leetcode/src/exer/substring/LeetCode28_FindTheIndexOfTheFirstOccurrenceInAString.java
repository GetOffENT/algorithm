package exer.substring;

import java.util.Arrays;

/**
 * <p>
 *     KMP算法
 *     <a href="https://leetcode.cn/problems/find-the-index-of-the-first-occurrence-in-a-string/description/">...</a>
 * </p>
 *
 * @author Yuxian Wu
 * @version 1.0
 * @since 2025-03-26 5:19
 */
public class LeetCode28_FindTheIndexOfTheFirstOccurrenceInAString {
    public int strStr(String haystack, String needle) {
        char[] origin = haystack.toCharArray();
        char[] pattern = needle.toCharArray();


        int[] next = new int[pattern.length];

        int i = 1, j = 0;
        while (i < pattern.length) {
            if (pattern[i] == pattern[j]) {
                next[i] = j + 1;
                i++;
                j++;
            } else if (j != 0) {
                j = next[j - 1];
            } else {
                i++;
            }
        }

        i = 0;
        j = 0;
        while (i < origin.length) {
            if (origin[i] == pattern[j]) {
                i++;
                j++;
            } else if (j == 0) {
                i++;
            } else {
                j = next[j - 1];
            }

            if (j == pattern.length) {
                return i - j;
            }
        }

        System.out.println(Arrays.toString(next));
        return -1;
    }


    public static void main(String[] args) {
        System.out.println(new LeetCode28_FindTheIndexOfTheFirstOccurrenceInAString().strStr(
                "ajkalsdaaaabasdjk", "aaaab"
        ));
    }
}
