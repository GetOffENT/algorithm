package hot150;

/**
 * <p>
 *     <a href="https://leetcode.cn/problems/remove-element/?envType=study-plan-v2&envId=top-interview-150">...</a>
 * </p>
 *
 * @author Yuxian Wu
 * @version 1.0
 * @since 2025-04-07 14:32
 */
public class HOT150_2_LeetCode27_RemoveElement {
    public int removeElement(int[] nums, int val) {
        int l = 0, r = 0;
        int count = 0;
        while (r < nums.length) {
            if (nums[r] != val) {
                int temp = nums[l];
                nums[l] = nums[r];
                nums[r] = temp;
                l++;
                count++;
            }
            r++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new HOT150_2_LeetCode27_RemoveElement().removeElement(
                new int[]{0,1,2,2,3,0,4,2}, 2
        ));
    }
}
