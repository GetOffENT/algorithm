package hot100.hashing;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

/**
 * @author Will
 * @version 1.0
 * @Description: TODO
 * @Create: 2024-09-10 18:43
 */
public class LeetCode1_TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Number[] nums1 = new Number[nums.length];
        for (int i = 0; i < nums.length; i++) {
            nums1[i] = new Number(nums[i], i);
        }


        Arrays.sort(nums1, Comparator.comparingInt(o -> o.num));
        int[] ans = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int result = search(target - nums1[i].num, nums1, nums1[i].index);
            if (result != -1) {
                ans[0] = nums1[i].index;
                ans[1] = nums1[result].index;
                break;
            }
        }
        return ans;
    }

    public int search(int value, Number[] nums, int index) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            if (nums[mid].num < value ||nums[mid].index == index) {
                low = mid + 1;
            } else if (value < nums[mid].num) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;

    }

    public static void main(String[] args) {
        int[] ans = new int[2];
        ans = new LeetCode1_TwoSum().twoSum(new int[]{3,3}, 6);
        System.out.println(Arrays.toString(ans));
    }




    public int[] twoSum1(int[] nums, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (hashMap.containsKey(target - nums[i])) {
                return new int[]{i, hashMap.get(target - nums[i])};
            }

            hashMap.put(nums[i], i);
        }
        return null;
    }
}
class Number {
    int num;
    int index;

    public Number(int num, int index) {
        this.num = num;
        this.index = index;
    }
}
