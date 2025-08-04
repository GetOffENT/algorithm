package hot100_redo2.binarysearch;

/**
 * <p>
 * </p>
 *
 * @author Yuxian Wu
 * @version 1.0
 * @since 2025-03-14 3:39
 */
public class LeetCode74_SearchA2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int[] array = new int[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            array[i] = matrix[i][0];
        }
        int index = search(array, target);

        return matrix[index][search(matrix[index], target)] == target;
    }

    private int search(int[] array, int target) {
        int low = 0, high = array.length - 1;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            if (array[mid] < target) {
                low = mid + 1;
            } else if (target < array[mid]) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        return Math.max(0, high);
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode74_SearchA2DMatrix().searchMatrix(
                new int[][]{
                        {1, 3, 5, 7},
                        {10, 11, 16, 20},
                        {23, 30, 34, 60}
                },
                3
        ));
    }
}
