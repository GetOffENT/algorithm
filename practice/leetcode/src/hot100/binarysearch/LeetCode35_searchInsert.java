package hot100.binarysearch;

/**
 * @author Will
 * @version 1.0
 * @Description: TODO
 * @Create: 2024-09-25 9:29
 */
public class LeetCode35_searchInsert {
    public int searchInsert(int[] a, int target) {
        int low = 0, high = a.length - 1;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            if (target <= a[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}
