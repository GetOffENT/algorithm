package hot150;


/**
 * <p>
 * <a href="https://leetcode.cn/problems/majority-element/?envType=study-plan-v2&envId=top-interview-150">...</a>
 * </p>
 *
 * @author Yuxian Wu
 * @version 1.0
 * @since 2025-04-07 14:32
 */
public class HOT150_5_LeetCode169_MajorityElement {
    public int majorityElement(int[] nums) {
        int candidate = 0;
        int count = 0;
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            if (num == candidate) {
                count++;
            } else {
                count--;
            }
        }
        return candidate;
    }

    public static void main(String[] args) {
    }
}
