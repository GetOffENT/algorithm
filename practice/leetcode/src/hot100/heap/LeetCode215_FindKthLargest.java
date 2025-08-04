package hot100.heap;

import exer.graph.LeetCode1584_MinCostConnectPoints;

import java.util.PriorityQueue;

/**
 * <p>
 * </p>
 *
 * @author Yuxian Wu
 * @version 1.0
 * @since 2025-03-06 18:31
 */
public class LeetCode215_FindKthLargest {
    public int findKthLargest(int[] numbers, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(k);

        for (int i = 0; i < k; i++) {
            heap.offer(numbers[i]);
        }

        for (int i = k; i < numbers.length; i++) {
            int peek = heap.peek();
            if (numbers[i] > peek) {
                heap.poll();
                heap.offer(numbers[i]);
            }
        }

        return heap.peek();
    }

    public int findKthLargest1(int[] numbers, int k) {
        return quickSelect(numbers, 0, numbers.length - 1, numbers.length - k);
    }

    public int quickSelect(int[] numbers, int low ,int high, int k) {
        if (low == high) {
            return numbers[low];
        }

        int pivot = numbers[low];
        int left = low, right = high;
        while (left < right) {
            while (left < right && numbers[right] >= pivot) {
                right--;
            }
            numbers[left] = numbers[right];

            while (left < right && numbers[left] <= pivot) {
                left++;
            }
            numbers[right] = numbers[left];
        }

        numbers[left] = pivot;
        if (left < k) return quickSelect(numbers, left + 1, high, k);
        else return quickSelect(numbers, low, left, k);
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode215_FindKthLargest().findKthLargest1(
                new int[]{3,2,3,1,2,4,5,5,6}, 4
        ));
    }
}
